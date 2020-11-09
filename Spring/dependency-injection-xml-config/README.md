# Spring Dependency Injection (XML configuration)

   ![dp_ixml](images/dpixml_01.jpg)

   > Let's understand this with a example.
   > Say we're going to buy a car, and this car is built at the factory on demand.
   > So there's nothing in the car lot, we have to talk to the factory and put in a request and they'll build a car for us.
   > So at the factory we have all the different parts for the car. (enginer, tire, seat, etc.)
   > And technicians will assemble the car for us and deliver us the final car.
   > **so they actually inject *dependency* for the car**.
   > So that's basically what is dependency injection.

   **we simply out source the construction and injection of your object to an external entity.**
     in this case that's the car factory.

   **How this works in Spring world?**
   > Remeber spring has an Object factory.
   > So when we retrieve an Object like Coach object, this coach object mayhave some additional dependencies.
   > So these dependencies are really just helper objects, Ohter objects that it needs to perform it's operation.
   > So instead of developer having manually build the coach object and all it's dependencies the spring framework or the spring factory will actually do this.
   > So just like the car that's ready to drive, here we get an Object that's ready to use.

   ![dp_ixml](images/dpixml_02.png)

   **Demo Example**
      *Our Coach already provides daily workouts
      * Now will also provide daily fortunes
         *New helper: FortuneService
         * This is a *dependency*

## Injection Types

* There are many types of injection with Spring.
* Most two common are
  *Constructor Injection
  * Setter Injection
  * auto-wiring

### Developement Process - Constructor Injection

   1. Define the dependency interface and class
   2. Create a constructor in your class for injections
   3. Configre the dependency injection in Spring config file.

#### Step 1: Define the dependency inferface and class**

   ***FortuneService.java***

   ```Java
      public interface FortuneService {
         public String getFortune();
      }
   ```

   ***HappyFortuneService.java***

   ```Java
      public class HappyFortuneService implements FortuneService {
         public String getFortune(){
            return "Today is your lucly day!";
         }
      }
   ```

#### Step 2: Create a constructor in your class for injections**

   ***BaseballCoach.java***

   ```Java
      public class BaseballCoach implements Coach {
         private FortuneService fortuneService;

         public BaseballCoach(FortuneService theFortuneService){
            fortuneService = theFortuneService;
         }
         ...
      }
   ```

#### Step 3: Configure the dependency injection in Spring config file**

   ***applicationContext.xml***

   ```Xml
      <bean id="myFortuneService"
         class="fully qualified class name">
      </bean>
      <bean id="myCoach"
         class="fully qualified class name">
            <constructor-arg ref="myFortuneService" />
      </bean>
   ```

### How Spring Processes your Config File (Constructor Injection)

   ***applicationContext.xml***

   ```Xml
      <bean id="myFortuneService"
         class="full qualified class name">
      </bean>
      <bean id="myCoach"
         class="full qualified class name">
            <constructor-arg ref="myFortuneService" />
      </bean>
   ```

   > The Spring Framework will perform operations behind the scenes for you.
   ***Based on above config file Spring Framework will do this work***

   ```Java
      HappyFortuneService myFortuneService = new HappyFortuneService();
      BaseballCoach myCoach = new BaseballCoach(myFortuneService);
   ```

   ![dp_ixml](images/dpixml_03.jpg)

### Setter Injection (Development Process)

   1. Create setter method(s) in your class for injections.
   2. Configure the dependency injection in Spring config file.

#### Step 1: Create setter method(s) in your class for injections

   ***CricketCoach.java***

   ```Java
      public class CricketCoach implements  Coach {
         private FortuneService fortuneService;

         //no arg constructor
         public CricketCoach(){

         }

         //setter method for setter injection
         public void setFortuneService(FortuneService fortuneService){
            this.fortuneService = fortuneService;
         }
      }
   ```

   ***applicationContext.xml***

   ```Xml
      <bean id="myFortuneService"
         class="fully qualified class name">
      </bean>

      <bean id="myCricketCoach"
         class="fully qualified class name">

         <!-- set up setter injection -->
         <property name="fortuneService" ref="myFortuneService" />
      </bean>
   ```

   ![dp_ixml](images/dpixml_04.jpg)
   ![dp_ixml](images/dpixml_05.jpg)

##### **Injecting Literal Values**

   > So, currently we have our CricketCoach.
   > We've learned how to inject a FortuneService to our CricketCoach.
   > But now we'd like to inject some literal values like some string values.
   > So, I'd like to inject the actual *email* address for the coach, and the actual team name for the coach.

   ![dp_ixml](images/dpixml_06.jpg)

###### Development Process for this

   1. Create Setter method(s) in your class for injections.
   2. Configure the injection in Spring config file.

   **Step 1: Create setter method(s) in your class**
   
   ***CricketCoach.java***

   ```Java
      public class CricketCoach implements Coach {
         private String emailAddress;
         private String team;

         public void setEmailAddress(String emailAddress) ...

         public void setTeam(String team) ...

         ...
      }
   ```

   **Step 2: Configure the injection in Spring config file**

   ***applicationContext.xml***

   ```Xml
      <bean id="myCricketCoach"
         class="fully qualified class name">
         <!-- Set up setter injection -->
         <property name="fortuneService" ref="myFortuneService" />

         <!-- inject literal values -->
         <property name="emailAddress" value="theBestcoach@abk.com" />

         <property name="team" value="Sunrisers Hydrabad" />
      </bean>
   ```

##### Injecting Literal Values using Property files

   > Previously we learned about Injecting Literal values.
   > The only problem is that those values were hard coded in the config file.
   > And what we like to do is read this information from our properties file.
   > So we'll have a external properties file and we'll have our values there and then we'll be able to read the email address and team name from this properties file.

   ![dp_ixml](images/dpixml_07.jpg)

###### Developement process for injecting literal values using Property file

   1. Create Properties File.
   2. Load Properties File in Spring config file.
   3. Reference values from Properties File.

   **Step 1: Create Properties File**

   ***sport.properties***

   ```Properties
      foo.email=abk.abk@abk.abk
      foo.team=ah be ke
   ```

   **Step 2: Load Properties file in Spring config file**

   ***applicationContext.xml***

   ```Xml
      <context:property-placeholder location="classpath:sport.properties" />
   ```

   **Step 3: Reference Values from Properties File**

   ***applicationContext.xml***

   ![dp_ixml](images/dpixml_08.jpg)
