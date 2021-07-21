package fyjz.com.retailers.commons;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	private T date;//��������
	private String message;//������Ϣ����ȷ/����
	private  int state;
	private static final int ERROR=0;//����״̬
	private static final int SUCCESS=1;//��ȷ״̬
	
	//��ȡ������Ϣ
	public JsonResult(T date) {
		
		this.date=date;
		this.state=SUCCESS;
		this.message="ok";
	}
	
	//��ȡ�쳣��Ϣ
	public JsonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}

	public JsonResult() {
		this.state=SUCCESS;
		this.message="ok";
		
	}

	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}

	public T getDate() {
		return date;
	}
	
	public void setDate(T date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "JsonResult [date=" + date + ", message=" + message + ", state=" + state + "]";
	}

}
