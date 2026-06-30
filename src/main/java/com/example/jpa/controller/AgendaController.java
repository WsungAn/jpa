package com.example.jpa.controller;

import com.example.jpa.dto.*;
import com.example.jpa.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping("/agendas")
    public CreateAgendaResponse response(@RequestBody CreateAgendaRequest request) {
        return agendaService.save(request);
    }

    @GetMapping("/agendas/{agendaId}")
    public GetOneAgendaResponse getOneAgenda (@PathVariable Long agendaId) {
        return agendaService.getOne(agendaId);
    }

    @GetMapping("/agendas")
    public List<GetOneAgendaResponse> getAllAgendas(String username) {
        return agendaService.getAll(username);
    }

    @PutMapping("/agendas{agendaId}")
    public UpdateAgendaResponse update (@PathVariable Long agendaId, @RequestBody UpdateAgendaRequest request) {
        return agendaService.update(agendaId, request);
    }

    @DeleteMapping("/agendas{agendaId}")
    public void delete (@PathVariable Long agendaId, @RequestBody DeleteAgendaRequest request) {
        agendaService.delete(agendaId, request);
    }
}
