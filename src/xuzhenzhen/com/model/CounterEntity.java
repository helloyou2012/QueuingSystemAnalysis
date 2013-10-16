package xuzhenzhen.com.model;

public class CounterEntity {
	private float[] counter;
	public CounterEntity(int num){
		counter=new float[num];
		for(int i=0;i<num;i++)counter[i]=0;
	}
	public int getMinIndex(){
		float min=counter[0];
		int index=0;
		for(int i=1;i<counter.length;i++)
			if(counter[i]<min){
				min=counter[i];
				index=i;
			}
		return index;
	}
	public float getMin(){
		float min=counter[0];
		for(int i=1;i<counter.length;i++)
			if(counter[i]<min)
				min=counter[i];
		return min;
	}
	public float get(int i){
		return counter[i];
	}
	public void set(int i,float value){
		counter[i]=value;
	}
}