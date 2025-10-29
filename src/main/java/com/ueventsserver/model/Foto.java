package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String foto;
    @ManyToOne
    @JoinColumn(name="evento", referencedColumnName = "id", nullable = true)
    public Evento evento;
    @ManyToOne
    @JoinColumn(name="organizacao", referencedColumnName = "id", nullable = true)
    public Organizacao organizacao;
}
