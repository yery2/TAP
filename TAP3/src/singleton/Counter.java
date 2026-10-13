package singleton;

public class Counter {

    private static Counter counter = new Counter();
    private int count=0;

    
	public static Counter getInstance(){
		return counter;
	}

    public void increment(){
		count += 1;
	}

	public int getCount(){
		return count;
	}
}
