package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.cefet.system.InterfaceHomeAdm;

import java.util.List;

@Data
@SuperBuilder
public class UsuarioAdm extends Usuario {
    private List<Doacao> objetosAprovados;

    @Override
    public void exibeHome() {
        InterfaceHomeAdm interfaceHomeAdm = new InterfaceHomeAdm();
        interfaceHomeAdm.exibe();
    }
}
