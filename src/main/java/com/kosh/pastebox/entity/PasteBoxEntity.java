package com.kosh.pastebox.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "pastebox")
public class PasteBoxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String data;

    @Column(columnDefinition = "VARCHAR(500)", unique = true)
    private String hash;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lifetime;

    @Column(columnDefinition = "BOOLEAN")
    private boolean isPublic;

}
