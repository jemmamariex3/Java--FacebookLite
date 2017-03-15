/*
Jemma Tiongson
Section #16031
App: FacebookLite
Purpose: Demonstrate ability to program an application with classes, and custom constructors
-------------------------------------------------------------------------
This application is an "Archaic/Simplistic" Version of Facebook that is executed in the terminal.
It is expected to be able to store and pull data through constructors.

FacebookLite is the user defined class.
Declare/Initialize an object of this class by calling the constructor and providing 2 arguments: name, age.

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

class FacebookLite{
   private String name;
   private int age;
   private String [] friends;
   private String [] posts;
   private int fidx;
   private int pidx;
   private String status;
   private boolean showFriends;
   private boolean showPosts;
   private boolean showAge;
   private boolean showStatus;
   
   //log methods
   public void log(String str){
      System.out.println(str);
   }
   public void log(String str, String input){
      System.out.println(str+ ": "+input);
   }
   public void log(int num, String input){
      System.out.println(num+ ": "+input);
   }
   public void log(boolean val, String input){
      System.out.println(val+ ": "+input);
   }
   public void log(String str, int input){
      System.out.println(str+ ": "+input);
   }
   
   //Constructor: initializing variables above
   public FacebookLite (String name, int age){
      this.name = name;
      this.age = age;
      friends = new String [5];
      posts = new String [5];
      fidx = 0;
      pidx = 0;
      status = "Update Status";
      showFriends = true;
      showPosts = true;
      showAge = true;
      showStatus = true;
      
      //Initializing friends and posts array
      for(int i =0; i<friends.length; i++){
         friends[i] = "";
      }
      for(int i = 0; i<posts.length; i++){
         posts[i] ="";
      }
   }
   
   //Adding Friend
   public void addFriend(String friendName){
      if(fidx <friends.length){
         friends[fidx] = friendName;
         fidx++;
      }
      else{
         log("Unable to add friend. Array is full.");
      }
   }
   
   //add a post
   public void addPost(String post){
      if(pidx < posts.length){
         posts[pidx] = post;
         pidx++;
      }
      else{
         log("Unable to add post. Array is full.");
      }
   }
   
   //Removing Friend
   public void removeLastFriend(){
      if(fidx > 0){
         friends[fidx-1] = "";
         fidx--;
      }
   }
   
   //removing last post
   public void removeLastPost(){
      if(pidx > 0){
         posts[pidx-1] = "";
         pidx--;
      }
   }
  
   //set age
   public void setAge(int newAge){
      this.age = newAge;
   }
   
   //set status
   public void setStatus(String newStatus){
      status = newStatus;
   }
   
   //remove all friends (for loop)
   public void removeAllFriends(){
      for(int i = 0; i<friends.length; i++){
         if(fidx > 0){
            friends[fidx-1] = "";
            fidx--;
         }
      }
   }
   
   //remove all posts (for loop)
   public void removeAllPosts(){
      for(int i = 0; i<posts.length; i++){
         if(pidx > 0){
            posts[pidx-1] = "";
            pidx--;
         }
      }
   }
   
   //toggle friends
   public void toggleFriends() {
      showFriends = !showFriends;
   }
   
   //toggle posts
   public void togglePosts() {
      showPosts = !showPosts;
   }
   
   //toggle age
   public void toggleAge() {
      showAge = !showAge;
   }
   
   //toggle status
   public void toggleStatus() {
      showStatus = !showStatus;
   }
   
   //print FacebookLite Profile
   public void printProfile(){
      log("\nName: ", name);
      if(showAge){
         log("\nAge: ", age);
      }
      if(showStatus){
         log("\nStatus: ", status);
      }
      if(showFriends){
         log("\nFriends: ", fidx);
         for(int i = 0; i < friends.length; i++){
            log(friends[i]);
         }
      }
         
      if(showPosts){
         log("\nPosts: ", pidx);
         for(int i = 0; i < posts.length; i++){
            log(posts[i]);
         }
      }
   }
   public void loadProfile(String fileName){
      String fileLine = "";
      String [] inputArr = new String[15];
      
      try {
         // Read file
         FileReader data = new FileReader(fileName);
         // Wrap FileReader with BufferedReader
         BufferedReader br = new BufferedReader(data);
         
         int tmpIdx=0;
         while((fileLine = br.readLine()) != null) {
            System.out.println(fileLine);
            
         }
      
         // close the file
         br.close();
      }
      catch(FileNotFoundException ex) {
         System.out.println("File not found: " + fileName);
      }
      catch(IOException ex) {
         System.out.println("Error reading file: " + fileName);
      }
      
      name = inputArr[0];
      age = Integer.parseInt(inputArr[1]);
      status = inputArr[2];
      fidx = Integer.parseInt(inputArr[3]);
      for(int i = 0; i < fidx; i++){
         friends[i] = inputArr[4+i];
      }
      pidx= Integer.parseInt(inputArr[4+fidx]);
      for(int i =0; i<pidx; i++){
         posts[i] = inputArr[5+i];
      }
   
   }
   public void saveProfile(){
      String fileName = "fblSave.txt";
   
      try {
         File file = new File(fileName);
         // creates the file
         file.createNewFile();
         // create FileWriter object
         FileWriter writer = new FileWriter(file);
         // output to file
         writer.write(name +"\n");
         writer.write(age +"\n");
         writer.write(status +"\n");
         writer.write(fidx+ "\n");
         
         //loop to print out friend for text file
         for(int i = 0; i < fidx; i++){
            writer.write(friends[i]+ "\n");
         }
         
         writer.write(pidx+ "\n");
   
         for(int i = 0; i < pidx; i++){
            writer.write(posts[i]+ "\n");
         }
         
         writer.flush();
         writer.close();
      }
      catch(IOException ex) {
         System.out.println("Error writing to file: " + fileName);
      }
   
   }
}