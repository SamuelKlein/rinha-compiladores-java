package dev.samukklein.rinhacompiladores;

import dev.samukklein.rinhacompiladores.dto.Term;
import dev.samukklein.rinhacompiladores.dto.InterpreterData;
import dev.samukklein.rinhacompiladores.dto.KindEnum;
import dev.samukklein.rinhacompiladores.gson.JsonConvert;
import dev.samukklein.rinhacompiladores.tasks.Int;
import dev.samukklein.rinhacompiladores.tasks.Let;
import dev.samukklein.rinhacompiladores.tasks.Print;
import dev.samukklein.rinhacompiladores.tasks.Str;
import dev.samukklein.rinhacompiladores.tasks.TaskExec;

public class Interpreter {

    private JsonConvert jsonConvert;

    public Interpreter() {
        jsonConvert = new JsonConvert();
    }

    public void exec(String code) {
        var json = jsonConvert.convert(code);
        execute(json);
    }

    private void execute(InterpreterData json) {
        processExpression(json.getExpression());
    }

    public String processExpression(Term expression) {
        
        if (expression == null) {
            return null;
        }

        TaskExec taskExec = null;
        switch (KindEnum.getEnum(expression)) {
            case PRINT:
                taskExec = new Print(this, expression);
                break;
            case STR:
                taskExec = new Str(this, expression);
                break;
            case LET:
                taskExec = new Let(this, expression);
                break;
            case INT:
                taskExec = new Int(this, expression);
                break;
            default:
                throw new RuntimeException("Unknown kind: " + expression.getKind());
        }
        
        if (expression.getNext() != null) {
            System.out.println("here >> " + expression.getNext());
            return processExpression(expression.getNext());
        }

        return taskExec.exec();
    }

}
