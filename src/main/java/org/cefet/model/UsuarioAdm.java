package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.cefet.repositorio.RepositorioUsuarioAdm;
import org.cefet.system.InterfaceHomeAdm;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
public class UsuarioAdm extends Usuario {
    @Builder.Default
    private List<Doacao> objetosPendentes = new ArrayList<>();
    @Builder.Default
    private List<Doacao> objetosReprovados = new ArrayList<>();
    @Builder.Default
    private List<Doacao> objetosAprovados = new ArrayList<>();

    @Override
    public void exibeHome() {
        InterfaceHomeAdm interfaceHomeAdm = new InterfaceHomeAdm();
        interfaceHomeAdm.exibe(this);
    }

    @Override
    public void update() {
        RepositorioUsuarioAdm repositorioUsuarioAdm = new RepositorioUsuarioAdm();
        repositorioUsuarioAdm.update(this);
    }
}
