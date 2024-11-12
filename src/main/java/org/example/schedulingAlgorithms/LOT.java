package org.example.schedulingAlgorithms;

import org.example.domain.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LOT extends Escalation{
    @Override
    public void executar(List<Process> processos) {
        Random random = new Random();
        List<Process> filaDeBilhetes = new ArrayList<>();

        for (Process p : processos) {
            int bilhetes = calcularBilhetes(p);
            for (int i = 0; i < bilhetes; i++) {
                filaDeBilhetes.add(p);
            }
        }

        while (!filaDeBilhetes.isEmpty()) {
            int indexSorteado = random.nextInt(filaDeBilhetes.size());
            Process pSorteado = filaDeBilhetes.get(indexSorteado);

            if (pSorteado.getTempoChegada() > tempoAtual) {
                tempoOcioso += pSorteado.getTempoChegada() - tempoAtual;
                tempoAtual = pSorteado.getTempoChegada();
            }

            pSorteado.setTempoInicialExecucao(tempoAtual);
            tempoAtual += pSorteado.getTempoExecucao();
            pSorteado.setTempoFinalExecucao(tempoAtual);
            pSorteado.setTempoRetornado(pSorteado.getTempoFinalExecucao() - pSorteado.getTempoChegada());

            tempoTotalRetornado += pSorteado.getTempoRetornado();
            filaDeBilhetes.remove(pSorteado);
            trocaProcessos++;

        }

        exibirEstatisticas(processos.size());
    }

    private int calcularBilhetes(Process p) {
        return p.getTempoExecucao();
    }
}