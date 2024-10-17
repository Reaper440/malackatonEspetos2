import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sequia.dtos.EmbalseDTO;
import sequia.entities.Embalse;
import sequia.services.EmbalseService;

package es.uma.informatica.sii.spring.jpa.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import sequia.dtos.EmbalseDTO;
import sequia.entities.Embalse;

import sequia.exceptions.EntidadNoEncontradaException;
import sequia.services.EmbalseService;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api/embalses")
public class EmbalseRest {

    @Autowired
    private EmbalseService embalseService;

    // GET /api/embalses
    @GetMapping
    public List<EmbalseDTO> obtenerTodosLosEmbalses(UriComponentsBuilder uriBuilder) {
        var embalses = embalseService.getAllEmbalses();
        return embalses.stream()
                .map(e -> EmbalseDTO.fromEmbalse(e, embalseUriBuilder(uriBuilder.build())))
                .toList();
    }

    public static Function<Long, URI> embalseUriBuilder(UriComponents uriComponents) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance().uriComponents(uriComponents);
        return id -> uriBuilder.path("/api/embalses")
                .path(String.format("/%d", id))
                .build()
                .toUri();
    }

    // POST /api/embalses
    @PostMapping
    public EmbalseDTO createEmbalse(@RequestBody EmbalseDTO embalseDTO) {
        Embalse embalse = Embalse.builder()
                .ambitoNombre(embalseDTO.getAmbitoNombre())
                .embalseNombre(embalseDTO.getEmbalseNombre())
                .aguaTotal(embalseDTO.getAguaTotal())
                .electricoFlag(embalseDTO.getElectricoFlag())
                .build();
        Embalse savedEmbalse = embalseService.saveEmbalse(embalse);
        return EmbalseDTO.builder()
                .id(savedEmbalse.getId())
                .ambitoNombre(savedEmbalse.getAmbitoNombre())
                .embalseNombre(savedEmbalse.getEmbalseNombre())
                .aguaTotal(savedEmbalse.getAguaTotal())
                .electricoFlag(savedEmbalse.getElectricoFlag())
                .build();
    }
}