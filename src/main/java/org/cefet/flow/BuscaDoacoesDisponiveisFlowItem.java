package org.cefet.flow;

import org.cefet.model.Doacao;
import org.cefet.model.Usuario;
import org.cefet.repositorio.RepositorioDoacoes;

import java.util.List;
import java.util.stream.Collectors;

public class BuscaDoacoesDisponiveisFlowItem {
    public List<Doacao> busca(Usuario usuario) {
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        return repositorioDoacoes.getAll()
                .stream()
                .filter(doacao -> !doacao.getUsuario().getEmail().equals(usuario.getEmail()))
                .collect(Collectors.toList());
    }
}
