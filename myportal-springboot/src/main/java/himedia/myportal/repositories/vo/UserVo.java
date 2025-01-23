package himedia.myportal.repositories.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserVo {
	private Integer no;
	
	@NotEmpty
	@Length(min=2, max=8)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Length(min=4, max=20)
	private String password;
	
	@NotNull
	private String gender;
	private Date joindate;
	
}
