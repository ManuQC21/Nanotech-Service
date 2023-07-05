package org.example.repository;



import org.example.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    @Query("SELECT P FROM Producto P WHERE P.recomendado = true")
    Iterable<Producto> listarProductosRecomendados();

    @Query("SELECT P FROM Producto P WHERE P.categoria.id=:idC")
    Iterable<Producto> listarProductosPorCategoria(int idC);

}