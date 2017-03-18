/*
Jemma Tiongson
Section #16031
App: FacebookLite
Purpose: Demonstrate ability to program an application with classes, and custom constructors
-------------------------------------------------------------------------
FacebookLite is an "Archaic/Simplistic" Version of Facebook that is executed in the terminal.
It is expected to be able to store and pull data through constructors.

Driver.java is the main file of the FacebookLite

Terminal:
   Compile: "javac FacebookLite.java Driver.java"
   Run: "java Driver"
_________________________________________________________________________
*/
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Driver{
   
   public static void log(String str){
      System.out.println(str);
   }
   public static void log(String str, String input){
      System.out.println(str+ ": "+input+ "\n\tEnter new Option");
   }
   public static void log(int num, String input){
      System.out.println(num+ ": "+input+ "\n\tEnter new Option");
   }
   public static void log(boolean val, String input){
      System.out.println(val+ ": "+input+ "\n\tEnter new Option");
   }
   public static void log(String str, int input){
      System.out.println(str+ ": "+input+ "\n\tEnter new Option");
   }
   
   public static void main (String [] arg) {
      
      Scanner scan = new Scanner(System.in);
      FacebookLite fbl;
      String userName = "";
      int userAge = 0;
      boolean isUserNameValid = true;
      boolean isUserAgeValid = true;
   
      String fileName = "fblSave.txt";
      File f = new File(fileName);
      if(f.exists() && !f.isDirectory()) {
         System.out.println("Found user profile, loading it...");
         // Create a profile with some name/age
         fbl = new FacebookLite("",0);
         fbl.loadProfile(fileName);
      }
      else {
         System.out.println("Profile not found, creating a new profile...");
               
         while(isUserNameValid){
            log("Enter your name:");
            userName = scan.nextLine();
         
            if(userName.trim().isEmpty()){
               log("\tERROR: Please enter a valid name.\n");
            }
            else{
               isUserNameValid = false;
            }
         }
         
         log("Enter your age:");
         while(isUserAgeValid){
            try{
               userAge = Integer.parseInt(scan.nextLine());
               if(userAge >= 0 && userAge <= 115){
                  isUserAgeValid = false;
               }
               else{
                  log("\tInvalid Age. Enter a valid integer.");
               }
            }
            catch(NumberFormatException e){
               log("\tInvalid Age. Enter a valid integer");
               scan.reset();
            }
         }
         fbl = new FacebookLite(userName, userAge);
      }
      boolean exit = false;
      int newAge = 0;
      int opt = 0;
      String input = "";
      String post = "";
      String status = "";
      
      log("Welcome to FacebookLite -\nOptions:\n\t0: exit application\n\t1: Add a Friend\n\t2: Add Post" +
            "\n\t3: Set Age\n\t4: Set Status\n\t5: Remove Last Friend\n\t6: Remove ALL Friends\n\t7: Remove Last Post\n\t8: Remove All Posts\n\t9: Toggle Friends" +
            "\n\t10: Toggle Posts\n\t11: Toggle Age\n\t12: Toggle Status\n\t13: Print Profile");
      while (!exit){
         try{
            opt = Integer.parseInt(scan.nextLine());
         }
         catch(NumberFormatException e){
            log("Please enter a valid integer from 1 - 13.");
         }
         
         switch(opt){
            //exiting application option
            case 0:
               exit = true;
               fbl.saveProfile();
               log("Bye Bye!");
               break;
            //adding friend option
            case 1:
               boolean strTrue = true;
               while(strTrue){
                  log("Enter Friend's Name:");
                  input = scan.nextLine();
   
                  if(input.trim().isEmpty()){
                     log("\tERROR: Please enter a valid name.\n");
                  }
                  else{
                     fbl.addFriend(input);
                     log("Added", input);
                     strTrue = false;
                  }
               }
                             
               break;
            //add Post
            case 2:
               log("Enter post:");
               post = scan.nextLine();
               boolean postTrue = true;
               
               while(postTrue){
                  if(post.trim().isEmpty()){
                     log("\tERROR: Please enter a valid post.\n");
                  }
                  else{
                     fbl.addPost(post);
                     log("Post added", post);
                     postTrue = false;
                  }
               }
               break;
            //set New Age
            case 3:
               boolean age = true;
               log("Set Age:");
               while(age){
                  try{
                     newAge = Integer.parseInt(scan.nextLine());
                     if(newAge >= 0 && newAge <= 115){
                        fbl.setAge(newAge);
                        log("Age changed", newAge);
                        age = false;
                     }
                     else{
                        log("\tInvalid Age. Enter a valid integer.");
                     }
                  }
                  catch(NumberFormatException e){
                     log("Not an Integer");
                     scan.reset();
                  }
               }
               break;
            //set status
            case 4:
               boolean statTrue = true;
               while(statTrue){
                  log("Set Status:");
                  status = scan.nextLine();
      
                  if(status.trim().isEmpty()){
                     log("\tERROR: Please enter a valid status.\n");
                  }
                  else{
                     fbl.setStatus(status);
                     log("Status Set", status);
                     statTrue = false;
                  }
               }
               break;
            //removing last friend
            case 5:
               log("Removing last friend", input);
               fbl.removeLastFriend();
               break;
            //remove all friends
            case 6:
               log("Removing ALL your Friends");
               fbl.removeAllFriends();
               log("Friends: empty\n\tEnter new Option");
               break;
            //remove last post
            case 7:
               log("Removing last post", post);
               fbl.removeLastPost();
               break;
            //remove all posts
            case 8:
               log("Removing ALL your Posts");
               fbl.removeAllPosts();
               log("Posts: empty\n\tEnter new Option");
               break;
            //toggleFriends
            case 9:
               log("Changing Visibility of Friends. Please View Profile\n\tEnter new Option");
               fbl.toggleFriends();
               break;
            //togglePosts
            case 10:
               log("Changing Visibility of Posts. Please View Profile\n\tEnter new Option");
               fbl.togglePosts();
               break;
            //toggleAge
            case 11:
               log("Changing Visibility of Age. Please View Profile\n\tEnter new Option");
               fbl.toggleAge();
               break;
            //toggleStatus
            case 12:
               log("Changing Visibility of Status. Please View Profile\n\tEnter new Option");
               fbl.toggleStatus();
               break;
            case 13:
               log("----------------------------\nYour FacebookLite Profile -\n----------------------------");
               fbl.printProfile();
               log("\n\tEnter new Option");
               break;
            default:
               log("Please select between 0 - 13. \nOptions:\n\t0: exit application\n\t1: Add a Friend\n\t2: Add Post" +
                     "\n\t3: Set Age\n\t4: Set Status\n\t5: Remove Last Friend\n\t6: Remove ALL Friends\n\t7: Remove Last Post\n\t8: Remove All Posts\n\t9: Toggle Friends" +
                     "\n\t10: Toggle Posts\n\t11: Toggle Age\n\t12: Toggle Status\n\t13: Print Profile");
         }
      }
      scan.close();
   }
}