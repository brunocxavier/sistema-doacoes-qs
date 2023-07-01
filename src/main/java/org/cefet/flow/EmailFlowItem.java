package org.cefet.flow;

import org.cefet.model.Doacao;

import javax.inject.Singleton;

@Singleton
public class EmailFlowItem {
    public void envia(Doacao doacao) {
        System.out.println("Simulação email enviado para " + doacao.getReceptor());
    }
}
