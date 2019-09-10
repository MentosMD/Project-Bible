package com.backend.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "messages")
public class OutputMessage {

    public OutputMessage(String userName, String text, String time) {
        this.userName = userName;
        this.text = text;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "text")
    private String text;
    @Column(name = "time")
    private String time;
}
