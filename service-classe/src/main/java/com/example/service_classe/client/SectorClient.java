package com.example.service_classe.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-sector")
public interface SectorClient {
    @GetMapping("/sectors/{id}")
    Object getSectorById(@PathVariable("id") Long id);
}
