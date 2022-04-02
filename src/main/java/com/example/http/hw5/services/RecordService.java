package com.example.http.hw5.services;

import com.example.http.hw3.GameSession;
import com.example.http.hw3.IParse;
import com.example.http.hw3.ParseFabric;
import com.example.http.hw5.repositories.GameSessionRepository;
import com.example.http.utils.TicTacToe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private GameSessionRepository gSR;
    private List<GameSession> sessions;

    @Autowired
    public void setGameSessionRepository(GameSessionRepository gSR) {
        this.gSR = gSR;
//        this.gSR.saveAll(parser.getSessionList());
    }

    private final IParse parser;

    {
        parser = ParseFabric.getParserInstance();
    }

    public List<String> getRecords() {
//        return parser.getRecordsList(true);
        sessions = gSR.findAll();
        return sessions.stream().map(GameSession::getName).toList();
    }

    public List<String> getReplay(int num) {
//        parser.setRecordNum(num);
        if (num > 0 && num <= sessions.size()) {
            System.out.println(sessions.get(num-1));
            parser.readRecord(sessions.get(num-1));
        }
        return TicTacToe.getListOfWebPrint();
    }
}
