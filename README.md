# Exportador de Dados de Pessoas

Este projeto é uma implementação do padrão Template Method para exportar dados de pessoas para diferentes formatos, como Texto Plano, HTML, JSON e XML. Ele também suporta a leitura de dados a partir de arquivos CSV e permite a criação de listas de pessoas diretamente no código para exportação.

## Funcionalidades

- **Leitura de Arquivos CSV**: O programa lê dados de pessoas de arquivos CSV para exportação.
- **Exportação para Múltiplos Formatos**:
  - Texto Plano (.txt)
  - HTML (.html)
  - JSON (.json)
  - XML (.xml)
- **Criação Manual de Pessoas**: Também é possível criar uma lista de pessoas diretamente no código e exportar esses dados.

## Estrutura do Projeto

O projeto segue o padrão de design Template Method, onde diferentes formas de exportação são implementadas através de subclasses concretas que seguem um fluxo geral de exportação. As principais classes são:

- **Pessoa**: Representa uma pessoa com CPF, nome e idade.
- **DataExporter**: Classe abstrata que define o método Template para a exportação.
- **TextExporter**, **HTMLExporter**, **JSONExporter**, **XMLExporter**: Classes concretas que implementam a exportação para os respectivos formatos.

## Requisitos

- Java 8 ou superior

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/gabriel-fstk/trab03-template-method.git
   ```

2. Compile o projeto:
   ```bash
   javac Main.java
   ```

3. Execute o projeto:
   ```bash
   java Main
   ```

## Exemplo de Exportação

### A partir de um arquivo CSV

O arquivo CSV deve ter o seguinte formato:
```
cpf;nome;idade
12345678900;João Silva;30
98765432100;Maria Santos;25
```

O programa lê o arquivo e exporta os dados para o formato desejado. Por exemplo, um arquivo `pessoas.csv` seria exportado para `pessoas.txt` (Texto Plano), `pessoas.html` (HTML), etc.

### A partir de uma Lista de Pessoas Inseridas Manualmente

Você também pode criar uma lista de pessoas diretamente no código e exportá-la:
```java
List<Pessoa> pessoaList = new ArrayList<>();
pessoaList.add(new Pessoa("12345678900", "João Silva", 30));
pessoaList.add(new Pessoa("98765432100", "Maria Santos", 25));

DataExporter jsonExporter = new JSONExporter();
jsonExporter.generateOutputFromPessoaList(pessoaList, "pessoas_from_list.json");
```

## Estrutura do Código

```
src/
├── Pessoa.java                # Classe que define os atributos de uma pessoa
├── DataExporter.java           # Classe abstrata que define o método Template
├── TextExporter.java           # Implementação concreta para exportar como Texto Plano
├── HTMLExporter.java           # Implementação concreta para exportar como HTML
├── JSONExporter.java           # Implementação concreta para exportar como JSON
├── XMLExporter.java            # Implementação concreta para exportar como XML
└── Main.java                   # Classe principal para executar o programa
```

## Extensibilidade

Caso você queira adicionar mais formatos de exportação, basta criar uma nova classe que herde de `DataExporter` e implementar os métodos abstratos `readData`, `processData` e `writeData`.

## Contribuição

Se quiser contribuir com o projeto, siga estas etapas:

1. Faça um fork do projeto.
2. Crie uma nova branch: 
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Commit suas mudanças: 
   ```bash
   git commit -m 'feat: adiciona nova funcionalidade X'
   ```
4. Envie para o repositório remoto: 
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
