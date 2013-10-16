package xuzhenzhen.com.strategy;

import java.util.ArrayList;

import xuzhenzhen.com.model.StrategyEntity;

public class QueueList {
	private ArrayList<StrategyEntity> list;
	public QueueList(){
		list=new ArrayList<StrategyEntity>();
	}
	public int size(){
		return list.size();
	}
	public void add(StrategyEntity entity){
		list.add(entity);
	}
	public StrategyEntity popMin(){
		int size=list.size();
		if(size>0){
			int index=0;
			float MinT=list.get(0).getServiceT();
			for(int i=1;i<size;i++){
				if(MinT>list.get(i).getServiceT()){
					MinT=list.get(i).getServiceT();
					index=i;
				}
			}
			return list.remove(index);
		}
		return null;
	}
	public StrategyEntity popFpfMax(float now){
		int size=list.size();
		if(size>0){
			int index=0;
			float max=getFpfWeight(now, list.get(0));
			for(int i=1;i<size;i++){
				float weight=getFpfWeight(now, list.get(i));
				if(max<weight){
					max=weight;
					index=i;
				}
			}
			return list.remove(index);
		}
		return null;
	}
	public float getFpfWeight(float now,StrategyEntity entity){
		return 1+(now-entity.getComeT())/entity.getServiceT();
	}
}
