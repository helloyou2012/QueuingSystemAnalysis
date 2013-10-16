package xuzhenzhen.com.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import xuzhenzhen.com.model.CustomEntity;
import xuzhenzhen.com.model.StrategyEntity;
import xuzhenzhen.com.strategy.FcfsStrategy;
import xuzhenzhen.com.strategy.FpfStrategy;
import xuzhenzhen.com.strategy.ServiceStrategy;
import xuzhenzhen.com.strategy.SjfStrategy;

public class StrategyTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 608625437462273363L;
	private ArrayList<StrategyEntity> list;
	private String[] columnNames={"顾客","服务台","到达时间",
			                      "服务时间","开始时间","结束时间",
			                      "等待时间","逗留时间","带权逗留时间"};
	public StrategyTableModel(ArrayList<CustomEntity> cus){
		list=new ArrayList<StrategyEntity>();
		for(CustomEntity c:cus){
			String id=c.getId();
			float comeT=c.getComeTime();
			float serviceT=c.getServiceTime();
			StrategyEntity entity=new StrategyEntity(id, comeT, serviceT);
			list.add(entity);
		}
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
		return false;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		StrategyEntity strat=list.get(row);
		if(col==0)return strat.getId();
		if(col==1)return strat.getServiceID();
		if(col==2)return strat.getComeT();
		if(col==3)return strat.getServiceT();
		if(col==4)return strat.getStartT();
		if(col==5)return strat.getEndT();
		if(col==6)return strat.getWaitT();
		if(col==7)return strat.getWholeT();
		if(col==8)return strat.getWholeWT();
		return null;
	}
	public void doService(int counterNum,int strategyKey){
		ServiceStrategy strategy=null;		
		switch (strategyKey) {
		case 1:strategy=new FcfsStrategy(list);	break;
		case 2:strategy=new SjfStrategy(list);	break;
		case 3:strategy=new FpfStrategy(list);	break;
		}
		if(strategy!=null)strategy.service(counterNum);
	}
}
