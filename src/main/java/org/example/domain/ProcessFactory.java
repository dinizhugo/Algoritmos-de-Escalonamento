package org.example.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ProcessFactory {
    public static List<Process> generateProcess(int value) {
        Random random = new Random();
        List<Process> list = new ArrayList<>();

        for (int i = 0; i < value; i++) {
            int tempoChegada = random.nextInt(10);
            int tempoExecucao = random.nextInt(10) + 1;
            int prioridade = random.nextInt(5) + 1;
            list.add(new Process(i, tempoChegada, tempoExecucao, prioridade));
        }

        list.sort(Comparator.comparingInt(Process::getTempoChegada));

        return list;
    }
}
