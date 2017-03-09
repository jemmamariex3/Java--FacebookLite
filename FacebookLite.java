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
}