package org.cefet.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String senha;

    public void exibeHome() {}

    public void cadastra() {}

    public void update() {}

    public boolean loga(String s) {
        return senha.equals(s);
    }
}
