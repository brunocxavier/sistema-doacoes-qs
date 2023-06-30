package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.enums.EnumStatusItem;
import org.cefet.model.Doacao;
import org.cefet.repositorio.RepositorioDoacoes;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class StatusDoacaoFlowItem {
    private final RepositorioDoacoes repositorioDoacoes;

    public void atualiza(Doacao doacao, EnumStatusItem enumStatusItem) {
        doacao.setStatus(enumStatusItem);
        repositorioDoacoes.update(doacao);
    }
}
