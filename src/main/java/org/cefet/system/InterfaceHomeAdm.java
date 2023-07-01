package org.cefet.system;

import org.cefet.model.UsuarioAdm;

import static org.cefet.App.SCANNER;

public class InterfaceHomeAdm {
    public void exibe(UsuarioAdm usuarioAdm) {
        InterfaceValidaItemAdm interfaceValidaItemAdm = new InterfaceValidaItemAdm();
        InterfaceCadastroCategoria interfaceCadastroCategoria = new InterfaceCadastroCategoria();

        while (true) {
            System.out.println("Opções:");
            System.out.println("V -> validar itens pendentes");
            System.out.println("C -> cadastra categoria");
            System.out.println("Q -> deslogar");

            String option = SCANNER.nextLine();

            if ("q".equalsIgnoreCase(option)) {
                break;
            } else if ("v".equalsIgnoreCase(option)) {
                interfaceValidaItemAdm.exibe(usuarioAdm);
            } else if ("c".equalsIgnoreCase(option)) {
                interfaceCadastroCategoria.exibe();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
