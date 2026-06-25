package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Direccion")
public class Direccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dir_id", nullable = false)
    private Long dirId;

    @Column(name = "dir_colonia", length = 100, nullable = false)
    private String dirColonia;

    @Column(name="dir_calle", length = 100, nullable = false)
    private String dirCalle;

    @Column(name = "dir_numero", length = 20, nullable = true)
    private String dirNumero;

    @Column(name = "dir_indicaciones", length = 300, nullable = true)
    private String dirIndicaciones;

    @Column(name = "dir_cp", nullable = false)
    private int dirCp;

    @Column(name = "dir_latitud", nullable = true)
    private BigDecimal dirLatitud;

    @Column(name = "dir_longitud", nullable = true)
    private BigDecimal dirLongitud;

    @Column(name = "dir_ultimaubicacion", nullable = true)
    private OffsetDateTime dirUltimaUbicacion;

    @OneToMany(mappedBy = "dirId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dirId"})
    private Set<Negocio> negocios = new HashSet<>();

}
