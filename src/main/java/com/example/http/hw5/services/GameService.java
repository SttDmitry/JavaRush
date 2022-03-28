package com.example.http.hw5.services;

import com.example.http.hw5.entities.MStep;
import com.example.http.hw5.entities.Names;
import com.example.http.utils.TicTacToe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private TicTacToe ticTacToe;

    public GameService (TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public GameService() {
    }

    public void gameStart(Names names) {
        ticTacToe = new TicTacToe(names);
        ticTacToe.gridInitializeResult();
    }

    public boolean makeStep(MStep mstep) {
        String normalStep = mstep.getStepX() + " " + mstep.getStepY();
        return ticTacToe.gameTurnOnline(normalStep);
    }

    public List<String> getPrint() {
        return TicTacToe.getListOfWebPrint();
    }

    public String getResult(){
        return TicTacToe.getGameResult();
    }
}
