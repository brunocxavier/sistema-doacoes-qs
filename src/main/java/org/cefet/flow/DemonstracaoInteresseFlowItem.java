package org.cefet.flow;

import org.cefet.model.Doacao;
import org.cefet.model.Usuario;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class DemonstracaoInteresseFlowItem {

    public void demonstra(List<Doacao> doacoes, String id, Usuario usuario) {
        //TODO lançar doacao not found
        Doacao doacao = doacoes.stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow();
        doacao.cadastraInteressado(usuario);
    }
}
