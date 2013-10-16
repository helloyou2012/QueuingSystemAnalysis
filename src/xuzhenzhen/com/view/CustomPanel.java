package xuzhenzhen.com.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import xuzhenzhen.com.control.CustomListener;
import xuzhenzhen.com.model.CustomEntity;
import xuzhenzhen.com.tablemodel.CustomTableModel;

public class CustomPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8497054290255576000L;
	private CustomTableModel model;
	private JTable table;
	private JScrollPane panel;
	public CustomPanel(){
		table=new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		panel=new JScrollPane(table);
		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
	}
	public CustomPanel(CustomListener l,ArrayList<CustomEntity> list){
		model=new CustomTableModel(l, list);
		table=new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		panel=new JScrollPane(table);
		setLayout(new BorderLayout());
		add(panel,BorderLayout.CENTER);
	}
	public void setTableModel(CustomListener l,ArrayList<CustomEntity> list){
		model=new CustomTableModel(l, list);
		table.setModel(model);
		this.validate();
	}
}
