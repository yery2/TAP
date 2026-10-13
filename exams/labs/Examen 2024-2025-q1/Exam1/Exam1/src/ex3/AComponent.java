package ex3;

import java.util.List;
import java.util.function.Predicate;

public interface AComponent {
	public void ls();
	public List<String> collect();
	public List<AComponent> toList();
	public List<File> search(String name);
	public List<File> query(Predicate<File> filter);
	public int size();
	public void setParent(AComponent parent);
	public String getName();
}
