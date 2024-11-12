package org.example.schedulingAlgorithms;

import org.example.domain.Process;

import java.util.List;

public class FIFO extends Escalation{
    @Override
    public void executar(List<Process> processos) {
        int tempoAtual = 0;

        for (Process p : processos) {
            if (p.getTempoChegada() > tempoAtual) {
                tempoOcioso += p.getTempoChegada() - tempoAtual;
                tempoAtual = p.getTempoChegada();
            }

            p.setTempoInicialExecucao(tempoAtual);
            p.setTempoFinalExecucao(tempoAtual + p.getTempoExecucao());
            p.setTempoRetornado(p.getTempoFinalExecucao() - p.getTempoChegada());

            tempoTotalRetornado += p.getTempoRetornado();
            tempoAtual = p.getTempoFinalExecucao();
            trocaProcessos++;
        }

        exibirEstatisticas(processos.size());
    }
}
