package com.springbootsql.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootsql.model.Report;
import com.springbootsql.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    public List<Report> getAllReports() {
        return repository.findAll();
    }

    public Report addReport(Report report) {
        return repository.save(report);
    }

    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}