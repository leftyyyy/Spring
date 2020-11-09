# Spring Dependency Injection with Annotations and Autowiring

## Injection Types with annotations

1. Constructor Injection
2. Setter Injection
3. Field Injection

###### Demp Example

- Our coach already provides daily workouts.
- Now will also provide daily fortunes.
  - New helper: **FortuneService**
  - This is a ***dependency***

> We know how to this, but we're going to do this with annotations and autowiring.

## What is Spring AutoWiring

- For dependency injection, Spring can use auto wiring.
- Spring will look for a class that *matches* the property.
  - *mataches by types:* **class** or **interface**
- Spring will inject it automatically ... hence it is autowired.

### Autowiring Example

- Injecting FortuneService into a Coach implementation.
- Spring will scan @Components.
- Any one implements FortuneService interface???
- If so, let's inject them. For example: *HappyFortuneService*

#### Autowiring Injection Types

- Constructor Injection
- Setter Injection
- Field Injection

## Development Process (Constructor Injection with Annotations and autowiring)

1. Define the dependency interface and class.
2. Create a constructor in your class for injections.
3. Configure the dependency injection with **@Autowired** Annotation.

### Step 1: Define the dependency interface and class

***File: FortuneService.java***

 ```Java
    public interface FortuneService {
        public String getFortune();
    }
 ```

***File: HappyFortuneService.java***

 ```Java
    @Component
    public class HappyFortuneService implements FortuneService {
        public String getFortune() {
            return "Today is your lucky day!";
        }
    }
 ```

### Step 2: Create a constructor in your class for injections

***File: TennisCoach.java***

 ```Java
    @Component
    public class TennisCoach implements Coach {
        private FortuneService fortuneService;
        //constructor for injection
        public TennisCoach(FortuneService theFortuneService) {
            fortuneService = theFortuneService;
        }
        ...
    }
 ```

### Step 3: Configure the dependency injection with **@Autowired** Annotation

***File: TennisCoach.java***

 ```Java
    @Component
    public class TennisCoach implements Coach {
        private FortuneService fortuneService;

        //configuring DI with Autowired annotation
        @Autowired
        public TennisCoach(FortuneService theFortuneService) {
            fortuneService = theFortuneService;
        }
        ...
    }
 ```

> What happends in the background is, Spring will say that I need to satisfy this dependency. So spring will again, it will scan all the components there and it will find the component that implements this FortuneService interface, which in our case is HappyFortuneService. And it will take that bean, actually inject it or Autowire it here into this TennisCoach.

***********

> So that's how they handle the dependency injection using Autowired Annotation.

***********
***********

# Setter Injection with Annotations and Autowiring

> Inject dependencies by calling setter method(s) on your class.

## Autowiring Example

- Inject FortuneService into a Coach implementation.
- Spring will scan @Components and will see
  - Any one implements FortuneService interface??
  - If so, let's inject them. For example: HappyFortuneService

## Developement Process - Setter Injection

1. Create setter method (s) in your class for injections.
2. Configure the dependency injection with @Autowired Annotation.

### Step 1: Create setter method(s) in your class for injections

***File: TennisCoach.java***

 ```Java
    @Component
    public class TennisCoach implements Coach {
        private FortuneService fortuneService;
        //createing default constructor
        public TennisCoach(){

        }
        //creating setter for injection
        public void setFortuneService(FortuneService fortuneService) {
            this.fortuneService = fortuneService;
        }
        ...
    }
 ```

### Step 2: Configure the dependency injection with Autowired Annotation

***File: TennisCoach.java***

 ```Java
    @Component
    public class TennisCoach implements Coach {
        private FortuneService fortuneService;

        public TennisCoach(){

        }

        @Autowired
        public void setFortuneService(FortuneService fortuneService) {
            this.fortuneService = fortuneService;
        }
        ...
    }
 ```

***********
***********

# Field Injection with Annotations and Autowiring

> Inject dependencies by setting field values on your class directly. (even private fields)
***********
> Accomplished by using ***Java Reflection***

## Development Process - Field Injection

1. Configure the dependency injection with Autowired Annotation
   - Applied directly to the field
   - No need for setter methods

### Step 1: Configure the dependency injection with Autowired Annotation

***File: TennisCoach.java***

 ```Java
    public class TennisCoach implements Coach {
        //placing autowired annotation directly on the field
        @Autowired
        private FortuneService fortuneService;
        public TennisCoach() {

        }
        // no need for setter methods
        ...
    }
 ```

***********
***********

# Annotation Autowiring and Qualifiers

> So far in the autowiring

- Injecting FortuneService into a Coach implementation
- Spring will scan @Components
- Any one implements FortuneService interface?
- if so, let's inject them ... ***oops which one?***

> So far we've been using autowiring where Spring will basically scan for components and it will ask, hey does anyone implement a given FortuneService interface? But what happends if there's multiple implementations out there? Will it pick the first one it finds basically what's up with that?

***********

> So if we have multiple FortuneService implementations like HappyFortuneService, RandomFortuneService, DatabaseFortuneService, RESTFortuneService, etc.

***********

> We if this is the case, Spring will throw an error, Spring will say expected single matching bean but found multiple.
***********
> So to resolve this we need to specifity or basically tell Spring which bean to use.

 ***Solution: Be specific! - @Qualifier***

 ```Java
    @Component
    public class TennisCoach implements Coach {
        @Autowired
        @Qualifier("happyFortuneService")
        private FortuneService fortuneService;
        ...
    }
 ```

> Note: in this case we're using @Component and we're using default name for the component so, default Bean id will be **happyFortuneService**

##### We can use this **@Qualifier** with Constructor injection, Setter injection and Field Injection
