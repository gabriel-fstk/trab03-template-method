import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

class HTMLExporter extends DataExporter {
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
        sb.append("<html><body>\n<table border='1'>\n<tr><th>CPF</th><th>Nome</th><th>Idade</th></tr>\n");
        for (Pessoa pessoa : pessoas) {
            sb.append("<tr><td>").append(pessoa.getCpf()).append("</td><td>").append(pessoa.getNome()).append("</td><td>").append(pessoa.getIdade()).append("</td></tr>\n");
        }
        sb.append("</table>\n</body></html>");
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