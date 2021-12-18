import java.util.*;
import java.io.*;
public class f{
    public static void main(String[] args) {
        try{
            PrintWriter output=new PrintWriter("temp.txt");
            output.write("JAVA\n");
            output.write("C++");
         
            output.close();
            Scanner input=new Scanner (new File("temp.txt"));
            while(input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();


        }catch(Exception e){
            System.out.println("Exception Caught");
            System.out.println(e.toString());   
            
        }
    }
}