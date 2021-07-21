package fyjz.com.retailers.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class HandlerException {
	@ExceptionHandler
	@ResponseBody
	public JsonResult<Object> handler(Exception e){
		return new  JsonResult<Object>(e);
	}
}
