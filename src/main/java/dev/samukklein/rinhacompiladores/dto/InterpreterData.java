package dev.samukklein.rinhacompiladores.dto;

import lombok.Data;

@Data
public class InterpreterData {
    private String name;
    private Term expression;
}
