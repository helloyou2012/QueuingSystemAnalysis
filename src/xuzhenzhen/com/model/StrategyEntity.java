package xuzhenzhen.com.model;

public class StrategyEntity {
	private String id;//顾客标号
	private int serviceID=0;//服务台标号
	private float comeT;//到达时间
	private float serviceT;//服务时间
	private float startT=0;//开始时间
	private float endT=0;//结束时间
	private float waitT=0;//等待时间
	private float wholeT=0;//逗留时间
	private float wholeWT=0;//带权逗留时间
	public StrategyEntity(String id, float comeT, float serviceT) {
		this.id = id;
		this.comeT = comeT;
		this.serviceT = serviceT;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public float getComeT() {
		return comeT;
	}
	public void setComeT(float comeT) {
		this.comeT = comeT;
	}
	public float getServiceT() {
		return serviceT;
	}
	public void setServiceT(float serviceT) {
		this.serviceT = serviceT;
	}
	public float getStartT() {
		return startT;
	}
	public void setStartT(float startT) {
		this.startT = startT;
	}
	public float getEndT() {
		return endT;
	}
	public void setEndT(float endT) {
		this.endT = endT;
	}
	public float getWaitT() {
		return waitT;
	}
	public void setWaitT(float waitT) {
		this.waitT = waitT;
	}
	public float getWholeT() {
		return wholeT;
	}
	public void setWholeT(float wholeT) {
		this.wholeT = wholeT;
	}
	public float getWholeWT() {
		return wholeWT;
	}
	public void setWholeWT(float wholeWT) {
		this.wholeWT = wholeWT;
	}
	public void computeTimes(){
		this.endT=startT+serviceT;
		this.waitT=startT-comeT;
		this.wholeT=endT-comeT;
		this.wholeWT=wholeT/serviceT;
	}
}
