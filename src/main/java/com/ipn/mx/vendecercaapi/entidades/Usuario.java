package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Long usuId;

    @Column(name = "usu_nombre", length = 15, nullable = false)
    private String usuNombre;

    @Column(name = "usu_password", length = 255, nullable = false)
    private String usuPassword;

    @Column(name = "usu_activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean usuActivo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_id")
    private TipoUsuario tipId;

    @JsonIgnore
    @OneToOne(mappedBy="usuId",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private Persona persona;
}
