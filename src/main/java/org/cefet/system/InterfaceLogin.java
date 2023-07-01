package org.cefet.system;

import org.cefet.flow.BuscaUsuarioFlowItem;
import org.cefet.model.Usuario;

import static org.cefet.App.SCANNER;

public class InterfaceLogin {
    public void exibe() {
        BuscaUsuarioFlowItem buscaUsuarioFlowItem = new BuscaUsuarioFlowItem();
        while (true) {
            System.out.println("Opções:");
            System.out.println("L -> login");
            System.out.println("A -> login adm");
            System.out.println("V -> voltar");

            String option = SCANNER.nextLine();
            if (option.equalsIgnoreCase("v")) {
                break;
            } else if (option.equalsIgnoreCase("l") || option.equalsIgnoreCase("a")) {
                System.out.println("Entre com o email e apos a senha:");

                String login = SCANNER.nextLine();
                String senha = SCANNER.nextLine();

                Usuario usuario = buscaUsuarioFlowItem.busca(option, login);

                if (usuario == null) {
                    System.out.println("Usuario ou senha invalidos");
                    continue;
                }

                if (usuario.loga(senha)) {
                    usuario.exibeHome();
                } else {
                    System.out.println("Usuario ou senha invalidos");
                }
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
