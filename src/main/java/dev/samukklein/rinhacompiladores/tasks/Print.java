package dev.samukklein.rinhacompiladores.tasks;

import dev.samukklein.rinhacompiladores.Interpreter;
import dev.samukklein.rinhacompiladores.dto.Term;

public class Print implements TaskExec {

    private String value = null;

    public Print(Interpreter interpreter, Term expression) {
        value = interpreter.processExpression(expression.getValueExpression());
    }

    public String exec() {
        System.out.println(value);
        return value;
    }

}
