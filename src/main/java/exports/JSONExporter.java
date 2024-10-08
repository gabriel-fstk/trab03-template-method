import models.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class JSONExporter extends DataExporter {
    @Override
    protected List<Pessoa> readData(String inputFilePath) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(";");
                pessoas.add(new Pessoa(fields[0], fields[1], Integer.parseInt(fields[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    @Override
    protected String processData(List<Pessoa> pessoas) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            sb.append("  { \"cpf\": \"").append(pessoa.getCpf()).append("\", \"nome\": \"").append(pessoa.getNome()).append("\", \"idade\": ").append(pessoa.getIdade()).append(" }");
            if (i < pessoas.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    protected void writeData(String data, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
