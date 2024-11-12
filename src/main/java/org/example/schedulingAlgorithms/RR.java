package org.example.schedulingAlgorithms;

import org.example.domain.Process;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RR extends Escalation {
    private int quantum;

    // Construtor para inicializar o quantum
    public RR(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public void executar(List<Process> processos) {
        // Criando uma fila de processos prontos
        Queue<Process> fila = new LinkedList<>(processos);

        // Loop para executar os processos até que a fila esteja vazia
        while (!fila.isEmpty()) {
            Process p = fila.poll();

            // Calcular o tempo de execução do processo no quantum atual
            int tempoExecucao = Math.min(p.getTempoExecucao(), quantum);

            // Atualizar o tempo ocioso caso o processador esteja ocioso
            if (p.getTempoChegada() > tempoAtual) {
                tempoOcioso += p.getTempoChegada() - tempoAtual;
                tempoAtual = p.getTempoChegada();
            }

            // Definir o tempo de início de execução
            p.setTempoInicialExecucao(tempoAtual);

            // Atualizar o tempo do processador
            tempoAtual += tempoExecucao;

            // Atualizar o tempo restante do processo
            p.setTempoExecucao(p.getTempoExecucao() - tempoExecucao);

            // Se o processo não terminou, adicione de volta à fila
            if (p.getTempoExecucao() > 0) {
                fila.offer(p);
            } else {
                // Se o processo terminou, definir o tempo final e calcular o tempo retornado
                p.setTempoFinalExecucao(tempoAtual);
                p.setTempoRetornado(p.getTempoFinalExecucao() - p.getTempoChegada());

                // Atualizar as estatísticas de tempo total retornado e trocas de processos
                tempoTotalRetornado += p.getTempoRetornado();
                trocaProcessos++;
            }
        }

        // Exibir as estatísticas após a execução de todos os processos
        exibirEstatisticas(processos.size());
    }
}