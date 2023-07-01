package org.cefet.flow;

import org.cefet.enums.EnumStatusDoacao;
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
        RepositorioUsuarioAdm repositorioUsuarioAdm = new RepositorioUsuarioAdm();
        UsuarioAdm usuarioAdm = getAprovador(repositorioUsuarioAdm);
        Doacao doacao = Doacao.builder()
                .status(EnumStatusDoacao.ARGUADANDO_APROVACAO)
                .usuario(usuarioComum)
                .item(item)
                .aprovador(usuarioAdm)
                .build();
        usuarioAdm.getObjetosPendentes().add(doacao);

        usuarioComum.getObjetosDoados().add(doacao);
        usuarioComum.update();

        usuarioAdm.update();

        repositorioDoacoes.update(doacao);
    }

    private UsuarioAdm getAprovador(RepositorioUsuarioAdm repositorioUsuarioAdm) {
        List<UsuarioAdm> adms = repositorioUsuarioAdm.getAdms();
        Random r = new Random();
        return adms.get(r.nextInt(adms.size()));
    }
}
