package com.expediente.expMedico.repository;

import com.expediente.expMedico.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    @Query(value = "SELECT * FROM paciente u WHERE u.ap_pat = :apPat",
            nativeQuery = true)
    Paciente findByNameLastname2(
            @Param("apPat") String apPat);
}
