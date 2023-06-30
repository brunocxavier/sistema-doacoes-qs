package org.cefet.system;

import org.cefet.model.Usuario;
import org.cefet.repositorio.RepositorioUsuarioComum;

import static org.cefet.App.SCANNER;

public class InterfaceLogin {
    public void exibe() {
        while (true) {
            System.out.println("Opções:");
            System.out.println("L -> login");
            System.out.println("V -> voltar");

            String option = SCANNER.nextLine();
            if (option.equalsIgnoreCase("v")) {
                break;
            }
            if (!option.equalsIgnoreCase("l")) {
                System.out.println("Opção inválida");
                continue;
            }

            System.out.println("Entre com o email e apos a senha:");

            String login = SCANNER.nextLine();
            String senha = SCANNER.nextLine();

            RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();
            Usuario usuario = repositorioUsuarioComum.get(login);

            if (usuario == null) {
                System.out.println("Usuario ou senha invalidos");
                continue;
            }

            if (usuario.getSenha().equals(senha)) {
                usuario.exibeHome();
            } else {
                System.out.println("Usuario ou senha invalidos");
            }
        }
    }
}
