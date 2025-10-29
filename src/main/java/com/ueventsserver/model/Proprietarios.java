package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proprietarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proprietarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    @JoinColumn(name = "organizacao", referencedColumnName = "id", nullable = false)
    public Organizacao organizacao;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    public Usuario usuario;
}
