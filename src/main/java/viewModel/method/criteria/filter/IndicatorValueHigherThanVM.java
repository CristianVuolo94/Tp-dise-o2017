package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IndicatorValueHigherThanCriterion;

@Observable
public class IndicatorValueHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorValueHigherThanCriterion(selectedIndicator, value, years));
	}
}