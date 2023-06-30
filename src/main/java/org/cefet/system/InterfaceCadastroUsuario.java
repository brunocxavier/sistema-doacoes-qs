package org.cefet.system;

import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioUsuarioComum;

import java.util.Scanner;

public class InterfaceCadastroUsuario {
    public void exibe() {
        Scanner scanner = new Scanner(System.in);
        RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();

        while (true) {
            System.out.println("Opções:");
            System.out.println("C -> cadastrar");
            System.out.println("V -> voltar");

            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("v")) {
                break;
            } else if (option.equalsIgnoreCase("c")) {
                System.out.println("Entre com seu nome:");
                String nome = scanner.nextLine();
                System.out.println("Entre com seu email:");
                String email = scanner.nextLine();
                System.out.println("Entre com sua senha:");
                String senha = scanner.nextLine();
                UsuarioComum usuarioComum = UsuarioComum.builder()
                        .nome(nome)
                        .senha(senha)
                        .id(email)
                        .email(email)
                        .build();
                repositorioUsuarioComum.cadastra(usuarioComum);
                System.out.println("Usuario criado");
                break;

            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
