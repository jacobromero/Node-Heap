package edu.csupomona.cs.cs241.prog_assgmnt_1;

//TODO create customer class
//TODO implement priority queue

public class MainApp {
	public static void main(String[] args){
		NodeHeap<Integer> test = new NodeHeap<Integer>();
		test.add(10);
		test.add(40);
		
		Integer[] array = {5, 60, 3, 0, 95};
		test.fromArray(array);
		System.out.println(test);
		
		test.remove();
		System.out.println(test);
		test.remove();
		test.remove();
		System.out.println(test);
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		array = test.getSortedContents(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
