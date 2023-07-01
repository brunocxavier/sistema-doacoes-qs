package org.cefet.system;

import org.cefet.flow.AprovaDoacaoFlowItem;
import org.cefet.flow.ReprovaDoacaoFlowItem;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.UsuarioAdm;

import static org.cefet.App.SCANNER;

public class InterfaceValidaItemAdm {
    public void exibe(UsuarioAdm usuarioAdm) {
        AprovaDoacaoFlowItem aprovaDoacaoFlowItem = new AprovaDoacaoFlowItem();
        ReprovaDoacaoFlowItem reprovaDoacaoFlowItem = new ReprovaDoacaoFlowItem();

        while (true) {
            System.out.println("Opções:");
            System.out.println("I -> Ver doações pendentes");
            System.out.println("A -> Aprova doação");
            System.out.println("R -> Reprova doação");
            System.out.println("v -> voltar");

            String option = SCANNER.nextLine();

            if ("i".equalsIgnoreCase(option)) {
                for (Doacao doacao : usuarioAdm.getObjetosPendentes()) {
                    Item item = doacao.getItem();
                    System.out.println("id:" + item.getId() + " nome: " + item.getNome() + " doador: " + doacao.getUsuario().getNome());
                }
            } else if ("a".equalsIgnoreCase(option)) {
                System.out.println("Entre com o id da doacao que deseja aprovar");
                String id = SCANNER.nextLine();
                aprovaDoacaoFlowItem.aprova(usuarioAdm, id);
            } else if ("r".equalsIgnoreCase(option)) {
                System.out.println("Entre com o id da doacao que deseja reprovar");
                String id = SCANNER.nextLine();
                reprovaDoacaoFlowItem.reprova(usuarioAdm, id);
            } else if ("v".equalsIgnoreCase(option)) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
