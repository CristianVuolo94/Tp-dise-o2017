package modelo.method.criteria;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class MixedCriterion extends Criterion
{
	private OrderCriterion orderCriterion;
	private FilterCriterion filterCriterion;
	
	public MixedCriterion(OrderCriterion orderCriterion, FilterCriterion filterCriterion, String description) {
		super(description);
		this.orderCriterion = orderCriterion;
		this.filterCriterion = filterCriterion;
	}
	
	public OrderCriterion getOrderCriterion() {
		return orderCriterion;
	}

	public FilterCriterion getFilterCriterion() {
		return filterCriterion;
	}
}
