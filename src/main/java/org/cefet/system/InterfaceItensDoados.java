package org.cefet.system;

import org.apache.commons.collections.CollectionUtils;
import org.cefet.flow.PersistenciaItemFlowItem;
import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.Usuario;
import org.cefet.model.UsuarioComum;

import java.util.Scanner;

import static org.cefet.enums.EnumStatusItem.DOADO;
import static org.cefet.enums.EnumStatusItem.RECUSADO;

public class InterfaceItensDoados {
    public void exibe(UsuarioComum usuario) {
        if (CollectionUtils.isEmpty(usuario.getObjetosDoados())) {
            System.out.println("Você ainda não realizou nenhuma doação");
            return;
        }

        System.out.println("Suas doaçoes");
        for (Doacao doacao : usuario.getObjetosDoados()) {
            Item item = doacao.getItem();
            System.out.println(item.getNome());

            if (doacao.getStatus() == DOADO) {
                System.out.println("Doado para " + doacao.getReceptor().getNome());
            } else if (doacao.getStatus() == RECUSADO) {
                System.out.println("Essa doacao foi cancelada");
            } else {
                System.out.println("Essa doacao está disponivel");
            }

        }
    }
}
