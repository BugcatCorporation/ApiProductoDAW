package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    Categoria findBynombreCategoria (String nombreCategoria);
}
