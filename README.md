# Parlamentares Rest App

Esta é uma aplicação web, escrita em Java, que consome a API RESTful da Câmara dos Deputados com o objetivo de:

1. Apresentar a lista de deputados informando, para cada um, os seguintes dados:
    
    * Nome;
    
    * Sigla do Partido;
    
    * Unidade Federativa para qual atua;
    
    * Número de visualizações que seu perfil obteve.

2. Exibir os detalhes do deputado selecionado pelo usuário:
 
    * Nome completo;
    
    * Data de nascimento;
    
    * Sigla do partido;
    
    * Sexo;
    
    * Valor líquido total de despesas nos dois últimos meses.
    
3. Exibir a lista de detalhada de despesas do mês selecionado pelo usuário:

    * Tipo de despesa;
    
    * Tipo de documento;
    
    * Data da despesa;
    
    * Valor líquido.
    
## Como executar

1. Baixar o repositório;

2. Entrar na pasta raiz do repositório local ```~/ParlamentaresRestApp```;

3. Executar ```target\bin\webapp.bat``` no Windows, ou ```sh target/bin/webapp``` no Linux ou MacOS.

4. Entrar no endereço ```localhost:9090```.

> Obs: caso você queira mudar a porta de execução, basta alterar o atributo ```webPort``` no arquivo Main.java e então executar o comando ```mvn clean package``` na pasta raiz do projeto.

## Tecnologias

> Esse webapp foi desenvolvido com a linguagem Java, versão 8, e as tecnologias: JSF, versão 2.2.13, e Primefaces 10.0.0.


## Imagens

### Tela inicial — Lista de deputados
![alt text](https://github.com/Arouck/ParlamentaresRestApp/blob/master/images/Tela%20inicial.png?raw=true)

### Tela de detalhes de um deputado escolhido
![alt text](https://github.com/Arouck/ParlamentaresRestApp/blob/master/images/Tela%20de%20detalhes.png?raw=true)

### Tela de detalhes das despesas no mês escolhido
![alt text](https://github.com/Arouck/ParlamentaresRestApp/blob/master/images/Tela%20de%20detalhes%20de%20despesa.png?raw=true)