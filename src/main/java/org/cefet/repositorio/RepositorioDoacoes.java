package org.cefet.repositorio;


import com.google.gson.Gson;
import org.cefet.model.Doacao;
import org.cefet.model.UsuarioComum;

import javax.inject.Singleton;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class RepositorioDoacoes {
    private FileReader fileReader = null;

    public Doacao get(String id) {
        try {
            fileReader = new FileReader("doacoes.json");
            Gson gson = new Gson();
            List<Doacao> doacoes = gson.fromJson(fileReader, List.class);
            return doacoes.stream()
                    .filter(doacao -> id.equals(doacao.getId()))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return null;
    }

    public List<Doacao> getAll() {
        try {
            fileReader = new FileReader("doacoes.json");
            Gson gson = new Gson();
            return gson.fromJson(fileReader, List.class);
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
        return new ArrayList<>();
    }

    public void update(Doacao doacao) {
        try {
            fileReader = new FileReader("doacoes.json");
            Gson gson = new Gson();

            Doacao[] doacoesArray = gson.fromJson(fileReader, Doacao[].class);
            List<Doacao> doacoes = new ArrayList<>();
            if (doacoesArray != null) {
                doacoes = Arrays.asList(doacoesArray);
            }
            doacao.setId(String.valueOf(doacoes.size()));
            doacoes.add(doacao);
            FileWriter fileWriter = new FileWriter("doacoes.json");
            String doacoesJson = gson.toJson(doacoes);
            fileWriter.write(doacoesJson);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Arquivo nao encontrado");
        }
    }
}
