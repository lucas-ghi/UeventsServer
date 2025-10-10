package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "local")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String endereco;
    public int numero;
    public String complemento;
    public int cep;
    public String bairro;
    public String cidade;
    public String estado;
    public String pais;
    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evento> eventos;
    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Organizacao> organizacoes;
}
