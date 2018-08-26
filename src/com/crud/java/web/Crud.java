package com.crud.java.web;


import java.util.Scanner;
import com.crud.java.web.services.ClienteService;

public class Crud {
	public static void main(String[] args) {
		ClienteService clienteService = new ClienteService();
		Scanner reader = new Scanner(System.in);
		
		do {
			
			clearConsole();
			
			System.out.println("\nCRUD COM JPA E HIBERNATE\n\n");
			System.out.println("1 - CRIAR");
			System.out.println("2 - ATUALIZAR");
			System.out.println("3 - PROCURAR POR MATRICULA");
			System.out.println("4 - LISTAR TODOS");
			System.out.println("5 - EXCLUIR");
			System.out.println("6 - ATIVAR");
			System.out.println("7 - DESATIVAR");
			System.out.println("8 - LISTAR PREFERENCIAS");
			
			int input = reader.nextInt();
			
			switch (input) {
			case 1:
				clienteService.create();
				break;
				
			case 2:
				clienteService.update();
				break;
				
			case 3:
				clienteService.findByMatricula();
				break;
				
			case 4:
				clienteService.findAll();
				break;
				
			case 5:
				clienteService.delete();
				break;
				
			case 6:
				clienteService.ativar();
				break;
				
			case 7:
				clienteService.desativar();
				break;
				
			case 8:
				clienteService.listarPreferencias();
				break;

			default:
				break;
			}
			

		System.out.println("DESEJA FAZER MAIS ALGUMA OPERAÇÃO?");
		System.out.println("0 - sim");
		System.out.println("1 - não");
			
		} while (reader.nextInt() == 0);
		
		reader.close();
	}
	
	private static void clearConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
