package com.example.service_classe.controller;

import com.example.service_classe.model.Classe;
import com.example.service_classe.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> getAll() {
        return classeService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(@PathVariable Long id) {
        return classeService.getClasseById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Classe> create(@RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.createClasse(classe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id, @RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.updateClasse(id, classe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
}
