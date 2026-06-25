package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Negocio")
public class Negocio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "neg_id", nullable = false)
    private Long negId;

    @Column(name = "neg_nombre", length = 50, nullable = false)
    private String negNombre;

    @Column(name = "neg_descripcion", length = 300, nullable = false)
    private String negDescripcion;

    @Column(name = "neg_fecha", nullable = false)
    private OffsetDateTime negFecha;

    @Column(name = "neg_activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean negActivo;

    @Column(name = "neg_ambulante", nullable = false)
    private Boolean negAmbulante;

    @Column(name = "neg_abierto", nullable = false)
    private Boolean negAbierto;

    @OneToMany(mappedBy = "negId", cascade = CascadeType.ALL)
    private Set<Imagen> imagenes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id")
    @JsonIgnoreProperties({"negocios", "feedbacks", "chatsComoComprador", "chatsComoVendedor", "hibernateLazyInitializer", "handler"})
    private Persona perId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dir_id")
    @JsonIgnoreProperties({"negocios", "hibernateLazyInitializer", "handler"})
    private Direccion dirId;

    @OneToMany(mappedBy="negId",
            cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true)
    @JsonIgnoreProperties({"negId"})
    private Set<ProductoServicio> productoServicios = new HashSet<>();

    @OneToMany(mappedBy = "negId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"negId"})
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToMany(mappedBy = "negId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"negId"})
    private Set<Chat> chats = new HashSet<>();

}
