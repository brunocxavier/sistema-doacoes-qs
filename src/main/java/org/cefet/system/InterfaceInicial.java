package org.cefet.system;

import java.util.Scanner;

public class InterfaceInicial {
    public void exibe() {
        InterfaceLogin interfaceLogin = new InterfaceLogin();
        InterfaceCadastroUsuario interfaceCadastroUsuario = new InterfaceCadastroUsuario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("L -> login");
            System.out.println("C -> cadastro");
            System.out.println("F -> fechar o sistema");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("l")) {
                interfaceLogin.exibe();
            } else if (option.equalsIgnoreCase("c")) {
                interfaceCadastroUsuario.exibe();
            } else if (option.equalsIgnoreCase("f")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }

    }
}