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
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service.CategoriaService;

@RestController
@RequestMapping("/api/v1/categoria")

public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/findAll")
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }
    
    @GetMapping("/findPage/page/{page}/size/{size}")
    public Page<Categoria> findPage(int page, int size){
        return categoriaService.findPage(page, size);
    }
    
    @GetMapping("/findByCategoria/{nombreCategoria}")
    public Categoria findByCategoria(@PathVariable String nombreCategoria){
        return categoriaService.findBynombreCategoria(nombreCategoria);
    }
    
    @PostMapping("/add")
    public Categoria add(@RequestBody Categoria categoria){
        return categoriaService.add(categoria);
    }
    
    @PutMapping("/update")
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaService.update(categoria);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }
    
    
    
}
