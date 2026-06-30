package com.example.jpa.repository;

import com.example.jpa.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {


    List<Agenda> username(String username);

    List<Agenda> findByUsernameOrderByModifiedAtDesc(String username);


}
