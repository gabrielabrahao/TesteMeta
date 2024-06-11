# TesteMeta

Projeto de teste para a vaga de desenvolvedor na Meta.

## Tecnologias utilizadas

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Spring Boot 2.4.0](https://spring.io/projects/spring-boot)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://projectlombok.org/)
- [Swagger](https://swagger.io/)


## Execução

Para executar o projeto, é necessário ter o Java 11 e o Maven instalados. Após clonar o projeto, basta executalo com sua IDE de preferência:

ao executar o projeto, acesse a url `http://localhost:8080/swagger-ui.html` para visualizar a documentação da API.

ao acessar a url `http://localhost:8080/h2-console` é possível acessar o banco de dados H2.
login: `sa`
senha: `password`

## Estrutura do projeto

O projeto foi desenvolvido utilizando a arquitetura de pacotes, onde cada pacote é responsável por uma camada da aplicação.

- **controller**: Responsável por receber as requisições HTTP e chamar os métodos dos serviços.
- **service**: Responsável por conter a lógica de negócio da aplicação.
- **repository**: Responsável por conter as operações de persistência de dados.
- **entity**: Responsável por conter as entidades da aplicação.
- **dto**: Responsável por conter os objetos de transferência de dados.
- **exception**: Responsável por conter as exceções personalizadas da aplicação.
- **config**: Responsável por conter as configurações da aplicação.
- **enums**: Responsável por conter os enums da aplicação.

## Lógica de negócio

A aplicação consiste em um sistema de cadastro de agendamento de transferências financeiras e listagem desses agendamentos. 

O sistema deve permitir o cadastro de uma transferência financeira, onde o usuário informa o valor, a conta de origem, a conta de destino e a data de agendamento.

O sistema deve permitir a listagem de todas as transferências cadastradas.

O sistema tem um enum que define em que de acordo com a data de agendamento, a transferência pode ter uma taxa específica conforme a tabela abaixo:

- **Transferências agendadas**:  

| De | Até | R$     | Taxa | 
|----|-----|--------|------|
| 0  | 0   | 3,00   | 2,5% |
| 1  | 10  | 12,00  | 0,0% |
| 11 | 20  | 0,00   | 8,2% |
| 21 | 30  | 0,00   | 6,9% |
| 31 | 40  | 0,00   | 4,7% |
| 41 | 50  | 0,00   | 1,7% |

- Em um cenário real, essas taxas seriam dinâmicas e poderiam ser alteradas a qualquer momento.




