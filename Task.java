package com.example.tasktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {
    private int Id;
    private String Title;
    private String Description;
    private String Status;


}
