package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PessoaJuridica extends UsuarioComum {
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;
}
