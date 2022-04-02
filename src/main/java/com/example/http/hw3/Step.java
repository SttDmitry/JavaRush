package com.example.http.hw3;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@JsonPropertyOrder({ "_num", "_playerId", "__text" })
@XmlType(propOrder = { "num", "playerId", "step" })
@Entity
@Table(name = "steps")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("_num")
    private int num;
    @JsonProperty("_playerId")
    private long playerId;
    @JsonProperty("__text")
    private String step;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Step() {
    }

    public Step(int num, Long playerId, String step) {
        this.num = num;
        this.playerId = playerId;
        this.step = step;
    }

    public Step(int num, String step) {
        this.num = num;
        this.step = step;
    }

    public String getNum() {
        return String.valueOf(num);
    }

    @XmlAttribute
    public void setNum(String num) {
        this.num = Integer.parseInt(num);
    }

    public Long getPlayerId() {
        return playerId;
    }

    @XmlAttribute
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getStep() {
        return step;
    }

    @XmlValue
    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Step{" +
                "num=" + num +
                ", playerId=" + playerId +
                ", step='" + step + '\'' +
                '}';
    }
}
