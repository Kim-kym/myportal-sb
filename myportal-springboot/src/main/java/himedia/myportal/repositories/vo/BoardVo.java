package himedia.myportal.repositories.vo;

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
public class BoardVo {
	private Integer no;
	private String title;
	private String content;
	private Integer hit;
	private String regDate;
	private Integer userNo;
	private String userName;
	
}
