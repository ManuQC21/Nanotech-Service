package org.example.repository;


import org.example.entity.Pedido;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    @Query("SELECT P FROM Pedido P WHERE P.cliente.id=:idCli")
    Iterable<Pedido> devolverMisCompras(int idCli);
    @Query("SELECT P FROM Pedido P WHERE P.id=:idOrden AND P.cliente.id=:idCli")
    Optional<Pedido> findByIdAndClienteId(int idCli, int idOrden);
}