package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Producto;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service.ProductoService;

@RestController
@RequestMapping("api/v1/producto")
@Slf4j
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Producto>> findAll() {
        try {
            log.info("Obteniendo todos los productos");
            List<Producto> productos = productoService.findAll();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los productos", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findPage/page/{page}/size/{size}")
    public ResponseEntity<Page<Producto>> findPage(@PathVariable int page, @PathVariable int size) {
        try {
            log.info("Obteniendo página {} de productos con tamaño {}", page, size);
            Page<Producto> productos = productoService.findPage(page, size);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener la página de productos", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByName/{nombreProducto}")
    public ResponseEntity<Producto> findByName(@PathVariable String nombreProducto) {
        try {
            log.info("Buscando producto por nombre: {}", nombreProducto);
            Producto producto = productoService.findBynombreProducto(nombreProducto);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar el producto por nombre: {}", nombreProducto, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Producto> add(@RequestBody Producto producto) {
        try {
            log.info("Agregando nuevo producto: {}", producto);
            Producto nuevoProducto = productoService.add(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nuevo producto", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        try {
            log.info("Actualizando producto: {}", producto);
            Producto productoActualizado = productoService.update(producto);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar el producto", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            log.info("Eliminando producto con ID: {}", id);
            productoService.delete(id);
            return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar el producto", e);
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
