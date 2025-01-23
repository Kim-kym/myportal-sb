package himedia.myportal.repositories.vo;

import java.util.Date;

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
public class GuestbookVo {
	private Integer no;
	private String name;
	private String password;
	private String content;
	private Date regdate;
	
	
}
