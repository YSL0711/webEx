package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //모든 아규먼트가 있는 생성자를 추가해줘
@NoArgsConstructor

public class MemberVO {

	private int no;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String motive;
	
	
}
