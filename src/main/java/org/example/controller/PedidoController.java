package org.example.controller;

import org.example.entity.dto.GenerarPedidoDTO;
import org.example.entity.dto.PedidoConDetallesDTO;
import org.example.service.PedidoService;
import org.example.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService service;


    public PedidoController(PedidoService service) {
        this.service = service;
    }

    //LISTAR PEDIDOS CON DETALLES
    @GetMapping("/misPedidos/{idCli}")
    public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli){
        return this.service.devolverMisCompras(idCli);
    }
    //GUARDAR PEDIDO
    @PostMapping
    public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto){
        return this.service.guardarPedido(dto);
    }
    //ANULAR PEDIDO
    @DeleteMapping("/{id}")
    public GenericResponse anularPedido(@PathVariable int id){
        return this.service.anularPedido(id);
    }


}
