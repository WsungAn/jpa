package com.example.jpa.service;

import com.example.jpa.dto.*;
import com.example.jpa.entity.Agenda;
import com.example.jpa.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository agendaRepository;

    @Transactional
    public CreateAgendaResponse save(CreateAgendaRequest request) {
        Agenda agenda = new Agenda(
                request.getTitle(),
                request.getContent(),
                request.getUsername(),
                request.getPassword()
        );
        Agenda savedAgenda = agendaRepository.save(agenda);

        return new CreateAgendaResponse(
                savedAgenda.getId(),
                savedAgenda.getTitle(),
                savedAgenda.getContent(),
                savedAgenda.getUsername(),
                savedAgenda.getCreatedAt(),
                savedAgenda.getModifiedAt()
        );
    }


    @Transactional(readOnly = true)
    public GetOneAgendaResponse getOne(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetOneAgendaResponse(
                agenda.getId(),
                agenda.getTitle(),
                agenda.getContent(),
                agenda.getUsername(),
                agenda.getCreatedAt(),
                agenda.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetOneAgendaResponse> getAll(String username) {
        List<Agenda> agendas;
        if (username == null || username.isBlank()) {
            agendas = agendaRepository.findAll();
        } else {
            agendas = agendaRepository.findByUsernameOrderByModifiedAtDesc(username);
        }

        List<GetOneAgendaResponse> dtos = new ArrayList<>();

        for (Agenda agenda : agendas) {
            GetOneAgendaResponse dto = new GetOneAgendaResponse(
                    agenda.getId(),
                    agenda.getTitle(),
                    agenda.getContent(),
                    agenda.getUsername(),
                    agenda.getCreatedAt(),
                    agenda.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateAgendaResponse update(Long agendaId, UpdateAgendaRequest request) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        if (!agenda.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        agenda.update(
                request.getTitle(),
                request.getUsername()
        );
        return new UpdateAgendaResponse(
                agenda.getId(),
                agenda.getTitle(),
                agenda.getContent(),
                agenda.getUsername()
        );

    }

    @Transactional
    public void delete(Long agendaId, DeleteAgendaRequest request) {
        boolean existence = agendaRepository.existsById(agendaId);
        if (!existence) {
            throw new IllegalArgumentException("없는 일정입니다.");
        }

        Agenda agenda = agendaRepository.findById(agendaId).get();

        if (!agenda.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }agendaRepository.delete(agenda);

    }
}
