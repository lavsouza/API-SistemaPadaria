# Sistema Padaria - Backend

## Descrição do Projeto

O **Sistema Padaria** é uma API desenvolvida em **Spring Boot** para gerenciar o fluxo de produção de pães. O sistema permite:

- Criação de fornadas de pães.
- Associação de pães a fornadas, com controle de hora de entrada e saída.
- Consulta e detalhamento das fornadas mais recentes.

O backend foi desenvolvido usando **Spring Boot**, **JDBC** e **PostgreSQL**, sem JPA, com foco em simplicidade e desempenho.


## Estrutura do Projeto

- `web2.sistemapadaria.model.entities`: Entidades do sistema (Pão, Fornada, FornadaPao).
- `web2.sistemapadaria.model.repositories`: Repositórios JDBC para acesso ao banco.
- `web2.sistemapadaria.service`: Serviços que implementam a lógica de negócio.
- `web2.sistemapadaria.controller`: Endpoints REST da API.
- `web2.sistemapadaria.util`: Contém `ConnectionManager` para conexão com o banco.
- `web2.sistemapadaria.config`: Configurações do Spring, incluindo `CorsConfig` para liberar requisições do front-end.
- `src/main/resources/schema_padaria.sql`: Script para criação do banco e inserção de dados iniciais.
## Configuração de Banco de Dados

1. **Instalar PostgreSQL** e criar um banco chamado `padaria` (ou outro nome à sua escolha).

2. **Rodar o script de criação do banco** localizado em: `src/main/resources/schema_padaria.sql`
   Este script cria as tabelas `pao`, `fornada` e `pao_fornada` e insere pães iniciais.

3. **Configurar o ConnectionManager**:  
   No pacote `web2.sistemapadaria.util`, ajuste o `ConnectionManager` com as credenciais e porta do banco de quem for usar.

Exemplo:
```java
public class ConnectionManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/padaria";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

4. **Configuração do CORS**
   Para permitir que o front-end consuma a API, configure o CORS no arquivo: `web2.sistemapadaria.config/CorsConfig.java`
   Exemplo:
```Java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // URL do front-end
                        .allowedMethods("*");
            }
        };
    }
}
```

## Executando a Aplicação
    1. Certifique-se de que o PostgreSQL esteja rodando.
    2. Configure o ConnectionManager com as credenciais corretas.
    3. Execute a aplicação Spring Boot via IDE ou comando Maven:

**Comando Maven**
```bash
  mvn spring-boot:run
```

**A API estará disponível em:**
```bash
  http://localhost:8080/
```

## Endpoints Principais
- POST /criar → Cria uma nova fornada.
- POST /adicionar-pao → Adiciona pães a uma fornada.
- GET /listar-fornadas → Lista todas as fornadas com pães.
- GET /detalhar-fornada/{id} → Detalha uma fornada específica.


## Observações
- Certifique-se de que a hora do sistema esteja correta para calcular corretamente `hora_entrada` e `hora_saida` das fornadas.
- Para testes com o front-end, configure o CORS para a URL correta do seu front-end.
- O projeto foi feito sem JPA, utilizando JDBC puro para fins de aprendizado e controle manual das queries.


Feito com ❤️ para fins acadêmicos.