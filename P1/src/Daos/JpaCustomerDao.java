package Daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import AbstractFactories.JpaDaoFactory;
import Interfaces.ICustomerDao;
import Models.Customer;

public class JpaCustomerDao implements ICustomerDao {
	
	private JpaDaoFactory jpaDaoFactory;

	public JpaCustomerDao(JpaDaoFactory jpaDaoFactory) {
		this.jpaDaoFactory = jpaDaoFactory;
	}
	
	@Override
	public Optional<Customer> get(int id) {
		EntityManagerFactory emf = jpaDaoFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return Optional.of(customer);
	}

	@Override
	public List<Customer> getAll() {
		EntityManagerFactory emf = jpaDaoFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Customer> people = em.createQuery("SELECT c FROM Customer c").getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return people;
	}

	@Override
	public void save(Customer t) {
		EntityManagerFactory emf = jpaDaoFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void update(Customer t) {
		EntityManagerFactory emf = jpaDaoFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void delete(Customer t) {
		EntityManagerFactory emf = jpaDaoFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@Override
	public void createTable() {
		System.out.println("This should not happen!");
	}

}
