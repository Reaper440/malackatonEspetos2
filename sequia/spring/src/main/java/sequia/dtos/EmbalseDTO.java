package sequia.dtos;

import java.net.URI;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sequia.entities.Embalse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmbalseDTO {
    private Long id;
    private String ambitoNombre;
    private String embalseNombre;
    private Double aguaTotal;
    private Boolean electricoFlag;

    public static EmbalseDTO fromEmbalse(Embalse embalse, Function<Long, URI> uriBuilder) {
        var dto = new EmbalseDTO();
        dto.setId(embalse.getId());
        dto.setAmbitoNombre(embalse.getAmbitoNombre());
        dto.setEmbalseNombre(embalse.getEmbalseNombre());
        dto.setAguaTotal(embalse.getAguaTotal());
        dto.setElectricoFlag(embalse.getElectricoFlag());
        return dto;
    }
}