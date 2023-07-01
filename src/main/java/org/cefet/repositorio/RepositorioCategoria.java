package org.cefet.repositorio;


import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.cefet.model.Categoria;

import javax.inject.Singleton;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@RequiredArgsConstructor
public class RepositorioCategoria {
    private FileReader fileReader = null;

    public Categoria get(String id) {
        try {
            fileReader = new FileReader("categorias.json");
            Gson gson = new Gson();
            List<Categoria> doacoes = Arrays.asList(gson.fromJson(fileReader, Categoria[].class));
            return doacoes.stream()
                    .filter(categoria -> id.equals(categoria.getId()))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return null;
    }

    public List<Categoria> getAll() {
        try {
            fileReader = new FileReader("categorias.json");
            Gson gson = new Gson();
            return new ArrayList<>(Arrays.asList(gson.fromJson(fileReader, Categoria[].class)));
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return new ArrayList<>();
    }

    public void update(Categoria categoria) {
        try {
            fileReader = new FileReader("categorias.json");
            Gson gson = new Gson();

            Categoria[] categoriasArray = gson.fromJson(fileReader, Categoria[].class);
            List<Categoria> categorias = new ArrayList<>();
            if (categoriasArray != null) {
                categorias = new ArrayList<>(Arrays.asList(categoriasArray));
            }
            categoria.setId(String.valueOf(categorias.size()));
            categorias.add(categoria);
            FileWriter fileWriter = new FileWriter("categorias.json");
            String categoriasJson = gson.toJson(categorias);
            fileWriter.write(categoriasJson);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
    }
}
