package org.cefet.system;

import org.cefet.model.UsuarioComum;

import java.util.Scanner;

public class InterfaceItensDoadosPorMim {
    public void exibe(UsuarioComum usuarioComum) {
        InterfaceItensDoados interfaceItensDoados = new InterfaceItensDoados();
        InterfaceCadastroDoacao interfaceCadastroDoacao = new InterfaceCadastroDoacao();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("C -> cadastro de doação");
            System.out.println("l -> listar minhas doacoes");
            System.out.println("v -> voltar");


            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("l")) {
                interfaceItensDoados.exibe(usuarioComum);
            } else if (option.equalsIgnoreCase("c")) {
                interfaceCadastroDoacao.exibe(usuarioComum);
            } else if (option.equalsIgnoreCase("v")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
