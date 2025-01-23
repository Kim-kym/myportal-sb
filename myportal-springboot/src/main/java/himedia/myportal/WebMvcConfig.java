package himedia.myportal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import himedia.myportal.interceptors.AuthInterceptor;
import himedia.myportal.interceptors.LogoutInterceptor;

//	WebMvcConfig 설정 클래스 
@Configuration	
public class WebMvcConfig implements WebMvcConfigurer {
	
	//	인터셉터 설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogoutInterceptor())
			.addPathPatterns("/users/logout");
		
		//		AuthInterceptor
		//	/board/ 하위 모든 URL은 막아두고(인증 걸어두고)
		//	목록만 인증을 거치지 않는다.
		registry.addInterceptor(new AuthInterceptor())
			.addPathPatterns("/board/**")	//	board 하위 경로에 인터셉터 적용 
			.excludePathPatterns("/board", 
					"/board/",
					"/board/list");
	}
	
	//	정적 자원 매핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload-images/**")
			.addResourceLocations("file:/c:/uploadd/");
	}
	
}
