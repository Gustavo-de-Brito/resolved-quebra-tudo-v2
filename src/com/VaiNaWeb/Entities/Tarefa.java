package com.VaiNaWeb.Entities;

import java.time.LocalDate;

public class Tarefa {
	public String titulo;
	public String descricao;
	public Integer prioridade;
	public LocalDate data;
	public Boolean concluida = false;

	public Tarefa() {
	}

	public Tarefa(String titulo, String descricao, Integer prioridade, LocalDate data) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.data = data;
	}
	
	@Override
	public String toString() {
		if(this.concluida) {
			return "T�tulo: " + titulo + ", descri��o: " + descricao + ", prioridade: " + prioridade + ", data: "
					+ data + ", estado: " + "conclu�da";
		}
		return "T�tulo: " + titulo + ", descri��o: " + descricao + ", prioridade: " + prioridade + ", data: "
				+ data + ", estado da tarefa: " + "pendente";
	}
}
