package xuzhenzhen.com.tablemodel;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import xuzhenzhen.com.control.CustomListener;
import xuzhenzhen.com.model.CustomEntity;

public class CustomTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4555501192206006691L;
	private CustomListener listener;
	private ArrayList<CustomEntity> customs;
	private String[] columnNames={"顾客标号","到达时间","服务时间"};
	public CustomTableModel(CustomListener l,ArrayList<CustomEntity> cus){
		super();
		this.listener=l;
		this.customs=cus;
	}
	public void add(CustomEntity cus){
		customs.add(cus);
		listener.customDataChanged();
	}
	public ArrayList<CustomEntity> getCustoms() {
		return customs;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0)return false;
		return true;
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		try {
			float value=Float.parseFloat(aValue.toString());
			CustomEntity cus=customs.get(rowIndex);
			if(columnIndex==1)cus.setComeTime(value);
			if(columnIndex==2)cus.setServiceTime(value);
			listener.customDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据输入错误！", "警告",JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return customs.size();
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		CustomEntity cus=customs.get(row);
		if(col==0)return cus.getId();
		if(col==1)return cus.getComeTime();
		if(col==2)return cus.getServiceTime();
		return null;
	}
}
