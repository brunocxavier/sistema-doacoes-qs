package org.cefet.flow;

import org.cefet.enums.EnumStatusDoacao;
import org.cefet.model.Doacao;
import org.cefet.model.UsuarioAdm;
import org.cefet.repositorio.RepositorioDoacoes;

import java.util.Optional;

public class ReprovaDoacaoFlowItem {
    public void reprova(UsuarioAdm usuarioAdm, String id) {
        Optional<Doacao> doacaoSelecionadaOp = usuarioAdm.getObjetosPendentes()
                .stream()
                .filter(doacao -> id.equalsIgnoreCase(doacao.getId()))
                .findFirst();
        if (doacaoSelecionadaOp.isEmpty()) {
            System.out.println("Doacao com o id " + id + " não existe");
            return;
        }
        Doacao doacaoSelecionada = doacaoSelecionadaOp.get();
        doacaoSelecionada.setStatus(EnumStatusDoacao.RECUSADO);

        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        repositorioDoacoes.update(doacaoSelecionada);

        usuarioAdm.getObjetosPendentes().remove(doacaoSelecionada);
        usuarioAdm.getObjetosReprovados().add(doacaoSelecionada);
        usuarioAdm.update();
    }
}
