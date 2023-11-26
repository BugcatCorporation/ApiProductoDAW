package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.dao.ProductoRepository;
import pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity.Producto;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        log.info("Buscando todos los productos");
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Page<Producto> findPage(int page, int size) {
        log.info("Buscando página {} de productos con tamaño {}", page, size);
        return productoRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Producto findById(Long id) {
        log.info("Buscando producto por ID: {}", id);
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con la id: " + id.toString()));
    }

    @Override
    public Producto findBynombreProducto(String nombreProducto) {
        log.info("Buscando producto por nombre: {}", nombreProducto);
        return productoRepository.findBynombreProducto(nombreProducto);
    }

    @Override
    public Producto add(Producto producto) {
        log.info("Añadiendo nuevo producto: {}", producto);
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        log.info("Actualizando producto con ID: {}", producto.getIdproducto());
        var ProductoDB = productoRepository.findById(producto.getIdproducto()).orElse(null);

        if (ProductoDB == null) {
            log.warn("Producto no encontrado con ID: {}", producto.getIdproducto());
            // Puedes lanzar una excepción o devolver un valor predeterminado según tu lógica de negocio.
            return null;
        }

        ProductoDB.setNombreProducto(producto.getNombreProducto());
        ProductoDB.setDescripcion(producto.getDescripcion());
        ProductoDB.setPrecio(producto.getPrecio());
        ProductoDB.setStock(producto.getStock());
        ProductoDB.setEstado(producto.getEstado());

        log.info("Producto actualizado: {}", ProductoDB);
        return productoRepository.save(ProductoDB);
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando producto con ID: {}", id);
        var ProductoDB = productoRepository.findById(id).orElse(null);

        if (ProductoDB == null) {
            log.warn("Producto no encontrado con ID: {}", id);
            return;
        }

        productoRepository.delete(ProductoDB);
        log.info("Producto con ID {} eliminado exitosamente", id);
    }
}
