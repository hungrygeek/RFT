package uk.ac.cam.ss2099.fjava.tick5;

import java.util.HashSet;
import java.util.Set;

public class MultiQueue<T> {
	private Set<MessageQueue<T>> outputs = new HashSet<MessageQueue<T>>();
	public synchronized void register(MessageQueue<T> q) {
		outputs.add(q);
	}
	public synchronized void deregister(MessageQueue<T> q) {
		outputs.remove(q);
	}
	public synchronized void put(T message) {
		for(MessageQueue<T> msgQ : outputs){
			msgQ.put(message);
		}
	}
}
