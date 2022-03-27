package com.example.http.hw3;

import java.util.List;

public interface IParse {
    void parse(GameSession game);
    void readRecord (String name);
    List<String> getRecordsList(boolean isOnline);
    void setRecordNum(int num);
}
