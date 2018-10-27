import java.util.Collection;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Analyzer<T extends Comparable<T>>{
	
	private T[] list;
	//private List<T> list = null;
	
	public Analyzer(T[] args){
		list = args;
	}
	
	public T getHighest() {
		Collection<T> c = Arrays.asList(list);
		Stream<T> stream = c.stream();
		Optional<T> highest = stream.max((x, y) -> x.compareTo(y));
		return highest.get();
	}
	
	public T getLowest() {
		Collection<T> c = Arrays.asList(list);
		Stream<T> stream = c.stream();
		Optional<T> lowest = stream.min((x, y) -> x.compareTo(y));
		return lowest.get();
	}
	
	public double getTotal() {
		Double[] doubleList = new Double[list.length];
		for(int i = 0; i < doubleList.length; i++) {
			doubleList[i] = Double.valueOf(list[i].toString()); //this line may be the dumbest thing I've ever written.
		}
		
		Collection<Double> c = Arrays.asList(doubleList);
		Map<Double, Double> m = (Map<Double, Double>) c.stream().collect(Collectors.toMap(Function.identity(), s->s));
		return m.values().stream().mapToDouble(Number::doubleValue).sum();
		
		
		
	}
	
	public double getAverage() {
		return (Double)this.getTotal() / list.length;
	}