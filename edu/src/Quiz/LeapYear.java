package Quiz;

public class LeapYear {

 public static void main(String[] args)
 {
     int year = 2023;
     int lst[] = new int [100];
     int count = 0;
     while (count <100){
         if(year % 4 == 0){
             if(year % 100 != 0){
                 lst[count] = year;
                 count++;
             }
             else if(year % 100 == 0 && year % 400 == 0){
                 lst[count] = year;
                 count++;
             }
         }
         year++;
     }
     for (int i : lst){
         System.out.print(i + "\t");
     }
 }
}