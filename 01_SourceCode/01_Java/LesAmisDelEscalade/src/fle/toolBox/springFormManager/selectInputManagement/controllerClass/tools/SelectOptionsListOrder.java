package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.MessageSource;

public class SelectOptionsListOrder {

	public <S extends SelectOptionsInterface> List<S> byValue(List<S> toOrder) {
		Collections.sort(toOrder, valueComparator());
		return toOrder;
	}

	public <S extends SelectOptionsInterface> List<S> byDisplayValue(List<S> toOrder) {
		Collections.sort(toOrder, displayValueComparator());
		return toOrder;
	}

	public <S extends SelectOptionsInterface> List<S> byDisplayValueI18N(List<S> toOrder, MessageSource messageSource,String suffix) {
		Collections.sort(toOrder, displayValueI18NComparator(messageSource,suffix));
		return toOrder;
	}

	private <S extends SelectOptionsInterface> Comparator<S> valueComparator() {
		Comparator<S> comparator = ((S a, S b) -> a.getValue().compareTo(b.getValue()));
		return comparator;
	}

	private <S extends SelectOptionsInterface> Comparator<S> displayValueComparator() {
		Comparator<S> comparator = ((S a, S b) -> a.getDisplayValue().compareTo(b.getDisplayValue()));
		return comparator;
	}

	private <S extends SelectOptionsInterface> Comparator<S> displayValueI18NComparator(MessageSource messageSource,String suffix) {
		Comparator<S> comparator = ((S a, S b) -> a.getDisplayValueI18N(messageSource,suffix)
				.compareTo(b.getDisplayValueI18N(messageSource,suffix)));
		return comparator;
	}

}
