package com.simplilearn.project1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;

public class Test {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		//displaying the application and the developer details
		System.out.println("LockedMe.com");
		System.out.println("Developed By: Varnit Bhaskar");
		System.out.println("Contact Me: bhaskarvarnit4@gmail.com");
		System.out.println("-------------------------------------");
		
		File folder=null;
		String path="C:\\Users\\LENOVO\\OneDrive\\Desktop\\Project-1\\main";
		while(true){
			try {
				folder = new File(path);
		        folder.mkdirs(); // Created a Directory named Project-1 and inside it created a main folder
			}catch(Exception e) {
				e.printStackTrace();
			}

            System.out.println("----------Prototype of the Application LockedMe.com----------  \n");
            System.out.println("-----The following functions are :- -----  \n");
            System.out.println("1. Display the files in ascending order\n");
            System.out.println("2. Some User Enabled Operations  \n");
            System.out.println("3. Terminate the Program");
            System.out.println("-----What option do you want to choose?---- \n");

            int choice = sc.nextInt();
			switch(choice)
            {
                case 1:

                    String arr[] = folder.list();
                    if(arr.length>0) {
                    	Arrays.sort(arr);
                    	for(int i=0;i<arr.length;i++) {
                    		System.out.println(arr[i]);
                    	}
                    }            
                    else {
                    	System.out.println("Files Not Found");
                    }
                    break;


                case 2:
                    Boolean temp = true;
                    while(temp) {
                        System.out.println("Option-1: Add a file in the existing Directory");
                        System.out.println("Option-2: To Delete a file from the existing Directory. ");
                        System.out.println("Option-3: Search a user specified file from the Directory");
                        System.out.println("Option-4: Navigate back to the previous menu");
                        System.out.println("Option-5: Terminate the Program");


                        int choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                System.out.println("Enter a file name");
                                String name = sc.next();
                                if(new File(folder,name).exists()){
                                    System.out.println("File already exists in the directory");
                                }else {
                                	try {
                                    File file1 = new File(folder, name);
                                    file1.createNewFile();
                                    if (new File(folder, name).exists()) {
                                        System.out.println("File added successfully");
                                    }
                                	}catch(Exception e) {
                                		e.printStackTrace();
                                	}
                                }

                                break;


                            case 2:
                                System.out.println("Enter a file name");
                                String name1 = sc.next();
                                File fileExists = new File(folder, name1);
                                //System.out.println(fileExists.getName());
                                
							try {
								if (fileExists.exists() && fileExists.getCanonicalFile().getName().equals(fileExists.getName()
										)) {
                           
                                  fileExists.delete();
                                  System.out.println("File successfully deleted from the directory");
                                } else {
                                    System.out.println("File does not exist");
                                }
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                                break;


                            case 3:
                                System.out.println("Enter the keyword to search a file");
                                String search = sc.next();
                                
                                boolean flag=false;
                                int a;

                                String arr1[] = folder.list();
                                for(a=0;a<arr1.length;a++){
                                   if(arr1[a].startsWith(search)) {
                                	   flag=true;
                                   }
                                }
                                if(flag) {
                                	System.out.println("File Found Successfully");
                                }
                                else {
                                	System.out.println("File Not Found");
                                }
                                break;

                            case 4:

                                temp = false;
                                break;

                            case 5:

                                System.out.println("---------Program Terminated Successfully---------");
                                System.exit(0);
                            default:
                                System.out.println("Input correct value and retry");

                        }

                    }
                    break;

                case 3:
                    System.out.println("---------Program Terminated Successfully---------");
                    System.exit(0);

                default:
                    System.out.println("Input correct value and retry");
                    break;

            }

	}

}
}
