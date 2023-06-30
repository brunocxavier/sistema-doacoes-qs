package org.cefet.system;

import org.cefet.model.Usuario;
import org.cefet.model.UsuarioComum;

import java.util.Scanner;

public class InterfaceHomeUsuarioComum {
    public void exibe(UsuarioComum usuarioComum) {
        InterfaceItensDoadosPorMim interfaceItensDoadosPorMim = new InterfaceItensDoadosPorMim();
        InterfacePesquisaItens interfacePesquisaItens = new InterfacePesquisaItens();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("P -> pesquisar items");
            System.out.println("D -> doar");
            System.out.println("Q -> deslogar");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("q")) {
                break;
            } else if (option.equalsIgnoreCase("p")) {
                interfacePesquisaItens.exibe(usuarioComum);
            } else if (option.equalsIgnoreCase("d")) {
                interfaceItensDoadosPorMim.exibe(usuarioComum);
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
