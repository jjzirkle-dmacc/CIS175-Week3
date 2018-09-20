package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListTask;

public class ListTaskHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ProjectTracker");
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void insertTask(ListTask li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteTask(ListTask toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select li from ListTask li where li.department = :selectedDepartment and li.task = :selectedTask", ListTask.class);
		typedQuery.setParameter("selectedDepartment", toDelete.getDepartment());
		typedQuery.setParameter("selectedTask", toDelete.getTask());
		typedQuery.setMaxResults(1);
		ListTask result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListTask> searchForTaskByTask(String taskName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select li from ListTask li where li.task = :selectedTask", ListTask.class);
		typedQuery.setParameter("selectedTask", taskName);

		List<ListTask> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
	}

	public List<ListTask> searchForTaskByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTask> typedQuery = em.createQuery("select li from ListTask li where li.department = :selectedDepartment", ListTask.class);
		typedQuery.setParameter("selectedDepartment", departmentName);

		List<ListTask> foundTasks = typedQuery.getResultList();
		em.close();
		return foundTasks;
		
	}
	
	public ListTask searchForTaskById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListTask found = em.find(ListTask.class, id);
		em.close();
		return found;
	}

	public List<ListTask> showAllTasks(ListTask viewList){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListTask> typedQuery = em.createQuery("select li from ListTask li", ListTask.class);
		List<ListTask> allTasks = typedQuery.getResultList();
		em.close();
		return allTasks;
	}

	public void updateTask(ListTask toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	
}