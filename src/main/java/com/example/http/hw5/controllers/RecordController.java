package com.example.http.hw5.controllers;

import com.example.http.hw5.entities.RecordNum;
import com.example.http.hw5.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/records")
    public String getRecords(Model model, @ModelAttribute("recordNum") RecordNum recordNum){
        System.out.println(recordNum);
        model.addAttribute("records", recordService.getRecords());
        return "records";
    }

    @PostMapping("/records/play")
    public String playRecord(Model model, @ModelAttribute("recordNum") RecordNum recordNum){
        model.addAttribute("replay", recordService.getReplay(recordNum.getNum()));
        return "replay";
    }

}
