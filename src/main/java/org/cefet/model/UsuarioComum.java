package org.cefet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.cefet.system.InterfaceHomeUsuarioComum;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
public class UsuarioComum extends Usuario {
    @Builder.Default
    private List<Doacao> objetosDoados = new ArrayList<>();
    @Builder.Default
    private List<Doacao> objetosRecebidos = new ArrayList<>();

    @Override
    public void exibeHome() {
        InterfaceHomeUsuarioComum interfaceHomeUsuarioComum = new InterfaceHomeUsuarioComum();
        interfaceHomeUsuarioComum.exibe(this);
    };
}
