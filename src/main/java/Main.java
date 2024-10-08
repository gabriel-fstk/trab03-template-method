import java.util.Arrays;
import java.util.List;

import models.Pessoa;

public class Main {
    public static void main(String[] args) {

        //  Exemplo 1: Exportar a partir de arquivo CSV

        String inputFilePath = "resources/pessoas.csv";

        DataExporter textExporter = new TextExporter();
        textExporter.parseDataAndGenerateOutput(inputFilePath, "output/pessoas.txt");

        DataExporter htmlExporter = new HTMLExporter();
        htmlExporter.parseDataAndGenerateOutput(inputFilePath, "output/pessoas.html");

        DataExporter jsonExporter = new JSONExporter();
        jsonExporter.parseDataAndGenerateOutput(inputFilePath, "output/pessoas.json");

        DataExporter xmlExporter = new XMLExporter();
        xmlExporter.parseDataAndGenerateOutput(inputFilePath, "output/pessoas.xml");

        // Exemplo 2: Exportar a partir de lista de pessoas inseridas manualmente

        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("111.111.111-11", "Gabriel", 23),
            new Pessoa("222.222.222-22", "Joana", 19),
            new Pessoa("333.333.333-33", "Ingrid", 24)
        );

        DataExporter htmlExporterFromEntity = new HTMLExporter();
        htmlExporterFromEntity.generateOutputFromPessoaList(pessoas, "output/pessoas_from_list.html");

        DataExporter jsonExporterFromEntity = new JSONExporter();
        jsonExporterFromEntity.generateOutputFromPessoaList(pessoas, "output/pessoas_from_list.json");

        DataExporter xmlExporterFromEntity = new XMLExporter();
        xmlExporterFromEntity.generateOutputFromPessoaList(pessoas, "output/pessoas_from_list.xml");

        System.out.println("Exportação concluída.");
    }
}
