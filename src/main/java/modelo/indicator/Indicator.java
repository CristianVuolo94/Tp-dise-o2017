package modelo.indicator;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.uqbar.commons.utils.Observable;
import exceptions.EmptyFieldException;
import modelo.ModelEntity;
import modelo.enterprise.Enterprise;
import modelo.indicator.math.Operable;
import modelo.indicator.parser.IndicatorParser;

@Entity
@Observable
@Table(name = "Indicators")
public class Indicator extends ModelEntity implements Operable
{
	
	@Column(nullable = false)
	private String name;
	private String formula;
	
	@Transient
	private Operable value;

	public Indicator(String name, String formula){
		if(name == null) throw new EmptyFieldException("Nombre");
		if(formula == null) throw new EmptyFieldException("Formula");
		this.name = name;
		this.formula = formula;
		this.value = IndicatorParser.parseIndicator(formula);
	}
	
	public Indicator(String name, String formula, Long id){
		this(name, formula);
		this.id = id;
	}
	
	protected Indicator(){}
	
	public String getName() 
	{
		return name;
	}

	public String getFormula() {
		return formula;
	}
	
	@PostLoad
	protected void postLoad(){
		value = IndicatorParser.parseIndicator(formula);
	}

	public BigDecimal reduce(Enterprise enterprise, int year){
		return value.reduce(enterprise, year);
	}
	
	public boolean tryReduce(Enterprise enterprise, int year)
	{
		try
		{
			reduce(enterprise, year);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	public String normalize(){
		return value.toString();
	}
	
	@Override
	public String toString(){
		return "@" + name;
	}
	
	public Boolean uses(Indicator indicator){
		return value.includes(indicator);
	}
	
	public Boolean includes(Indicator indicator){
		return this == indicator || value.includes(indicator);
	}

}
