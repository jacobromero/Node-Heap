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

import java.util.ArrayList;
public class NodeHeap<V extends Comparable<V>> implements Heap<V> {
	protected int heapSize = 0;
	protected Node root;
	
	@Override
	public void add(V value) {
		 Node newNode = new Node();
		 newNode.value = value;
		 if(heapSize == 0){
			 root = newNode;
			 heapSize++;
		 }
		 else{
			 Node addPos = getAddNodePos();
			 if(addPos.leftChild == null){
				 addPos.leftChild = newNode;
				 newNode.parent = addPos;
				 
			 }
			 else{
				 addPos.rightChild = newNode;
				 newNode.parent = addPos;
			 }
			 heapSize++;
			 siftUp(newNode);
		 }
	}
	
	private Node getAddNodePos(){
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(root);
		Node currentNode = root;
		while(currentNode.leftChild != null || currentNode.rightChild != null){
			currentNode = queue.remove(0);
			
			if(currentNode.leftChild != null)
				queue.add(currentNode.leftChild);
			else
				return currentNode;
			if(currentNode.rightChild != null)
				queue.add(currentNode.rightChild);
			else
				return currentNode;
		}
		
		return currentNode;
	}

	private void siftUp(Node node){
		Node count = node;
		int heapLevels = (int) ((Math.log(heapSize + 1)) / Math.log(2));
		for(int i = heapLevels; i >= 0; i--){
			if(count.parent != null && count.parent.value.compareTo(count.value) < 0){
				count = swap(count, count.parent);
				if(count.parent != null && count.parent.parent == null)
					count.parent = root;
			}
		}	
		
		if(count.parent != null && count.parent.value.compareTo(count.value) < 0){
			count = swap(count, count.parent);
		}
		
		if(count.parent == null){
			root = count;
		}
	}
	
	private Node swap(Node child, Node parent){
		Node tmp = new Node();
		tmp.value = child.value;
		
		child.value = parent.value;
		parent.value = tmp.value;
		
		return parent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V[] toArray() {
		V[] tmp = (V[])java.lang.reflect.Array.newInstance(root.value.getClass(), heapSize);		
		int counter = 0;
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(root);
		Node currentNode = root;
		while(currentNode != null){
			currentNode = queue.remove(0);

			tmp[counter] = currentNode.value;
			counter++;
			if(currentNode.leftChild == null){
				break;
			}
			queue.add(currentNode.leftChild);
			if(currentNode.rightChild == null)
				break;
			queue.add(currentNode.rightChild);
		}
		while(queue.size() != 0){
			tmp[counter] = queue.remove(0).value;
			counter++;
		}
		return tmp;
	}

	@Override
	public V remove() {
		Node tmp = root;
		tmp.leftChild = root.leftChild;
		tmp.rightChild = root.rightChild;
		Node newRoot = getRemovePos();
//		System.out.println(root.value);
		if(newRoot.parent != null){
			root = newRoot;
			if(root.parent.leftChild == root)
				root.parent.leftChild = null;
			else if(root.parent.rightChild == root)
				root.parent.rightChild = null;
			else{
				root.rightChild = null;
				root = root.leftChild;
			}
			root.leftChild = tmp.leftChild;
			root.rightChild = tmp.rightChild;
		}
		
		siftDown(newRoot);
		
		return tmp.value;
		
	}
	
	private void siftDown(Node node) {
		Node swapNode = node;
		Node parent = node;
		int heapLevels = (int) ((Math.log(heapSize) + 1) / Math.log(2));
		
		for(int i = heapLevels; i > 0; i--){
			if(parent.leftChild != null && parent.leftChild.value.compareTo(swapNode.value) > 0)
				swapNode = parent.leftChild;
			if(parent.rightChild != null && parent.rightChild.value.compareTo(swapNode.value) > 0)
				swapNode = parent.rightChild;
			
			parent = swap(parent, swapNode);
		}
//		System.out.println(root.value);
	}

	public Node getRemovePos(){
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(root);
		Node currentNode = root;
		
		while(queue.get(0) != null){
			currentNode = queue.remove(0);		
			
			queue.add(currentNode.leftChild);
			queue.add(currentNode.rightChild);
		}

		return currentNode;
	}
	
	public int siftDown(V value, int index){
		return 0;
	}
	
	//REDO
	@Override
	public void fromArray(V[] array) {
		for(int i = 0; i < array.length; i++){
			this.add(array[i]);
		}
	}

	@Override
	public V[] getSortedContents() {
		V[] array = this.toArray();
		int end = array.length - 1;
		heapifiy(array);
		
		V tmp = array[end];
//		System.out.println(array[0]);
		array[end] = array[0];
		array[0] = tmp;
		
		for(int i = end; i > 0; i--){
			tmp = array[i];
//			System.out.println(array[0]);
			array[i] = array[0];
			array[0] = tmp;
			siftDown(array, 0, i - 1);
		}
		
		
		return array;
	}
	
	private void siftDown(V[] array, int begIndex, int endIndex){
		int swapIndex = begIndex;
		int leftChildIndex = (2 * begIndex) + 1;
		int rightChildIndex = (2 * begIndex) + 2;
		
		if(leftChildIndex <= endIndex){
			V leftChild = array[leftChildIndex];
			
			if(leftChild.compareTo(array[begIndex]) > 0)
				swapIndex = leftChildIndex;
		}
			
		if(rightChildIndex <= endIndex){
			V rightChild = array[rightChildIndex];
		
			if(rightChild.compareTo(array[swapIndex]) > 0)
				swapIndex = rightChildIndex;
		}	
	}
	
	private void heapifiy(V[] array) {
		for(int i = array.length/2; i >= 0; i--){
			siftDown(array, i);
		}
		
	}
	
	private void siftDown(V[] array, int index){
		int swapIndex = index;
		int leftChildIndex = (2 * index) + 1;
		int rightChildIndex = (2 * index) + 2;
		
		if(leftChildIndex < array.length){
			V leftChild = array[leftChildIndex];
			
			if(leftChild.compareTo(array[index]) > 0)
				swapIndex = leftChildIndex;
		}
			
		if(rightChildIndex < array.length){
			V rightChild = array[rightChildIndex];
		
			if(rightChild.compareTo(array[swapIndex]) > 0)
				swapIndex = rightChildIndex;
		}
		
		if(swapIndex != index){
			V tmp = array[index];
			array[index] = array[swapIndex];
			array[swapIndex] = tmp;
			siftDown(array, swapIndex);
		}		
	}
	
	public String toString(){
		String str = "";
		V[] tmp = toArray(); 
		
		for(int i = 0; i < tmp.length; i++){
			if(tmp[i] != null)
				str = str.concat(" | " + tmp[i] + " |\n");
		}
		
		return str;
	}
	
	class Node{
		Node leftChild;
		Node rightChild;
		Node parent = null;
		V value;
	}	
}
