import models.Pessoa;
import java.util.List;

abstract class DataExporter {

    public final void parseDataAndGenerateOutput(String inputFilePath, String outputFilePath) {
        List<Pessoa> pessoas = readData(inputFilePath);
        String processedData = processData(pessoas);
        writeData(processedData, outputFilePath);
    }

    public final void generateOutputFromPessoaList(List<Pessoa> pessoas, String outputFilePath) {
        String processedData = processData(pessoas);
        writeData(processedData, outputFilePath);
    }

    protected abstract List<Pessoa> readData(String inputFilePath);
    protected abstract String processData(List<Pessoa> pessoas);
    protected abstract void writeData(String data, String outputFilePath);
}