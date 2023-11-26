package pe.bugcatcorporation.commerce.BugcatApiProductoCategoria.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categorias")

public class Categoria {   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    private String nombreCategoria;
    
    @OneToMany(targetEntity = Producto.class , cascade = CascadeType.ALL)
    @JoinColumn(name="cp_fk", referencedColumnName = "Id")
    @JsonIgnoreProperties("nombreCategoria")
    private List<Producto> productos;
}
