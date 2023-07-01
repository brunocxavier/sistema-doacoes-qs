package org.cefet.system;

import org.cefet.model.UsuarioComum;

import static org.cefet.App.SCANNER;

public class InterfaceHomeUsuarioComum {
    public void exibe(UsuarioComum usuarioComum) {
        InterfaceMinhasDoacoes interfaceMinhasDoacoes = new InterfaceMinhasDoacoes();
        InterfacePesquisaItensDisponiveis interfacePesquisaItensDisponiveis = new InterfacePesquisaItensDisponiveis();

        while (true) {
            System.out.println("Opções:");
            System.out.println("P -> pesquisar items");
            System.out.println("M -> meus itens");
            System.out.println("Q -> deslogar");

            String option = SCANNER.nextLine();

            if ("q".equalsIgnoreCase(option)) {
                break;
            } else if ("p".equalsIgnoreCase(option)) {
                interfacePesquisaItensDisponiveis.exibe(usuarioComum);
            } else if ("m".equalsIgnoreCase(option)) {
                interfaceMinhasDoacoes.exibe(usuarioComum);
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
