package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local", referencedColumnName = "id", nullable = false)
    private Local local;
    @OneToOne
    @JoinColumn(name = "contato", referencedColumnName = "id", unique = true, nullable = true)
    public Contato contatos;
    @OneToMany(mappedBy = "organizacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Foto> fotos;
    @OneToMany(mappedBy = "organizacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Organizadores> eventosOrganizados;
    @OneToMany(mappedBy = "organizacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Proprietarios> proprietarios;
}
