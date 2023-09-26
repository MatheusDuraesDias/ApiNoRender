package com.example.funcionario.controllers;

import com.example.funcionario.models.Funcionario;
import com.example.funcionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public Funcionario postFuncionario(
        @RequestBody Funcionario funcionario
    ){
        return this.funcionarioRepository.save(funcionario);
    }


    @GetMapping
    public List<Funcionario> getFuncionarios(){
        return this.funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioPorId(
            @PathVariable Integer id
    ){
        Optional<Funcionario>funcionario = this.funcionarioRepository.findById(id);

        if(funcionario.isPresent()){
            return ResponseEntity.ok(funcionario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Funcionario> alterarFuncionario(
            @PathVariable Integer id,
            @RequestBody Funcionario funcionarioAtualizacao
    ){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);

        if(funcionario.isPresent()){
            Funcionario novoFuncionario = funcionario.get();

            if(funcionarioAtualizacao.getCargo() != null){
                novoFuncionario.setCargo(funcionarioAtualizacao.getCargo());
            }

            if(funcionarioAtualizacao.getDepartamento() != null){
                novoFuncionario.setDepartamento(funcionarioAtualizacao.getDepartamento());
            }

            if(funcionarioAtualizacao.getSalario() != null){
                novoFuncionario.setSalario(funcionarioAtualizacao.getSalario());
            }

            Funcionario atualizado = this.funcionarioRepository.save(novoFuncionario);

            return ResponseEntity.ok(atualizado);
        }

//        String test = dateFormat.format("1");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{dataAdmissao}")
    public ResponseEntity<Funcionario> getFuncionarioPorDataAdmissao(
            @PathVariable String dataAdmissao
    ){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findByData(dataAdmissao);

        if (funcionario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.funcionarioRepository.delete(funcionario.get());
        return ResponseEntity.noContent().build();
    }
}
