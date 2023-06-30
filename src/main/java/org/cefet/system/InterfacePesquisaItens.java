package org.cefet.system;

import org.cefet.model.Doacao;
import org.cefet.model.Item;
import org.cefet.model.Usuario;
import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioDoacoes;
import org.cefet.repositorio.RepositorioItem;

import java.util.List;
import java.util.Scanner;

import static org.cefet.App.SCANNER;

public class InterfacePesquisaItens {
    public void exibe(UsuarioComum usuarioComum) {
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        List<Doacao> doacoes = repositorioDoacoes.getAll();

        while (true) {
            System.out.println("Opções:");
            System.out.println("I -> Ver doações disponiveis");
            System.out.println("D -> demonstrar interesse");
            System.out.println("v -> voltar");


            String option = SCANNER.nextLine();

            if (option.equalsIgnoreCase("i")) {
                for (Doacao doacao : doacoes) {
                    Item item = doacao.getItem();
                    System.out.println("id:" + item.getId() + " nome: " + item.getNome() + " doador: " + doacao.getUsuario().getNome());
                }
            } else if (option.equalsIgnoreCase("d")) {
                System.out.println("Digite o id do produto que voce deseja");
                String id = SCANNER.nextLine();
                //TODO lançar doacao not found
                Doacao doacao = doacoes.stream()
                        .filter(i -> i.getId().equalsIgnoreCase(id))
                        .findFirst()
                        .orElseThrow();
                doacao.getInteressados().add(usuarioComum);
                repositorioDoacoes.update(doacao);
            } else if (option.equalsIgnoreCase("v")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
