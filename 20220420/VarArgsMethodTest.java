
public class VarArgsMethodTest {

	public static void main(String[] args) {
		
//		같은(비슷한) 기능을 실행하는 메소드의 인수가 서로 다를 경우 많은 수의 메소드 오버로딩이 필요하다.
		System.out.println("sum(1, 2) = " + sum(1, 2));
		System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
		System.out.println("sum(1, 2, 3, 4) = " + sum(1, 2, 3, 4));
		System.out.println("====================================");
		
//		메소드의 인수를 배열로 구현하면 많은 수의 오버로딩이 필요 없지만 인수를 배열로 선언하고 선언한 배열에
//		초기치를 지정해서 호출되는 메소드로 전달해야 하는 번거로움이 있다.
		System.out.println("sum(1, 2) = " + sum(new int[] {1, 2}));
		System.out.println("sum(1, 2, 3) = " + sum(new int[] {1, 2, 3}));
		System.out.println("sum(1, 2, 3, 4) = " + sum(new int[] {1, 2, 3, 4}));
		System.out.println("====================================");
		
//		위 2가지 방법의 단점을 해결하는 가장 좋은 방법이 가변 인수를 만들어 사용하는 방법이다.
		System.out.println("total(1, 2, 3, 4) = " + total(1, 2, 3, 4));
		System.out.println("total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) = " + total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
	}

//	가변 인수를 사용하는 메소드 => 가변 인수는 자료형 뒤에 "..."을 쓰고 배열 이름을 입력하면 된다.
//	가변 인수는 인수 목록의 맨 뒤에 딱 1번만 사용할 수 있다.
	public static int total(int ... data) {
		int sum = 0;
		for (int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
//	인수를 배열로 받으면 많은 수의 오버로딩이 필요없다.
	private static int sum(int[] is) {
		int sum = 0;
		for (int i=0; i<is.length; i++) {
			sum += is[i];
		}
		return sum;
	}
	
//	메소드 오버로딩: 같은 이름을 가지는 메소드가 여러개 나올 수 있다. => 파이썬은 지원하지 않는다.
//	메소드의 이름이 같으면 인수의 개수로 메소드를 식별하고 인수의 개수도 같다면 인수의 데이터 타입으로 메소드를 식별한다.

	private static int sum(int i, int j, int k, int l) {
		return i + j + k + l;
	}

	private static int sum(int i, int j, int k) {
		return i + j + k;
	}

	private static int sum(int i, int j) {
		return i + j;
	}
	
}



