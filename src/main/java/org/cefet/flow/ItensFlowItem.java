package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Item;
import org.cefet.repositorio.RepositorioItem;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class ItensFlowItem {
    private final RepositorioItem repositorioItem;

    public List<Item> busca() {
        return repositorioItem.getAll();
    }
}
