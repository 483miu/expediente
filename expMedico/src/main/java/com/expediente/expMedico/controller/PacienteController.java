package com.expediente.expMedico.controller;

        import com.expediente.expMedico.exception.ResourceNotFoundException;
        import com.expediente.expMedico.model.Paciente;
        import com.expediente.expMedico.repository.PacienteRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.data.domain.Pageable;

        import javax.validation.Valid;

@RestController
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/paciente")
    public Paciente createPaciente(@Valid @RequestBody Paciente paciente){
        System.out.println(paciente.toString());
        return pacienteRepository.save(paciente);
    }


    @GetMapping("/paciente")
    public Page<Paciente> getPaciente(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    @GetMapping("/paciente/{apPat}")
    public Paciente getByApPat(@PathVariable String apPat){
        return pacienteRepository.findByNameLastname2(apPat);
    }

    @PutMapping("/paciente/{pacienteId}")
    public Paciente updatePaciente(@PathVariable Long pacienteId,
                                   @Valid @RequestBody Paciente pacienteRequest) {
        return pacienteRepository.findById(pacienteId)
                .map(paciente -> {
                    paciente.setNombre(pacienteRequest.getNombre());
                    paciente.setApPat(pacienteRequest.getApPat());
                    paciente.setApMat(pacienteRequest.getApMat());
                    paciente.setFechaNa(pacienteRequest.getFechaNa());
                    paciente.setEdad(pacienteRequest.getEdad());
                    paciente.setSexo(pacienteRequest.getSexo());
                    paciente.setOcupacion(pacienteRequest.getOcupacion());
                    return pacienteRepository.save(paciente);
                }).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id " + pacienteId));
    }

    @DeleteMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long pacienteId) {
        return pacienteRepository.findById(pacienteId)
                .map(paciente -> {
                    pacienteRepository.delete(paciente);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id " + pacienteId));
    }

}
