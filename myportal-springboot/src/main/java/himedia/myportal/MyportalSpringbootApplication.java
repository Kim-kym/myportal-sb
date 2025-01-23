package himedia.myportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("himedia.myportal.mappers")
public class MyportalSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyportalSpringbootApplication.class, args);
	}

}
