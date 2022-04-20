
class ClassA {
	
	int a = 10;
	
	int funcAdd(int x, int y) {
		return x + y + a;
	}
	
}

//	java 파일 이름과 같은 이름의 클래스에만 public을 붙일 수 있다.
public class Test {

	public static void main(String[] args) {
		
		int x = 3, y = 6, r;
		
		ClassA cal = new ClassA();
		
		r = cal.funcAdd(x, y);
		System.out.println(r);
		
	}
	
}
