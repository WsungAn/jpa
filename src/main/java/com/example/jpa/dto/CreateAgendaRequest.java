package com.example.jpa.dto;

import lombok.Getter;

@Getter
public class CreateAgendaRequest {

    private String title;
    private String content;
    private String username;
    private String password;
}
