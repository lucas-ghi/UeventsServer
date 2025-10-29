package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public String descriao;
    @OneToOne
    @JoinColumn(name = "foto_perfil", referencedColumnName = "id", unique = true, nullable = true)
    private Foto foto_perfil;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Organizadores> eventosOrganizados;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Proprietarios> organizacoes;
    @OneToOne
    @JoinColumn(name = "contatos", referencedColumnName = "id", unique = true, nullable = true)
    public Contato contatos;
    public String refresh_token;
    public Date refresh_validade;
    @OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Follow> seguindo;
    @OneToMany(mappedBy = "seguido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Follow> seguidores;
}
