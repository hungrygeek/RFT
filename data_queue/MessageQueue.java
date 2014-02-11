package uk.ac.cam.ss2099.fjava.tick5;

public interface MessageQueue<T> {
	public abstract void put(T msg); 
	public abstract T take(); 
}