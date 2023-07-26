package com.example.demo.service;


import com.example.demo.entities.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private  PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente){

        Paciente paciente1 = pacienteRepository.save(paciente);

        return paciente1;
    }


}
