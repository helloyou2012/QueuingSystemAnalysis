package xuzhenzhen.com.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import xuzhenzhen.com.control.CustomListener;
import xuzhenzhen.com.factory.EntityFactory;
import xuzhenzhen.com.model.CustomEntity;

public class MainTabbedPane extends JTabbedPane implements CustomListener,ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6749334923783628548L;
	private ArrayList<CustomEntity> list;
	private int serviceCount=1;
	private CustomPanel customPane;
	private ResultPanel fcfsPane;
	private ResultPanel sjfPane;
	private ResultPanel fpfPane;
	private boolean isChange=false;
	public MainTabbedPane(){
		init();
	}
	public void init(){
		customPane=new CustomPanel();
		fcfsPane=new ResultPanel();
		sjfPane=new ResultPanel();
		fpfPane=new ResultPanel();
		add("顾客到达表", customPane);
		add("FCFS表",fcfsPane);
		add("SJF表",sjfPane);
		add("FPF表",fpfPane);
		addChangeListener(this);
	}
	public void loadFromFile(){
		EntityFactory factory=new EntityFactory();
		if(factory!=null){
			list=factory.getEntity();
			if(list!=null)customPane.setTableModel(this, list);
			else{
				JOptionPane.showMessageDialog(null, "文件格式错误！", "警告", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void operateFcfs(){
		if(list!=null){
			if(!isChange)fcfsPane.oprateService(list, serviceCount,1);
			setSelectedIndex(1);
		}
	}
	public void operateSjf(){
		if(list!=null){
			if(!isChange)sjfPane.oprateService(list, serviceCount,2);
			setSelectedIndex(2);
		}
	}
	public void operateFpf(){
		if(list!=null){
			if(!isChange)fpfPane.oprateService(list, serviceCount,3);
			setSelectedIndex(3);
		}
	}
	public int getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}
	@Override
	public void customDataChanged() {
		// TODO Auto-generated method stub
		this.isChange=true;
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(isChange&&list!=null){
			int index=this.getSelectedIndex();
			if(index>0){
				int result=JOptionPane.showConfirmDialog(null, "列表已更新，是否重新运行算法？", "提示",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(result==JOptionPane.YES_OPTION){
					isChange=false;
					fcfsPane.oprateService(list, serviceCount,1);
					sjfPane.oprateService(list, serviceCount,2);
					fpfPane.oprateService(list, serviceCount,3);
				}
			}
		}
	}
}
