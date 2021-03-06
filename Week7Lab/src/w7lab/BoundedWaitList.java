package w7lab;

import java.util.Collection;

public class BoundedWaitList<E> extends WaitList<E> {
	
	private int capacity;

	public BoundedWaitList(int capacity) {
		super();
		this.capacity = capacity;
	}

	public BoundedWaitList(Collection<E> c, int capacity) {
		super(c);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return this.capacity;
	}
	
	@Override
	public void add(E element){
		if (this.content.size() < this.capacity) {
			this.content.add(element);
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + "and capacity is" + this.getCapacity();
	}
	
	

}
