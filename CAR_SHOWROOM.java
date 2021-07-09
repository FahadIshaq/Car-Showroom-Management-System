/******************ONLINE BUY SELL CAR SHOWROOM**********

 *PROJECT CREATOR: FAHAD ISHAQ 
GROUP MEMBERS: 
MINAHIL FATIMA
FATIMA MEHSOOD 
BILAL SHAKIR
HAMMAD IDREES
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class CAR_SHOWROOM {

	public static void main(String[] args) throws Exception {
		main(); //Calling the main method in the actual main method for the execution of the code. 
	}
	public static void main() throws Exception {  
		Scanner input=new Scanner(System.in); 
		
		System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                WELCOME TO LUXURIOUS CARS SHOWROOM                                          ");
		  System.out.println("------------------------------------------------------------------------------------"); 
		while (true) {
		  System.out.print("Enter Your Panel\n1. ADMIN\n2. COSTUMER\nEnter Your Choice: ");
		String choice=input.nextLine(); 
		if(choice.equals("1")) {
			   while(true) {
				   System.out.print("Enter Your User-Name: ");
				   String username=input.next(); 
				   System.out.print("Enter Your Password: ");
				   String password=input.next();
				   if (admin_login(username,password)==true) {
					  break;
					   
				   }else {
					   System.out.println("INVALID USER-NAME OR PASSWORD"); 
				   }
				   
			   }
			admin_module();
		break;
		}
		else if(choice.equals("2")) {
			while (true) {
			System.out.print("ENTER\n1. TO SIGN-UP\n2. TO LOG-IN\nEnter Your Choice: "); 
			String option=input.nextLine(); 
			if (option.equals("1")) {
				costumer_signup();
				
				System.out.print("ENTER\n1. TO LOGIN INTO YOUR ACCOUNT\n2. TO GO TO MAIN MENU\nEnter Your Choice:");
				String oppt=input.nextLine();
				if(oppt.equals("1")) {
					while (true) {
						
						System.out.print("Enter Your User-Name: "); 
						String user_name=input.nextLine(); 
						System.out.print("Enter Your Password: ");
						String password=input.nextLine();
						if (costumer_login(user_name,password)==true) {
							costumers(user_name,password);
							break;
						}
						else {
							System.out.println("INVALID USER-NAME OR PASSWORD!\n");
						}
					
				}
				}
				else if(oppt.equals("2")) {
					main();
					break;
				}
				
				
				break;
			}
			else if(option.equals("2")) {
				while (true) {
					
				System.out.print("Enter Your User-Name: "); 
				String user_name=input.nextLine(); 
				System.out.print("Enter Your Password: ");
				String password=input.nextLine();
				if (costumer_login(user_name,password)==true) {
					costumers(user_name,password);
					break;
				}
				else {
					System.out.println("INVALID USER-NAME OR PASSWORD!\n");
				}
				
			}
				break;
			}
			else {
				System.out.println("INVALID INPUT\n"); 
				
			}
		}
			break;
		
		}else {
			System.out.println("INVALID INPUT\n");
		}
		}
	}


	//==========================================================
	//
	//================ADMIN CAR DELETE===========================
	//
	//==========================================================
	public static void delete_car() throws IOException {// delete car by admin module. 
		Scanner input=new Scanner (System.in);   //user input form the the user. 
		
		File file1 = new File("C:\\Cars\\ImportedCars\\CARS.txt");  //specifying the location of the file with the file name. 
        Scanner fes1 = new Scanner(file1);//readoing the file 
        String[] str = new String[100];  //creating a file string of 100 length
        String[] mes = new String[100];   //creating another string of the same length. 
        while (fes1.hasNextLine()) {    //using loop for reading and displaying the data on the console. 
            System.out.println(fes1.nextLine());  //printing the results on the console. 
        }
        Scanner fes11 = new Scanner(file1);//scanning file
        int j = 0;
        while (fes11.hasNextLine()) {
            str[j] = fes11.nextLine();
            j++;
        }
        Scanner ves = new Scanner(file1);
        System.out.println("WHICH CAR DO YOU WANT TO DELETE?");
        String sc = input.nextLine();
        int rev1 = Integer.parseInt(sc);
        String[] str1 = new String[0];
        while(ves.hasNextLine()){
            str1 =ves.nextLine().split(" ");
        }
        String[] mes1 = str1[0].split("\\.");
        int num = Integer.parseInt(mes1[0]);
        if(rev1 > num)
            System.out.println("CAR NOT FOUND!!!\n");
        else{
            for (int i = 0; i < str.length; i++) {
                String[] arr = str[i].split(" ");
                if (arr[0].equals(sc)) {
                    str[i] = " ";
                    break;
                }
            }
            int x = 0;
            for(String e:str){
                if(e != null)
                    mes[x] = e;
                x++;
            }
            for(int i = 0; i<19; i++){
                if(mes[i].equals(" ")){
                    mes[i] = mes[i+1];
                    mes[i+1] = " ";
                }
            }
            String[] proj = new String[0];
            int count = 0;
            for(String k:mes){
                if(k != null)
                    count++;
            }
            int k = 0;
            for(int i = k; i<=count; i++) {
                if(mes[i] != null){
                    proj = mes[i].split(" ");
                    String test = "";
                    for(int l = 1; l<=proj.length-1; l++){
                        test += proj[l] +  " ";
                    }
                    proj[0] = i+1 +"";
                    mes[i] = proj[0] + " " + test;
                }
            }
            FileWriter fileWriter1 = new FileWriter(file1);
            BufferedWriter buffer1 = new BufferedWriter(fileWriter1);
            for(String e:mes){
                if(e !=null){
                    if(!e.equals(" ")){
                        buffer1.write(e);
                        buffer1.newLine();
                    }
                }
            }
            buffer1.close();
            fes1.close();
            fes11.close();
            ves.close();
            System.out.println("CAR RECORD DELETED SUCCESSFULLY!!!");
        }
	}
	//==============================================================================================
	//
	//================================ADMIN DATA=====================================================
	//
	//===============================================================================================
	
public static void admin_module() throws Exception {
		
		Scanner input=new Scanner(System.in);
		System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                WELCOME TO ADMIN MODULE                                          ");
		  System.out.println("------------------------------------------------------------------------------------"); 
	    while (true) {
	     System.out.print("\nENTER\n1. TO VIEW PROFILE\n2. TO VIEW COSTUMERS\n3. TO ADD A COSTUMER\n4. TO ADD A CAR\n5. TO DELETE A CAR\n6. TO VIEW CARS\n7. TO VIEW REVIEWS\n8. TO DELETE REVIEWS\n0. TO LOG-OUT\nEnter Your Option: ");
	     String option=input.nextLine();
	     if  (option.equals("1")) {
	    	 System.out.println("------------------------------------------------------------------------------------");
			  System.out.println("                                LUXURIOUS CARS                                          ");
			  System.out.println("------------------------------------------------------------------------------------\n"); 
	    	   for (int i=0; i<countLine("C:\\FileHandling\\AdminData.txt"); i++) {
	    		   System.out.println("\t\t\t"+Files.readAllLines(Paths.get("C:\\FileHandling\\AdminData.txt")).get(i)+"\n");
	    	   }
	    		System.out.print("\nDo you want to Edit Profile Details(Y/N)?"); 
	    		while (true){
	    			String op=input.nextLine();
	    			if (op.equalsIgnoreCase("Y")) {
	    				ADMIN_EDIT();
	    				break;
	    			}
	    			else if (op.equalsIgnoreCase("N")) {
	    				break;
	    			}else {
	    				System.out.println("INVALID INPUT!\nPLEASE ENTER A VALID CHOICE!\n"); 
	    				
	    			}
	    			
	    		}
	    		break;
	    		
	     }else if(option.equals("2")) {
	    	 while(true) {
	    		 try {
	    			 
	    		 
	    	view_costumers();
	    		 
	    	break;
	    		 }catch(Exception e ) {
	    			 System.out.println("RECORD NOT FOUND!"); 
	    			 ;
	    		 }
	    	 }
	    	 break;
	     }else if (option.equals("3")) {
	    	 costumer_signup();
	    	 break;
	    	 
	     }
	     else if (option.equals("4")) {
	    	add_car();
	    	break;
	    	
	     }else if (option.equals("5")){
	    	 delete_car();
	    	 break;
	     }else if(option.equals("6")) {
	    	 search_car();
	    	 break; 
	     }else if(option.equals("7")){
	    	 view_review();
	    	 
	    	 break; 
	     }else if (option.equals("8")) {
	    	 delete_review();
	    	 break;
	     }else if (option.equals("0")) {
	    	 main();
	    	 break;
	     }else {
	    	 System.out.println("INVALID INPUT!");
	     }
	    }
	     while (true) {
		    		System.out.print("\nENTER\n1. TO GO BACK\n0. TO LOG-OUT\nEnter Your Choice:");
		    		String choice=input.nextLine();
		    		if (choice.equals("1")) {
		    			admin_module();
		    			break;
		    		}else if (choice.equals("0")) {
		    			main();
		    			break;
		    		}else {
		    			System.out.println("\nINVALID INPUT!\nPLEASE ENTER A VALID CHOICE!\n"); 
		    			
		    		}
		    		}
	    	 
	    	 
	     }
public static void ADMIN_EDIT()

{
	Scanner input=new Scanner(System.in);
	String ch;
	while(true) {
		System.out.print("\nENTER\n1. TO EDIT COMPANY NAME\n2. TO EDIT USER-NAME\n3. TO EDIT PASSWORD\n4. TO EDIT CNIC\n5. TO EDIT NAME\n6. TO EDIT GENDER\n7. TO EDIT PHONE NUMBER\n8. TO EDIT AGE\n9. TO EDIT ADDRESS");

	 ch=input.nextLine();
	if((ch.equals("1"))||(ch.equals("2"))||(ch.equals("3"))||(ch.equals("4"))||(ch.equals("5"))||(ch.equals("6"))||(ch.equals("7"))||(ch.equals("8"))||(ch.equals("9"))) {
		break;}
	else
		System.out.println("\nINVLAID INPUT!");
	}

	if (ch.equals("1")) {  //user option 
	
	String line = "";   // accessing line in the text file
	int lineNo;
	try {
		FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
		BufferedReader br = new BufferedReader(fr);
		Scanner sc=new Scanner(System.in);
		
		for (lineNo = 0; lineNo < 50; lineNo++) {
			if (lineNo == 0) {   //at 0 there is company name. 
				line = br.readLine();
			} else
				br.readLine();   //reading all the lines. 
		}
	} catch (IOException e) {
		e.printStackTrace(); //exception 
	}
	

Scanner nes = new Scanner(System.in);
File file = new File("C:\\FileHandling\\AdminData.txt");
Scanner nex = new Scanner(line);
String[] test=new String[100];
while(nex.hasNextLine()){
     test = nex.nextLine().split(":");  //spliting by :
   
}
String currentCompany_Name;
while(true) {
System.out.print("Enter Your Current Company Name: ");

  currentCompany_Name=input.next();
 
if((test[1].equals(currentCompany_Name))==true) {  //CHECKING THE EQUALITY. 
	
	break;
	
}
else {
	System.out.print("INCORRECT COMPANY NAME!\n");
}
}
System.out.print("Enter Your New Company Name: ");

String newCompany_Name=input.nextLine();

    
	modifyFile("C:\\FileHandling\\AdminData.txt", currentCompany_Name, newCompany_Name);
    
    }
	
	if (ch.equals("2")) {
		String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 1) {  //reading line 1. for user name
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }

		
		String currentuser_Name;
		String newuser_Name;

    while (true) {
		System.out.print("Enter Your Current User-Name: ");
		currentuser_Name=input.next();

		if ((tes[1].equals(currentuser_Name))) {
			break; 
			
		}
		else if((currentuser_Name.equals(null))) {
			System.out.println("INVALID USER-NAME!\n");
		}
		else {
			System.out.println("INCORRECT USER-NAME!\n");

			
		}
		
		}
    while (true) {
		System.out.println("Enter Your New User-Name: ");
		 newuser_Name=input.next();
		if (newuser_Name.equals(null)) {
			System.out.println("INVALID USER NAME!\n"); 
			
		}else {

			
		
		break; 
		}
		}
	modifyFile("C:\\FileHandling\\AdminData.txt", currentuser_Name, newuser_Name);
		
	}

	

    if(ch.equals("3")) {
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 2) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }
    System.out.println(tes[1]);

    	String currentPassword;
    	String newPassword;
    while (true) {
		System.out.print("Enter Your Current Password: ");
		
		 currentPassword=input.nextLine();
		
		if ((validPassword(currentPassword))==true && (!(currentPassword.equals(null)))&&(tes[1].equals(currentPassword)) ) {
			 
				break; 
		
		}
		else {
			System.out.println("INVALID PASSWORD!\n"); 
			
		}
    }
		
    
    while (true) {
		System.out.print("Enter Your New Password: ");
		
		newPassword=input.nextLine();
		
		if (validPassword(newPassword)==true && (!(newPassword.equals(null)))) {
		break; 
		}
		else {
			System.out.println("INVALID PASSWORD!\n"); 
			
		}
		}
	modifyFile("C:\\FileHandling\\AdminData.txt", currentPassword, newPassword);

    }
    if(ch.equals("4")) {
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 5) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }
    	String current_cnic;
    	String new_cnic;
    while(true) {
		System.out.print("Enter Your Current CNIC (xxxxx-xxxxxxx-x): ");
		 current_cnic=input.next();
		if ((validCNIC(current_cnic))==true  && (!(current_cnic.equals(null)))||((tes[1].equals(current_cnic)))) {
			 break;
		}
		else {
			 System.out.println("INVALID INPUT!\n");
		}
		}
    
    while(true) {
		System.out.print("Enter Your New CNIC (xxxxx-xxxxxxx-x): ");
		 new_cnic=input.next();
		if (validCNIC(new_cnic)==true  && (!(new_cnic.equals(null)))) {
			 break;
		}else {
			 System.out.println("INVALID INPUT!\n");
		}
		}
	modifyFile("C:\\FileHandling\\AdminData.txt", current_cnic, new_cnic);

    }
    if (ch.equals("5")) {
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 3) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    }
    	String current_name;
    	String new_name;
    while(true) {
		System.out.print("Enter Your Current Name: "); 
		 current_name=input.nextLine();
		if (validName(current_name)==true && (!(current_name.equals(null)))&&(tes[1].equals(current_name))){
			 break;
		}else {
			 System.out.println("INVALID INPUT!\n");
		}
			}
    while(true) {
		System.out.print("Enter Your New Name: "); 
		 new_name=input.nextLine();
		if (validName(new_name)==true && (!(new_name.equals(null)))){
			 break;
		}else {
			 System.out.println("INVALID INPUT!\n");
		}
			}
	modifyFile("C:\\FileHandling\\AdminData.txt", current_name, new_name);

    }
    if (ch.equals("6")) {
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 4) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
   
    }
    	String current_gender;
    	String new_gender;
    while(true) {
    	System.out.println("ENTER YOUR CURRENT GENDER\nPRESS\nMALE\nFEMALE\nPREFER NOT");
		current_gender=input.nextLine();
		if((current_gender.equals("Male"))||(current_gender.equals("Female"))||(current_gender.equals("Prefer not"))&&(tes[1].equals(current_gender))){
			break;
		}
		else {
			 System.out.println("INVALID INPUT!\n");

			
		}

    	
    }
    
    while(true) {
    	System.out.println("ENTER YOUR NEW GENDER\nPRESS\nMALE\nFEMALE\nPREFER NOT");
		new_gender=input.nextLine();
		if((new_gender.equals("Male"))||(new_gender.equals("Female"))||(new_gender.equals("Prefer not"))){
			break;
		}
		else {
			 System.out.println("INVALID INPUT!\n");

			
		}

    	
    }
	modifyFile("C:\\FileHandling\\AdminData.txt", current_gender, new_gender);

    }
    if(ch.equals("7")) {
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 6) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }
    	String currentphone_number;
    	String newphone_number;
    while(true) {
		System.out.print("Enter Your Current Phone Number: ");
		 currentphone_number=input.nextLine();
		if(validNumber(currentphone_number)==true && (!(currentphone_number.equals(null))||(tes[1].equals(currentphone_number)) )){
			 break;
		}else {
			 System.out.println("INVALID INPUT!\n");
		}
		}
    while(true) {
		System.out.print("Enter Your New Phone Number: ");
		 newphone_number=input.nextLine();
		if(validNumber(newphone_number)==true && (!(newphone_number.equals(null)) )){
			 break;
		}else {
			 System.out.println("INVALID INPUT!\n");
		}
		}
	modifyFile("C:\\FileHandling\\AdminData.txt", currentphone_number, newphone_number);

    }
    if(ch.equals("8")) {
    	
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 7) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }
    	String current_age;
    	String new_age;
    while(true) {
		
		 System.out.print("Enter Your Current Age: "); 
          current_age=input.nextLine(); 
         boolean option=true;
         for (int i=0; i<current_age.length(); i++) {
 			if (! ('0' <= current_age.charAt(i) && current_age.charAt(i) <= '9') &&   ((current_age.charAt(i) >= 'A' && current_age.charAt(i) <= 'Z' ))
 		            && ((current_age.charAt(i) >= 'a' && current_age.charAt(i) <= 'z') ) && (current_age.equals(null))) {
 				option=false;
 			
 			}else {
 				option=true;
 				break ;
 			}
         }
         if ((validAge(Integer.parseInt(current_age))==true ) && (option=true)&&(tes[1].equals(current_age))) {
        	 break;
         }
         
         else {
		
        	 System.out.println("INVALID AGE!\n"); 
         }
	
	 
		 
	 }
    
    while(true) {
		
		 System.out.print("Enter Your New Age: "); 
         new_age=input.nextLine(); 
         boolean option=true;
         for (int i=0; i<new_age.length(); i++) {
 			if (! ('0' <= new_age.charAt(i) && new_age.charAt(i) <= '9') &&   ((new_age.charAt(i) >= 'A' && new_age.charAt(i) <= 'Z' ))
 		            && ((new_age.charAt(i) >= 'a' && new_age.charAt(i) <= 'z') ) && (new_age.equals(null))) {
 				option=false;
 			
 			}else {
 				option=true;
 				break ;
 			}
         }
         if ((validAge(Integer.parseInt(new_age))==true ) && (option=true)) {
        	 break;
         }
         
         else {
		
        	 System.out.println("INVALID AGE!\n"); 
         }
	
	 
		 
	 }
	modifyFile("C:\\FileHandling\\AdminData.txt", current_age, new_age);

    }
    if(ch.equals("9")) {
    	
    	String line = "";
		int lineNo;
		try {
			FileReader fr = new FileReader("C:\\FileHandling\\AdminData.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc=new Scanner(System.in);
			
			for (lineNo = 0; lineNo < 50; lineNo++) {
				if (lineNo == 8) {
					line = br.readLine();
				} else
					br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\FileHandling\\AdminData.txt");
    Scanner nex = new Scanner(line);
    String[] tes=new String[100];
    while(nex.hasNextLine()){
         tes = nex.nextLine().split(":");
        
    
    
   
    }
    	String current_address;
    	String new_address;
    while (true) {
		System.out.print("Enter Your Current  Address: ");
		 current_address=input.nextLine();
		if (tes[1].equals(current_address)) {
			break;
		}else if (current_address.equals(null)){
			System.out.println("INVALID ADDRESS!\n");

			
		}
		else {
			System.out.println("INCORRECT ADDRESS!\n");

			
		}
			}
    
    while (true) {
		System.out.print("Enter Your New  Address: ");
		 new_address=input.nextLine();
		if (new_address.equals(null)) {
			System.out.println("INVALID ADDRESS!\n");
		}else {
			break;
		}
			}
	modifyFile("C:\\FileHandling\\AdminData.txt", current_address, new_address);

    }
   
	
	System.out.println("\nPROFILE UPDATED SUCCESFULLY!!!");}

	



	public static void modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);    //reading the file. 
		
		String oldContent = "";   //declaring an empty string. 
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));  //reading the file to be  odified. 
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();    
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();  
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
}
public static void view_review() throws IOException {
    for (int i=0; i<=countLine("C:\\Cars\\ImportedCars\\Reviews.txt"); i++) {
    	try {
    		System.out.println("\t\t\t"+Files.readAllLines(Paths.get("C:\\Cars\\ImportedCars\\Reviews.txt")).get(i));
    	}catch(Exception e ) {
    		//System.out.println("No Record Found!\n");
    	}
    }
}
public static void view_costumers() throws IOException {
	
	System.out.println("------------------------------------------------------------------------------------");
	  System.out.println("                                COSTUMERS                                         ");
	  System.out.println("------------------------------------------------------------------------------------\n"); 
	Scanner sc=new Scanner(System.in); 
	 File file = new File("C:\\FileHandling\\Data.txt"); //reading the file 
       Scanner fes = new Scanner(file);
       while(fes.hasNextLine()){
       	
           String[] str = fes.nextLine().split(" ");
           System.out.println("\t\tENTER  '" +str[1]+"' TO SHOW DATA OF  '" +str[3]+"'\n");
           
 
       }
       System.out.print("Enter Your Choice: ");
       String Choice=sc.nextLine(); 
       int choice=Integer.parseInt(Choice);
    System.out.println( Files.readAllLines(Paths.get("C:\\FileHandling\\Data.txt")).get(choice-1));
    String ID=costumer_profile(costumer_username_pass(Choice)[0],costumer_username_pass(Choice)[1])[1];  //costumers owned cars
    
    	 System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                CARS OWNED                                          ");
		  System.out.println("------------------------------------------------------------------------------------\n"); 
    
    costumers_cars(ID);
    }

public static void search_car() throws FileNotFoundException {
	Scanner sc=new Scanner(System.in);
	while (true) {
		try {
			
		
	 File file = new File("C:\\Cars\\ImportedCars\\CARS.txt");
      Scanner fes = new Scanner(file);
      while(fes.hasNextLine()){
      	
          String[] str = fes.nextLine().split(" ");
          System.out.println("Press " +str[0]+" To show Data of " +str[4]);
      }
      String Choice=sc.nextLine(); 
      int choice=Integer.parseInt(Choice);
   System.out.println(  ReadCarLine(choice));
   break;
	}catch(Exception e) {
		System.out.println("RECORD NOT FOUND!");
	}
	
	}
}

	public static void add_review() throws IOException {
		Scanner nes=new Scanner(System.in);
		 File file1 = new File("C:\\Cars\\ImportedCars\\Reviews.txt");
		 //Scanner nes = new Scanner(System.in);
	        File file$ = new File("C:\\Cars\\ImportedCars\\Reviews.txt");
	        FileWriter fileWriter = new FileWriter("C:\\Cars\\ImportedCars\\Reviews.txt", true);
	        BufferedWriter buffer = new BufferedWriter(fileWriter);
	        Scanner ves1 = new Scanner(file$);
	        int ex = 0;
	        if(ves1.hasNextLine()) {
	            while (ves1.hasNextLine()) {
	                String[] arr = ves1.nextLine().split(" ");
	                ex = Integer.parseInt(arr[0]);
	            }
	        }
	        System.out.println("Enter Your Review:");
	        String rev = nes.nextLine();
	        buffer.write((ex+1)+" "+rev);
	        buffer.newLine();
	        System.out.println("THANK YOU FOR YOUR REVIEW!\n");
	        ves1.close();
	        buffer.close();
	        fileWriter.close();
	        
	        
	}
	public static void delete_review() throws IOException {
		
		
			
		
	try {
		
		Scanner input=new Scanner (System.in); 
		
		File file1 = new File("C:\\Cars\\ImportedCars\\Reviews.txt");
        Scanner fes1 = new Scanner(file1);
        String[] str = new String[100];
        String[] mes = new String[100];
        while (fes1.hasNextLine()) {
            System.out.println(fes1.nextLine());
        }
        Scanner fes11 = new Scanner(file1);
        int j = 0;
        while (fes11.hasNextLine()) {
            str[j] = fes11.nextLine();
            j++;
        }
        Scanner ves = new Scanner(file1);
        
        System.out.println("Which Review You Want To Delete?");
        String sc = input.nextLine();
        int rev1 = Integer.parseInt(sc);
        String[] str1 = new String[0];
        while(ves.hasNextLine()){
            str1 =ves.nextLine().split(" ");
        }
        String[] mes1 = str1[0].split("\\.");
        int num = Integer.parseInt(mes1[0]);
        if(rev1 > num)
            System.out.println("Review Not Found!\n");
        else{
            for (int i = 0; i < str.length; i++) {
                String[] arr = str[i].split(" ");
                if (arr[0].equals(sc)) {
                    str[i] = " ";
                    break;
                }
            }
            int x = 0;
            for(String e:str){
                if(e != null)
                    mes[x] = e;
                x++;
            }
            for(int i = 0; i<19; i++){
                if(mes[i].equals(" ")){
                    mes[i] = mes[i+1];
                    mes[i+1] = " ";
                }
            }
            String[] proj = new String[0];
            int count = 0;
            for(String k:mes){
                if(k != null)
                    count++;
            }
            int k = 0;
            for(int i = k; i<=count; i++) {
                if(mes[i] != null){
                    proj = mes[i].split(" ");
                    String test = "";
                    for(int l = 1; l<=proj.length-1; l++){
                        test += proj[l] +  " ";
                    }
                    proj[0] = i+1 +"";
                    mes[i] = proj[0] + " " + test;
                }
            }
            FileWriter fileWriter1 = new FileWriter(file1);
            BufferedWriter buffer1 = new BufferedWriter(fileWriter1);
            for(String e:mes){
                if(e !=null){
                    if(!e.equals(" ")){
                        buffer1.write(e);
                        buffer1.newLine();
                    }
                }
            }
            buffer1.close();
            fes1.close();
            fes11.close();
            ves.close();
            System.out.println("REVIEW DELETED SUCCESSFULLY!\n");
        }}
        catch(Exception e ) {
        	System.out.println("No Record Found!\n");
        	
        }
		}
        
	
	

	//======================================================================================================================================
	//
	//======================================COSTUMERS MODULES================================================================================
	//
	//======================================================================================================================================
	public static void costumers(String user_name,String password) throws Exception {
		Scanner input=new Scanner(System.in);
		System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                WELCOME TO COSTUMER'S MODULE                                          ");
		  System.out.println("------------------------------------------------------------------------------------"); 
		  while (true) {
		  
		  System.out.print("ENTER\n1. TO VIEW PROFILE\n2. TO VIEW CARS OWNED\n3. TO VISIT SHOWROOM\n4. TO EDIT PROFILE DETAILS\n0. TO LOG-OUT\nEnter Your Choice: "); 
		  String choice=input.nextLine();
		  
		  String ID=costumer_profile(user_name,password)[1];
		  if (choice.equals("1")) {
			  try {
			  int id=Integer.parseInt( costumer_profile(user_name,password)[0]); 
			 int id_number=id-1;
			  System.out.println(Files.readAllLines(Paths.get("C:\\FileHandling\\Data.txt")).get(id_number));
			  }catch(Exception e ) {
				  System.out.print("\nError! Log-out and Re-Login\n");
			  }
			  break; 
			  
			  
		  }
		  else if(choice.equals("2")) {
			  System.out.println("------------------------------------------------------------------------------------");
			  System.out.println("                                CARS OWNED                                          ");
			  System.out.println("------------------------------------------------------------------------------------"); 
			  costumers_cars(ID);
			  break; 
		  }
		  else if(choice.equals("3")) {
			 car_buy(user_name,password);
			 break; 
			  
		  }
		  else if (choice.equals("4")) {
			  edit_costumer(user_name,password); 
			  break; 
		  
			  
		  }else if (choice.equals("0")) {
			  
		  main();
		  break ;
			  
		  }
		  }
		  while (true) {
		
		  System.out.print("\nENTER\n1. TO GO BACK\n2. TO LOG-OUT\nEnter Your Choice: ");
		  String op=input.nextLine();
			  if(op.equals("1")) {
				  costumers(user_name,password);
				  break; 
			  }else if (op.equals("2")) {
				  main();
				  break;
			  }
			  else {
				  System.out.println("INVALID INPUT!\n"); 
				  
			  }
		  }
		  
	}
	public static  String[] costumer_username_pass(String id) throws IOException {
		//File file = new File("C:\\Users\\Fahad X Raja\\Downloads\\Video\\Review.txt");
	   // Scanner fes = new Scanner(file);
	    String [] costumer=new String [2];

		BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\Data.txt")); //creating instance for reading file
	    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file
		String s;
		int count=0; 
	    while ((s = inputStream.readLine()) != null) {
	    	 
	         
	    	// read  line by line file
			 char[] chars = s.toCharArray();       //store the file content in array
	            
	            s = new String(chars);
	            //converting char array to string
	            
	            String [] word=s.split(" ");
	            //System.out.println(word[11]+" "+word[13]);
	            if(word[1].equals(id)){
	            	
	                costumer[0]=word[11];//username 
	                costumer[1]=word[13];//password
	               
	                break;
	            }
	            
	        }
	        return costumer; 
	}
	public static void costumers_cars(String cnic) {
		     try {

		        BufferedReader br;
		        String line;

		        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\FileHandling\\Rev.txt"), "UTF-8");
		        br = new BufferedReader(inputStreamReader);
		        while ((line = br.readLine()) != null) {
		          if (line.contains(cnic)) {
		        	  System.out.println(line);
		          }
		        }
		        br.close();
		        br = null;

		      }
		      catch (Exception ex) {
		        ex.printStackTrace();
		      }
		  }
		
	
	public static String[] costumer_profile(String name, String pass) throws IOException {
		File file = new File("C:\\Users\\Fahad X Raja\\Downloads\\Video\\Review.txt");
	    Scanner fes = new Scanner(file);
	    

		BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\Data.txt")); //creating instance for reading file
	    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file
         String []id=new String [2];
		String s;
		int count=0; 
		boolean bool = true;
	    while ((s = inputStream.readLine()) != null) {
	    	 
	         
	    	// read  line by line file
			 char[] chars = s.toCharArray();       //store the file content in array
	            
	            s = new String(chars);
	            //converting char array to string
	            
	            String [] word=s.split(" ");
	            
	            if(word[11].equals(name) && word[13].equals(pass)){
	                bool = true;
	               id[0]=word[1];
	               id[1]=word[9];
	                break;
	            }
	            else{
	                bool = false;
	                
	            }
	        }
	    return (id);
	    
	         
	}
	public static String getnum(String name, String pass) throws IOException {
		BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\Data.txt")); //creating instance for reading file
	    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

		String s;
		int count=0; 
		boolean bool = true;
	    String r="";
	    while ((s = inputStream.readLine()) != null) {
	    	 
	         
	    	// read  line by line file
			 char[] chars = s.toCharArray();       //store the 	 content in array
	            
	            s = new String(chars);
	            //converting char array to string
	            
	            String [] word=s.split(" ");
	            
	            if(word[11].equals(name) && word[13].equals(pass)){
	                bool = true;
	                
	              // System.out.println(word[1]);
	               r+=word[9]; 
	                break;
	            }
	            else{
	                bool = false;
	                
	            }
	        }
	    
	    return r; 
	    
	        
	}
	public static boolean costumer_login(String name, String pass) throws IOException {
		
		File file = new File("C:\\Users\\Fahad X Raja\\Downloads\\Video\\Review.txt");
	    Scanner fes = new Scanner(file);
	    

		BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\Data.txt")); //creating instance for reading file
	    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

		String s;
		int count=0; 
		boolean bool = true;
	    while ((s = inputStream.readLine()) != null) {
	    	 
	         
	    	// read  line by line file
			 char[] chars = s.toCharArray();       //store the file content in array
	            
	            s = new String(chars);
	            //converting char array to string
	            
	            String [] word=s.split(" ");
	            
	            if(word[11].equals(name) && word[13].equals(pass)){
	                bool = true;
	               
	                break;
	            }
	            else{
	                bool = false;
	                
	            }
	        }
	        return bool; 
	}
	public static void costumer_signup() {
		
		  System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                  COSTUMER'S SIGN-UP                                          ");
		  System.out.println("------------------------------------------------------------------------------------"); 
		Scanner input=new Scanner(System.in); 
		
		 String [] costumer=new String[9];
		 
		 
		while(true) {
	System.out.print("Enter Name: "); 
	String name=input.nextLine();
	if (validName(name)==true && (!(name.equals(null)))){
		 costumer[1]="NAME: "+name;
		 break;
	}else {
		 System.out.println("INVALID INPUT!\n");
	}
		}
		
		while(true) {
		
			 System.out.print("Enter Age: "); 
	         String age=input.nextLine(); 
	         boolean option=true;
	         for (int i=0; i<age.length(); i++) {
	 			if (! ('0' <= age.charAt(i) && age.charAt(i) <= '9') &&   ((age.charAt(i) >= 'A' && age.charAt(i) <= 'Z' ))
	 		            && ((age.charAt(i) >= 'a' && age.charAt(i) <= 'z') ) && (age.equals(null))) {
	 				option=false;
	 			
	 			}else {
	 				option=true;
	 				break ;
	 			}
	         }
	         if ((validAge(Integer.parseInt(age))==true ) && (option=true)) {
	        	 costumer[7]="AGE: "+age; 
	        	 break;
	         }
	         
	         else {
			
	        	 System.out.println("INVALID AGE!\n"); 
	         }
		
		 
			 
		 }
		while (true) {
	System.out.print("Enter Your Address: ");
	String address=input.nextLine();
	if (address.equals(null)) {
		System.out.println("INVALID ADDRESS!\n");
	}else {
		costumer[8]="ADDRESS: "+address;
		break;
	}
		}
	 
	while (true) {
	System.out.print("Select Your Gender\n1. Male\n2. Female\n3. Prefer Not To Say: ");

	String gender=input.nextLine();
	if (gender.equals("1")||gender.equals("2")|| gender.equals("3")) {
		 if(gender.equals("1")) {
			 costumer[2]="GENDER: "+"Male";
		 }else if(gender.equals("2")) {
			 costumer[2]="GENDER: "+"Female";
		 }else {
			 costumer[2]="GENDER: "+"Prefer Not To Say";
		 }
		 break;
	}else {
		 System.out.println("INVALID INPUT!\n");
	}
	}
	while(true) {
	System.out.print("Enter Phone Number: ");
	String phone_number=input.nextLine();
	if(validNumber(phone_number)==true && (!(phone_number.equals(null)) )){
		 costumer[3]="PHONE: "+phone_number; 
		 break;
	}else {
		 System.out.println("INVALID INPUT!\n");
	}
	}
	while(true) {
	System.out.print("Enter CNIC (xxxxx-xxxxxxx-x): ");
	String cnic=input.nextLine();
	if (validCNIC(cnic)==true  && (!(cnic.equals(null)))) {
		 costumer[4]="CNIC: "+cnic; 
		 break;
	}else {
		 System.out.println("INVALID INPUT!\n");
	}
	}
	while (true) {
	System.out.print("Enter User-Name: ");
	String user_name=input.nextLine();
	if (user_name.equals(null)) {
		System.out.println("INVLALID USER-NAME!\n"); 
		
	}else {
		
	costumer[5]="USER-NAME: "+user_name;
	break; 
	}
	}
	while (true) {
	System.out.print("Enter Password\n(Password Must Contain an Upper-Case Letter a Lower-Case letter A Number And Must Be Of Minimum 8 Characters: ");
	
	String Password=input.nextLine();
	
	if (validPassword(Password)==true && (!(Password.equals(null)))) {
	costumer[6]="PASSWORD: "+Password;
	break; 
	}
	else {
		System.out.println("INVALID PASSWORD!\n"); 
		
	}
	}

	int Unique_ID=(int)countLine("C:\\FileHandling\\Data.txt")+1;
	costumer[0]="ID: "+Unique_ID; 

	Writer output;
	 try {
			File f=new File("C:\\FileHandling\\Data.txt");
			
			PrintWriter pw=new PrintWriter(new FileOutputStream(f,true)); 
			for (int i=0; i<costumer.length; i++) {
				
				pw.append(costumer[i]+" ");//appending the data in the existiing file.
				
				}
			pw.println(""); 
			
		
			pw.close();
			
			
		}catch(Exception e) {}
	System.out.println();
	  System.out.println("------------------------------------------------------------------------------------");
	  System.out.println("                       RECORD ADDED SUCCESSFULLY!                                     ");
	  System.out.println("------------------------------------------------------------------------------------");

	}
	
	
public static boolean validCNIC(String SNN) {
		
		boolean option= true; 
		if (SNN.length()!=15) {
			option=false;
		}else {
			if (!  ('0' <= SNN.charAt(0) && SNN.charAt(0) <= '9') ){
		
			option=false;
			}if (! ('0' <= SNN.charAt(1) && SNN.charAt(1) <= '9')){
			option=false;
		   }
			if (!('0' <= SNN.charAt(2) && SNN.charAt(2) <= '9')){
			option=false;
		 }
		if (!('0' <= SNN.charAt(3) && SNN.charAt(3) <= '9')) {
			option=false;
		}if (! ('0' <= SNN.charAt(4) && SNN.charAt(4) <= '9')){
			option=false;
		}if (!(SNN.charAt(5)=='-')){
			option=false;
		
		}if (!('0' <= SNN.charAt(6) && SNN.charAt(6) <= '9')) {
			option=false;}
		if(! ('0' <= SNN.charAt(7) && SNN.charAt(7) <= '9')){
			option=false;
		}if (! ('0' <= SNN.charAt(8) && SNN.charAt(8) <= '9')) {
			option=false;
		}if (! ('0' <= SNN.charAt(9) && SNN.charAt(9) <= '9')){
			option=false;
		}if (! ('0' <= SNN.charAt(10) && SNN.charAt(10) <= '9')){
			option=false;
		}
		if (! ('0' <= SNN.charAt(11) && SNN.charAt(11) <= '9')){
			option=false;
			
		}
		if (!('0' <= SNN.charAt(12) && SNN.charAt(12) <= '9')){
			option=false;
		}if (! (SNN.charAt(13)=='-')) {
			option=false; 
		}
		if (!('0' <= SNN.charAt(14) && SNN.charAt(14) <= '9')) {
			option=false;
		}
		}
		
		return option;
		
			
	
}

	
	//=========================================================================================================================
	//
	//================================CARS MODULES=============================================================================
	//
	//=========================================================================================================================
	public static void add_car() throws IOException {
		  Scanner input=new Scanner (System.in);
		  System.out.println("------------------------------------------------------------------------------------");
		  System.out.println("                                  ADD CAR!                                          ");
		  System.out.println("------------------------------------------------------------------------------------"); 
			  
		  String [] add_vehicle=new String[10];
		   
		  while (true) {
			  System.out.print("1. CAR\n2. BIKE \n3. HEAVY\nSelect your Vehicle Type: ");
			  String type=input.nextLine();
			  if (type.equals("1")|| type.equals("2")||type.equals("3")) {
				  if (type.equals("1")) {
					  add_vehicle[1]="VEHICLE_TYPE: CAR";
				  }else if(type.equals("2")) {
					  add_vehicle[1]="VEHICLE_TYPE: BIKE";
				  }else if (type.equals("3")) {
					  add_vehicle[1]="VEHICLE_TYPE: HEAVY";
				  }
				  break;
			  }else {
				  System.out.println("INVALID INPUT!\n");
			  }
		  }
		  System.out.print("Enter Vehicle's Name: ");
		  String vehicle_name=input.next();
		  add_vehicle[2]="VEHICLE'S_NAME: "+vehicle_name;
		  while (true) {
			  System.out.print("Enter Vehicle's Mileage: ");
			  
		  String vehicle_mileage=input.next();
		  if (validName(vehicle_mileage)==true) {
			  System.out.println("INVALID INPUT!\n");
		  }else {
			  
		  add_vehicle[3]="VHEICLE'S_MILEAGUE: "+vehicle_mileage+"KMPL";
		  break;
		  }
		  }
		  
		  
		  while(true) {
		  System.out.print("Enter Vehicle's Engine (cc): ");
		  String vehicle_engine=input.next();
		  if (validName(vehicle_engine)==true) {
			  System.out.println("INVALID INPUT!\n"); 
			  
		  }
		  else {
			  
		  add_vehicle[4]="ENGINE(CC): "+vehicle_engine;
		  break;
		  }
		  }
		  
		  
		  while (true) {
			  
		  System.out.print("Enter Engine Number(e.g XON1099VXHA): ");
		  
		  String Engine_number=input.next();
		  if (Engine_number.length()==11) {
		  add_vehicle[5]="ENGINE_NUMBER: " +Engine_number;
		  break; 
		  }else {
			  System.out.println("INVALID INPUT!\n"); 
			  
		  }
		  }
		  
		  while (true) {
		  System.out.print("Enter the Model of the Vehicle: ");
		  
		  String model=input.next(); 
		  if (Integer.parseInt(model)>2021 || Integer.parseInt(model)<2000) {
			  System.out.println("INVALID INPUT!\n");
		  }else {
			  
		  add_vehicle[6]="MODEL: "+model;
		  break;
		  }
		  }
		  
		  while (true) {
		  System.out.print("Enter price ( $ ): ");
		  String price=input.next(); 
		  if (validPrice(price)==true) {
		  add_vehicle[7]="PRICE($): "+price;
		  break;
		  }
		  else {
			  System.out.println("INVALID INPUT!\n"); 
		  }
		  }
		  
		  while (true) {
		  System.out.print("Available Colour: ");
		  String colours=input.next();
		  if (validName(colours)==true) {
			 
		  add_vehicle[8]="COLOUR: "+colours;
		  break;
		  }
		  else {
			  System.out.println("INVALID INPUT!\n"); 
			  
		  }
		  }
		 
		  while (true) {
		  System.out.print("Enter Quantity of Cars: "); 
		  String quantity =input.next();
		  if (validPrice(quantity)==true) {
		  add_vehicle[9]="QUANTITY: "+Integer.parseInt(quantity);
		  break; 
		  }
		  else {
			  System.out.println("INVLAID INPUT!\n"); 
			  
		  }
		  }
		  
		 long Unique_ID=countLine("C:\\Cars\\ImportedCars\\CARS.txt")+1;
		 
		  add_vehicle[0]=Long.toString(Unique_ID);  //connverting long to String. 
		  
		  
			 
				  try {
						File f=new File("C:\\Cars\\ImportedCars\\CARS.txt");
						
						PrintWriter pw=new PrintWriter(new FileOutputStream(f,true)); 
						for (int j=0; j<add_vehicle.length; j++) {
							
						
						pw.append(add_vehicle[j]+" ");//appending the data in the existiing file.
						}
						pw.append("\n");
						pw.close();
						
						
					}catch(Exception e) {}
				  System.out.println("------------------------------------------------------------------------------------");
				  System.out.println("                       RECORD ADDED SUCCESSFULLY!                                     ");
				  System.out.println("------------------------------------------------------------------------------------");

		  
	}
	public static boolean validPrice(String num) {
		
	boolean b=true;
		for (int i=0; i<num.length(); i++) {
	if(!('0' <= num.charAt(i) && num.charAt(i) <= '9')) {
		b=false;
	}else {
		b=true;
	}
		}
		return b;
		
		
	}
		  
		  //COUNTING THE NUMBER OF LINES IN A FILE 
	public static long countLine(String fileName) {  //count line 

	    Path path = Paths.get(fileName);

	    long lines = 0;
	    try {

	        lines = Files.lines(path).count();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return lines;
	}
	
	//valid  NAME 
	public static boolean validName(String str)
	{
	    if (str == null || str.equals("")) {
	        return false;
	    }
	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if ((!(ch >= 'A' && ch <= 'Z' ))
	            && (!(ch >= 'a' && ch <= 'z'))) {
	            return false;
	        }
	    }
	    return true;

	}
// VALID AGE
	public static boolean validAge(int age) { 
		  
		if (age<=17 || age>=100 || age==0) {
			return false;
		}
		else {
			return true; 
		}
		}
	// VALID NUMBER MODULE 
	
	public static boolean validNumber(String id) {
		boolean option=true; 
		if (id.length()<11) {
			option=false;
		}else {
			
		
		for (int i=0; i<id.length(); i++) {
			if (! ('0' <= id.charAt(i) && id.charAt(i) <= '9') && (!(id.length()==11))) {
				option=false;
			}else {
				option=true;
			}
		
		}
		}
		return option;
	}
	public static boolean validPassword(String Password) {
		if ((Password.length()>=8) && (Password.contains("A") || Password.contains("B") || Password.contains("C") ||Password.contains("D") ||Password.contains("E") || Password.contains("F")  || Password.contains("G") || Password.contains("H") || Password.contains("I") || Password.contains("J") || Password.contains("K") || Password.contains("L") || Password.contains("M") || Password.contains("N") || Password.contains("O") || Password.contains("P") || Password.contains("Q") || Password.contains("R") || Password.contains("S") || Password.contains("T") || Password.contains("U") || Password.contains("V") || Password.contains("W") || Password.contains("X") || Password.contains("Y") || Password.contains("Z"))
				&&(Password.contains("0")|| Password.contains("1") || Password.contains("2")|| Password.contains("3")|| Password.contains("4")|| Password.contains("5")|| Password.contains("6")|| Password.contains("7")|| Password.contains("8")|| Password.contains("9"))){
		return true;
	}else {
		return false; 
	}
	}
	
	//=============================================
	//
	//===============SEARCH CAR=====================
	//
	//===============================================
	public static void car_buy(String username, String password) throws Exception {

		Scanner sc=new Scanner(System.in); 
		 File file = new File("C:\\Cars\\ImportedCars\\CARS.txt");
	        Scanner fes = new Scanner(file);
	        while(fes.hasNextLine()){
	        	
	            String[] str = fes.nextLine().split(" ");
	            System.out.println("Press " +str[0]+" To show Data of " +str[4]);
	        }
	        
	        String Choice=sc.nextLine(); 
	        int choice=Integer.parseInt(Choice);
	     System.out.println(  ReadCarLine(choice)); 
	       String data=ReadCarLine(choice); 
	       
	       
	       //  System.out.println(Files.readAllLines(Paths.get("C:\\Cars\\ImportedCars\\CARS.txt")).get(choice));
	        
	while (true) {
	System.out.print("\nPress\n1. TO BUY\n2. TO GO BACK\n3. TO GO TO PROFILE\nEnter Your Choice: ");
     String option=sc.nextLine();
      if (option.equals("1")) {
    	  while(true) {
    	  System.out.println("Enter Your User-Name: ");
    	  String user_name=sc.next(); 
    	  System.out.println("Enter Your Password: "); 
    	  String Password=sc.next();
    	  System.out.print("Enter Credit Card Number: ");
    	  //long card_number=sc.nextLong();
    	  long card_number=0;
    	  try {
    	  String card_num=sc.next();
    	  long card=Long.parseLong(card_num);
    	  card_number+=card;}
    	  catch (Exception e){
    		  System.out.println("\nINPUT MISMATCH EXCEPTION\n");
    	  }
    	  
    	if (  costumer_login(user_name,Password)==true && payment_module(card_number)==true ) {
    		
    		while(true) {
    			 System.out.print("Enter Amount($): "); 
    	       	  int price=sc.nextInt(); 
    	       	  if (price>car_price(Choice)) {
    	       		  System.out.println(price-car_price(Choice)+"($) RETURNED!");
    	       		invoice_Number(user_name,Choice);
    	       		decrease_car_quantity(choice);
    	       		  break;
    	       	  }
    	       	  else if(price==car_price(Choice)) {
    	       		invoice_Number(user_name,Choice);
    	       		decrease_car_quantity(choice);
    	       		  break;
    	       		  
    	       	  }
    	       	  else {
    	       		System.out.println("Enter Correct Amount!");
    	       	  }
    		}
    		while (true) {
    	  System.out.println("Do You Want To Give Some Reviews?(Y/N)");
    	  String ch=sc.next(); 
    	  if (ch.equalsIgnoreCase("Y")) {
    		  add_review();
    		 
    		  break;
    	  }else if(ch.equalsIgnoreCase("N") ){
    		  break;
    	  }else {
    		  System.out.println("INVALID INPUT");
    	  }
    		}
    		
       	  
    		try {
				File f=new File("C:\\FileHandling\\Rev.txt");
				
				PrintWriter pw=new PrintWriter(new FileOutputStream(f,true)); 
				String  num=getnum(username,password); 
			 
								
				
				pw.append(countLine("C:\\FileHandling\\Rev.txt")+" "+"CNIC: "+num+" "+data);//appending the data in the existiing file. 
				pw.append("\n");
				pw.close(); 
				
			}catch(Exception e) {}
    		System.out.println("\n\nTHANK YOU FOR YOUR VISIT!"); 
    		break;
    	}
    	else {
    		System.out.println("INVALID CREDENTIALS!"); 
    
    	 }
    	 
    	  }
    	  break;
    	  
      
      }else if(option.equals("2")) { 
    	  car_buy(username, password);
    	  break ;
    	  
      }
      else if (option.equals("3")) {
    	  costumers(username,password); 
    	  break;
      }
      else {
    	  System.out.println("INVALID INPUT"); 
    	  
      }
	}
	
	}
	
	
	
	
	//==================================================
	//==================READ CARS LINE=================
	//===================================================
	
	public static String ReadCarLine(int length) {
	
			String line = "";
			int lineNo;
			try {
				
				FileReader fr = new FileReader("C:\\Cars\\ImportedCars\\CARS.txt");
				BufferedReader br = new BufferedReader(fr);
				Scanner input=new Scanner (System.in);
				
				
			//	System.out.println("enter the line number you want to read");
				//int l=input.nextInt();
		            
				for (lineNo = 1; lineNo < 50; lineNo++) {
					if (lineNo ==length) {
					    			           
			            line= br.readLine();
			           
					} else
						br.readLine();
				
					
			} 
			}catch (IOException e) {
				e.printStackTrace();
			}
			String file="";
			//System.out.println("Line: " + line);
			 Scanner nex = new Scanner(line);
		        while(nex.hasNextLine()){
		            String[] test = nex.nextLine().split(" ");
		          
		            for(int i = 1; i<=test.length-3; i++) {
		            
		                	//System.out.print(test[i]+" ");
		                	
		                	file+=test[i]+" "; 
		                }
		        }
		        return file; 
		        

	}
	
	
	
	//========================================================================================
	//
	//===============================================PAYMENT MODULES==========================
	//
	//======================================================================================
	
	
	
	public static boolean payment_module(long number) throws IOException {

		// Prompt the user to enter a credit card number as a long integer
	   
		if (isValid(number)==true) {
		   return true; 
	      
	      }else {
	      return false; 
	      }
	}
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		boolean valid =
			(getSize(number) >= 13 && getSize(number) <= 16) &&
			(prefixMatched(number, 4) || prefixMatched(number, 5) ||
			prefixMatched(number, 37) || prefixMatched(number, 6)) &&
			((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

		return valid;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 2; i >= 0; i -= 2) {
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
		}
		return sum;
	}

	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}

	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = getSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		String num = d + "";
		return num.length();
	}

	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k) {
		if (getSize(number) > k)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, k));
		}
		return number;
	}

	public static int car_price(String unique_id) throws NumberFormatException, IOException {
		
			
			File file = new File("C:\\Cars\\ImportedCars\\CARS.txt");
		    Scanner fes = new Scanner(file);
		    

			BufferedReader inputStream = new BufferedReader(new FileReader("C:\\Cars\\ImportedCars\\CARS.txt")); //creating instance for reading file
		    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

			String s;
			int count=0; 
			boolean bool = true;
		    String price="";
		    while ((s = inputStream.readLine()) != null) {
		    	 
		         
		    	// read  line by line file
				 char[] chars = s.toCharArray();       //store the file content in array
		            
		            s = new String(chars);
		            //converting char array to string
		            
		            String [] word=s.split(" ");
		            
		            if(word[0].equals(unique_id)){
		                price+=word[14]; 
		                
		               
		                break;
		            }
		            else{
		                bool = false;
		                
		            }
		        }
		        return Integer.parseInt(price); 
		        
		
	}
	
	
	
	public static void invoice_Number(String id,String car_id) throws IOException {
		Random rand = new Random();
		  
        // Generate random integers in range 0 to 9999
        int rand_int1 = rand.nextInt(10000);
        
            LocalDateTime time=java.time.LocalDateTime.now();
        
        
        System.out.println("\t\t*******CAR SALE INVOICE******");
        System.out.println("\n\t******LUXURIOUS  ONLINE  CAR  SHOW  ROOM*****\t");
        


        System.out.println("\n\tINVOICE # "+rand_int1+"\t\t\tDATE: "+time);
        
        System.out.println("\n\tCLIENT/CUSTOMER:");
        System.out.println("\tNAME: "+costumer_data(id)[0]);
        System.out.println("\tADDRESS: "+costumer_data(id)[2]);
        System.out.println("\tPHONE #: "+costumer_data(id)[1]);



        
        
        
        System.out.println("__________________________________________________________________________________________________");

        System.out.println("\n\tITEM DESCRIPTION\t\t\t\t\t\tPRICE");
        System.out.println("____________________________________________________________________________________________________");

        
        System.out.println("\n\tCAR NAME:"+car_data(car_id)[0]+",\t\t\t   \t\t     PRICE($): "+car_data(car_id)[3]+"\n\tMODEL: "+car_data(car_id)[1]+",\n\tCOLOUR: "+car_data(car_id)[2] );
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t    SUBTOTAL: "+car_data(car_id)[3]);
        System.out.println("\n\t\t\t\t\t\t\t    TAX: NILL");
        System.out.println("\n\t\t\t\t\t\t\t    BALANCE DUE: NILL");
        System.out.println("\n\t\t\t  "+Files.readAllLines(Paths.get("C:\\FileHandling\\AdminData.txt")).get(8).toUpperCase());
       
        System.out.println("\t\t\t  EMAIL ADDRESS:LUXCAR12@GMAIL.COM");
        System.out.println("\t\t\t  "+Files.readAllLines(Paths.get("C:\\FileHandling\\AdminData.txt")).get(6).toUpperCase());
        System.out.println("\n\t\t  *******THANK YOU FOR YOUR BUSINESS******");
	}

	
	
public static String[] costumer_data(String user_name) throws IOException {
	
		
		
		File file = new File("C:\\FileHandling\\Data.txt");
	    Scanner fes = new Scanner(file);
	    

		BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\Data.txt")); //creating instance for reading file
	    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

		String s;
		int count=0;
		String [] data=new String[4];
		boolean bool = true;
	     
	    String all="";
	    while ((s = inputStream.readLine()) != null) {
	    	 
	         
	    	// read  line by line file
			 char[] chars = s.toCharArray();       //store the file content in array
	            
	            s = new String(chars);
	            //converting char array to string
	            
	            String [] word=s.split(" ");
	             
	            if(word[11].equals(user_name)){
	                 
	                data[0]=word[11];
	                
	                data[1]=word[7]; 
	              
	                data[2]=word[17]; 
	                data[3]=word[1];
	               
	                break;
	            }
	            else{
	                bool = false;
	                
	            }
	            
	             
	        }
	               
	        
	    return data; 

}
public static String[] car_data(String id) throws IOException {

	File file = new File("C:\\Cars\\ImportedCars\\CARS.txt");
    Scanner fes = new Scanner(file);
    

	BufferedReader inputStream = new BufferedReader(new FileReader("C:\\Cars\\ImportedCars\\CARS.txt")); //creating instance for reading file
    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

	String s;
	int count=0;
	String [] data=new String[4];
	boolean bool = true; 
    String all="";
    while ((s = inputStream.readLine()) != null) {
    	 
         
    	// read  line by line file
		 char[] chars = s.toCharArray();       //store the file content in array
            
            s = new String(chars);
            //converting char array to string
            
            String [] word=s.split(" ");
         
            if(word[0].equals(id)){
                 
                data[0]=word[4]; 
                data[1]=word[12];
                data[2]=word[16];
                data[3]=word[14];
                
               
                
               
                break;
            }
            else{
                bool = false;
                
            }
            
             
        }
               
        
   return data; 
}
public static void decrease_car_quantity(int buy) throws IOException {
	Scanner nes = new Scanner(System.in);
    File file = new File("C:\\Cars\\ImportedCars\\CARS.txt");  //reading the text file
    Scanner nex = new Scanner(file);
    int num = 0;     
    while(nex.hasNextLine()){
        String[] test = nex.nextLine().split(" ");
        num = Integer.parseInt(test[0]);   //converting test[0] into integer. 
    }
   
    if(buy>num){
        System.out.println("INVALID INPUT!\n");   //if buy is greater then num then prints invaid input
    }
    else{
        FileWriter fileWriter1 = new FileWriter(file, true);  
        BufferedWriter buff1 = new BufferedWriter(fileWriter1);
        Scanner fes = new Scanner(file);
        String[] str = new String[100];   //creating another string array of 100 length. 
        int j = 0;   
        Scanner fes11 = new Scanner(file);
        while (fes11.hasNextLine()) {
            str[j] = fes11.nextLine();//reading each line
            j++;   
        }
        while (fes.hasNextLine()){    
            for(int i = 0; i<=str.length-1; i++){
                String[] arr = fes.nextLine().split(" ");   //spliting 
                String buy1 = String.valueOf(buy);  //getting the value of buy. 
                if(arr[0].equals(buy1)){ 
                    int k = Integer.parseInt(arr[arr.length-1]);
                    String quan = "";
                    for(int x = 0; x<=arr.length-2; x++){
                        quan += arr[x] + " ";
                    }
                    str[i] = quan + --k;
                    break;
                }
            }
            break;
        }
        FileWriter empty = new FileWriter(file);
        empty.write("");
        for (String e : str) {
            if (e != null) {
                buff1.write(e);
                buff1.newLine();
            }
        }
     //   System.out.println("Updated successfully");
        buff1.close();
        empty.close();
    }
}




//============================================================================
//
//===========================================EDIT COSTUMER DETAILS===============
//
//=================================================================================
public static void edit_costumer(String Username, String Pass) throws Exception {
	System.out.println("-----------------------------------------------------------------------------------------"); 
	System.out.println("                                  EDIT PROFILE                                           ");
	System.out.println("-----------------------------------------------------------------------------------------"); 
	String user=Username,pass=Pass;
	Scanner nes=new Scanner(System.in); 
	while (true) {
	
	 System.out.print("ENTER\n1. TO EDIT USER-NAME\n2. TO EDIT PASSWORD\n3. To EDIT PHONE-NUMBER");

     String option=nes.next();
     if (option.equals("1")) {
    	 
     while (true) {
    
     System.out.print("Enter Your Current User-Name: ");
     String User_Name=nes.next();
     if (User_Name.equals(Username)&& (Pass.equals(pass))){
    	 while(true) {
     System.out.print("Enter Your New User-Name: ");
     String User_Name1=nes.next();
     if (validName(User_Name1)==true) {
     Edit_customer_details("C:\\FileHandling\\Data.txt",User_Name , User_Name1);
     System.out.println("\nUSER-NAME UPDATED SUCCESSFULLY!");
     break;
     }
     else {
    	 System.out.println("INVALID USER-NAME!\n"); 
     }
     
    	 }
    	break;
     }else {
    	 System.out.println("INVALID USER-NAME!\n"); 
    	 
     }
    
    
    
     }
     break;
     
     }else if (option.equals("2")) {
    	 while (true) {
         System.out.println("Enter Your Current Password: ");
         String Password=nes.next();
         if (Password.equals(Pass) && user.equals(Username)) {
        	while (true) {
        	 System.out.println("Enter Your New Password: ");
         String Password1=nes.next();
         if (validPassword(Password1)==true) {
        	 
         
         Edit_customer_details("C:\\FileHandling\\Data.txt",Password , Password1);
         System.out.println("\nPASSWORD UPDATED SUCCESSFULLY!");
         break; 
         }else {
        	 System.out.println("Your Password Must Contain a Letter a Digit And Minimum Length 8");
        	 
         }
         
        	}
        	break;
         
     }else {
    	 System.out.println("INVALID PASSWORD!\n");
     }
         
    	 }
    	 break;
    	 
     }else if (option.equals("3")) {
    	 while (true) {
         System.out.print("Enter Your Current Phone-Number: ");
         String Phone=nes.next();
         if (user.equals(Username)&& pass.equals(Pass)) {
        
        while(true) {
         System.out.print("Enter Your New Phone Number: ");
         String Phone1=nes.next();
         if (validNumber(Phone1)==true) {
        	 Edit_customer_details("C:\\FileHandling\\Data.txt",Phone , Phone1);
             System.out.println("PHONE NUMBER UPDATED SUCCESSFULLY!");
     
        	 break;
         }else {
        	 System.out.println("Enter a Valid Phone Number!\n");
        	 
         }
         
        }
              break; 
              
         }else {
        	 System.out.println("INCORRECT PHONE-NUMBER!\n"); 
        	 
         }
         
       
     }
    	 break;
     }
     else {
    	 System.out.println("INVALID INPUT!\n"); 
    	 
     }
	}

}

public static void Edit_customer_details(String filePath, String oldString, String newString) throws Exception {
	
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
public static boolean admin_login(String username, String password) throws IOException {
	if (username.equals(adminLogin()[0])&& password.equals(adminLogin()[1])) {
		return true;
	}else {
		return false;
	}
}
public static String[] adminLogin() throws IOException {

    

	BufferedReader inputStream = new BufferedReader(new FileReader("C:\\FileHandling\\AdminData.txt")); //The BufferedReader class of Java is used to read the stream of characters from the specified source (character-input stream).
    PrintWriter outputStream = new PrintWriter(new FileOutputStream("C:\\Users\\Fahad X Raja\\Downloads\\Video\\ko.txt"));//creating instance for writing on file

	String s;
	int count=0;
	String [] data=new String[2];  //creating a array of size 2. 
	boolean bool = true; 
    //String all="";  
    
    
    
    //USERNAME
    while ((s = inputStream.readLine()) != null) {
    	 
         
    	// read  line by line file
		 char[] chars = s.toCharArray();       //store the file content in array
            
            s = new String(chars);
            //converting char array to string
            
            String [] word=s.split(":");
         
            if(word[0].equals("User_name")){
                 
                data[0]=word[1]; //user name
                
                
               
                
               
                break;
            }
            else{
                bool = false;
            }
         
        }
    
    //PASSWORD
    while ((s = inputStream.readLine()) != null) {
   	 
        
    	// read  line by line file
		 char[] chars = s.toCharArray();       //store the file content in array
            
            s = new String(chars);
            //converting char array to string
            
            String [] word=s.split(":");
         
            if(word[0].equals("Password")){
                 
                data[1]=word[1]; //password
                break;
            }
            
            else{
                bool = false;
                
            }
            
             
        }      
   return data; 
}

}
