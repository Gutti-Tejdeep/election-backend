package com.springbootsql.service;
import com.springbootsql.model.Incident;
import com.springbootsql.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAll() { return incidentRepository.findAll(); }
    public Incident save(Incident incident) { return incidentRepository.save(incident); }
}