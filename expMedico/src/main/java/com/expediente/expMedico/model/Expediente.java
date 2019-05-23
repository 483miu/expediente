package com.expediente.expMedico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Expediente {
    @Id
    @GeneratedValue(generator = "expediente_generator")
    @SequenceGenerator(
            name = "expediente_generator",
            sequenceName = "expediente_sequence",
            initialValue = 10
    )
    private Long idExpediente;
    private String cita;
    private String operaciones;
    private String analisis;
    private String diagnostico;
    private String medicamento;
    private String tipoSangre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idPaciente", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idEnfermedad", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Enfermedad enfermedad;

    @JsonProperty("idPaciente")
    private void unpackNested(Long idPaciente) {
        this.paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
    }

    @JsonProperty("idEnfermedad")
    private void unpackNested2(Long idEnfermedad){
        this.enfermedad = new Enfermedad();
        enfermedad.setIdEnfermedad(idEnfermedad);
    }

    public String getAnalisis() {
        return analisis;
    }

    public String getCita() {
        return cita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }


    public Long getIdExpediente() {
        return idExpediente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getOperaciones() {
        return operaciones;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setIdExpediente(Long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
