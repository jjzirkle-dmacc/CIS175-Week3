package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class ListTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="TASK")
	private String task;

	public ListTask() {
		// TODO Auto-generated constructor stub
	}

	public ListTask(String department, String task) {
		this.department = department;
		this.task = task;
	}
	
	public ListTask(int id, String department, String task) {
		this.id = id;
		this.department = department;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "ListTask [id=" + id + ", department=" + department + ", task=" + task + "]";
	}
	
	public String returnItemDetails() {
		return department + ": " + task;
	}

}