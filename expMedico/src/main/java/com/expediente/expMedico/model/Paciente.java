package com.expediente.expMedico.model;

import javax.persistence.*;

@Entity
@Table(name="paciente")
public class Paciente {


    @Id
    @GeneratedValue(generator = "paciente_generator")
    @SequenceGenerator(
            name = "paciente_generator",
            sequenceName = "paciente_sequence",
            initialValue = 10
    )
    private Long idPaciente;

    private String nombre;
    private String apPat;
    private String apMat;
    private String fechaNa;
    private int edad;
    private String sexo;
    private String ocupacion;


    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getFechaNa() {
        return fechaNa;
    }

    public void setFechaNa(String fechaNa) {
        this.fechaNa = fechaNa;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }



    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nombre='" + nombre + '\'' +
                ", apPat='" + apPat + '\'' +
                ", apMat='" + apMat + '\'' +
                ", fechaNa='" + fechaNa + '\'' +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
}
