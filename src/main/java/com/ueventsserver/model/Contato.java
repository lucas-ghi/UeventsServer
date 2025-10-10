package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contato")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String whatsapp;
    public String email;
    public String instagram;
    public String facebook;
    public String site;
}
