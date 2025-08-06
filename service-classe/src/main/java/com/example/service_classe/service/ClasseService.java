package com.example.service_classe.service;


import com.example.service_classe.client.SectorClient;
import com.example.service_classe.model.Classe;
import com.example.service_classe.repository.ClasseRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private SectorClient sectorClient;

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Optional<Classe> getClasseById(Long id) {
        return classeRepository.findById(id);
    }

    public Classe createClasse(Classe classe) {
        try {
            sectorClient.getSectorById(classe.getSector_id());
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Sector inexistant");
        }

        return classeRepository.save(classe);
    }

    public Classe updateClasse(Long id, Classe updatedClasse) {
        return classeRepository.findById(id).map(classe -> {
            try {
                sectorClient.getSectorById(updatedClasse.getSector_id());
            } catch (FeignException.NotFound e) {
                throw new RuntimeException("Sector inexistant");
            }

            classe.setClassName(updatedClasse.getClassName());
            classe.setDescription(updatedClasse.getDescription());
            classe.setSector_id(updatedClasse.getSector_id());

            return classeRepository.save(classe);
        }).orElseThrow(() -> new RuntimeException("Classe introuvable avec id " + id));
    }

    public void deleteClasse(Long id) {
        if (!classeRepository.existsById(id)) {
            throw new RuntimeException("Classe introuvable avec id " + id);
        }
        classeRepository.deleteById(id);
    }
}
