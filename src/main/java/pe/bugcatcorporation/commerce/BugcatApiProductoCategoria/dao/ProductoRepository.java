package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    Producto findBynombreProducto(String nombreProducto);
}
