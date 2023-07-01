package org.cefet.system;

import org.cefet.flow.BuscaDoacoesDisponiveisFlowItem;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.UsuarioComum;

import java.util.List;

import static org.cefet.App.SCANNER;

public class InterfacePesquisaItensDisponiveis {
    public void exibe(UsuarioComum usuarioComum) {
        BuscaDoacoesDisponiveisFlowItem buscaDoacoesDisponiveisFlowItem = new BuscaDoacoesDisponiveisFlowItem();
        List<Doacao> doacoes = buscaDoacoesDisponiveisFlowItem.busca(usuarioComum);

        while (true) {
            System.out.println("Opções:");
            System.out.println("I -> Ver doações disponiveis");
            System.out.println("D -> demonstrar interesse");
            System.out.println("v -> voltar");

            String option = SCANNER.nextLine();

            if (option.equalsIgnoreCase("i")) {
                for (Doacao doacao : doacoes) {
                    Item item = doacao.getItem();
                    System.out.println("id:" + item.getId() + " nome: " + item.getNome() + " doador: " + doacao.getUsuario().getNome());
                }
            } else if (option.equalsIgnoreCase("d")) {
                InterfaceDemonstraInteresse interfaceDemonstraInteresse = new InterfaceDemonstraInteresse();
                interfaceDemonstraInteresse.exibe(doacoes, usuarioComum);
            } else if (option.equalsIgnoreCase("v")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
