package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.dao.CategoriaRepository;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;

@Service
@Slf4j
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

       
    @Override
    public List<Categoria> findAll() {
        log.info("Buscando todas las categorías");
        return categoriaRepository.findAll();
    }

    @Override
    public Page<Categoria> findPage(int page, int size) {
        log.info("Buscando página {} de categorías con tamaño {}", page, size);
        return categoriaRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Categoria findById(Long id) {
        log.info("Buscando categoría por ID: {}", id);
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con la id: " + id.toString()));
    }

    @Override
    public Categoria findBynombreCategoria(String nombreCategoria) {
        log.info("Buscando categoría por nombre: {}", nombreCategoria);
        return categoriaRepository.findBynombreCategoria(nombreCategoria);
    }
 
    @Override
    public Categoria add(Categoria categoria) {
        log.info("Añadiendo nueva categoría: {}", categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        log.info("Actualizando categoría con ID: {}", categoria.getIdcategoria());
        var CategoriaDB = categoriaRepository.findById(categoria.getIdcategoria()).orElse(null);

        if (CategoriaDB == null) {
            log.warn("Categoría no encontrada con ID: {}", categoria.getIdcategoria());
            // Puedes lanzar una excepción o devolver un valor predeterminado según tu lógica de negocio.
            return null;
        }

        CategoriaDB.setNombreCategoria(categoria.getNombreCategoria());

        log.info("Categoría actualizada: {}", CategoriaDB);
        return categoriaRepository.save(CategoriaDB);
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando categoría con ID: {}", id);
        var CategoriaDB = categoriaRepository.findById(id).orElse(null);

        if (CategoriaDB == null) {
            log.warn("Categoría no encontrada con ID: {}", id);
            return;
        }

        categoriaRepository.delete(CategoriaDB);
        log.info("Categoría con ID {} eliminada exitosamente", id);
    }
}
