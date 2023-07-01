package org.cefet.flow;

import org.cefet.model.Categoria;
import org.cefet.repositorio.RepositorioCategoria;

public class CadastroCategoriaFlowItem {
    public void cadastro(Categoria categoria) {
        RepositorioCategoria repositorioCategoria = new RepositorioCategoria();
        repositorioCategoria.update(categoria);
    }
}
