package org.cefet.flow;

import org.cefet.enums.EnumStatusItem;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.UsuarioAdm;
import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioDoacoes;
import org.cefet.repositorio.RepositorioUsuarioAdm;

import java.util.List;
import java.util.Random;

public class CadastroDoacaoFlowItem {
    public void cadastra(Item item, UsuarioComum usuarioComum) {
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        Doacao doacao = Doacao.builder()
                .status(EnumStatusItem.ARGUADANDO_APROVACAO)
                .usuario(usuarioComum)
                .item(item)
                .aprovador(getAprovador())
                .build();

        repositorioDoacoes.update(doacao);
    }

    private UsuarioAdm getAprovador() {
        RepositorioUsuarioAdm repositorioUsuarioAdm = new RepositorioUsuarioAdm();
        List<UsuarioAdm> adms = repositorioUsuarioAdm.getAdms();
        Random r = new Random();
        return adms.get(r.nextInt(adms.size()));
    }
}
