package day02;

import java.util.Arrays;

public class Lotto {
	int[] rnd;
	int[] m;

	public Lotto() {
		rnd = new int[45];
		m = new int[6];
		init(); // 초기화
		shuffle(); // 1000번 섞기
		set(); // 6개의 값 배열에 담기
		sort(); // 정렬

	}

	public int[] getRnd() {
		return rnd;
	}

	public void setRnd(int[] rnd) {
		this.rnd = rnd;
	}

	public int[] getM() {
		return m;
	}

	public void setM(int[] m) {
		this.m = m;
	}

	private void init() {
		for (int i = 0; i < rnd.length; i++) {
			rnd[i] = i + 1;
		}
	}

	private void shuffle() {
		for(int i =0; i<1000; i++) {
			
		
			int a = (int) (Math.random() * 45);
			int b = (int) (Math.random() * 45);
	
	//		System.out.println("rnd["+ a + "] : " + rnd[a]);
	//		System.out.println("rnd["+ b + "] : " + rnd[b]);
	
			int temp = 0;
			temp = rnd[a];
			rnd[a] = rnd[b];
			rnd[b] = temp;
	
	//		System.out.println("rnd["+ a + "] : " + rnd[a]);
	//		System.out.println("rnd["+ b + "] : " + rnd[b]);
		}
		System.out.println(Arrays.toString(rnd));
	}

	private void set() {
		for(int i=0; i<6; i++) {
			m[i] = rnd[i];
		}
	}

	private void sort() {
		Arrays.sort(m);
	}

	public void print() {
		for(int i= 0; i<m.length; i++) {
			System.out.print(m[i]+"\t");
		}
	}
}
