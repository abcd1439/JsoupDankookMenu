import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Calendar;

public class JsoupDankook {
	private static final String address = "http://www.dankook.ac.kr/web/kor/-56";
	private static int i;
	
	public static void main(String[] args) throws Exception {
		String today = findToday();
		kyosikPrint(today);	System.out.println();
		haksikPrint(today);	System.out.println();
		kisikPrint(today);	System.out.println();
		System.out.print("\n종료하려면 아무키나 누르세요...");
		System.in.read();
	}
	//오늘의 날짜 찾기
	private static String findToday(){
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1, date = cal.get(Calendar.DATE);
		return month+"월 "+date+"일";
	}
	//각 식당마다 오늘 메뉴 부분만 뽑아서 Elements 타입으로 리턴
	private static Elements jsoupConnect(String address) throws Exception {
		String tag = "tr";
		Document doc = Jsoup.connect(address).get();
		return doc.select(tag);
	}
	
	private static void kyosikPrint(String today) throws Exception {
		System.out.println("## 교직원 식당 메뉴 ##\n");
		String tmp; i = 0;
		
		Elements menu = jsoupConnect(address+0);
		
		for(Element res:menu){
			System.out.println(res.text());
		}
	}
	private static void haksikPrint(String today) throws Exception {
		System.out.println("## 학생 식당 메뉴 ##\n");
		String tmp; i = 0;
		
		Elements menu = jsoupConnect(address+1);
		
		for(Element res:menu){
			System.out.println(res.text());
		}
	}
	private static void kisikPrint(String today) throws Exception {
		System.out.println("## 단우홀 기숙사 식당 메뉴 ##\n");
		String tmp; i = 0;
		
		Elements menu = jsoupConnect(address+2);
		
		for(Element res:menu){
			System.out.println(res.text());
		}
	}
}