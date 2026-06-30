package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "agendas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Agenda extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String content;
    @Column(nullable = false, length = 100)
    private String username;
    @Column(nullable = false, length = 100)
    private Long password;
    @Column(nullable = false, length = 100)
    LocalDateTime createdAt;
    @Column(nullable = false, length = 100)
    LocalDateTime modifiedAt;

    public Agenda(String title, String content, String username, Long password) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.password = password;
    }

    public void update(String title, String username) {
        this.title = title;
        this.username = username;
    }
}
