package view;

import java.util.List;
import java.util.Scanner;

import controller.ListTaskHelper;
import model.ListTask;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListTaskHelper lih = new ListTaskHelper();

		private static void addEntry() {
			// TODO Auto-generated method stub
			System.out.print("Enter a department: ");
			String department = in.nextLine();
			System.out.print("Enter an task: ");
			String task = in.nextLine();
			
			ListTask toAdd = new ListTask(department, task);
			lih.insertTask(toAdd);
		}

		private static void deleteEntry() {
			// TODO Auto-generated method stub
			System.out.print("Enter the department to delete: ");
			String department = in.nextLine();
			System.out.print("Enter the task to delete: ");
			String task = in.nextLine();
			
			ListTask toDelete = new ListTask(department, task);
			lih.deleteTask(toDelete);

		}

		private static void updateEntry() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Department");
			System.out.println("2 : Search by Task");
			int searchBy = in.nextInt();
			in.nextLine();
			
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("Project Tracker");
			while (goAgain) {
				System.out.println("*  Select a task:");
				System.out.println("*  1 -- Add a task");
				System.out.println("*  2 -- Edit a task");
				System.out.println("*  3 -- Delete a task");
				System.out.println("*  4 -- View the task list");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addEntry();
				} else if (selection == 2) {
					updateEntry();
				} else if (selection == 3) {
					deleteEntry();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			
			
			ListTask viewList = new ListTask();
			lih.showAllTasks(viewList);

		}

	}
