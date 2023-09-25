package dev.samukklein.rinhacompiladores.tasks;

import dev.samukklein.rinhacompiladores.Interpreter;
import dev.samukklein.rinhacompiladores.dto.Term;

public class Str implements TaskExec {

    private String value;

    public Str(Interpreter interpreter, Term expression) {
        if (expression.getValueString() != null) {
            this.value = expression.getValueString();
        }
    }

    @Override
    public String exec() {
        return value;
    }

}
