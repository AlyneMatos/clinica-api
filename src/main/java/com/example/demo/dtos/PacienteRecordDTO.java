package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record PacienteRecordDTO(String nome,Integer idade,LocalDate nascimento, String cpf,String cep) {
}
