package vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {

	
	int empno;
	String ename;
	String job;
	int mgr;
	Date hiredate;
	int sal;
	int comm;
	int deptno;
	
}
