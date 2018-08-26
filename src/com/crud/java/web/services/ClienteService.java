package com.crud.java.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crud.java.web.models.Cliente;
import com.crud.java.web.models.Preferencia;
import com.crud.java.web.repository.ClienteRepository;

public class ClienteService {
		ClienteRepository clienteRepository = new ClienteRepository();
		PreferenciaService preferenciaService = new PreferenciaService();
	
		public void create( ) {
			
			Scanner reader = new Scanner(System.in);
			Cliente cliente = new Cliente();
			List<Preferencia> preferencias = new ArrayList<Preferencia>();
			
			System.out.println("\nINFORMAÇÕES USUARIO\n");
			
			System.out.println("Nome: ");
			cliente.setNome(reader.next());
			
			System.out.println("\nSobrenome: ");
			cliente.setSobrenome(reader.next());
			
			System.out.println("\nMatricula: ");
			cliente.setMatricula(reader.next());
			
			clienteRepository.create(cliente);
			
			System.out.println("Quer adicionar preferencias?\n");
			System.out.println("0 - sim");
			System.out.println("1 - não");
			
			if(reader.nextInt() == 0) {
				do {
					Preferencia preferencia = new Preferencia();
					preferencia.setCliente(cliente);
					System.out.println("\nDescrição: ");
					preferencia.setDescricao(reader.next());
					preferencias.add(preferencia);
					
					System.out.println("\n Quer adicionar mais um?");
					System.out.println("0 - sim");
					System.out.println("1 - não");
					
				}while(reader.nextInt() == 0);
				
				preferenciaService.createMany(preferencias);
				
			} 
			
			
			reader.close();
		}
		
		public void update() {
			
			Scanner reader = new Scanner(System.in);
			List<Preferencia> preferencias = new ArrayList<Preferencia>();
			
			Cliente cliente = clienteRepository.findByMatricula(reader.next());
			
			System.out.println("\nINFORMAÇÕES USUARIO\n");
			
			System.out.println("Nome: ");
			cliente.setNome(reader.next());
			
			System.out.println("\nSobrenome: ");
			cliente.setSobrenome(reader.next());
			
			System.out.println("\nMatricula: ");
			cliente.setMatricula(reader.next());
			
			System.out.println("Quer adicionar preferencias?\n");
			System.out.println("0 - sim");
			System.out.println("1 - não");
			
			if(reader.nextInt() == 0) {
				do {
					Preferencia preferencia = new Preferencia();
					preferencia.setCliente(cliente);
					System.out.println("\nDescrição: ");
					preferencia.setDescricao(reader.next());
					preferencias.add(preferencia);
					
					System.out.println("\n Quer adicionar mais um?");
					System.out.println("0 - sim");
					System.out.println("1 - não");
					
				}while(reader.nextInt() == 0);
				
				clienteRepository.update(cliente);
				preferenciaService.createMany(preferencias);
				
			} else {
				clienteRepository.create(cliente);
			}
			
			
			reader.close();
		}
		
		public void findByMatricula() {
			Scanner reader = new Scanner(System.in);
			
			System.err.println("INFORME A MATRICULA DO CLIENTE QUE DESEJA PROCURAR: ");
			Cliente cliente = clienteRepository.findByMatricula(reader.next());
			
			System.out.println(cliente.toString());
			reader.close();
		}
		
		public void findAll() {
			
			List<Cliente> clientes = clienteRepository.findAll();
			
			System.out.println("[\n");
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString() + ",\n");
			}
			
		}
		
		public void delete() {
			Scanner reader = new Scanner(System.in);
			
			System.err.println("INFORME A MATRICULA DO CLIENTE QUE DESEJA EXCLUIR: ");
			clienteRepository.removeByMatricula(reader.next());
			
			reader.close();
		}
		
		public void ativar() {
			Scanner reader = new Scanner(System.in);
			
			System.err.println("INFORME A MATRICULA DO CLIENTE QUE DESEJA ATIVAR: ");
			clienteRepository.ativarByMatricula(reader.next());
			
			reader.close();
		}
		
		public void desativar() {
			Scanner reader = new Scanner(System.in);
			
			System.err.println("INFORME A MATRICULA DO CLIENTE QUE DESEJA DESATIVAR: ");
			clienteRepository.desativarByMatricula(reader.next());
			
			reader.close();
		}
		
		public void listarPreferencias() {
			Scanner reader = new Scanner(System.in);
			
			System.err.println("INFORME A MATRICULA DO CLIENTE QUE DESEJA LISTAR AS PREFERENCIAS: ");
			List<Preferencia> preferencias = clienteRepository.getListaPreferenciasByMatricula(reader.next());
			
			System.out.println("[");
			for (Preferencia preferencia : preferencias) {
				System.out.println("  " + preferencia.toString());
			}
			System.out.println("]");
			
			reader.close();
		}
}
