package dev.waca.services.user.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id @GeneratedValue
    private String id;

    @Column
    String email;

    @Column
    String name;

    @CreatedDate
    LocalDateTime creactedAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

}
