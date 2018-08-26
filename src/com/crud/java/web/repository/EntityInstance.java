package com.crud.java.web.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityInstance {
	public EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
	public EntityManager manager = factory.createEntityManager();
	
	public void close() {
		this.manager.close();
		this.factory.close();
	}
	
	public EntityInstance getEntityInstance() {
		return new EntityInstance();
	}
}
