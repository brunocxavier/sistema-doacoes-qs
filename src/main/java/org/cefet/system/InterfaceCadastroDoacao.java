package org.cefet.system;

import org.cefet.enums.EnumStatusConservacao;
import org.cefet.flow.CadastroDoacaoFlowItem;
import org.cefet.model.Categoria;
import org.cefet.model.Item;
import org.cefet.model.UsuarioComum;
import org.cefet.repositorio.RepositorioCategoria;

import java.util.List;
import java.util.Optional;

import static org.cefet.App.SCANNER;

public class InterfaceCadastroDoacao {
    public void exibe(UsuarioComum usuarioComum) {
        CadastroDoacaoFlowItem cadastroDoacaoFlowItem = new CadastroDoacaoFlowItem();
        RepositorioCategoria repositorioCategoria = new RepositorioCategoria();

        System.out.println("Entre com o nome do item");
        String nome = SCANNER.nextLine();

        System.out.println("Entre com a categoria do item");
        List<Categoria> categorias = repositorioCategoria.getAll();
        categorias.forEach(System.out::println);
        String tipo = getCategoria(categorias);

        System.out.println("Entre com a descrição do item");
        String descricao = SCANNER.nextLine();

        System.out.println("Entre com a quantidade do item que voce deseja doar");
        int quantidade = SCANNER.nextInt();
        SCANNER.nextLine();

        System.out.println("Entre com o estado de conservação do item que voce deseja doar");
        System.out.println("B -> bom");
        System.out.println("M -> medio");
        System.out.println("R -> ruim");

        String codigoStatus = SCANNER.nextLine();
        EnumStatusConservacao statusConservacao = EnumStatusConservacao.getByCodigo(codigoStatus);

        System.out.println("Entre com a cidade em que o item está");
        String cidade = SCANNER.nextLine();

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

    private String getCategoria(List<Categoria> categorias) {
        while (true) {
            String codigoTipo = SCANNER.nextLine();
            Optional<Categoria> categoriaOp = categorias.stream()
                    .filter(categoria -> codigoTipo.equalsIgnoreCase(categoria.getId()))
                    .findFirst();
            if (categoriaOp.isPresent()) {
                return categoriaOp.get().getNome();
            }
        }
    }
}
