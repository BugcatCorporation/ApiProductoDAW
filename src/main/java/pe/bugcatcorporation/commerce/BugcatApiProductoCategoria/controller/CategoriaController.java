package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service.CategoriaService;

@RestController
@Slf4j
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Categoria>> findAll() {
        try {
            log.info("Obteniendo todas las categorías");
            List<Categoria> categorias = categoriaService.findAll();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todas las categorías", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findPage/page/{page}/size/{size}")
    public ResponseEntity<Page<Categoria>> findPage(@PathVariable int page, @PathVariable int size) {
        try {
            log.info("Obteniendo página {} de categorías con tamaño {}", page, size);
            Page<Categoria> categorias = categoriaService.findPage(page, size);
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener la página de categorías", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByCategoria/{nombreCategoria}")
    public ResponseEntity<Categoria> findByCategoria(@PathVariable String nombreCategoria) {
        try {
            log.info("Buscando categoría por nombre: {}", nombreCategoria);
            Categoria categoria = categoriaService.findBynombreCategoria(nombreCategoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar la categoría por nombre: {}", nombreCategoria, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Categoria> add(@RequestBody Categoria categoria) {
        try {
            log.info("Agregando nueva categoría: {}", categoria);
            Categoria nuevaCategoria = categoriaService.add(categoria);
            return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nueva categoría", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        try {
            log.info("Actualizando categoría: {}", categoria);
            Categoria categoriaActualizada = categoriaService.update(categoria);
            return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar la categoría", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            log.info("Eliminando categoría con ID: {}", id);
            categoriaService.delete(id);
            return new ResponseEntity<>("Categoría eliminada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar la categoría", e);
            return new ResponseEntity<>("Error al eliminar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
