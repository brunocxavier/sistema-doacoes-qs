package org.cefet.system;

import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.UsuarioComum;

import static org.cefet.enums.EnumStatusDoacao.DOADO;
import static org.cefet.enums.EnumStatusDoacao.RECUSADO;

public class InterfaceTodasAsDoacoes {
    public void exibe(UsuarioComum usuario) {
        for (Doacao doacao : usuario.getObjetosDoados()) {
            Item item = doacao.getItem();
            System.out.println(item.getNome());

            if (doacao.getStatus() == DOADO) {
                System.out.println("Doado para " + doacao.getRandomReceptor().getNome());
            } else if (doacao.getStatus() == RECUSADO) {
                System.out.println("Essa doacao foi cancelada");
            } else {
                System.out.println("Essa doacao está disponivel");
            }

        }
    }
}
