package org.example.domain;

public class Process {
    private Integer id;
    private int tempoChegada;
    private int tempoExecucao;
    private int tempoInicialExecucao;
    private int tempoFinalExecucao;
    private int tempoRetornado;
    private int prioridade;

    public Process(Integer id, int tempoChegada, int tempoExecucao, int prioridade) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getTempoInicialExecucao() {
        return tempoInicialExecucao;
    }

    public void setTempoInicialExecucao(int tempoInicialExecucao) {
        this.tempoInicialExecucao = tempoInicialExecucao;
    }

    public int getTempoFinalExecucao() {
        return tempoFinalExecucao;
    }

    public void setTempoFinalExecucao(int tempoFinalExecucao) {
        this.tempoFinalExecucao = tempoFinalExecucao;
    }

    public int getTempoRetornado() {
        return tempoRetornado;
    }

    public void setTempoRetornado(int tempoRetornado) {
        this.tempoRetornado = tempoRetornado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Processo " + id + " (Chegada: " + tempoChegada + ", Execução: " + tempoExecucao + ", Prioridade: " + prioridade + ")";
    }
}
