package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import org.cefet.enums.EnumStatusDoacao;
import org.cefet.repositorio.RepositorioDoacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Builder
public class Doacao {
    private String id;
    private Item item;
    private Usuario usuario;
    @Builder.Default
    private List<Usuario> interessados = new ArrayList<>();
    private Usuario receptor;
    private UsuarioAdm aprovador;
    private EnumStatusDoacao status;

    public void cadastraInteressado(Usuario usuario) {
        this.interessados.add(usuario);
        RepositorioDoacoes repositorioDoacoes = new RepositorioDoacoes();
        repositorioDoacoes.update(this);
    }

    public Usuario getRandomReceptor() {
        Random r = new Random();
        return interessados.get(r.nextInt(interessados.size()));
    }
}
