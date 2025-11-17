package com.udea.lab3LF.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflight")
    private Long idflight;

    @Column(name = "nombreavion", nullable = false, length = 80)
    private @NonNull String nombreavion;

    @Column(name = "numerovuelo", nullable = false, length = 80)
    private @NonNull String numerovuelo;

    @Column(name = "origen", nullable = false, length = 80)
    private @NonNull String origen;

    @Column(name = "destino", nullable = false, length = 80)
    private @NonNull String destino;

    @Column(name = "capacidad", nullable = false, length = 80)
    private @NonNull String capacidad;

    @Column(name = "rating", nullable = false, length = 80)
   @Min(value = 1, message = "rating must be >= 1")
    @Max(value = 5, message = "rating must be <= 5")
    @NonNull
    private Long rating;

    @Column(name = "planvuelo", nullable = false, length = 80)
    private @NonNull Long planvuelo;

    private Boolean cumplido;

    public Long getIdflight() {
        return idflight;
    }

    public String getNombreavion() {
        return nombreavion;
    }

    public String getNumerovuelo() {
        return numerovuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public Long getRating() {
        return rating;
    }

    public Long getPlanvuelo() {
        return planvuelo;
    }

    public Boolean getCumplido() {
        return cumplido;
    }

    public void setIdflight(Long idflight) {
        this.idflight = idflight;
    }

    public void setNombreavion(String nombreavion) {
        this.nombreavion = nombreavion;
    }

    public void setNumerovuelo(String numerovuelo) {
        this.numerovuelo = numerovuelo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public void setPlanvuelo(Long planvuelo) {
        this.planvuelo = planvuelo;
    }

    public void setCumplido(Boolean cumplido) {
        this.cumplido = cumplido;
    }

    

}
