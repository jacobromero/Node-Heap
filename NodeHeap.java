package edu.csupomona.cs.cs241.prog_assgmnt_1;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {
	V data;
	NodeHeap<V> next;
	public static NodeHeap head = null;
	private static NodeHeap last = null;
		
	public NodeHeap(V d){
		data = d;
		next = null;
		if(head == null){
			head = this;
			last = this;
		}
	}
	
	@Override
	public void add(V value) {
		NodeHeap<V> tmp = new NodeHeap<V>(value);
		if(head == null){
			head = tmp;
			last = tmp;
		}
		last.next = tmp;
		last = tmp;
	}
	
	private void siftUp(NodeHeap<V> node){
		
	}

	@Override
	public V[] toArray(V[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(V value) {
		// TODO Auto-generated method stub
		
	}
	
	private void siftDown(NodeHeap<V> node){
		
	}

	@Override
	public void fromArray(V[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V[] getSortedContents(V[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int compareTo(V o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
