package ex3;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

@BlackList(names = {"black", "bad"})

public class Directory implements AComponent,Iterable<AComponent> {

	private String name;
	private List <AComponent> children;
	private AComponent parent = null;
	private List<String> black = getList();

	public Directory(String name) {
		this.name = name;
		children = new LinkedList<AComponent>();

	}

	public void addChild(AComponent child) throws ExistException{
		if (children.contains(child))
			throw new ExistException();
		children.add(child);
		child.setParent(this);
	}

	public void removeChild(AComponent child){
		children.remove(child);
	}
	
	public void ls() {
		System.out.println(name);
		for (AComponent child:children)
			child.ls();
		
	}

	public List<String> collect() {
		List<String> result = new LinkedList<String>();
		result.add(name);
		for (AComponent child:children)
			result.addAll(child.collect());
		return result;
	}

	public List<File> search(String name) {
		List<File> result = new LinkedList<File>();
		for (AComponent child:children)
			result.addAll(child.search(name));
		return result;
	}

	public List<String> getList(){
		Class<Directory> obj = Directory.class;
		Annotation annotation = obj.getAnnotation(BlackList.class);
		BlackList copy = (BlackList) annotation;
		return Arrays.asList(copy.names());
	}

	public List<File> query(Predicate<File> filter) {
		List<File> result = new LinkedList<File>();
		if (black.contains(name))
			return result;
		for (AComponent child:children)
			result.addAll(child.query(filter));
		return result;
	}


	public void setParent(AComponent parent) {
		this.parent = parent;
		
	}
	public String toString(){
		String path="/";
		if (parent!=null)
				path = parent.toString()+ "/";
		return path + name;
	}
	public List<AComponent> toList() {
		List<AComponent> result = new LinkedList<AComponent>();
		result.add(this);
		for (AComponent child:children)
			result.addAll(child.toList());
		return result;
	}


	public int size() {
		int result = 0;
		for (AComponent child:children)
			result = result + child.size();
		return result;
	}

	public Iterator<AComponent> iterator() {
		return this.toList().iterator(); 
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
