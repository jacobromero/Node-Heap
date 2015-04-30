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

/**
 * 
 * @author Jacob Romero
 *
 */
public class Customer implements Comparable<Customer>{
	protected String groupName;
	protected boolean hasVip = false;
	protected boolean hasReservation = false;
	protected boolean hasSeniors = false;
	protected boolean hasVeterans = false;
	protected int groupSize = 1;
	protected boolean hasChildren = false;
	protected int priority;
	
	public Customer(int size, String name, boolean vip, boolean reservation, boolean senoirs, boolean veterans, boolean children){
		groupSize = size;
		groupName = name;
		hasVip = vip;
		hasReservation = reservation;
		hasSeniors = senoirs;
		hasVeterans = veterans;
		hasChildren = children;
		calcPriority();
	}
	public Customer(int size, String name){
		groupSize = size;
		groupName = name;
		calcPriority();
	}
	
	//Mutators
	/**
	 * 
	 * @param vip
	 */
	public void setVipStatus(boolean vip){
		hasVip = vip;
		calcPriority();
	}
	
	public void setReservationStatus(boolean reservation){
		hasReservation = reservation;
		calcPriority();
	}
	
	public void setSeniorStatus(boolean senior){
		hasSeniors = senior;
		calcPriority();
	}
	
	public void setVeteranStatus(boolean veteran){
		hasVeterans = veteran;
		calcPriority();
	}
	
	public void setChilderenStatus(boolean children){
		hasChildren = children;
		calcPriority();
	}
	
	public void setGroupSize(int size){
		groupSize = size;
		calcPriority();
	}
	
	private void calcPriority() {
		if(hasVip)
			priority = 7;
		else if(hasReservation)
			priority = 6;
		else if(hasSeniors)
			priority = 5;
		else if(hasVeterans)
			priority = 4;
		else if(groupSize > 4)
			priority = 3;
		else if(hasChildren)
			priority = 2;
		else
			priority = 1;
	}
	
	public int compareTo(Customer customer) {
		if(this.priority > customer.priority)
			return 1;
		else if(this.priority < customer.priority)
			return -1;
		else
			return 0;
	}
	
	public String toString(){
		String str = groupName + " - Party of: " + groupSize;
		return str;
	}
	
	//Accessors
	
		public boolean getVipStatus(){
			return hasVip;
		}
		
		public boolean getReservationStatus(){
			return hasReservation;
		}
		
		public boolean getSeniorStatus(){
			return hasSeniors;
		}
		
		public boolean getVeteranStatus(){
			return hasVeterans;
		}
		
		public boolean getChilderenStatus(){
			return hasChildren;
		}
		
		public int getGroupSize(){
			return groupSize;
		}
		
		public String getGroupName(){
			return groupName;
		}
		
}
