package com.backend.backend.models;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class OutputMessage {
    private String userName;
    private String text;
    private String time;
}
