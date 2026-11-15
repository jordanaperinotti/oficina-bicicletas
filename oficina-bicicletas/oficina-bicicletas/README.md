# Oficina de Bicicletas

Aplicacao Java inicial para cadastro de clientes, mecânicos e bicicletas, bem como abertura e consulta de ordens de servico. Nesta fase inicial da implementação, os dados ficam em memória durante a execução. Posteriormente, com o andamento do projeto os dados serão armazenados em arquivo.

## Modelagem proposta (inicial)

### Heranca

```text
             Person (abstrata)
              /          \
         Customer      Mechanic
```

`Person` concentra os dados comuns (nome e telefone). `Customer` acrescenta CPF e endereco; `Mechanic` acrescenta matrícula e salário.

### Associações e responsabilidades

- Um `Customer` pode ter várias bicicletas; cada `Bicycle` cadastrada pertence a um cliente.
- Uma `ServiceOrder` registra a bicicleta atendida, o mecânico responsável, a descrição, as datas, o status, a mão de obra e as peças utilizadas.
- `ServiceStatus` enumera os estados iniciais: `OPEN`, `IN_PROGRESS`, `WAITING_FOR_PART`, `UNDER_REVIEW_AND_TESTING`, `WAITING_FOR_PICKUP` e `COMPLETED`.
- `Part` representa um item e sua quantidade na ordem de serviço.
- `Calculable` e implementada por `ServiceOrder`, que calcula mão de obra mais o valor das pecas.
- `Model` e `History` serão extraidas/adicionadas em uma próxima etapa. Por enquanto, a bicicleta guarda marca e modelo como textos e a ordem de serviço ainda não persiste um histórico de alterações.

### Regras previstas para evolução

- O prazo inicial da ordem é de cinco dias a partir da abertura.
- Se for necessário solicitar uma peça ao revendedor, a ordem deve passar para `WAITING_FOR_PART` e a previsão deve ser atualizada.
- A atribuição automática deve priorizar o mecânico que atendeu anteriormente a bicicleta, caso esteja disponível; caso contrario, deve escolher um mecânico livre.
- A disponibilidade dos mecânicos, o histórico, a extensao do prazo por espera de peças e a persistência dos dados ainda precisam ser implementados.

## O que já funciona

O menu de terminal permite cadastrar e listar clientes, mecânicos e bicicletas, abrir ordens de serviços e consultar as ordens. Os cadastros e as ordens usam `ArrayList` e são perdidos ao encerrar o programa.
