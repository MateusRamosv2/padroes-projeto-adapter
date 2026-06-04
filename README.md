# Padrões de Projeto - Adapter

---

## Estrutura do Projeto

- **Interface Alvo (Target):** `IDespesaBRL` → Define o contrato padrão que o nosso sistema local (ERP) espera utilizar. No nosso caso, o ERP entende transações e valores em Reais (BRL).
- **Implementação Local:** `DespesaLocal` → Uma classe concreta padrão do nosso sistema que implementa a interface alvo e armazena os valores na nossa moeda nativa.
- **Serviço Incompatível (Adaptee):** `GatewayEstrangeiroUSD` → Representa uma API externa, uma biblioteca de terceiros ou um sistema legado que precisamos consumir, mas que possui uma interface incompatível com o nosso ERP (neste caso, processa transações apenas em Dólares - USD).
- **Adaptador (Adapter):** `GatewayAdapter` → É o "tradutor" do sistema. Ele estende a funcionalidade do serviço incompatível (Adaptee) e, simultaneamente, interage com a interface do nosso sistema (Target) através de composição. Ele encapsula toda a complexidade da conversão (cálculo de câmbio) para que o ERP não precise conhecer as regras da API externa.
- **Cliente (Client):** `PagamentoERP` → A classe principal que utiliza as regras de negócio. O cliente conversa exclusivamente na sua linguagem padrão (em Reais), completamente alheio ao fato de que, por trás dos panos, o Adapter está enviando requisições em Dólar.
- **Testes:** `PagamentoERPTest` → Utiliza o JUnit para validar a conversão bidirecional, garantindo que os valores em Reais digitados no ERP sejam corretamente convertidos e registrados em Dólar na API, e vice-versa.

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O diagrama ilustra claramente a natureza de "ponte" do padrão Adapter, conectando o nosso sistema corporativo (`PagamentoERP` / `IDespesaBRL`) ao gateway estrangeiro através de herança e composição simultâneas.

<img width="567" height="611" alt="Diagrama - Command" src="https://github.com/user-attachments/assets/1ad3b4eb-0fae-486c-b30b-f7bcded08d9a" />
