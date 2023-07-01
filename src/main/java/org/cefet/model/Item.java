package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import org.cefet.enums.EnumStatusConservacao;

@Data
@Builder
public class Item {
    private String id;
    private String nome;
    private String tipo;
    private String descricao;
    private int quantidade;
    private EnumStatusConservacao estadoConservacao;
    private String cidade;
}
