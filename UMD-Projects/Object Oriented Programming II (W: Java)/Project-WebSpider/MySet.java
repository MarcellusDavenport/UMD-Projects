import java.util.ArrayList;

public class MySet<T> {

	ArrayList<T> set = new ArrayList<T>();
	
	public synchronized int size() {
		return set.size();
	}
	
	public synchronized void clear() {
		set.clear();
	}
	
	public synchronized boolean remove(T o) {
		if (set.contains(o)) {
			set.remove(o);
			return true;
		} 
		return false;
	}
	
	public synchronized boolean add(T o) {
		if (set.contains(o)) {
			return false;
		} else {
			set.add(o);
			return true;
		}
	}
	
	public synchronized boolean contains(T o) {
		return set.contains(o);
	}
	
	
}