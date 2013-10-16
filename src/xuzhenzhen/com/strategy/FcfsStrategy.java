package xuzhenzhen.com.strategy;

import java.util.ArrayList;

import xuzhenzhen.com.model.CounterEntity;
import xuzhenzhen.com.model.StrategyEntity;

public class FcfsStrategy implements ServiceStrategy{
	private ArrayList<StrategyEntity> list;
	public FcfsStrategy(ArrayList<StrategyEntity> list){
		this.list=list;
	}
	@Override
	public void service(int counterNum){
		if(counterNum<1)return;
		CounterEntity counter=new CounterEntity(counterNum);
		if(list.size()>0){
			SortList sortList=new SortList(list);
			sortList.sortByComeT();
			for(int i=0;i<list.size();i++){
				StrategyEntity temp=list.get(i);
				int index=counter.getMinIndex();
				float startT=Math.max(counter.get(index), temp.getComeT());
				temp.setServiceID(index);
				temp.setStartT(startT);
				temp.computeTimes();
				counter.set(index, temp.getEndT());
			}
		}
	}
}
