package com.expediente.expMedico.controller;

import com.expediente.expMedico.exception.ResourceNotFoundException;
import com.expediente.expMedico.model.Enfermedad;
import com.expediente.expMedico.repository.EnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EnfermedadController {
    @Autowired
    private EnfermedadRepository enfermedadRepository;

    @PostMapping("/enfermedad")
    public Enfermedad createEnfermedad(@Valid @RequestBody Enfermedad enfermedad){
        return enfermedadRepository.save(enfermedad);
    }

    @GetMapping("/enfermedad")
    public Page<Enfermedad> getEnfermedad(Pageable pageable) {
        return enfermedadRepository.findAll(pageable);
    }

    @PutMapping("/enfermedad/{enfermedadId}")
    public Enfermedad updateEnfermedad(@PathVariable Long enfermedadId,
                                   @Valid @RequestBody Enfermedad enfermedadRequest) {
        return enfermedadRepository.findById(enfermedadId)
                .map(enfermedad -> {
                    enfermedad.setNombre(enfermedadRequest.getNombre());
                    enfermedad.setTipoEnfermedad(enfermedadRequest.getTipoEnfermedad());
                    return enfermedadRepository.save(enfermedad);
                }).orElseThrow(() -> new ResourceNotFoundException("Enfermedad no encontrada con id " + enfermedadId));
    }

    @DeleteMapping("/enfermedad/{enfermedadId}")
    public ResponseEntity<?> deleteEnfermedad(@PathVariable Long enfermedadId) {
        return enfermedadRepository.findById(enfermedadId)
                .map(enfermedad -> {
                    enfermedadRepository.delete(enfermedad);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Enfermedad no encontrada con id " + enfermedadId));
    }
}
