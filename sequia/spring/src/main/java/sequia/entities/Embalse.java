package sequia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
public class Embalse {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "ambito_nombre")
    private String ambitoNombre;

    @Column(name = "embalse_nombre")
    private String embalseNombre;

    @Column(name = "agua_total")
    private Double aguaTotal;

    @Column(name = "electrico_flag")
    private Boolean electricoFlag;
}