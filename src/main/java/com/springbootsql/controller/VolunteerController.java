package com.springbootsql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springbootsql.model.Volunteer;
import com.springbootsql.service.VolunteerService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @PostMapping
    public ResponseEntity<?> addVolunteer(@RequestBody Volunteer volunteer) {
        try {
            Volunteer savedVolunteer = volunteerService.addVolunteer(volunteer);
            return ResponseEntity.ok(savedVolunteer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVolunteer(@PathVariable Long id) {
        try {
            volunteerService.deleteVolunteer(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteerDetails) {
        try {
            Volunteer updatedVolunteer = volunteerService.updateVolunteer(id, volunteerDetails);
            return ResponseEntity.ok(updatedVolunteer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}