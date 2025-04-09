package br.com.isaccanedo.controller;

import br.com.isaccanedo.exception.ResourceNotFoundException;
import br.com.isaccanedo.model.FuncionarioModel;
import br.com.isaccanedo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiV1")
public class FuncionariosController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionarios")
    public List<FuncionarioModel> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping("/funcionario/novo")
    public FuncionarioModel createFuncionario(@Valid @RequestBody FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/funcionario/{id}")
    public FuncionarioModel getFuncionarioById(@PathVariable(value = "id") Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario", "id", funcionarioId));
    }

    @PutMapping("/funcionario/{id}")
    public FuncionarioModel updateFuncionario(@PathVariable(value = "id") Long funcionarioId,
                                              @Valid @RequestBody FuncionarioModel funcionarioDetails) {

        FuncionarioModel funcionarioModel = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario", "id", funcionarioId));

        funcionarioModel.setNome(funcionarioDetails.getNome());
        funcionarioModel.setCargo(funcionarioDetails.getCargo());

        return funcionarioRepository.save(funcionarioModel);
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable(value = "id") Long funcionarioId) {
        FuncionarioModel funcionarioModel = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario", "id", funcionarioId));

        funcionarioRepository.delete(funcionarioModel);

        return ResponseEntity.ok().build();
    }
}
