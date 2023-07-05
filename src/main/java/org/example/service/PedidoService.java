package org.example.service;

import org.example.entity.DetallePedido;
import org.example.entity.Pedido;
import org.example.entity.dto.GenerarPedidoDTO;
import org.example.entity.dto.PedidoConDetallesDTO;
import org.example.repository.DetallePedidoRepository;
import org.example.repository.PedidoRepository;
import org.example.repository.ProductoRepository;
import org.example.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.utils.Global.*;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepository repository;
    private final DetallePedidoRepository detallePedidoRepository;
    private final DetallePedidoService dpService;
    private final ProductoRepository pRepository;

    public PedidoService(PedidoRepository repository, DetallePedidoRepository detallePedidoRepository, DetallePedidoService dpService, ProductoRepository pRepository) {
        this.repository = repository;
        this.detallePedidoRepository = detallePedidoRepository;
        this.dpService = dpService;
        this.pRepository = pRepository;
    }

    //Método para devolver los pedidos con su respectivo detalle
    public GenericResponse<List<PedidoConDetallesDTO>> devolverMisCompras(int idCli) {
        final List<PedidoConDetallesDTO> dtos = new ArrayList<>();
        final Iterable<Pedido> pedidos = repository.devolverMisCompras(idCli);
        pedidos.forEach(p -> {
            dtos.add(new PedidoConDetallesDTO(p, detallePedidoRepository.findByPedido(p.getId())));
        });
        return new GenericResponse(OPERACION_CORRECTA, RPTA_OK, "Petición Encontrada", dtos);
    }

    //Método para guardar el pedido
    public GenericResponse guardarPedido(GenerarPedidoDTO dto) {
        Date date = new Date();
        dto.getPedido().setFechaCompra(new java.sql.Date(date.getTime()));
        dto.getPedido().setAnularPedido(false);
        dto.getPedido().setMonto(dto.getPedido().getMonto());
        dto.getPedido().setCliente(dto.getCliente());
        this.repository.save(dto.getPedido());
        for (DetallePedido dp : dto.getDetallePedidos()) {
            dp.setPedido(dto.getPedido());
            this.pRepository.descontarStock(dp.getCantidad(), dp.getProducto().getId());
        }
        //Llamamos al DetallePedidoService
        this.dpService.guardarDetalles(dto.getDetallePedidos());
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, dto);

    }
    //Método para anular el pedido
    public GenericResponse anularPedido(int id) {
        Pedido p = this.repository.findById(id).orElse(new Pedido());
        if (p.getId() != 0) {
            p.setAnularPedido(true);
            this.repository.save(p);
            return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, p);
        } else {
            return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_ERRONEA, "El pedido que desea anular no es válido");
        }
    }







}
