package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Categoria;
import org.cefet.repositorio.RepositorioCategoria;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CategoriasFlowItem {
    private final RepositorioCategoria repositorioCategoria;

    public List<Categoria> get() {
        return repositorioCategoria.getAll();
    }
}
