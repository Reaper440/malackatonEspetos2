package sequia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sequia.dtos.EmbalseDTO;
import sequia.entities.Embalse;
import sequia.repositories.EmbalseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmbalseService {

    @Autowired
    private EmbalseRepository embalseRepository;

    public List<EmbalseDTO> getAllEmbalses() {
        return embalseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmbalseDTO getEmbalseById(Long id) {
        Embalse embalse = embalseRepository.findById(id).orElse(null);
        return convertToDTO(embalse);
    }

    public EmbalseDTO saveEmbalse(EmbalseDTO embalseDTO) {
        Embalse embalse = convertToEntity(embalseDTO);
        embalse = embalseRepository.save(embalse);
        return convertToDTO(embalse);
    }

    public void deleteEmbalse(Long id) {
        embalseRepository.deleteById(id);
    }

    private EmbalseDTO convertToDTO(Embalse embalse) {
        if (embalse == null) {
            return null;
        }
        return EmbalseDTO.builder()
                .id(embalse.getId())
                .ambitoNombre(embalse.getAmbitoNombre())
                .embalseNombre(embalse.getEmbalseNombre())
                .aguaTotal(embalse.getAguaTotal())
                .electricoFlag(embalse.getElectricoFlag())
                .build();
    }

    private Embalse convertToEntity(EmbalseDTO embalseDTO) {
        return Embalse.builder()
                .id(embalseDTO.getId())
                .ambitoNombre(embalseDTO.getAmbitoNombre())
                .embalseNombre(embalseDTO.getEmbalseNombre())
                .aguaTotal(embalseDTO.getAguaTotal())
                .electricoFlag(embalseDTO.getElectricoFlag())
                .build();
    }
}
