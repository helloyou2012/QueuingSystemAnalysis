package xuzhenzhen.com.strategy;

import java.util.ArrayList;

import xuzhenzhen.com.model.StrategyEntity;

public class SortList {
	private ArrayList<StrategyEntity> list;
	public SortList(ArrayList<StrategyEntity> list) {
		this.list = list;
	}
	public void sortByComeT(){
		int size=list.size();
		boolean isChange;
		for(int i=0;i<size-1;i++){
			isChange=false;
			for(int j=size-1;j>=i+1;j--){
				if(compareEntity(j-1, j)){
					swapEntity(j, j-1);
					isChange=true;
				}
				if(!isChange)return;
			}
		}
	}
	public boolean compareEntity(int i,int j){
		float temp1=list.get(i).getComeT();
		float temp2=list.get(j).getComeT();
		return temp1>temp2;
	}
	public void swapEntity(int i,int j){
		StrategyEntity temp=list.set(i,list.get(j));
		list.set(j, temp);
	}
}
