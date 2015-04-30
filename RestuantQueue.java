/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #1
 *
 * A linked list implementation of a max heap,
 * maintaining the same run-time complexities as its
 * array counter part.
 * A restaurant app is used to demonstrate using a heap
 * as a priority queue.
 * 
 * Jacob Romero
 * 
 */

package edu.csupomona.cs.cs241.prog_assgmnt_1;

import java.util.Scanner;

//TODO validate input
public class RestuantQueue {
	private static PriorityQueue<Customer> queue = new PriorityQueue<Customer>();
	private static Scanner kb = new Scanner(System.in);
	public static void startApp() {		
		System.out.println("Thanks for using QueueMaster-3000");
		printMenu();
	}
	
	private static void printMenu() {
		try{
			int userInput = 0;
		
			do{
				printUI();
				userInput = kb.nextInt();
			
				kb.nextLine();
				calcInput(userInput);
			}while(userInput != 4);	
		}
		catch(Exception e){
			System.out.println("\n\noops something went wrong, try again.\n");
			kb.nextLine();
			printMenu();
		}
	}

	private static void calcInput(int input) {
			if(input == 1){
				addCustomer();
			}
			else if(input == 2){
				removeCustomer();
			}
			else if(input == 3){
				peekCustomer();
			}
			else if(input == 4){
				System.out.println("Now Exiting... Have a Nice day!");
			}
			else
				System.out.println("UNRECOGNIZED COMMAND. Please try again.");
	}

	private static void addCustomer(){
		boolean vip, reservation, senior, veteran, children;
		int input = 0;
		System.out.print("Please enter the group size: ");
		int groupSize = kb.nextInt();
		kb.nextLine();
		
		System.out.print("Please enter the group name: ");
		String name = kb.nextLine();
		
		System.out.println("Is the customer a VIP? (1 = yes. 2 = no) ");
		input = kb.nextInt();
		if(input == 1)
			vip = true;
		else
			vip = false;
		kb.nextLine();
		
		System.out.println("Does the customer have a reservation? (1 = yes. 2 = no) ");
		input = kb.nextInt();
		if(input == 1)
			reservation = true;
		else
			reservation = false;
		kb.nextLine();
		
		System.out.println("Is the customer a Senior(Age 55+)? (1 = yes. 2 = no) ");
		input = kb.nextInt();
		if(input == 1)
			senior = true;
		else
			senior = false;
		kb.nextLine();
		
		System.out.println("Is the customer a Veteran? (1 = yes. 2 = no) ");
		input = kb.nextInt();
		if(input == 1)
			veteran = true;
		else
			veteran = false;
		kb.nextLine();
		
		System.out.println("Does the customer have children? (1 = yes. 2 = no) ");
		input = kb.nextInt();
		if(input == 1)
			children = true;
		else
			children = false;
		kb.nextLine();
		
		
		Customer customer = new Customer(groupSize, name, vip, reservation, senior, veteran, children);
		queue.enqueue(customer);
	}
	
	private static void removeCustomer() {
		System.out.println("\n\nA table for " + queue.dequeue() + " is now ready");		
	}
	
	private static void peekCustomer() {
		System.out.println("\n\n" + queue.peek() + " is the next customer that will be served");
		
	}
	
	private static void printUI() {
		System.out.println("Use the following to add or remove customers to the waiting list:");
		System.out.println("	1.) Add customer to waiting list.");
		System.out.println("	2.) Remove customer to waiting list.");
		System.out.println("	3.) View next customer on the waiting list.");
		System.out.println();
		System.out.println("	4.) Exit App.");
		System.out.println();
		System.out.print("Enter Selection Now: ");
	}
}
