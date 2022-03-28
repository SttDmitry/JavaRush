package com.example.http.hw5.services;

import com.example.http.hw5.entities.MStep;
import com.example.http.hw5.entities.Names;
import com.example.http.utils.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private GameService gameService;
    private RecordService recordService;
    private TicTacToe ticTacToe = new TicTacToe(new Names("", null));;

    @BeforeEach
    void initUseCase() {
        gameService = new GameService(ticTacToe);
        recordService = new RecordService();
    }

    @Test
    void gameStart() {
        assertEquals("defaultNick1", TicTacToe.getGame().getPlayer().get(0).getName());
        assertEquals("defaultNick2", TicTacToe.getGame().getPlayer().get(1).getName());
    }


    @Test
    void makeStep__ShouldThrowExpected() {
        MStep mstep = new MStep("String", "");
        try {
            Integer.parseInt(mstep.getStepX());
            fail("Expected exception to be thrown");
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Integer.parseInt(mstep.getStepY());
            fail("Expected exception to be thrown");
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test
    void getResult() {
        assertEquals("No result!" , gameService.getResult());
    }

    @Test
    void getReplay__ShouldThrowExpected(){
        recordService.getRecords();
        try {
            recordService.getReplay(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}