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

import java.util.Scanner;
class Driver{
   public static void main (String [] arg){
      Scanner scan = new Scanner(System.in);
      FacebookLite fbl = new FacebookLite("Jemma", 22);
      boolean exit = false;
      int newAge = 0;
      int opt = 0;
      String input = "";
      String post = "";
      String status = "";
      
      System.out.println("Welcome to FacebookLite -\nOptions:\n\t0: exit application\n\t1: Add a Friend\n\t2: Add Post" +
            "\n\t3: Set Age\n\t4: Set Status\n\t5: Remove Last Friend\n\t6: Remove ALL Friends\n\t7: Remove Last Post\n\t8: Remove All Posts\n\t9: Toggle Friends" +
            "\n\t10: Toggle Posts\n\t11: Toggle Age\n\t12: Toggle Status\n\t13: Print Profile");
      while (!exit){
         opt = Integer.parseInt(scan.nextLine());
         
         switch(opt){
            //exiting application option
            case 0:
               exit = true;
               System.out.println("Bye Bye!");
               break;
            //adding friend option
            case 1:
               System.out.println("Enter Name:");
               input = scan.nextLine();
               fbl.addFriend(input);
               System.out.println("Added: " +input+ "\n\tEnter new Option");
               break;
            //add Post
            case 2:
               System.out.println("Enter post:");
               post = scan.nextLine();
               fbl.addPost(post);
               System.out.println("Post added: " +post+ "\n\tEnter new Option");
               break;
            //set New Age
            case 3:
               System.out.println("Set Age:");
               newAge = Integer.parseInt(scan.nextLine());
               fbl.setAge(newAge);
               System.out.println("Age changed: " +newAge+ "\n\tEnter new Option");
               break;
            //set status
            case 4:
               System.out.println("Set Status:");
               status = scan.nextLine();
               fbl.setStatus(status);
               System.out.println("Status Set: " +status+ "\n\tEnter new Option");
               break;
            //removing last friend
            case 5:
               System.out.println("Removing last friend: " +input+ "\n\tEnter new Option");
               fbl.removeLastFriend();
               input = "";
               break;
            //remove all friends
            case 6:
               System.out.println("Removing ALL Your Friends");
               fbl.removeAllFriends();
               System.out.println("Friends: empty\n\tEnter new Option");
               break;
            //remove last post
            case 7:
               System.out.println("Removing last post: " +post+ "\n\tEnter new Option");
               fbl.removeLastPost();
               post = "";
               break;
            //remove all posts
            case 8:
               System.out.println("Removing ALL Your Posts");
               fbl.removeAllPosts();
               System.out.println("Posts: empty\n\tEnter new Option");
               break;
            //toggleFriends
            case 9:
               System.out.println("Changing Visibility of Friends. Please View Profile\n\tEnter new Option");
               fbl.toggleFriends();
               break;
            //togglePosts
            case 10:
               System.out.println("Changing Visibility of Posts. Please View Profile\n\tEnter new Option");
               fbl.togglePosts();
               break;
            //toggleAge
            case 11:
               System.out.println("Changing Visibility of Age. Please View Profile\n\tEnter new Option");
               fbl.toggleAge();
               break;
            //toggleStatus
            case 12:
               System.out.println("Changing Visibility of Status. Please View Profile\n\tEnter new Option");
               fbl.toggleStatus();
               break;
            case 13:
               System.out.println("----------------------------\nYour FacebookLite Profile -\n----------------------------");
               fbl.printProfile();
               System.out.println("\n\tEnter new Option");
               break;
            default:
               System.out.println("Please select between 0 - 13. \nOptions:\n\t0: exit application\n\t1: Add a Friend\n\t2: Add Post" +
                     "\n\t3: Set Age\n\t4: Set Status\n\t5: Remove Last Friend\n\t6: Remove ALL Friends\n\t7: Remove Last Post\n\t8: Remove All Posts\n\t9: Toggle Friends" +
                     "\n\t10: Toggle Posts\n\t11: Toggle Age\n\t12: Toggle Status\n\t13: Print Profile");
         }
      }
      scan.close();
   }
}