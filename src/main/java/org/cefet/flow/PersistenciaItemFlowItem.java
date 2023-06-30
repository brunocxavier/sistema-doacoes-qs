package org.cefet.flow;

import org.cefet.model.Item;
import org.cefet.repositorio.RepositorioItem;

public class PersistenciaItemFlowItem {
    public void salva(Item item) {
        RepositorioItem repositorioItem = new RepositorioItem();
        repositorioItem.update(item);
    }
}
