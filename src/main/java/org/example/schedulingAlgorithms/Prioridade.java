package org.example.schedulingAlgorithms;

import org.example.domain.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prioridade extends Escalation{
    @Override
    public void executar(List<Process> processos) {
        List<Process> processosRestantes = new ArrayList<>(processos);

        while (!processosRestantes.isEmpty()) {
            List<Process> disponiveis = new ArrayList<>();
            for (Process p : processosRestantes) {
                if (p.getTempoChegada() <= tempoAtual) {
                    disponiveis.add(p);
                }
            }

            if (!disponiveis.isEmpty()) {
                Process p = Collections.min(disponiveis, Comparator.comparingInt(Process::getPrioridade));
                processosRestantes.remove(p);

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
            } else {
                tempoAtual++;
            }
        }

        exibirEstatisticas(processos.size());
    }
}
