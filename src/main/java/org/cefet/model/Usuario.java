package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String senha;

    public void exibeHome() {

    };
}
