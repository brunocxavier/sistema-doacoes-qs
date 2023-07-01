package org.cefet.system;

import org.apache.commons.collections.CollectionUtils;
import org.cefet.flow.BuscaDoacoesPendentesFlowItem;
import org.cefet.flow.FinalizaDoacaoFlowItem;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.UsuarioComum;

import java.util.List;

import static org.cefet.App.SCANNER;

public class InterfaceFinalizarDoacao {
    public void exibe(UsuarioComum usuario) {
        BuscaDoacoesPendentesFlowItem buscaDoacoesPendentesFlowItem = new BuscaDoacoesPendentesFlowItem();
        FinalizaDoacaoFlowItem finalizaDoacaoFlowItem = new FinalizaDoacaoFlowItem();

        List<Doacao> doacoesPendentes = buscaDoacoesPendentesFlowItem.busca(usuario);
        if (CollectionUtils.isEmpty(doacoesPendentes)) {
            System.out.println("Você não possue doaçoes pendentes");
            return;
        }

        System.out.println("Suas doaçoes pendentes");
        for (Doacao doacao : doacoesPendentes) {
            Item item = doacao.getItem();
            System.out.println("Deseja doar aleatoriamente o item : " + item.getNome() + " (aperte s para doar)");

            String option = SCANNER.nextLine();
            if ("s".equals(option)) {
                finalizaDoacaoFlowItem.finaliza(doacao);
            }
        }
        /*for (Doacao doacao : usuario.getObjetosDoados()) {
            Item item = doacao.getItem();
            System.out.println(item.getNome());

            if (doacao.getStatus() == DOADO) {
                System.out.println("Doado para " + doacao.getReceptor().getNome());
            } else if (doacao.getStatus() == RECUSADO) {
                System.out.println("Essa doacao foi cancelada");
            } else {
                System.out.println("Essa doacao está disponivel");
            }

        } */
    }
}
