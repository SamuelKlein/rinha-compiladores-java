package dev.samukklein.rinhacompiladores.dto;

import javax.management.RuntimeErrorException;

public enum KindEnum {
    VAR,
    LET,
    CALL,
    INT,
    STR,
    BOOL,
    PRINT,
    IF;

    public static KindEnum getEnum(Term expressionDTO) {
        if (expressionDTO != null) {
            if (expressionDTO.getKind() != null) {
                return KindEnum.valueOf(expressionDTO.getKind().toUpperCase());
            }
            throw new RuntimeErrorException(null, "Invalide Kind " + expressionDTO.getKind());
        }
        throw new RuntimeErrorException(null, "Invalide expressionDTO = " + expressionDTO);
    }
}
