package org.cefet.system;

import org.cefet.flow.DemonstracaoInteresseFlowItem;
import org.cefet.model.Doacao;
import org.cefet.model.Usuario;

import java.util.List;

import static org.cefet.App.SCANNER;

public class InterfaceDemonstraInteresse {
    public void exibe(List<Doacao> doacoes, Usuario usuario) {
        System.out.println("Digite o id do produto que voce deseja");
        String id = SCANNER.nextLine();

        DemonstracaoInteresseFlowItem demonstracaoInteresseFlowItem = new DemonstracaoInteresseFlowItem();
        demonstracaoInteresseFlowItem.demonstra(doacoes, id, usuario);
    }
}
