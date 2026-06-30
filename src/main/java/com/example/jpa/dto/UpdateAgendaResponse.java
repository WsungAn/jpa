package com.example.jpa.dto;

import lombok.Getter;

@Getter
public class UpdateAgendaResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String username;

    public UpdateAgendaResponse (Long id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;

    }
}

