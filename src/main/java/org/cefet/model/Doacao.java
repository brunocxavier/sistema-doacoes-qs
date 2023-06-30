package org.cefet.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.cefet.enums.EnumStatusItem;

import java.util.ArrayList;
import java.util.List;

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
    private EnumStatusItem status;
}
