package com.springbootsql.service;
import com.springbootsql.model.Interaction;
import com.springbootsql.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;

    public List<Interaction> getAll() { return interactionRepository.findAll(); }
    public Interaction save(Interaction interaction) { return interactionRepository.save(interaction); }
}