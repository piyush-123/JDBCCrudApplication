package in.piyush.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.piyush.controller.IstudentController;
import in.piyush.dto.Student;
import in.piyush.factory.StudentControllerFactory;

public class main {

	public static void main(String[] args) {
		
		while(true) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String status = null;
			
			System.out.println("1. INSERT");
			System.out.println("2. SELECT");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			System.out.print("Enter your option 1,2,3,4,5 :: ");
			Integer id;
			IstudentController studentController = StudentControllerFactory.getStudentControllerInstance();
			
			try {
				Integer option = Integer.parseInt(br.readLine());
				
				switch(option) {
				
				case 1:
					
					
					System.out.print("Enter the student id :: ");
					Integer sid = Integer.parseInt(br.readLine());
					
					System.out.print("Enter the student age :: ");
					Integer sage = Integer.parseInt(br.readLine());
					
					
					
					System.out.print("Enter the student name :: ");
					String sname = br.readLine();
					
					System.out.print("Enter the student address :: ");
					String saddr = br.readLine();
					
					Student st = new Student();
					st.setSaddr(saddr);
					
					st.setSid(sid);
					st.setSage(sage);
					st.setSname(sname);
					
					
					status = studentController.save(st);
					
					if (status.equalsIgnoreCase("success"))
					{
						System.out.println("Record inserted successfully");
					}
					
					else if (status.equalsIgnoreCase("failure"))
					{
						System.out.println("Record insertion failed");
					} 
					
					else
					{
						System.out.println("Some Problem Occurred...");
					}
					break;
					
				case 2:
					
					System.out.print("Enter the student id :: ");
					id = Integer.parseInt(br.readLine());
					Student studentrecord = studentController.findById(id);
					if(studentrecord != null) {
					System.out.println("Student details are :: " + studentrecord);
					}
					else
					{
						System.out.println("Student details are not present for id :: "+ id);
					}
					
					break;
					
				case 3:
					System.out.print("Enter the student id :: ");
					Integer new_age_int;
					id = Integer.parseInt(br.readLine());
					Student studentrecord2 = new Student();
					Student studentrecord1 = studentController.findById(id);
					
					if(studentrecord1 != null) {

						System.out.print("OldName of student is :: " + studentrecord1.getSname()); 
						String new_name = br.readLine();
						
						if ( new_name == null || new_name.equals("") )
						{
							studentrecord2.setSname(studentrecord1.getSname());
						}
						else
						{
							studentrecord2.setSname(new_name);
						}
						System.out.print("Age of student is :: " + studentrecord1.getSage()); 
						String new_age = br.readLine();
						
						if (new_age.equals("") || new_age == null) { 
							new_age_int = 0 ;	
						}
						else
						{ 
							
							new_age_int = Integer.parseInt(new_age);
						}
						if ( new_age_int == 0 )
						{
							studentrecord2.setSage(studentrecord1.getSage());
						}
						else
						{
							studentrecord2.setSage(new_age_int);
						}
						System.out.print("OldAddr of student is :: " + studentrecord1.getSaddr()); 
						String new_addr = br.readLine();
						
						if ( new_addr == null || new_addr.equals("") )
						{
							studentrecord2.setSaddr(studentrecord1.getSaddr());
						}
						else
						{
							studentrecord2.setSaddr(new_addr);
						}
						
						studentrecord2.setSid(studentrecord1.getSid());
						
						System.out.println(studentrecord2);
						
						status = studentController.updateById(studentrecord2);
						
						if (status.equalsIgnoreCase("success"))
						{
							System.out.println("Record updated successfully");
						}
						
						else if (status.equalsIgnoreCase("failure"))
						{
							System.out.println("Record updation failed");
						} 
						
						else
						{
							System.out.println("Some Problem Occurred...");
						}
						
					}
					
					else
					{
						System.out.println("Record is not present for id :: " + id);
					}
					
							
							break;
					
				case 4:
					System.out.println("Enter the student id :: ");
					id = Integer.parseInt(br.readLine());
					status = studentController.deleteById(id);
					
					if (status.equalsIgnoreCase("success"))
					{
						System.out.println("Record deleted successfully");
					}
					
					else if (status.equalsIgnoreCase("failure"))
					{
						System.out.println("Record deletion failed");
					} 
					
					else
					{
						System.out.println("Some Problem Occurred...");
					}
					
					break;
					
				case 5:
					System.out.println("Thanks for using the app");
					System.exit(0);
				default:
					System.out.println("Please Enter options 1,2,3,4,5");
					break;
					
				}
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}

}
