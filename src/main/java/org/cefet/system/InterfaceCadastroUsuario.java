package org.cefet.system;

import org.cefet.flow.CadastroUsuarioFlowItem;
import org.cefet.model.UsuarioComum;

import static org.cefet.App.SCANNER;

public class InterfaceCadastroUsuario {
    public void exibe() {
        CadastroUsuarioFlowItem cadastroUsuarioFlowItem = new CadastroUsuarioFlowItem();

        while (true) {
            System.out.println("Opções:");
            System.out.println("C -> cadastrar");
            System.out.println("V -> voltar");

            String option = SCANNER.nextLine();

            if (option.equalsIgnoreCase("v")) {
                break;
            } else if (option.equalsIgnoreCase("c")) {
                System.out.println("Entre com seu nome:");
                String nome = SCANNER.nextLine();
                System.out.println("Entre com seu email:");
                String email = SCANNER.nextLine();
                System.out.println("Entre com sua senha:");
                String senha = SCANNER.nextLine();
                UsuarioComum usuarioComum = UsuarioComum.builder()
                        .nome(nome)
                        .senha(senha)
                        .id(email)
                        .email(email)
                        .build();
                cadastroUsuarioFlowItem.cadastra(usuarioComum);
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
