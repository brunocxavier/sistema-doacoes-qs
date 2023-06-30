package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.Usuario;
import org.cefet.repositorio.RepositorioDoacoes;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
@RequiredArgsConstructor
public class InteressadosFlowItem {
    private final RepositorioDoacoes repositorioDoacoes;

    public List<Usuario> get(Item item) {
        return repositorioDoacoes.getAll()
                .stream()
                .filter(doacao -> validaItem(doacao, item))
                .flatMap(this::getInteressados)
                .collect(Collectors.toList());
    }

    private boolean validaItem(Doacao doacao, Item item) {
        return item.equals(doacao.getItem());
    }

    private Stream<Usuario> getInteressados(Doacao doacao) {
        return doacao.getInteressados().stream();
    }
}
