package org.cefet.flow;

import org.cefet.model.Usuario;
import org.cefet.repositorio.RepositorioUsuarioAdm;
import org.cefet.repositorio.RepositorioUsuarioComum;

public class BuscaUsuarioFlowItem {
    public Usuario busca(String option, String email) {
        if ("a".equalsIgnoreCase(option)) {
            RepositorioUsuarioAdm repositorioUsuarioAdm = new RepositorioUsuarioAdm();
            return repositorioUsuarioAdm.get(email);
        }

        RepositorioUsuarioComum repositorioUsuarioComum = new RepositorioUsuarioComum();
        return repositorioUsuarioComum.get(email);
    }
}
