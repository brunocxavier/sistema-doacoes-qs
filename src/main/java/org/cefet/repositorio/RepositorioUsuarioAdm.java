package org.cefet.repositorio;

import com.google.gson.Gson;
import org.cefet.model.UsuarioAdm;

import javax.inject.Singleton;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Singleton
public class RepositorioUsuarioAdm {
    private FileReader fileReader = null;

    public UsuarioAdm get(String email) {
        try {
            fileReader = new FileReader("usuarios-adms.json");
            Gson gson = new Gson();
            List<UsuarioAdm> usuarios = new ArrayList<>(Arrays.asList(gson.fromJson(fileReader, UsuarioAdm[].class)));
            return usuarios.stream()
                    .filter(usuario -> email.equals(usuario.getEmail()))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return null;
    }

    public List<UsuarioAdm> getAdms() {
        try {
            fileReader = new FileReader("usuarios-adms.json");
            Gson gson = new Gson();
            return new ArrayList<>(Arrays.asList(gson.fromJson(fileReader, UsuarioAdm[].class)));
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return new ArrayList<>();
    }

    public void update(UsuarioAdm usuario) {
        try {
            fileReader = new FileReader("usuarios-adms.json");
            Gson gson = new Gson();
            List<UsuarioAdm> usuarios = new ArrayList<>(Arrays.asList(gson.fromJson(fileReader, UsuarioAdm[].class)));

            usuarios.stream()
                    .filter(usuarioAdm -> usuarioAdm.getId().equalsIgnoreCase(usuario.getId()))
                    .findFirst()
                    .map(usuarios::remove);

            usuarios.add(usuario);
            FileWriter fileWriter = new FileWriter("usuarios-adms.json");
            String usuariosJson = gson.toJson(usuarios);
            fileWriter.write(usuariosJson);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
    }
}
