package com.example.http.hw5.services;

import com.example.http.hw3.IParse;
import com.example.http.hw3.ParseFabric;
import com.example.http.utils.TicTacToe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final IParse parser;

    {
        parser = ParseFabric.getParserInstance();
    }

    public List<String> getRecords() {
        return parser.getRecordsList(true);
    }

    public List<String> getReplay(int num) {
        parser.setRecordNum(num);
        return TicTacToe.getListOfWebPrint();
    }
}
