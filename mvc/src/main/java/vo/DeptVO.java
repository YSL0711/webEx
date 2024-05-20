package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Value Object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.getDeptno() + " : " + this.getDname() + " : " + this.getLoc();
//	}
	
}
