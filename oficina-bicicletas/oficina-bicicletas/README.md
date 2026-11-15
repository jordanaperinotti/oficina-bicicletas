# Oficina de Bicicletas

Aplicacao Java inicial para cadastro de clientes, mecanicos e bicicletas e para abertura e consulta de ordens de servico. Nesta fase inicial da implementação, os dados ficam em memoria durante a execucao. Posteriormente, com o andamento do projeto os dados serão armazenados em arquivo.

## Modelagem proposta (inicial)

### Heranca

```text
             Person (abstrata)
              /          \
         Customer      Mechanic
```

`Person` concentra os dados comuns (nome e telefone). `Customer` acrescenta CPF e endereco; `Mechanic` acrescenta matricula e salario.

### Associacoes e responsabilidades

- Um `Customer` pode ter varias bicicletas; cada `Bicycle` cadastrada pertence a um cliente.
- Uma `ServiceOrder` registra a bicicleta atendida, o mecanico responsavel, a descricao, as datas, o status, a mao de obra e as pecas utilizadas.
- `ServiceStatus` enumera os estados iniciais: `OPEN`, `IN_PROGRESS`, `WAITING_FOR_PART`, `UNDER_REVIEW_AND_TESTING`, `WAITING_FOR_PICKUP` e `COMPLETED`.
- `Part` representa um item e sua quantidade na ordem de servico.
- `Calculable` e implementada por `ServiceOrder`, que calcula mao de obra mais o valor das pecas.
- `Model` e `History` serão extraidas/adicionadas em uma proxima etapa. Por enquanto, a bicicleta guarda marca e modelo como textos e a ordem de servico ainda nao persiste um historico de alteracoes.

### Regras previstas para evolucao

- O prazo inicial da ordem e de cinco dias a partir da abertura.
- Se for necessario solicitar uma peca ao revendedor, a ordem deve passar para `WAITING_FOR_PART` e a previsao deve ser atualizada.
- A atribuicao automatica deve priorizar o mecanico que atendeu anteriormente a bicicleta, caso esteja disponivel; caso contrario, deve escolher um mecanico livre.
- A disponibilidade dos mecanicos, o historico, a extensao do prazo por espera de pecas e a persistencia dos dados ainda precisam ser implementados.

## O que ja funciona

O menu de terminal permite cadastrar e listar clientes, mecanicos e bicicletas, abrir ordens de servico e consultar as ordens. Os cadastros e as ordens usam `ArrayList` e sao perdidos ao encerrar o programa.