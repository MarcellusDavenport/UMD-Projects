import java.util.ArrayList;

public class MyQueue<T> {
	
	//underlying data structure 
	ArrayList<T> queue = new ArrayList<T>();
	
	public int size() {
		return queue.size();
	}
	
	public synchronized void clear() {
		queue.clear();
	}
	
	public synchronized void enqueue(T o) {
		queue.add(o);
		notifyAll();
	}
	
	public synchronized T dequeue() {
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T data = queue.get(0);
		queue.remove(0);
		return data;
	}
	
}
