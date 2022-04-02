package com.example.http.hw3;


import com.fasterxml.jackson.annotation.*;
import jakarta.xml.bind.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Gameplay")
@XmlType(propOrder = { "player", "game", "gameResult" })
@JsonRootName("Gameplay")
@Entity
@Table(name = "gamesessions")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @JsonIgnore
    @Column(name = "name")
    private String name;
    @JsonProperty("Player")
    @ManyToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "sessions_players",
            joinColumns = @JoinColumn(name = "gamesession_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "player")
    private List<Player> player = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    @JsonProperty("Game")
    private Game game;
    @OneToOne
    @JoinColumn(name = "game_result_id", referencedColumnName = "resultId")
    @JsonProperty("GameResult")
    private GameResult gameResult = new GameResult();

    public GameSession(){}

    public GameSession(String playerName1, String playerName2) {
        this.game = new Game();
        this.name = playerName1 + "vs." + playerName2 + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk-mm-ss"));
        this.player.add(new Player( playerName1, "X"));
        this.player.add(new Player( playerName2, "O"));
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }


    public List<Player> getPlayer() {
        return player;
    }

    @XmlElement(name = "Player")
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }


    @XmlElement(name = "Game")
    public void setGame(Game game) {
        this.game = game;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @XmlElement(name="GameResult")
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", player=" + player +
                ", game=" + game +
                ", gameResult=" + gameResult +
                '}';
    }
}
