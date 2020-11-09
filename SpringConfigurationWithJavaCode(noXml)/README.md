# Spring Configuration with Java Code

> So instead of configuring our container using XML, instead what we're gonna do is make use of Java source code to configure the container.

## Java Configuration

- Instead of configuring Spring container using XML
- Configure the Spring container with Java code.

### Just for reminder there are 3 ways to configure Spring Container

1. Full XML config
2. XML Component Scan
3. Java Configuration Class

********
********

# Development Process

1. Create a Java class and annotate as **@Configuration**
2. Add component scanning support: **@ComponentScan** (optional)
3. Read Spring Java configuration class
4. Retrieve bean from Spring container

## Step 1: Create a Java class and annotate as @Configuration

 ```Java
    @Configuration
    public class SportConfig {
        ...
    }
 ```

## Step 2: Add component scanning support: @ComponentScan

 ```Java
    @Configuration
    @ComponentScan("package name")
    public class SportConfig {
        ...
    }
 ```

## Step 3: Read Spring Java configuration class

 ```Java
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
 ```

## Step 4: Retrieve bean from Spring Container

 ```Java
    Coach theCoach = context.getBean("tennisCoach", Coach.class);
 ```

********
********

# Define Beans in Spring with Java Code

- we can define bean using XML config, so we will list each bean out seprately in the XML file.

- We can also use Java Configuration Classes to define bean.

#### Our new Coach

 ```Java
    public class SwimCoach implements Coach {
        ...
    }
 ```

## Development Process

1. Define method to expose bean
2. Inject bean dependecies
3. Read Spring Java configuration class
4. Retrieve bean from Spring container

### Step 1: Define method to expose bean

> We're going to use new annotation **@Bean**

 ```Java
    @Configuration
    public class SportConfig {
        @Bean
        public Coach swimCoach() {
            SwimCoach mySwimCoach = new SwimCoach();
            return mySwimCoach;
        }
    }
 ```

#### What about our dependencies

 > How we will inject dependecies but, because we know that Coach needs FortuneService, So how will we do that?

### Step 2: Inject bean dependencies

 ```Java
    @Configuration
    public class SportConfig {
        @Bean
        public FortuneService happyFortuneService() {
            return new HappyFortuneService();
        }
        @Bean
        public Coach swimCoach() {
            SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
            return mySwimCoach;
        }
    }
 ```

 > To actually inject the bean dependencies, we make use of this @Bean, and we define the bean here with happyFortuneService. So again, I'll create another method here called **happyFortuneService** that returns a new instance of ***HappyFortuneService*** class. Now the bean method here **happyFortuneService** that's the actual bean ID that spring will use when they register this bean with the application context. Then we simply use that later on when we create the SwimCoach, new SwimCoach so here we pass in **happyFortuneService**.

### Step 3: Read Spring Java configuration class

 ```Java
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
 ```

### Step 4: Retrieve bean from Spring Container

 ```Java
    Coach theCoach = context.getBean("swimCoach", Coach.class);
 ```

********
********

# Inject Values from Properties File

> So we will make use of SwimCoach and we will use also use a properties file this properties file is going to have the email address, and a team. And we want to read information from this properties file and inject it into our Swim Coach to make use of.

## Development Process

1. Create Properties File
2. Load Properties File in Spring config
3. Reference values from Properties File.

### Step 1: Create Properties File

***File: sport.properties***

 ```Properties
    foo.email=myeasycoach@leftyyyy.com
    foo.team=Awesome Java Coders
 ```

### Step 2: Load Properties File in Spring Config

***File: SportConfig.java***

 ```Java
    @Configuration
    @PropertySource("classpath:sport.properties")
    public class SportConfig {
        ...
    }
 ```

### Step 3: Reference Values from Properties File

***File: SwimCoach.java***

 ```Java
    public class SwimCoach implements Coach {
        @Value("${foo.email}")
        private String email;

        @Value("${foo.team}")
        private String team;
        ...
    }
 ```
