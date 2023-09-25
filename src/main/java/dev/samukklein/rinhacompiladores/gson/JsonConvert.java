package dev.samukklein.rinhacompiladores.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.samukklein.rinhacompiladores.dto.Term;
import dev.samukklein.rinhacompiladores.dto.InterpreterData;

public class JsonConvert {

    private Gson gson;

    public InterpreterData convert(String code) {
        gson = new GsonBuilder()
                .create();
        var json = gson.fromJson(code, InterpreterData.class);

        fixed(json);

        return json;
    }

    private void fixed(InterpreterData json) {
        if (json.getExpression() != null && json.getExpression().getValue() != null) {
            fixed(json.getExpression());
        }
    }

    private void fixed(Term expressionDTO) {
        if (expressionDTO.getValue() != null) {
            var jsonElement = expressionDTO.getValue();
            if (jsonElement.isJsonPrimitive()) {
                expressionDTO.setValueString(jsonElement.getAsString());
            } else {
                expressionDTO.setValueExpression(gson.fromJson(jsonElement, Term.class));
                fixed(expressionDTO.getValueExpression());
            }
            expressionDTO.setValue(null);
        }
    }
}
