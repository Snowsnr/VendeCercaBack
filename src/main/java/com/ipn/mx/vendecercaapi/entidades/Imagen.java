package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Imagen")
public class Imagen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", nullable = false)
    private Long imgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neg_id")
    private Negocio negId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id", unique = true)
    private Persona perId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", unique = true)
    private ProductoServicio proId;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "img_principal", nullable = true)
    private Boolean imgPrincipal;


}
