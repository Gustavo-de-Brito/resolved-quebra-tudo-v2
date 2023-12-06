package com.VaiNaWeb.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.VaiNaWeb.Entities.Tarefa;
import com.VaiNaWeb.Services.TarefaService;

public class ListaTarefaApplication {
	public static void run() {
		boolean finaliza = true;
		Scanner sc = new Scanner(System.in);
		List<Tarefa> listaTarefas = new ArrayList<>();

		do {
			try {
				TarefaService.print();

				int resposta = sc.nextInt();
				sc.nextLine(); // Limpar o buffer do scanner ap�s a leitura do n�mero

				switch (resposta) {
					case 1:
						// adiciona uma nova tarefa
						TarefaService.adicionar(sc, listaTarefas);
						break;
					case 2:
						// remove uma tarefa da lista
						TarefaService.remover(sc, listaTarefas);
						break;
					case 3:
						// exibe todas tarefas
						TarefaService.listar(sc, listaTarefas);
						break;
					case 4:
						// marca como conclu�da uma tarefa
						TarefaService.tarefaOk(sc, listaTarefas);
						break;
					case 5:
						// exibe as tarefas concluidas
						TarefaService.listarTarefasConcluidas(sc, listaTarefas);
						break;
					case 6:
						// exibe as tarefas	pendentes
						TarefaService.listarTarefasPendentes(sc, listaTarefas);
						break;
					case 7:
						System.out.println("Saindo do sistema....");
						finaliza = false;
						break;
					default:
						System.out.println("Op��o inv�lida.");
				}

			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Desculpe-me, mas voc� inseriu algo n�o esperado pelo sistema, tente novamente ");
			}

		} while (finaliza);

		sc.close();
	}	
}
