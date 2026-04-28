package com.springbootsql.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootsql.model.Volunteer;
import com.springbootsql.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    public List<Volunteer> getAllVolunteers() {
        return repository.findAll();
    }

    public Volunteer addVolunteer(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public void deleteVolunteer(Long id) {
        repository.deleteById(id);
    }

    public Volunteer updateVolunteer(Long id, Volunteer volunteerDetails) {
        Volunteer volunteer = repository.findById(id).orElseThrow(() -> new RuntimeException("Volunteer not found with id " + id));
        if (volunteerDetails.getStatus() != null) {
            volunteer.setStatus(volunteerDetails.getStatus());
        }
        return repository.save(volunteer);
    }
}