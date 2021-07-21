package fyjz.com.retailers.commons;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	private T date;//正常数据
	private String message;//返回信息（正确/错误）
	private  int state;
	private static final int ERROR=0;//错误状态
	private static final int SUCCESS=1;//正确状态
	
	//获取正常信息
	public JsonResult(T date) {
		
		this.date=date;
		this.state=SUCCESS;
		this.message="ok";
	}
	
	//获取异常信息
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
