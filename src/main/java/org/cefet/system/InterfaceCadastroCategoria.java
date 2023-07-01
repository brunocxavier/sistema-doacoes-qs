package org.cefet.system;

import org.cefet.flow.CadastroCategoriaFlowItem;
import org.cefet.model.Categoria;

import static org.cefet.App.SCANNER;

public class InterfaceCadastroCategoria {
    public void exibe() {
        CadastroCategoriaFlowItem cadastroCategoriaFlowItem = new CadastroCategoriaFlowItem();

        System.out.println("Entre com o nome da categoria");
        String nome = SCANNER.nextLine();

        Categoria categoria = Categoria.builder()
                .nome(nome)
                .build();
        cadastroCategoriaFlowItem.cadastro(categoria);
    }
}
