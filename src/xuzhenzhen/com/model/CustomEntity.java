package xuzhenzhen.com.model;

public class CustomEntity {
	private String id;//顾客标号
	private float comeTime;//顾客到达时间
	private float serviceTime;//顾客服务时间
	
	public CustomEntity(String id, float comeTime, float serviceTime) {
		this.id = id;
		this.comeTime = comeTime;
		this.serviceTime = serviceTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getComeTime() {
		return comeTime;
	}
	public void setComeTime(float comeTime) {
		this.comeTime = comeTime;
	}
	public float getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(float serviceTime) {
		this.serviceTime = serviceTime;
	}
}
