# Sistema de Pedidos - Projeto Diamante 02

Este projeto é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de pedidos, clientes e produtos. O foco desta etapa foi a implementação de relacionamentos complexos, paginação de dados e filtros de busca personalizados.

## 👥 Integrantes
* **Raphael Gomes Mancera** - RM: 562279
* **Guilherme De Andrade Martini** - RM: 56087
* **Bruno Vinicius Barbosa** - RM: 566366

## 🛠️ Tecnologias Utilizadas
* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA** (Persistência de Dados)
* **H2 Database** (Banco de dados em memória para testes)
* **Maven** (Gerenciador de dependências)
* **Postman** (Testes de API)

## 🚀 Como Executar o Projeto

1. **Clonar ou extrair o projeto:** Certifique-se de que todas as pastas (`src`, `pom.xml`) estão presentes.
2. **Importar na IDE:** Abra o projeto no IntelliJ IDEA ou Eclipse como um projeto Maven.
3. **Perfil de Teste:** O projeto está configurado para usar o perfil `test`. Verifique se o arquivo `application.properties` ou `application-test.properties` contém as configurações do banco H2.
4. **Executar:** Rode a classe `SistemaPedidosApplication.java`.
    - O console deverá exibir a mensagem: `DADOS DE TESTE INSTANCIADOS COM SUCESSO!`.
5. **Acessar a API:** A aplicação estará disponível em `http://localhost:8080`.

## 📡 Endpoints Disponibilizados (Postman)

Foram implementados os 5 endpoints de busca exigidos, incluindo paginação e filtros por status/cliente:

1. **Listar Todos os Pedidos (Paginado):** `GET /orders?page=0&size=5`
2. **Buscar Pedido por ID:** `GET /orders/{id}`
3. **Filtrar Pedidos por Status:** `GET /orders/filter-status?status=PAGO`
4. **Filtrar Pedidos por Cliente:** `GET /orders/filter-client?clientId=1`
5. **Listar Todos os Clientes:** `GET /clients`

> **Nota:** O arquivo da Collection do Postman (`.json`) com todos os testes salvos encontra-se na raiz deste projeto.

## 📊 Regras de Negócio Implementadas
* **Cálculo do Total:** Cada pedido possui um método `getTotal()` que soma o subtotal de todos os seus itens (Preço x Quantidade).
* **Enumerações:** O status do pedido é controlado via `OrderStatus` (AGUARDANDO_PAGAMENTO, PAGO, ENVIADO, ENTREGUE, CANCELADO).
* **Seed de Dados:** O sistema utiliza a classe `TestConfig` para popular o banco de dados automaticamente ao iniciar, facilitando a correção e testes.

## 🗄️ Banco de Dados (H2 Console)
Para visualizar as tabelas criadas em tempo de execução:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa`
* **Password:** (em branco)