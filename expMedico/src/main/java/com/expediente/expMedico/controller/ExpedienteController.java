package com.expediente.expMedico.controller;

import com.expediente.expMedico.exception.ResourceNotFoundException;
import com.expediente.expMedico.model.Expediente;
import com.expediente.expMedico.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ExpedienteController {
    @Autowired
    private ExpedienteRepository expedienteRepository;

    @PostMapping("/expediente")
    public Expediente createExpediente(@Valid @RequestBody Expediente expediente){
        return expedienteRepository.save(expediente);
    }

    @GetMapping("/expediente")
    public Page<Expediente> getExpediente(Pageable pageable){
        return expedienteRepository.findAll(pageable);
    }

    @PutMapping("/expediente/{expedienteId}")
    public Expediente updateExpediente(@PathVariable Long expedienteId,
                                       @Valid @RequestBody Expediente expedienteRequest){
        return expedienteRepository.findById(expedienteId)
                .map(expediente -> {
                    expediente.setCita(expedienteRequest.getCita());
                    expediente.setOperaciones(expedienteRequest.getOperaciones());
                    expediente.setAnalisis(expedienteRequest.getAnalisis());
                    expediente.setDiagnostico(expedienteRequest.getDiagnostico());
                    expediente.setMedicamento(expedienteRequest.getMedicamento());
                    expediente.setTipoSangre(expedienteRequest.getTipoSangre());
                    return expedienteRepository.save(expediente);
                }).orElseThrow(() -> new ResourceNotFoundException("Expediente no encontrado con id " + expedienteId));
    }

    @DeleteMapping("/expediente/{expedienteId}")
    public ResponseEntity<?> deleteExpediente(@PathVariable Long expedienteId){
        return expedienteRepository.findById(expedienteId)
                .map(expediente -> {
                    expedienteRepository.delete(expediente);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id " + expedienteId));
    }

}
