package dev.samukklein.rinhacompiladores.tasks;

import dev.samukklein.rinhacompiladores.Interpreter;
import dev.samukklein.rinhacompiladores.dto.Term;

public class Int implements TaskExec {

    private String value;

    public Int(Interpreter interpreter, Term expression) {
        if (expression.getValueString() != null) {
            this.value = expression.getValueString();
        }
    }

    @Override
    public String exec() {
        return value;
    }
}
