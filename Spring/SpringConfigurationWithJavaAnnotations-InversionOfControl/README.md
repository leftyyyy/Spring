# Spring Configuration with Annotations

## What are Java Anootations

- Special labels/markers added to Java classes.
- **Provide meta-deta about the class.**
- Processed at compile time or run-time for special processing.

### Annotation Example

- We've seen annotations already

    ```Java
        public class TrackCoach implements Coach {
            //this override is annotation
            /*
                it tells compiler that we're gonna implement the iterface or extend the class and we're going to override the method.

                Now at the compilation time, the compiler will check your class and make sure that we really are overriding the method.
            */
            @Override
            public String getDailyWorkout(){
                return "Run a hard 5K";
            }
            ...
        }
    ```

# Why spring Configuration with Annotations

- XML configuration can be verbose.
  * Imagine a scenario where you have spring project and you have 30 beans or maybe 100 beans, you'd have to list each one of those in your XML config file, and that would just take a lot of time and can be very verbose, or a lot of work.
- Configure your Spring beans with Annotations.
- Annotations minimizes the XML configuration.

> How this works?

## Scanning for Component Classes

- Spring will scan your Java classes for special annotations.
- Automatically register the beans in the Spring container.

## Development Process

1. Enable component scanning in Spring config file.
2. Add the @Component Annotation to your Java classes.
3. Retrieve bean from Spring container.

### Step 1: Enable Component scanning in Spring config file

 ```Xml
    <beans ... >
        <context: component-scan base-package="package name" />
    </beans>
 ```

### Step 2: Add the ***@Component*** Annotation to your Java classes

 ```Java
    //thatSillyCoach is the bean id
    //it can be anything
    @Component("thatSillyCoach")
    public class TennisCoach implements Coach {
        @Override
        public String getDailyWorkout(){
            return "Practice your backhand volley";
        }
        ...
    }
 ```

### Step 3: Retrieve bean from Spring Container

- Same coding as before...nothing changes.

 ```Java
    Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
 ```

## Default Component Name

> We've learned how to specify bean id in the component annotation.

- Spring also supports Default Bean IDs
  * Default bean id: the class name, ***make first letter lower-case***
  * **TennisCoach** (class name) => ***tennisCoach*** (default bean id)
  * Code example

        ```Java
            @Component
            public class TennisCoach implements Coach {
                ...
            }
        ```

        > get the bean from Spring Container

        ```Java
            Coach theCoach = context.getBean("tennisCoach", Coach.class);
            //inside getBean, i'm giving default bean id
        ```
