package com.example.http.hw5.controllers;


import com.example.http.hw5.entities.MStep;
import com.example.http.hw5.entities.Names;
import com.example.http.hw5.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("names") Names names) {
        return "start";
    }

    @PostMapping("/gamestart")
    private String gameStart(Names names, Model model, @ModelAttribute("mstep")MStep mstep) {
        gameService.gameStart(names);
        model.addAttribute("gameStep", gameService.getPrint());
        return "step";
    }

    @PostMapping("/makestep")
    private String makeStep(Model model, @Valid @ModelAttribute("mstep")MStep mstep) {
        if(gameService.makeStep(mstep)) {
            return "redirect:/gameresult";
        }
        model.addAttribute("gameStep", gameService.getPrint());
        return "step";
    }

    @GetMapping("/gameresult")
    private String gameResult(Model model, @ModelAttribute("gameResult")String result) {
        model.addAttribute("gameResult", gameService.getResult());
        gameService.saveGame();
        return "result";
    }

}
