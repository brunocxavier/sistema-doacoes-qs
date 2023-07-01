package org.cefet.system;

import org.cefet.model.UsuarioComum;

import java.util.Scanner;

public class InterfaceMinhasDoacoes {
    public void exibe(UsuarioComum usuarioComum) {
        InterfaceFinalizarDoacao interfaceFinalizarDoacao = new InterfaceFinalizarDoacao();
        InterfaceCadastroDoacao interfaceCadastroDoacao = new InterfaceCadastroDoacao();
        InterfaceTodasAsDoacoes interfaceTodasAsDoacoes = new InterfaceTodasAsDoacoes();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("C -> cadastro de doação");
            System.out.println("F -> finalizar doações");
            System.out.println("D -> ver todas as doações");
            System.out.println("v -> voltar");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("d")) {
                interfaceTodasAsDoacoes.exibe(usuarioComum);
            } else if (option.equalsIgnoreCase("f")) {
                interfaceFinalizarDoacao.exibe(usuarioComum);
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
