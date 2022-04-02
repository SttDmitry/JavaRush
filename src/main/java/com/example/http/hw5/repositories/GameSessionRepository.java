package com.example.http.hw5.repositories;

import com.example.http.hw3.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
