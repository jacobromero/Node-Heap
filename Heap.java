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

public interface Heap <V extends Comparable<V>>{
	public void add(V value);
	public V[] toArray();
	public V remove();
	public void fromArray(V[] array);
	public V[] getSortedContents();
}
