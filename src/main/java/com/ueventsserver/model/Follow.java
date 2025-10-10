package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seguidor_id", nullable = false)
    private User seguidor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seguido_id", nullable = false)
    private User seguido;
}
