package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id", nullable = false)
    private Long perId;

    @Column(name = "per_nombrecompleto", length = 50, nullable = false)
    private String perNombreCompleto;

    @Column(name = "per_telefono", length = 10, nullable = false)
    private String perTelefono;

    @Column(name = "per_correo", length = 50, nullable = false)
    private String perCorreo;

    @Column(name = "per_fecha", nullable = false)
    private OffsetDateTime perFecha;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id")
    private Usuario usuId;

    @OneToMany(mappedBy = "perIdComprador")
    @JsonIgnoreProperties({"perIdComprador"})
    private Set<Chat> chatsComoComprador = new HashSet<>();

    @OneToMany(mappedBy = "perIdVendedor")
    @JsonIgnoreProperties({"perIdVendedor"})
    private Set<Chat> chatsComoVendedor = new HashSet<>();

    @OneToMany(mappedBy="perId", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties({"perId"})
    private Set<Negocio> negocios = new HashSet<>();

    @OneToMany(mappedBy = "perId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"perId"})
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToOne(mappedBy = "perId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Imagen imagen;
}
