package vista.indicator;

import org.uqbar.arena.layout.VerticalLayout;

import java.io.IOException;
import java.util.Optional;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import exceptions.DeleteUsedIndicatorException;
import exceptions.MissingFileException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import modelo.indicator.Indicator;
import viewModel.indicator.IndicatorsVM;
import vista.ErrorWindow;
import vista.ExportWindow;

@SuppressWarnings("serial")
public class IndicatorsWindow extends SimpleWindow<IndicatorsVM> 
{
	public IndicatorsWindow(WindowOwner owner)
	{
		super(owner, new IndicatorsVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Indicadores");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(4));
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("indicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
				
		Column<Indicator> columnName = new Column<Indicator>(indicatorTable);
		columnName.setTitle("Indicador").setFixedSize(100).bindContentsToProperty("name");
		
		Column<Indicator> columnFormula = new Column<Indicator>(indicatorTable);
		columnFormula.setTitle("Formula").setFixedSize(500).bindContentsToProperty("formula");
		
		new Button(panel2).setCaption("Nuevo").onClick(()->{ 
			Optional<Indicator> newIndicator = new EditIndicatorWindow(this, Optional.empty()).openWithReturn();
			this.getModelObject().addNewIndicator(newIndicator);
		});
		
		new Button(panel2).setCaption("Editar").onClick(()->{ 
			if(this.getModelObject().getSelectedIndicator() != null)
			{
				Optional<Indicator> targetIndicator = new EditIndicatorWindow(this, Optional.of(this.getModelObject().getSelectedIndicator())).openWithReturn();
				this.getModelObject().updateIndicator(targetIndicator);	
			}
		});
		
		new Button(panel2).setCaption("Borrar").onClick(()->{
			try
			{
				this.getModelObject().deleteIndicator();
			}
			catch(DeleteUsedIndicatorException exception)
			{
				ErrorWindow.show(this, exception.getMessage());
			}
			});
		
		new Button(panel2).setCaption("Cargar archivo").onClick(()->{ 
			new LoadIndicatorsWindow(this).open(); 
			this.getModelObject().refreshList();	
		});
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close);
	}
	
	protected void showMessageBox(String message, MessageBox.Type messageType)
	{
		MessageBox msgBox = new MessageBox(this, messageType);
		msgBox.setMessage(message);
		msgBox.open();
	}
	
	@SuppressWarnings("unused")
	private void verifyChangesAndSave()
	{
		//Verifico si se hicieron cambios
		if(this.getModelObject().verifyIfSomethingChanged())
		{
			//Si se hicieron cambios, muestro un dialogo preguntando si se quieren guardar esos cambios
			//Luego guardo los cambios o salgo de la ventana, dependiendo de la eleccion del usuario
	
			ExportWindow window = new ExportWindow(this);			
			window.onAccept(()->applySave());
			window.open();
		}		
		
		this.close();
		
	}
	
	private void applySave()
	{
		try
		{				
			this.getModelObject().exportToFile();
		}
		catch(BiffException e)	//es la excepcion que tira al invocar el metodo, que a su vez contiene la excepcion que tira el metodo
		{	
			ErrorWindow.show(this, "El archivo no existe o no es un archivo '.xls'  ");
			e.printStackTrace();
		}
		catch(WriteException e)
		{
			ErrorWindow.show(this, "No se a podido modificar el archivo");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			ErrorWindow.show(this, "El archivo que se intenta abrir no existe");
			e.printStackTrace();
		}
		catch(MissingFileException e)	
		{	
			ErrorWindow.show(this, e.getMessage());
		//	e.printStackTrace();
		}

	}
}

