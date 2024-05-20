package dao;

public class TestMain2 {

	public static void main(String[] args) {
		
		int cnt = 0;
		for(int i = 1; i<=4; i++) {
			for(int j = 1; j<=5 ; j++) {
				cnt ++;
				if(cnt == 10) break;
				//break는 가장 가까운 안쪽을 탈출한다.
				//lable을 달아야 바깥쪽을 탈출할 수 있음.
				//숫자 옆, 스크롤바같은걸 더블클릭 : 브레이크포인트 설정
				//브레이크포인트 : 디버그 모드로 보기. 로직이 뭐가 잘못됐는지 알 수 있다. 
				System.out.println("i = " + i + "j = " + j);
			}
		}
	}
}
