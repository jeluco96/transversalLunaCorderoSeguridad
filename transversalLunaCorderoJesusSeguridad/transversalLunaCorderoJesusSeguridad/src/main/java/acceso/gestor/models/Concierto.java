package acceso.gestor.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "concierto") 
public class Concierto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idConcierto;

    private LocalDate fecha; 

    private String lugar;
    // Relación con Banda
    @ManyToOne
    @JoinColumn(name = "banda_id")
    @JsonBackReference 
    @JsonIgnoreProperties("conciertos")
    private Banda banda;
}
