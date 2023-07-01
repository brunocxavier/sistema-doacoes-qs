package org.cefet.flow;

import org.cefet.enums.EnumStatusDoacao;
import org.cefet.model.Doacao;
import org.cefet.model.Usuario;
import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioDoacoes;
import org.cefet.repositorio.RepositorioUsuarioComum;

public class FinalizaDoacaoFlowItem {
    public void finaliza(Doacao doacao) {
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();

        Usuario receptor = doacao.getRandomReceptor();
        doacao.setReceptor(receptor);
        doacao.setStatus(EnumStatusDoacao.DOADO);
        repositorioDoacoes.update(doacao);

        UsuarioComum doador = repositorioUsuarioComum.get(doacao.getUsuario().getEmail());
        doador.getObjetosDoados().add(doacao);
        doador.getObjetosPendentes().stream()
                .filter(doacao1 -> doacao1.getId().equals(doacao.getId()))
                .findFirst()
                .map(x -> doador.getObjetosPendentes().remove(x));
        doador.update();

        EmailFlowItem emailFlowItem = new EmailFlowItem();
        emailFlowItem.envia(doacao);
    }
}
