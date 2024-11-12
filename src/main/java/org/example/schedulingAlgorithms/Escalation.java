package org.example.schedulingAlgorithms;

import org.example.domain.Process;

import java.util.List;

public abstract class Escalation {
    protected int tempoAtual = 0;
    protected int tempoOcioso = 0;
    protected int trocaProcessos = 0;
    protected int tempoTotalRetornado = 0;

    public abstract void executar(List<Process> processos);

    protected double calcularMediaTempoRetornado(int numeroDeProcessos) {
        return tempoTotalRetornado / (double) numeroDeProcessos;
    }

    protected void exibirEstatisticas(int numeroDeProcessos) {
        System.out.println("Ociosidade do processador: " + tempoOcioso);
        System.out.println("Média de Tempo de Retorno: " + calcularMediaTempoRetornado(numeroDeProcessos));
        System.out.println("Trocas de Processos: " + trocaProcessos);
    }
}
