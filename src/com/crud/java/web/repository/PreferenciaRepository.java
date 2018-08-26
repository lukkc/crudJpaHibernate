package com.crud.java.web.repository;

import java.util.List;

import com.crud.java.web.models.Preferencia;

public class PreferenciaRepository extends EntityInstance {

	public Preferencia create(Preferencia preferencia) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			entity.manager.persist(preferencia);
			entity.manager.getTransaction().commit();
			entity.close();
			return preferencia;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	public List<Preferencia> createMany(List<Preferencia> preferencias) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			for (Preferencia preferencia : preferencias) {
				entity.manager.persist(preferencia);
			}
			entity.manager.getTransaction().commit();
			entity.close();
			return preferencias;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	public void delete(Preferencia preferencia) {
		
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			entity.manager.remove(preferencia);
			entity.manager.getTransaction().commit();
			entity.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
		
	public void update(Preferencia preferencia) {
	
		try {
			
			EntityInstance entity = this.getEntityInstance();
			entity.manager.getTransaction().begin();
			entity.manager.merge(preferencia);
			entity.manager.getTransaction().commit();
			entity.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
}
