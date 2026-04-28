package com.springbootsql.controller;
import com.springbootsql.model.Interaction;
import com.springbootsql.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @GetMapping
    public List<Interaction> getAll() { return interactionService.getAll(); }

    @PostMapping
    public Interaction create(@RequestBody Interaction interaction) { return interactionService.save(interaction); }
}