package com.example.service_sector.controller;


import com.example.service_sector.model.Sector;
import com.example.service_sector.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public List<Sector> getAll() {
        return sectorService.getAllSectors();
    }

    @GetMapping("/{id}")
    public Sector getById(@PathVariable Long id) {
        return sectorService.getSectorById(id).orElseThrow(() -> new RuntimeException("Sector not found"));
    }

    @PostMapping
    public Sector create(@RequestBody Sector sector) {
        return sectorService.createSector(sector);
    }

    @PutMapping("/{id}")
    public Sector update(@PathVariable Long id, @RequestBody Sector sector) {
        return sectorService.updateSector(id, sector);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sectorService.deleteSector(id);
    }
}
