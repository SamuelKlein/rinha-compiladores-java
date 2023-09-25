package dev.samukklein.rinhacompiladores.dto;

import lombok.Data;
import java.util.List;

import com.google.gson.JsonElement;

@Data
public class Term {

    private String kind;
    private Name name;

    private JsonElement value;
    private String text;

    private Location location;

    private Term valueExpression;
    private String valueString;

    private List<Parameter> parameters;
    private Term condition;

    private String op;
    private Term lhs;
    private Term rhs;

    private Term then;
    private Term otherwise;

    private Term callee;

    private List<Term> arguments;

    private Term next;

}
