package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso ? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteudo ou tarefa (c/t) ? ");
			char resp = sc.next().charAt(0);
			System.out.print("Titulo: ");
			sc.nextLine();
			String titulo = sc.nextLine();
			
			if(resp == 'c') {
				System.out.print("URL do video: ");
				String url = sc.nextLine();
				System.out.print("Duracao em segundos: ");
				int segundos = sc.nextInt();
				list.add(new Video(titulo, url, segundos));
			} else if(resp == 't') {
				System.out.print("Descricao: ");
				String descricao = sc.nextLine();
				System.out.print("Quantidade de questoes: ");
				int questoes = sc.nextInt();
				list.add(new Task(titulo, descricao, questoes));
			}
		}
		
		System.out.println();
		int sum = 0;
		for(Lesson l: list) {
			sum += l.duration();
		}
		
		System.out.println("DURACAO TOTAL DO CURSO = " + sum);
		
		sc.close();
	}
}
