package dev.samukklein.rinhacompiladores.dto;

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
        }
        return null;
    }
}
