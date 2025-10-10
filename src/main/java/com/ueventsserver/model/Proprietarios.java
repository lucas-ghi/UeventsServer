package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public User user;
}
