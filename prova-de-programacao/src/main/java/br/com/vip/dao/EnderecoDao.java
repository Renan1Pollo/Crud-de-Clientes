package br.com.vip.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.vip.model.Endereco;

public class EnderecoDao {

	private EntityManager em;

	public EnderecoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Endereco endereco) {
		this.em.persist(endereco);
	}

	public void atualizar(Endereco endereco) {
		this.em.merge(endereco);
	}

	public List<Endereco> buscarPorId(int id) {
		String jpql = "SELECT e FROM Endereco e WHERE e.cliente.id = :id";
		return em.createQuery(jpql, Endereco.class).setParameter("id", id).getResultList();
	}

	public List<Endereco> buscarTodos() {
		String jpql = "SELECT e FROM Endereco e";
		return em.createQuery(jpql, Endereco.class).getResultList();
	}

	public void excluir(int id) {
		em.getTransaction().begin();
		String jpql = "SELECT e FROM Endereco e WHERE e.cliente.id = :id";
		List<Endereco> enderecos = em.createQuery(jpql, Endereco.class).setParameter("id", id).getResultList();
		for (Endereco endereco : enderecos) {
			em.remove(endereco);
		}

		em.getTransaction().commit();
	}
	
	

}
