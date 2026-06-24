package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TipoProducto")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tprId")
public class TipoProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpr_id", nullable = false)
    private Long tprId;

    @Column(name = "tpr_nombre", length = 20, nullable = false)
    private String tprNombre;

    @OneToMany(mappedBy = "tprId", cascade = CascadeType.ALL)
    private Set<ProductoServicio> productos = new HashSet<>();
}
