package org.cefet.flow;

import org.apache.commons.collections.CollectionUtils;
import org.cefet.model.Doacao;
import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioDoacoes;

import java.util.List;
import java.util.stream.Collectors;

public class BuscaDoacoesPendentesFlowItem {
    public List<Doacao> busca(UsuarioComum usuarioComum) {
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        return repositorioDoacoes.getAll()
                .stream()
                .filter(doacao -> doacao.getUsuario().getEmail().equals(usuarioComum.getEmail()))
                .filter(doacao -> CollectionUtils.isNotEmpty(doacao.getInteressados()))
                .collect(Collectors.toList());
    }
}
