package com.expediente.expMedico.repository;

import com.expediente.expMedico.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermedadRepository extends JpaRepository<Enfermedad,Long> {
}
