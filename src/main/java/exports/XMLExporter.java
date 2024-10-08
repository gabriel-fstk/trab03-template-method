import models.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class XMLExporter extends DataExporter {
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
        sb.append("<pessoas>\n");
        for (Pessoa pessoa : pessoas) {
            sb.append("  <pessoa>\n");
            sb.append("    <cpf>").append(pessoa.getCpf()).append("</cpf>\n");
            sb.append("    <nome>").append(pessoa.getNome()).append("</nome>\n");
            sb.append("    <idade>").append(pessoa.getIdade()).append("</idade>\n");
            sb.append("  </pessoa>\n");
        }
        sb.append("</pessoas>");
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