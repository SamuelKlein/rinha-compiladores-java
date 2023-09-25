package dev.samukklein.rinhacompiladores;

import dev.samukklein.rinhacompiladores.dto.Term;
import dev.samukklein.rinhacompiladores.dto.InterpreterData;
import dev.samukklein.rinhacompiladores.dto.KindEnum;
import dev.samukklein.rinhacompiladores.gson.JsonConvert;
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
        TaskExec taskExec = null;
        switch (KindEnum.getEnum(expression)) {
            case PRINT:
                taskExec = new Print(this, expression);
                break;
            case STR:
                taskExec = new Str(this, expression);
                break;
            default:
                throw new RuntimeException("Unknown kind: " + expression.getKind());
        }

        return taskExec.exec();
    }

}
