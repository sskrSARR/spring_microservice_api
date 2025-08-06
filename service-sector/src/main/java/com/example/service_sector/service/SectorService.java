package com.example.service_sector.service;

import com.example.service_sector.model.Sector;
import com.example.service_sector.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Optional<Sector> getSectorById(Long id) {
        return sectorRepository.findById(id);
    }

    public Sector createSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector updateSector(Long id, Sector updatedSector) {
        return sectorRepository.findById(id).map(sector -> {
            sector.setName(updatedSector.getName());
            return sectorRepository.save(sector);
        }).orElseThrow(() -> new RuntimeException("Sector not found"));
    }

    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }
}
