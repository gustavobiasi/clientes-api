package br.com.clientes.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class FieldValidationException extends RuntimeException {
    private final Map<String, String> fields = new LinkedHashMap<>();

    public FieldValidationException(String... items) {
        super("");
        int i = 0;
        String field = null;
        for (String item : items) {
            if (i % 2 == 0) {
                field = item;
            } else {
                fields.put(field, item);
            }
            i++;
        }
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
