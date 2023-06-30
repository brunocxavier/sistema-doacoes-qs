package org.cefet.enums;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum EnumStatusConservacao {
    BOM("b"),
    MEDIO("m"),
    RUIM("r");

    private final String codigo;

    public static EnumStatusConservacao getByCodigo(String c) {
        return Arrays.stream(values())
                .filter(status -> status.codigo.equals(c))
                .findFirst()
                .orElse(EnumStatusConservacao.BOM);
    }
}
