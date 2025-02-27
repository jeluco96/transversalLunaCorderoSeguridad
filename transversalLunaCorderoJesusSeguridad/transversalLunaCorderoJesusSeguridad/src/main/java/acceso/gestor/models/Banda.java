package acceso.gestor.models;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "banda") // Especificamos el nombre correcto de la tabla
public class Banda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idBanda;

    @Column()
    private String nombre;

    @Column()
    private String tipo;

    @Column(name = "num_componentes")
    private Integer numComponentes;
    
    
    // Relación con Concierto
    @OneToMany(mappedBy = "banda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnoreProperties("banda") 
    private List<Concierto> conciertos;
}

