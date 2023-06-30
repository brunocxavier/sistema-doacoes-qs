package org.cefet.flow;

import lombok.RequiredArgsConstructor;
import org.cefet.model.Item;
import org.cefet.repositorio.RepositorioItem;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class EdicaoItemFlowItem {
    private final RepositorioItem repositorioItem;

    public void edita(Item item) {
        repositorioItem.update(item);
    }
}
