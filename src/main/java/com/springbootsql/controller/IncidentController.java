package com.springbootsql.controller;
import com.springbootsql.model.Incident;
import com.springbootsql.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAll() { return incidentService.getAll(); }

    @PostMapping
    public Incident create(@RequestBody Incident incident) { return incidentService.save(incident); }
}