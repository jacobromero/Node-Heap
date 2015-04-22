package edu.csupomona.cs.cs241.prog_assgmnt_1;

//TODO comment/clean up code

import java.util.LinkedList;
public class NodeHeap<V extends Comparable<V>> implements Heap<V> {
	LinkedList<V> list = new LinkedList<V>();
	private static int x = 0;
	
	@Override
	public void add(V value) {
		list.addLast(value);
		int index = list.indexOf(value);
		int i = list.size() - 1;
		while(i != 0){
			i = siftUp(value, i);
			
			if(i == index)
				break;
		}	
	}

	private int siftUp(V value, int index){
		int parentIndex = (index - 1) / 2;
		if(parentIndex >= 0){ x++;
			V parent = list.get(parentIndex);
			if(parent.compareTo(value) < 0){
				list.set(parentIndex, value);
				list.set(index, parent);
			}
			else
				return index;
		}
		return parentIndex;
	}
	
	@Override
	public V[] toArray() {
		// TODO Finish this method
		return null;
	}

	@Override
	public void remove() {
		list.removeFirst();
		V value = list.removeLast();
		list.addFirst(value);
		int index = 0;
		int i = 0;
		while(i < list.size()){
			i = siftDown(value, i);
			if(i == index)
				break;
		}
		
	}
	
	public int siftDown(V value, int index){
		int swapIndex = index;
		int leftChildIndex = (2 * index) + 1;
		int rightChildIndex = (2 * index) + 2;
			
		if(leftChildIndex < list.size()){
			V leftChild = list.get(leftChildIndex);
			
			if(leftChild.compareTo(value) > 0)
				swapIndex = leftChildIndex;
		}
			
		if(rightChildIndex < list.size()){
			V rightChild = list.get(rightChildIndex);
		
			if(rightChild.compareTo(list.get(swapIndex)) > 0)
				swapIndex = rightChildIndex;
		}
		
		if(swapIndex != index){
			list.set(index, list.get(swapIndex));
			list.set(swapIndex, value);
			return swapIndex;
		}
			
		
		return list.size();
	}

	@Override
	public void fromArray(V[] array) {
		for(int i = 0; i < array.length; i++){
			this.add(array[i]);
		}
	}

	@Override
	public V[] getSortedContents(V[] array) {
		int end = array.length - 1;
		heapifiy(array);
		
		for(int i = end; i >= 1; i--){
			V tmp = array[i];
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
		
		if(swapIndex != begIndex){
			V tmp = array[begIndex];
			array[begIndex] = array[swapIndex];
			array[swapIndex] = tmp;
			
			siftDown(array, swapIndex, endIndex);
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
		for(int i = 0; i < list.size(); i++){
			str = str.concat(list.get(i).toString() + " -> " );
		}
		return str;
	}
	
}
