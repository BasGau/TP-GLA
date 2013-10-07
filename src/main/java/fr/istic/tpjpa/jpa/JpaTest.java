package fr.istic.tpjpa.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Set<Person> amis = new HashSet<Person>();
		
		Person p1 = new Person("Paul");
		Person p2 = new Person("Pierre");
		Person p3 = new Person("Marie");
		
		
		Set<Home> logements= new HashSet<Home>();
		
		
		Home h1 = new Home("rue du plow");
		 
		Set<Equipement> eq = new HashSet<Equipement>();
		
		Equipement eq1 = new Equipement("Chauffage electrique");
		Equipement eq2 = new Equipement("Chauffage a condensation");
		
		Person p = new Person("Jean", "Pierre", "Cheval", "plowplow@lol.de", "17/56/1995","Jean.Pierre", logements, amis);
		Home h = new Home("rue du puit", 589, "123.123.123.123", eq);
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		amis.add(p1);
		amis.add(p2);
		amis.add(p3);
		
		manager.persist(h1);
		
		logements.add(h1);
		
		eq1.setMezon(h);
		
		manager.persist(eq1);
		manager.persist(eq2);
		
		
		
		eq.add(eq1);
		eq.add(eq2);
	
		
		
		manager.persist(p);
		manager.persist(h);
		

		tx.commit();

		// TODO run request

		System.out.println(".. done.. LOOOL");

		manager.close();
	}

}
