package org.cefet.repositorio;

import com.google.gson.Gson;
import org.cefet.model.Usuario;
import org.cefet.model.UsuarioAdm;
import org.cefet.model.UsuarioComum;

import javax.inject.Singleton;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Singleton
public class RepositorioUsuarioAdm {

    public List<UsuarioAdm> getAdms() {
        try {
            FileReader fileReader = new FileReader("usuarios-adms.json");
            Gson gson = new Gson();
            return Arrays.asList(gson.fromJson(fileReader, UsuarioAdm[].class));
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return new ArrayList<>();
    }
}
