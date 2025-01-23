package himedia.myportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//	Global Exception Handler
@ControllerAdvice
public class ApplicationExceptionHandler {
	//	전역적으로 RuntimeException이 발생하면 500 Internal Server Error로 응답하는 예제 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public String handleRunTimeException(RuntimeException e, Model model) {
		//	1. 로그 처리
		System.err.println("=====================");
		System.err.println("ControllerAdvice에 의한 Error Handling");
		e.printStackTrace();
		
		//	2. 오류 화면 처리 
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
