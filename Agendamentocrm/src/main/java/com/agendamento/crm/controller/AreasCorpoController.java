package com.agendamento.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agendamento.crm.model.AreasCorpo;
import com.agendamento.crm.repository.AreasCorpoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/areas-corpo")
public class AreasCorpoController {
    @Autowired
    private AreasCorpoRepository areasCorpoRepository;

    @PostMapping
    public ResponseEntity<AreasCorpo> adicionarAreaCorpo(@RequestBody AreasCorpo areaCorpo) {
        AreasCorpo novaAreaCorpo = areasCorpoRepository.save(areaCorpo);
        return ResponseEntity.ok(novaAreaCorpo);
    }

    @GetMapping
    public List<AreasCorpo> listarAreasCorpo() {
        return areasCorpoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreasCorpo> buscarAreaCorpo(@PathVariable Long id) {
        Optional<AreasCorpo> areaCorpo = areasCorpoRepository.findById(id);
        if (areaCorpo.isPresent()) {
            return ResponseEntity.ok(areaCorpo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreasCorpo> atualizarAreaCorpo(@PathVariable Long id, @RequestBody AreasCorpo areaCorpo) {
        if (areasCorpoRepository.existsById(id)) {
            areaCorpo.setId(id);
            AreasCorpo areaCorpoAtualizada = areasCorpoRepository.save(areaCorpo);
            return ResponseEntity.ok(areaCorpoAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAreaCorpo(@PathVariable Long id) {
        if (areasCorpoRepository.existsById(id)) {
            areasCorpoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
