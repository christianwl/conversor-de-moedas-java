
<div align="center">
   <h1> Conversor de Moedas </h1>
   <img src="https://repository-images.githubusercontent.com/1016586495/27c823df-bc9f-494a-aae2-747329625594">
</div>

Este é um projeto de conversor de moedas desenvolvido em Java, que permite a conversão entre diferentes moedas utilizando uma API externa para obter as taxas de câmbio. O projeto foi desenvolvido como parte de um desafio da Alura durante o Programa ONE (Oracle Next Education).

---

## :bulb: Objetivo

O objetivo deste projeto é criar uma aplicação que permita ao usuário converter valores entre diferentes moedas, utilizando taxas de câmbio atualizadas. A aplicação é interativa e permite que o usuário escolha as moedas de origem e destino, além de inserir o valor a ser convertido.

## :computer: Tecnologias Utilizadas

- ``Java 21``
- ``API de taxas de câmbio (ExchangeRate-API)``
- ``Biblioteca Gson para manipulação de JSON``

## :scroll: Estrutura do Projeto

O projeto é organizado da seguinte forma:

- **modelos**: Contém as classes que representam os dados do sistema, como `CambioMoeda` e `TipoConversor`.
- **calculo**: Contém a lógica de conversão de moedas, incluindo a classe `ConverterMoeda`.
- **config**: Contém a classe `Config`, que gerencia a configuração da API.
- **excecoes**: Contém exceções personalizadas, como `InvalidKeyException`.
- **principal**: Contém a classe `Principal`, que inicia a aplicação e gerencia a interação com o usuário.
- **GerenciadorDeEntrada**: Classe responsável pela interação com o usuário, exibindo menus e recebendo entradas.

## :hammer: Como Usar

1. **Clone o repositório**:
    ```bash
    - `git clone https://github.com/christianwl/conversor-de-moedas-java.git`
    - `cd conversor-de-moedas`
    ```

2. **Configurar a API**:
    - Crie um arquivo `config.properties` na raiz do projeto e adicione sua chave da API:
      ```
      apiKey=SUA_CHAVE_DA_API
      ```

4. **Interação**:
    - Siga as instruções exibidas no console para escolher as moedas e inserir o valor a ser convertido.

# :bear: Autor
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/113655013?s=400&u=79618480e3c7b5a0c1b2f4d0169cd5d197e064f1&v=4" width=115><br><sub>Christian William</sub>](https://github.com/christianwl) |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|

