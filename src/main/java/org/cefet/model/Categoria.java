package org.cefet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categoria {
    private String id;
    private String nome;

    @Override
    public String toString() {
        return id + ": " + nome;
    }
}
