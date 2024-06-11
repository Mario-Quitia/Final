package com.example.crud.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.crud.entidades.Producto;
import com.example.crud.repositorioservicios.IProductoServicios;

import jakarta.validation.Valid;

import java.util.List;

/**
 * Controlador para gestionar las operaciones de la entidad Producto.
 */
@Controller
public class ProductoControlador {

    // Logger para registrar eventos y actividades del controlador.
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    // Inyección del servicio que maneja la lógica de negocio para Productos.
    @Autowired
    private IProductoServicios service;

    /**
     * Método para manejar la solicitud GET para listar todos los productos.
     * 
     * @param model Modelo de Spring para pasar datos a la vista.
     * @return Nombre de la vista a renderizar.
     */
    @GetMapping("/listar")
    public String mostrarListaProductos(Model model) {
        try {
            // Llamada al servicio para obtener la lista de productos.
            List<Producto> productos = service.listar();
            // Agrega la lista de productos al modelo que será accesible en la vista.
            model.addAttribute("productos", productos);
            logger.info("Listado de productos obtenido con éxito.");
        } catch (Exception e) {
            // Logueo del error y adición de un mensaje de error al modelo.
            logger.error("Error al obtener el listado de productos.", e);
            model.addAttribute("errorMensaje", "Error al obtener productos. Intente nuevamente más tarde.");
        }
        // Retorna el nombre de la vista 'index' que debe estar en la carpeta de recursos de vistas.
        return "index";
    }


  
      
   @GetMapping("/CrearProducto")
    public String mostrarOtroFormulario(Model model) {

        model.addAttribute("productos",new Producto());

        return "formularioProducto"; // Nombre de la vista del otro formulario
    }
    
    @PostMapping("/CrearProducto")
    public String save(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("producto", producto);
            return "formularioProducto";  // Retornar a la vista del formulario si hay errores.
        }
        try {
            service.save(producto);
        } catch (Exception e) {
            logger.error("Error al guardar el producto.", e);
            model.addAttribute("errorMensaje", "Error al guardar el producto. Intente nuevamente más tarde.");
            return "formularioProducto";
        }
        return "redirect:/listar";
    
    }
    



}










