package viewModel.method.criteria.filter;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.FilterCriterion;
import viewModel.method.criteria.IndicatorRelatedCriterionVM;

@Observable
public abstract class FilterCriterionVM extends IndicatorRelatedCriterionVM<FilterCriterion>
{
	protected int years;
	
	public int getYears()
	{
		return years;
	}

	public void setYears(int years) 
	{
		this.years = years;
	}
}
