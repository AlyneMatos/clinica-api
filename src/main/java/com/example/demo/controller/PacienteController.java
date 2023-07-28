package com.example.demo.controller;

import com.example.demo.dtos.PacienteRecordDTO;
import com.example.demo.entities.Paciente;
import com.example.demo.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> savePaciente(@RequestBody @Valid PacienteRecordDTO pacienteRecordDTO) {
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRecordDTO, paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(paciente));
    }
    @GetMapping("/paciente")
    public ResponseEntity<List<Paciente>> getAllPaciente(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.findAll());
    }
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Object> getPacienteById(@PathVariable Long id){
        Optional<Paciente> pacienteID = pacienteRepository.findById(id);
        if(pacienteID.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteID.get());
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<Paciente> putPacienteById(@PathVariable(value="id") Long id, @RequestBody @Valid PacienteRecordDTO pacienteRecordDTO ){
        Optional<Paciente> pacienteUP = pacienteRepository.findById(id);
        var paciente = pacienteUP.get();
        BeanUtils.copyProperties(pacienteRecordDTO,paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.save(paciente));
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable(value="id") Long id) {
        Optional<Paciente> pacienteDel = pacienteRepository.findById(id);
        if(pacienteDel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente not found.");
        }
        pacienteRepository.delete(pacienteDel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deleted successfully.");
    }

}
