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

public class PriorityQueue<V extends Comparable<V>> {
	NodeHeap<V> maxHeap = new NodeHeap<V>();
	
	public void enqueue(V item){
		maxHeap.add(item);
	}
	
	public V dequeue(){
		return maxHeap.remove();
	}
	
	public V peek(){
		V[] array = maxHeap.toArray();		
		return array[0];
	}
	
	public int size(){
		return maxHeap.heapSize;
	}
}
