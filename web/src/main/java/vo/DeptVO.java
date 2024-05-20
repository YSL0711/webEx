package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Value Object : VO


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
