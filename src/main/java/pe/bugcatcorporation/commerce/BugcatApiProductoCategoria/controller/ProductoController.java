package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Producto;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service.ProductoService;

@RestController
@RequestMapping("api/v1/producto")

public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    
    @GetMapping("/findAll")
    public List<Producto> findAll(){
        return productoService.findAll();
    }
    
    @GetMapping("/findPage/page/{page}/size/{size}")
    public Page<Producto> findPage(int page, int size){
        return productoService.findPage( page, size);
    }
    
    @GetMapping("/findByName/{nombreProducto}")
    public Producto findByName(@PathVariable String nombreProducto){
        return productoService.findBynombreProducto(nombreProducto);
    }
    
    @PostMapping("/add")
    public Producto add(@RequestBody Producto producto){
        return productoService.add(producto);
    }
    
    @PutMapping("/update")
    public Producto update(@RequestBody Producto producto){
        return productoService.update(producto);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productoService.delete(id);
    }
    
}
