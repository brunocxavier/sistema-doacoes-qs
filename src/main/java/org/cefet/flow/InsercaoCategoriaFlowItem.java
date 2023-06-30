package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Categoria;
import org.cefet.repositorio.RepositorioCategoria;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class InsercaoCategoriaFlowItem {
    private final RepositorioCategoria repositorioCategoria;


    public void insere(String id, String nome){
        repositorioCategoria.update(get(id, nome));
    }

    private Categoria get(String id, String nome) {
        return Categoria.builder()
                .id(id)
                .nome(nome)
                .build();
    }
}
