package fle.toolBox;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamListFilter {
	
	
	public static <O extends Object>  List<O> getPredicateFilteredList(List<O> list,Predicate<O> predicate){
		List<O> filteredList = list.stream().filter(predicate).collect(Collectors.toList());
		return filteredList;
	}

}
