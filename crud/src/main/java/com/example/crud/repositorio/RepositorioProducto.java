package com.example.crud.repositorio;

import com.example.crud.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    /**
     * Encuentra productos por la categoría especificada.
     * 
     * @param categoria La categoría de los productos.
     * @return Una lista de productos que coinciden con la categoría.
     */
    List<Producto> findByCategoria(String categoria);
}
