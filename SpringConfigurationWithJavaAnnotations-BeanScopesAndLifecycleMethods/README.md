# Bean Scopes with Annotations

## Explicitly Specify Bean Scope

 ```Java
    @Component
    @Scope("singleton")
    public class TennisCoach implements Coach {
        ...
    }
 ```

********
********

# Bean Lifecycle Methods - Annotations

## Development Process

1. Define your methods for init and destroy.
2. Add annotations: @PostConstruct and @PreDestroy

## Init: Method configuration

 ```Java
    @Component
    public class TennisCoach implements Coach {
        @PostConstruct
        public void doMyStartupStuff() { ... }
        ...
    }
 ```

## Destroy: Method configuration

 ```Java
    @Component
    public class TennisCoach implements Coach {
        @PreDestroy
        public void doMyCleanupStuff() { ... }
        ...
    }
 ```
