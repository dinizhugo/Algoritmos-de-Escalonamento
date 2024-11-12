package org.example;

import org.example.domain.Process;
import org.example.domain.ProcessFactory;
import org.example.schedulingAlgorithms.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int N = 5;  // Número de processos
        List<Process> processos = ProcessFactory.generateProcess(N);

        System.out.println("Processos Gerados: ");
        for (Process p : processos) {
            System.out.println(p);
        }

        // Executar FIFO
        System.out.println("\nExecutando FIFO:");
        Escalation fifo = new FIFO();
        fifo.executar(processos);

        // Executar SJF
        System.out.println("\nExecutando SJF:");
        Escalation sjf = new SJF();
        sjf.executar(processos);

        // Executar Prioridade
        System.out.println("\nExecutando Prioridade:");
        Escalation prioridade = new Prioridade();
        prioridade.executar(processos);

        // Executar Loteria
        System.out.println("\nExecutando Loteria:");
        Escalation loteria = new LOT();
        loteria.executar(processos);

        // Executar RR
        System.out.println("\nExecutando Round Robin (quantum = 3):");
        Escalation rr = new RR(3);
        rr.executar(processos);

    }
}