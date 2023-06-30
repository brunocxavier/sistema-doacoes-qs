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
public class RepositorioUsuarioComum {
    private FileReader fileReader = null;

    public UsuarioComum get(String email) {
        try {
            fileReader = new FileReader("usuarios-basicos.json");
            Gson gson = new Gson();
            List<UsuarioComum> usuarios = Arrays.asList(gson.fromJson(fileReader, UsuarioComum[].class));
            return usuarios.stream()
                    .filter(usuario -> email.equals(usuario.getEmail()))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return null;
    }

    public List<Usuario> getAll() {
        try {
            fileReader = new FileReader("usuarios-basicos.json");
            Gson gson = new Gson();
            return Arrays.asList(gson.fromJson(fileReader, Usuario[].class));
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return new ArrayList<>();
    }

    public void cadastra(UsuarioComum usuario) {
        try {
            fileReader = new FileReader("usuarios-basicos.json");
            Gson gson = new Gson();
            Usuario[] usuarioComums = gson.fromJson(fileReader, Usuario[].class);
            List<Usuario> usuarios = new ArrayList<>();
            if (usuarioComums != null) {
                usuarios = Arrays.asList(usuarioComums);
            }

            if (jaCadastrado(usuarios, usuario)) {
                System.out.println("Usuario ja cadastrado");
            }
            usuarios.add(usuario);
            FileWriter fileWriter = new FileWriter("usuarios-basicos.json");
            String usuariosJson = gson.toJson(usuarios);
            fileWriter.write(usuariosJson);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    private boolean jaCadastrado(List<Usuario> usuarios, Usuario usuario) {
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equals(usuario.getEmail()));
    }
}
