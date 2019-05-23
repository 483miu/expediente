package com.expediente.expMedico.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Enfermedad {
    @Id
   // @GeneratedValue(strategy= GenerationType.AUTO)
    @GeneratedValue(generator = "enfermedad_generator")
    @SequenceGenerator(
            name = "enfermedad_generator",
            sequenceName = "enfermedad_sequence",
            initialValue = 10
    )
    private Long idEnfermedad;
    private String nombre;
    private String tipoEnfermedad;

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
