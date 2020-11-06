# Bean Scope

- Scope refers to the lifecyle of a bean.
- How long does the bean live?
- How many instances are created?
- How is the bean shared?

> Default Scope: Singleton

```Xml
    <beans ... >
        <bean id="myCoach"
            class="full qualified class name">
            ...
        </bean>
    </beans>
```

> What is a singleton? **

- Spring Container creates only one instance of the bean, by default.
- It is cached in memory.
- All requests for the bean will return a SHARED reference to the SAME bean.
