package org.example.repository;

import org.example.entity.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    @Query("SELECT C FROM Categoria C WHERE C.Stock = true")
    Iterable<Categoria> listarCategoriasActivas();
}