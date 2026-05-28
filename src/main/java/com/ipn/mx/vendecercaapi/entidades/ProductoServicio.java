package com.ipn.mx.vendecercaapi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ProductoServicio")

public class ProductoServicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neg_id")
    private Negocio negId;

    @Column(name = "pro_nombre", length = 50, nullable = false)
    private String proNombre;

    @Column(name = "pro_descripcion", length = 300, nullable = false)
    private String proDescripcion;

    @Column(name = "pro_fecha", nullable = false)
    private OffsetDateTime proFecha;

    @Column(name = "pro_activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean proActivo;

    @Column(name = "pro_precio", nullable = false)
    private BigDecimal proPrecio;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tpr_id")
    private TipoProducto tprId;

    @Column(name = "pro_cantidad", nullable = false)
    private int proCantidad;

    @JsonIgnore
    @OneToOne(mappedBy = "proId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Imagen imagen;
}
