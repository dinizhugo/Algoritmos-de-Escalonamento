# Algoritmos de Escalonamento - Sistemas Operacionais

Este repositório contém a implementação de diversos algoritmos de **escalonamento de processos** desenvolvidos como parte da disciplina de **Sistemas Operacionais**.

Os algoritmos implementados são os seguintes:

- **FIFO (First In, First Out)**: Escalonamento simples, onde o primeiro processo a chegar é o primeiro a ser executado.
- **SJF (Shortest Job First)**: Escalonamento baseado no menor tempo de execução dos processos.
- **Prioridade**: Processos são executados de acordo com a sua prioridade, onde o processo de maior prioridade é executado primeiro.
- **Loteria (LOT)**: Um algoritmo de escalonamento aleatório, onde processos recebem "bilhetes" e o processador escolhe aleatoriamente um processo com base nesse sorteio.
- **Round Robin (RR)**: Escalonamento circular, onde cada processo recebe uma fatia de tempo (quantum) para execução, e os processos são executados em rodadas.

## Funcionalidades

- Simulação da execução de processos com tempos de chegada e tempo de execução configuráveis.
- Cálculo de estatísticas, como:
  - **Ociosidade do Processador**
  - **Média de Tempo de Retorno**
  - **Número de Trocas de Processos**

## Como Usar

1. Clone este repositório em sua máquina local:
    ```bash
    git clone https://github.com/dinizhugo/Algoritmos-de-Escalonamento.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd nome-do-repositorio
    ```

3. Compile e execute os algoritmos de escalonamento com os parâmetros desejados (como o número de processos e o tempo de quantum, se aplicável).

## Exemplo de Saída

- **FIFO**: Média de tempo de retorno, ociosidade do processador, trocas de processos.
- **SJF**: Média de tempo de retorno, ociosidade do processador, trocas de processos.
- **Prioridade**: Média de tempo de retorno, ociosidade do processador, trocas de processos.
- **Loteria**: Média de tempo de retorno, ociosidade do processador, trocas de processos.
- **Round Robin**: Média de tempo de retorno, ociosidade do processador, trocas de processos.
