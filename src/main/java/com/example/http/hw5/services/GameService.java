package com.example.http.hw5.services;

import com.example.http.hw3.GameSession;
import com.example.http.hw5.entities.MStep;
import com.example.http.hw5.entities.Names;
import com.example.http.hw5.repositories.*;
import com.example.http.utils.TicTacToe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameSessionRepository gameSessionRepository;
    private GameRepository gameRepository;
    private GameResultRepository gameResultRepository;
    private PlayerRepository playerRepository;
    private StepRepository stepRepository;

    @Autowired
    public void setRepositories(GameSessionRepository gSR, GameRepository gameRepository,
                                 GameResultRepository gameResultRepository, PlayerRepository playerRepository,
                                 StepRepository stepRepository) {
        this.gameSessionRepository = gSR;
        this.gameRepository = gameRepository;
        this.gameResultRepository = gameResultRepository;
        this.playerRepository = playerRepository;
        this.stepRepository = stepRepository;
    }

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
        System.out.println(mstep);
        String normalStep = mstep.getStepX() + " " + mstep.getStepY();
        return ticTacToe.gameTurnOnline(normalStep);
    }

    public List<String> getPrint() {
        return TicTacToe.getListOfWebPrint();
    }

    public String getResult(){
        return TicTacToe.getGameResult();
    }

    public void saveGame() {
        GameSession game = TicTacToe.getGame();
        playerRepository.saveAll(game.getPlayer());
        stepRepository.saveAll(game.getGame().getSteps());
        gameRepository.save(game.getGame());
        gameResultRepository.save(game.getGameResult());
        gameSessionRepository.save(game);
    }
}
