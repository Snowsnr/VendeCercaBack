package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TipoUsuario")
public class TipoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id", nullable = false)
    private Long tipId;

    @Column(name = "tip_nombre", length = 20, nullable = false)
    private String tipNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipId", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios = new HashSet<>();
}
