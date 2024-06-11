package com.example.crud.repositorioservicios;

import java.util.List;
import java.util.Optional;
import com.example.crud.entidades.Producto;

public interface IProductoServicios {

    /**
     * Lista todos los productos disponibles.
     * 
     * @return una lista de todos los productos.
     */
    List<Producto> listar();

    /**
     * Busca un producto por su ID.
     * 
     * @param idProducto el ID del producto a buscar.
     * @return un Optional conteniendo el producto encontrado o un Optional vacío si no se encuentra.
     */
    Optional<Producto> findById(Long idProducto);

    /**
     * Guarda un producto en la base de datos.
     * 
     * @param producto el producto a guardar.
     * @return el producto guardado con el ID asignado.
     */
    Producto save(Producto producto);

    /**
     * Elimina un producto de la base de datos por su ID.
     * 
     * @param idProducto el ID del producto a eliminar.
     */
    void delete(Long idProducto);
}


