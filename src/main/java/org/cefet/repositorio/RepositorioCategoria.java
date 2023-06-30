package org.cefet.repositorio;


import lombok.RequiredArgsConstructor;
import org.cefet.model.Categoria;

import javax.inject.Singleton;
import java.util.List;
@Singleton
@RequiredArgsConstructor
public class RepositorioCategoria {
    public void set(Categoria categoria) {
    }

    public Categoria get(String id) {
        return null;
    }

    public List<Categoria> getAll() {
        return null;
    }

    public void delete(String id) {
    }

    public void update(Categoria categoria) {
    }
}
