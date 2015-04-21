package edu.csupomona.cs.cs241.prog_assgmnt_1;

public class MainApp {
	public static void main(String[] args){
		NodeHeap<Integer> test = new NodeHeap<Integer>(10);
		test.add(5);
		System.out.println(test.next.data);
	}
}
