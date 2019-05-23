package com.expediente.expMedico.repository;

import com.expediente.expMedico.model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente,Long> {
}
