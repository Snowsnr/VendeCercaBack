package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Mensaje")
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "men_id", nullable = false)
    private Long menId;

    @Column(name = "men_texto", nullable = false)
    private String menTexto;

    @Column(name = "men_fecha", nullable = false)
    private OffsetDateTime menFecha;

    @Column(name = "men_leido", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean menLeido;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_idemisor")
    private Persona perIdEmisor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cha_id")
    private Chat chaId;

}
