package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    private String nombreProducto;
    private String descripcion;
    private int stock;
    private double precio;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    
    }