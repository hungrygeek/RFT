package uk.ac.cam.ss2099.fjava.tick5;

public class SafeMessageQueue<T> implements MessageQueue<T> {
	private static class Link<L> {
		L val;
		Link<L> next;
		Link(L val) { this.val = val; this.next = null; }
	}
	private Link<T> first = null;
	private Link<T> last = null;

	public synchronized void put(T val) {
		Link<T> new_Link = new Link<T>(val);
		if (first == null){
			first = new_Link;
			last = first;
		} else {
			last.next = new_Link;
			last = new_Link;
		}
		this.notify();
	}

	public synchronized T take() {
		while(first == null) //use a loop to block thread until data is available
			try {this.wait();} catch(InterruptedException ie) {}
		T val = first.val;
		first = first.next;
		return val;
	}
}
