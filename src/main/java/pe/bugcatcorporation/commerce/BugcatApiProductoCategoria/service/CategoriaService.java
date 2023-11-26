package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;


public interface CategoriaService {
    
    public List <Categoria> findAll();
    public Page <Categoria> findPage(int page, int size);
    public Categoria findById(Long id);
    public Categoria findBynombreCategoria(String nombreCategoria);
    public Categoria add(Categoria categoria);
    public Categoria update(Categoria categoria);
    public void delete(Long id);
    
}
