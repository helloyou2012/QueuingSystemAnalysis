package xuzhenzhen.com.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import xuzhenzhen.com.model.CustomEntity;
import xuzhenzhen.com.tablemodel.StrategyTableModel;

public class ResultPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6825335095647863360L;
	private StrategyTableModel model;
	private JTable table;
	private JScrollPane panel;
	public ResultPanel(){
		table=new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		panel=new JScrollPane(table);
		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
	}
	public void oprateService(ArrayList<CustomEntity> list,int num,int strategyKey){
		model=new StrategyTableModel(list);
		model.doService(num,strategyKey);
		table.setModel(model);
		this.validate();
	}

}
