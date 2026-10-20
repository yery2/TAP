package ex2;

import java.util.Collections;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ExistException{
		Directory root = new Directory("root");
		Directory home = new Directory("home");
		Directory lp = new Directory("lp");
		Directory secret = new Directory("black");
		File f1 = new File("f1",1234);
		File f2 = new File("f2",3445);
		File f3 = new File("f3",6688);
		File f4 = new File("lp",99999);
		File f5 = new File("money",999999);
		root.addChild(home);
		root.addChild(f1);
		home.addChild(lp);
		home.addChild(f2);
		lp.addChild(f3);
		secret.addChild(f5);
		root.addChild(f4);
		lp.addChild(secret);
		
		root.ls();
		System.out.println("-------------");
		
		
		List<String> result = root.collect();
		for (String elem:result)
			System.out.println(elem);
		
		System.out.println("-------------");
		
		List<File> result2 = root.search("lp");
		for (File elem2:result2)
			System.out.println(elem2);
		
		System.out.println("-------------");
		
		System.out.println(f3);

		System.out.println("-------------");


		List<AComponent> result3 = root.toList();
		for (AComponent a:result3)
			System.out.println(a);
		
		System.out.println("-------------");
		
		Order o = new Order();
		Collections.sort(result3,o);
		
		for (AComponent a:result3)
			System.out.println(a);
		
		System.out.println("-------------");
		
		System.out.println("SIZE:"+root.size());


		System.out.println("-------------");
		System.out.println("QUERY:"+root.query(f->f.size()>2000));

		PredicateDecorator<File> pd = new PredicateDecorator<>(f->f.size()>2000);
		System.out.println("QUERY:"+ root.query(pd));
		System.out.println("COUNT QUERIES "+pd.getCountTest());




		System.out.println("-------------");
		
		for (AComponent a:root)
			System.out.println(a); 
		
	}

}
