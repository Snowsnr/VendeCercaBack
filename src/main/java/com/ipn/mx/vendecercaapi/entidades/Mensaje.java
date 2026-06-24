package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Mensaje")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "menId")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_idemisor")
    private Persona perIdEmisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cha_id")
    private Chat chaId;

}
