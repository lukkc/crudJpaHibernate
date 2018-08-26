package com.crud.java.web.repository;

import java.util.ArrayList;
import java.util.List;

import com.crud.java.web.models.Cliente;
import com.crud.java.web.models.Preferencia;

public class ClienteRepository extends EntityInstance{
	
	public Cliente create(Cliente cliente) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			entity.manager.persist(cliente);		
			entity.manager.getTransaction().commit();
			entity.close();
			return cliente;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	public void update(Cliente cliente) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			entity.manager.merge(cliente);
			entity.manager.getTransaction().commit();
			System.out.println("Cliente foi atualizado.");
			entity.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public Cliente findByMatricula(String matricula) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			Cliente cliente = (Cliente) entity.manager.createQuery("select c from " +  Cliente.class.getName() + " as c where c.matricula = " + matricula).getSingleResult();		
			entity.manager.getTransaction().commit();
			entity.close();
			return cliente;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			List<Cliente> clientes = entity.manager.createQuery("FROM " + Cliente.class.getName()).getResultList();		
			entity.manager.getTransaction().commit();
			entity.close();
			return clientes;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	public void removeByMatricula(String matricula) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			Cliente cliente = (Cliente) entity.manager.createQuery("select c from " +  Cliente.class.getName() + " as c where c.matricula = " + matricula).getSingleResult();			
			entity.manager.remove(cliente);
			entity.manager.getTransaction().commit();
			System.out.println("Cliente " + cliente.getNome() + " foi removido.");
			entity.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public void ativarByMatricula(String matricula) {
		modificarStatusByMatricula(matricula, true, "Conta Ativada!");
	}
	
	public void desativarByMatricula(String matricula) {
		modificarStatusByMatricula(matricula, false, "Conta Desativada");
	}
	
	public List<Preferencia> getListaPreferenciasByMatricula(String matricula) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			List<Preferencia> preferencias = new ArrayList<Preferencia>();
			entity.manager.getTransaction().begin();
			Cliente cliente = (Cliente) entity.manager.createQuery("select c from " +  Cliente.class.getName() + " as c where c.matricula = " + matricula).getSingleResult();
			entity.manager.getTransaction().commit();
			preferencias.addAll(cliente.getPreferencias());
			entity.close();
			return preferencias;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	private void modificarStatusByMatricula(String matricula, boolean state, String message) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			Cliente cliente = (Cliente) entity.manager.createQuery("select c from " +  Cliente.class.getName() + " as c where c.matricula = " + matricula).getSingleResult();
			cliente.setAtivo(state);
			entity.manager.merge(cliente);
			entity.manager.getTransaction().commit();
			System.out.println(message);
			entity.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}


}
