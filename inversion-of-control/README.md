# Inversion of Control (IoC)
  What exactly is **Ioc** ?
  > It is simply the design process of externalizing, the construction and management of your objects.
  > *In a nutshell* It basically says, **that your application is gonna outsource the creation and management of objects. And this outsourcing will be handled by a object factory, and that's the big idea of INVERSION OF CONTROL**.

  ###### Coding Scenario
   > We're creating a app that will make use of a Coach, like a baseball Coach and this Coach should be able to give us DailyWorkOut method.
   > App should be configurable means this app should easily work for Coach of another Sport like Hockey, Cricket, Tennis, etc.
   
   ![IoC coding scenario](images/IoC_01.jpg)
  
  ###### Code demo (Rough prototype)
   * **MyApp.java** main method
   * **BaseballCoach.java**
   * **Coach.java** interface after refactoring
   * **TrackCoach.java**
   
   **BaseballCoach.java**
   ```Java
      public class BaseballCoach implements Coach{
        @Override
        public String getDailyWorkOut(){
          return "practice batting";
        }
      }
   ```
    
   **MyApp.java**
   ```Java
      public class MyApp.java{
        public static void main(String[] args){
          //Create the object
          Coach theCoach = new BaseballCoach();
          Coach trackCoach = new TrackCoach();
          
          //use the object
          System.out.println(theCoach.getDailyWorkOut());
        }
      }
   ```
   
  **Coach.java**
  ```Java
      public interface Coach {
        public String getDailyWorkOut();
      }
  ```
  
  **TrackCoach.java**
  ```Java
     public class TrackCoach implements Coach{
        @Override
        public String getDailyWorkOut(){
            return "run 5 KM";
        }
     }
  ```
