package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Doacao;
import org.cefet.repositorio.RepositorioDoacoes;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

import static org.cefet.enums.EnumStatusItem.ARGUADANDO_APROVACAO;

@Singleton
@RequiredArgsConstructor
public class ExibicaoItensPendentesAprovacao {
    private final RepositorioDoacoes repositorioDoacoes;

    public List<Doacao> exibe() {
        return repositorioDoacoes.getAll()
                .stream()
                .filter(this::aguardandoAprovacao)
                .collect(Collectors.toList());
    }

    private boolean aguardandoAprovacao(Doacao doacao) {
        return ARGUADANDO_APROVACAO == doacao.getStatus();
    }
}
