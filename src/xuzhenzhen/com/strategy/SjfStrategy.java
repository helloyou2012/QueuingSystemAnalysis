package xuzhenzhen.com.strategy;

import java.util.ArrayList;

import xuzhenzhen.com.model.CounterEntity;
import xuzhenzhen.com.model.StrategyEntity;

public class SjfStrategy implements ServiceStrategy{
	private ArrayList<StrategyEntity> list;
	public SjfStrategy(ArrayList<StrategyEntity> list) {
		this.list = list;
	}
	@Override
	public void service(int counterNum) {
		if(counterNum<1)return;
		CounterEntity counter=new CounterEntity(counterNum);
		if(list.size()>0){
			SortList sortList=new SortList(list);
			sortList.sortByComeT();
			QueueList queue=new QueueList();
			float now=list.get(0).getComeT();
			int i=0;
			int index;//服务台标号
			while(i<list.size()||queue.size()>0){
				while(i<list.size()&&now>=list.get(i).getComeT()){//加入到队列中
					queue.add(list.get(i));
					i++;
				}
				if(queue.size()<=0&&i<list.size()){//如果队列为空则添加下一个
					queue.add(list.get(i));
					i++;
				}
				StrategyEntity entity=queue.popMin();
				if(entity!=null){
					index=counter.getMinIndex();
					float startT=Math.max(counter.get(index),entity.getComeT());
					entity.setServiceID(index);
					entity.setStartT(startT);
					entity.computeTimes();
					counter.set(index, entity.getEndT());
				}
				now=counter.getMin();
			}
		}
	}

}
