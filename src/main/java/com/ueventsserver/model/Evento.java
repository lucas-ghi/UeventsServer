package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String tipo;
    public String nome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local", referencedColumnName = "id", unique = true, nullable = false)
    public Local local;
    public Date dataEvento;
    public String descricao;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Atracao> atracoes = new ArrayList<>();
    public String comidas_bebidas;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Foto> fotos;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Ingresso> ingressos;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Organizadores> organizacaoProprietaria;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Organizadores> organizadores;
}
