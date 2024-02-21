package Assignment;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
abstract class InterfaceStudents {
	public abstract void showObject();
}
class Student extends InterfaceStudents {
 static int countStudents;//객체수
 int sid;//학번
 String sname; //학생 이름
 String city; //주소 도시

 public Student() {
	 sid = 0; sname = null; city = null;
	 countStudents++;
 }
 
 public Student(int sid) {
	 this();
	 this.sid = sid;
 }
 
 public Student(int sid, String sname, String city) {
	 
	 this.sid = sid;
	 sname = null; city = null;
	 countStudents++;
 }
 
 
 public String toString() {
	 return "sid="+sid + ", sname=" + sname + ", city=" + city;
 }
 public void showObject() {
	 System.out.println("["+sid +", " + sname + ", " + city+"]");
 }
 static void showNumberObjects() {//생성된 객체수를 출력한다.
	 System.out.println(" 생성객체수=" + countStudents);
 }
}
class WorkStudent extends Student {
	
	String eno;
	String company;
	
	public WorkStudent() {
		
	}
	
	
	public WorkStudent(int sid, String sname, String city, String eno, String company){
		super(sid, sname, city);
		this.eno = eno;
		this.company = company;
	}
	
	public WorkStudent(int sid, String sname, String city){
		this.sid = sid;
		this.sname = sname;
		this.city = city;
	}
	
	public String toString() {
		 return("학번 : " + sid + "\n이름 : " + sname + "\n도시 : " + city); 
	}
	public void showObject() {
		 //Student 출력 코드 추가
		System.out.println("["+eno +", " + company + "]");
	}
}
class CodingWorkStudent extends WorkStudent {
	String language;

	
	
	public CodingWorkStudent(String lang) {
		//super(sid, name, city, eno, compnay);
		this.language = lang;
	}
	
	 public String toString() {
		 return ("학번 : " + sid + "\n이름 : " + sname + "\n도시 : " + city + "\neno : " + eno + "\ncompany : " + company + "\n언어 : " + language ); 
	 }
	 public void showObject() {
		 //WorkStudent 출력 코드 추가 
		 System.out.println("["+language+"]");
	 }
}
 // 생성자 구현한다.
public class Test_Ch08 {
	 static void showObjects(InterfaceStudents is) {
		 is.showObject();
	 }
	 public static void main(String[] args) {
	 Student arry[] = new Student[5];
//	 showNumberObjects();
	 arry[0] = new Student(); // default 생성자
	 arry[1] = new Student(202301); //
	 arry[2] = new WorkStudent(202302, "오정임", "부산", "ENO", "PNU");
	 arry[3] = new CodingWorkStudent("English");
	 arry[4] = new WorkStudent(202303, "오정일", "부산");
//	 showNumberObjects();
	 for (Student s : arry) {
		 System.out.println(s.toString());
	 }
	 for (Student sx : arry) {
		 showObjects(sx);
	 }
 }

}
