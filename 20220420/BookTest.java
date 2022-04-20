import java.util.Date;

public class BookTest {

	public static void main(String[] args) {
		
//		BookVO 클래스 객체를 기본 생성자로 만든다.
		BookVO bookVO1 = new BookVO();
		System.out.println(bookVO1);
		
		BookVO bookVO2 = new BookVO("자바", "홍길동", "더조은", new Date(), 32500);
		System.out.println(bookVO2);
		
		bookVO2.setName("임꺽정");
		System.out.println(bookVO2.getName());
		
	}
	
}
