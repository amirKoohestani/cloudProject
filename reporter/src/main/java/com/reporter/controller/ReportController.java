package com.reporter.controller;

import com.reporter.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<tempelate> getMails(){

    }

    @GetMapping(path = "{id}")
    public template getMailByUID(@PathVariable("id") int id){

    }

    @GetMapping(path = "configs/{id}")
    public template getMailByConfigID(PathVariable("id") int id){

    }
}