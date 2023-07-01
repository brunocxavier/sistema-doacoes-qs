package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.cefet.repositorio.RepositorioUsuarioComum;
import org.cefet.system.InterfaceHomeUsuarioComum;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
public class UsuarioComum extends Usuario {
    @Builder.Default
    private List<Doacao> objetosDoados = new ArrayList<>();
    @Builder.Default
    private List<Doacao> objetosPendentes = new ArrayList<>();

    @Override
    public void exibeHome() {
        InterfaceHomeUsuarioComum interfaceHomeUsuarioComum = new InterfaceHomeUsuarioComum();
        interfaceHomeUsuarioComum.exibe(this);
    }

    @Override
    public void cadastra() {
        RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();
        repositorioUsuarioComum.cadastra(this);
    }

    @Override
    public void update() {
        RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();
        repositorioUsuarioComum.update(this);
    }
}
