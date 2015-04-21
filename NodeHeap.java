package edu.csupomona.cs.cs241.prog_assgmnt_1;

public class NodeHeap<V extends Comparable<V>> implements Heap<V> {
	V data;
	NodeHeap<V> next;
	//TODO remove static from next to vars.
	public static NodeHeap head = null;
	private static NodeHeap last = null;
	private int size = 0;
		
	public NodeHeap(V d){
		data = d;
		next = null;
		if(head == null){
			head = this;
			last = this;
		}
		size++;
	}
	
	@Override
	public void add(V value) {
		NodeHeap<V> tmp = new NodeHeap<V>(value);
		if(head == null){
			head = tmp;
			last = tmp;
			size++;
		}
		last.next = tmp;
		last = tmp;
		size++;
	}
	
	private void siftUp(NodeHeap<V> node){
		NodeHeap<V> current = head;
		for(int i = 0; i > /*Get current position of passed node and use func to find paren*/; i++){
			current = current.next;
		}
		//TODO finish the swap operation on the passed node, and its parent.
		if(current.data < node.data){
			NodeHeap<V> tmp = current;
			current = node;
			current.next = 
		}
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
