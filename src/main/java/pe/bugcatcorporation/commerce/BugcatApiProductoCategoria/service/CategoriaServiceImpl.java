package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.dao.CategoriaRepository;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

       
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Page<Categoria> findPage(int page, int size) {
        return categoriaRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Categoría no encontrada con la id: " + id.toString()));
    }

    @Override
    public Categoria findBynombreCategoria(String nombreCategoria) {
        return categoriaRepository.findBynombreCategoria(nombreCategoria);
    }
 
   @Override
    public Categoria add(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        var CategoriaDB = categoriaRepository.findById(categoria.getId()).get();
        CategoriaDB.setNombreCategoria(categoria.getNombreCategoria());
        
        return categoriaRepository.save(CategoriaDB);
    }

    @Override
    public void delete(Long id) {
        var CategoriaDB = categoriaRepository.findById(id).get();
        
        categoriaRepository.delete(CategoriaDB);
    }
    
}
