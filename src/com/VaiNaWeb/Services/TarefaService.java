package com.VaiNaWeb.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.VaiNaWeb.Entities.Tarefa;

public class TarefaService {
	// printa op��es
		public static void print() {
			System.out.println("----------------------------------");
			System.out.println("|        Escolha uma op��o        |");
			System.out.println("----------------------------------");
			System.out.println("1        Adicionar tarefa");
			System.out.println("2        Apagar tarefa");
			System.out.println("3        Exibir tarefas");
			System.out.println("4        Marcar tarefa como conclu�da");
			System.out.println("5        Listar tarefas conclu�das");
			System.out.println("6        Listar tarefas pendentes");
			System.out.println("7        Sair do sistema");
			System.out.println("----------------------------------");
		}

		// adiciona uma nova tarefa
		public static void adicionar(Scanner sc, List<Tarefa> listaTarefas) {
			System.out.println("Digite o t�tulo da tarefa");
			String titulo = sc.nextLine();

			System.out.println("Digite a descri��o da tarefa");
			String descricao = sc.nextLine();

			System.out.println("-----------------------------");
			System.out.println("Qual o n�vel de prioridade da tarefa?");
			System.out.println("-----------------------------");
			System.out.println("1    Urgente");
			System.out.println("2    Pouco urgente");
			System.out.println("3    N�o urgente");
			System.out.println("-----------------------------");
			int urgencia = sc.nextInt();

			sc.nextLine();
			System.out.println("Digite a data de entrega no formato yyyy-MM-dd:");
			String dataTarefa = sc.nextLine();

			try {
				// formata uma data do timo localDate
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate data = LocalDate.parse(dataTarefa, formatter);

				// cria uma nova instancia e adiciona o objeto na lista
				listaTarefas.add(new Tarefa(titulo, descricao, urgencia, data));
				System.out.println("Tarefa adicionada com sucesso!");
				System.out.println(listaTarefas.get(listaTarefas.size() - 1)); // Mostra a �ltima tarefa adicionada
				
			} catch (DateTimeParseException e) {
				// printa uma mensagem se data estiver errada 
				System.out.println(
						"Erro ao adicionar a tarefa. Certifique-se de fornecer uma data v�lida no formato yyyy-MM-dd.");
			}
			
			apertaEnterParaContinuar(sc);//enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}

		
		// l�gica para exibir tarefas
		public static void listar(Scanner sc ,List<Tarefa> listaTarefas) {
			int controle = 0;
			for(int x = 0 ; x < listaTarefas.size() ; x++) {
				System.out.println("id " + x + " , " + listaTarefas.get(x));
				controle++;
			}
			if(controle==0) {
				System.out.println("N�o h� tarefas cadastradas.");
			}
			apertaEnterParaContinuar(sc);//enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}
		
		// remove uma tarefa da lista
		public static void remover(Scanner sc, List<Tarefa> listaTarefas) {
			listar(sc, listaTarefas); // chama outro m�todo que lista as tarefas
			System.out.println("Digite o id da tarefa que deseja apagar!");
			int apagar = sc.nextInt();
			Tarefa tarefa = listaTarefas.remove(apagar);
			if(tarefa!=null) {
				System.out.println("Tarefa exclu�da: ");    
			}

			sc.nextLine();
			apertaEnterParaContinuar(sc);//enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}
		
		// adiciona um true em tarefas que j� est�o conclu�das
		public static void tarefaOk(Scanner sc, List<Tarefa> listaTarefas) {
			listar(sc, listaTarefas); // chama outro m�todo que lista as tarefas
			System.out.println("Insira o �ndice da tarefa que deseja marcar como conclu�da");
			int concluida = sc.nextInt();
			boolean estadoTarefa = listaTarefas.get(concluida).concluida;
			listaTarefas.get(concluida).concluida = true;
			if(estadoTarefa!=listaTarefas.get(concluida).concluida) {
				System.out.println("Altera��o feita com sucesso!!");
			}

			sc.nextLine();
			apertaEnterParaContinuar(sc);//enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}
		
		// lista as tarefas conclu�das
		public static void listarTarefasConcluidas(Scanner sc, List<Tarefa> listaTarefas) {
			int controle = 0;
			for (int x = 0; x < listaTarefas.size(); x++) {
				if (listaTarefas.get(x).concluida){// retorna verdadeiro se tarefa j� foi conclu�da
					System.out.println("id " + x + " , " + listaTarefas.get(x));
					controle++;
				}	
			}
			if(controle==0) {
				System.out.println("N�o h� tarefas conclu�das.");
			}
			apertaEnterParaContinuar(sc); //enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}
		
		// lista tarefas pendentes
		public static void listarTarefasPendentes(Scanner sc, List<Tarefa> listaTarefas) {
			int controle = 0;
			for (int x = 0; x < listaTarefas.size(); x++) {
				if (!listaTarefas.get(x).concluida){// retorna negativo se ja foi concluida
					System.out.println("id " + x + " , " + listaTarefas.get(x));
					controle++;
				}
			}
			if(controle==0) {
				System.out.println("N�o h� tarefas pendentes.");
			}
			apertaEnterParaContinuar(sc); //enquanto o usu�rio n�o pressionar a tecla enter, o sistema n�o roda
		}
		
		// segura o sistema a at� o usu�rio pressione Enter 
		private static void apertaEnterParaContinuar(Scanner sc) {
			System.out.println("Pressione Enter para continuar");
			String verifica = sc.nextLine();
		}
}
