package singleton;

public class Main {

	public static void main(String[] args) {
		//Impossible to create instances using "new"
		//Car myCar=new Car();
		Car myCar = Car.getInstance();
		myCar.run();
		myCar.fillUp();
		myCar.run();
		
		//myCar2 = myCar --> both are the same instance, according to Singleton
		Car myCar2 = Car.getInstance();
		myCar2.run();

		Counter myCount = Counter.getInstance();
		myCount.increment();
		myCount.getCount();

		Counter myCount2 = Counter.getInstance();
		myCount2.getCount();
	}

}
