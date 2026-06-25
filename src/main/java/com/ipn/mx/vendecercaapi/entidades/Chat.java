package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Chat")
public class Chat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cha_id", nullable = false)
    private Long chaId;

    @OneToMany(mappedBy="chaId",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true)
    private Set<Mensaje> mensajes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_idcomprador")
    private Persona perIdComprador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_idvendedor")
    private Persona perIdVendedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neg_id")
    private Negocio negId;
}
