package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fed_id", nullable = false)
    private Long fedId;

    @Column(name = "fed_texto", nullable = false)
    private String fedTexto;

    @Column(name = "fed_estrella", nullable = false)
    private Integer fedEstrella;

    @Column(name = "fed_fecha", nullable = false)
    private OffsetDateTime fedFecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id")
    private Persona perId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neg_id")
    private Negocio negId;
}
