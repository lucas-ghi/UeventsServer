package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organizadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    @JoinColumn(name = "evento", referencedColumnName = "id", nullable = false)
    public Evento evento;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = true)
    public Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "organizacao", referencedColumnName = "id", nullable = true)
    public Organizacao organizacao;
}
