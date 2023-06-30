package org.cefet.system;

import org.cefet.enums.EnumStatusConservacao;
import org.cefet.flow.CadastroDoacaoFlowItem;
import org.cefet.model.Item;
import org.cefet.model.UsuarioComum;

import java.util.Scanner;

public class InterfaceCadastroDoacao {
    public void exibe(UsuarioComum usuarioComum) {
        Scanner scanner = new Scanner(System.in);
        CadastroDoacaoFlowItem cadastroDoacaoFlowItem = new CadastroDoacaoFlowItem();

        System.out.println("Entre com o nome do item");
        String nome = scanner.nextLine();

        System.out.println("Entre com o tipo do item");
        String tipo = scanner.nextLine();

        System.out.println("Entre com a descrição do item");
        String descricao = scanner.nextLine();

        System.out.println("Entre com a quantidade do item que voce deseja doar");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entre com o estado de conservação do item que voce deseja doar");
        System.out.println("B -> bom");
        System.out.println("M -> medio");
        System.out.println("R -> ruim");

        String codigoStatus = scanner.nextLine();
        EnumStatusConservacao statusConservacao = EnumStatusConservacao.getByCodigo(codigoStatus);

        System.out.println("Entre com a cidade em que o item está");
        String cidade = scanner.nextLine();

        Item item = Item.builder()
                .nome(nome)
                .tipo(tipo)
                .descricao(descricao)
                .quantidade(quantidade)
                .estadoConservacao(statusConservacao)
                .cidade(cidade)
                .build();
        cadastroDoacaoFlowItem.cadastra(item, usuarioComum);
    }
}
