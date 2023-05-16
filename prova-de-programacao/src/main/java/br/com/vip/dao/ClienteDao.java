package br.com.vip.dao;

import javax.persistence.EntityManager;

import br.com.vip.model.Cliente;

public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void excluir(int id) {
		em.getTransaction().begin();

		Cliente cliente = em.find(Cliente.class, id);
		if (cliente != null) {
			em.remove(cliente);
			em.getTransaction().commit();
		}
	}

}
