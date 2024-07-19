<div style="text-align: center;">

## Auto wiring

</div>

### Types : 

          -byName 
          -byType
          -constructor

####  Auto-wiring byName :

- Spring will look for beans with same name (eg: specification) as the dependencies (attributes) of the (Car) class and inject those dependencies. <br>
```xml
<bean id="specification" class="autowire.example.name.Specification">
        <property name="make" value="Toyota" />
        <property name="model" value="corolla" />
</bean>

<bean id="myCar" class="autowire.example.name.Car" autowire="byName" />
```

- When we use auto-wiring byName, properties of a bean are set with help of `setter` methods, program wont compile if not setters are prsent for the denpendencies. 

<hr> 

#### Auto-wiring byType : 

- Spring will look for beans with same type (eg: Specification) as the dependencies (attributes) of the (Car) class and inject those dependencies.

```xml
<bean id="specification" class="autowire.example.name.Specification">
        <property name="make" value="Toyota" />
        <property name="model" value="corolla" />
</bean>

<bean id="myCar" class="autowire.example.name.Car" autowire="byType" />
```

- If there are more than one bean with same type (Specification), there must be qualifier or a primary bean inorder to differentiate between them.

<hr>

#### Auto-wiring by constructor : 

- Spring will look for beans with same type (eg: Specification) as the dependencies (attributes) of the (Car) class and inject those dependencies.

```xml
<bean id="specification" class="autowire.example.constructor.Specification">
        <property name="make" value="Toyota" />
        <property name="model" value="corolla" />
    </bean>

    <bean id="myCar" class="autowire.example.constructor.Car" autowire="constructor" />
```

- Inorder to autowire by constructor the dependent class must have a constructor.

<hr>

<div style="text-align: center;">

## Components

</div>

- Components refers to java class that is managed by the spring IOC container.
- Components is a special type of bean that is design to be autodetect during scanning.

- Two ways to create components : (a) using XML, (b) using annotations.


<!-- later add examples of annotations -->
<hr>
<div style="text-align: center;">

## Component Scanning : 

</div>
- is the feature that helps to automatically detect and register beans from predefined package paths.

- Enable component scanning using XML: 
```xml
    <!-- Enable component scanning -->
    <context:component-scan base-package="com.example.componentscan" />
```

- All the classes in the defined package will be scanned and register as bean (including the classes in the sub-package).

<hr>

<div style="text-align: center;">

## Annotations

</div>
- Annotations are tags that are used to add metadata to our code.
- Simply put we specify some additional info about our source code, this metadata can be used by compliers, runtime envs, etc.

<hr> 

### `@Component` Annotation

Employee.java : 
```java
@Component("majdur")
public class Employee {
    // class members
}
```

App.java : 
```java
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("componentScanDemo.xml");

        //second arg is used to avoid type-casting of employee obj
        Employee employee = context.getBean("majdur", Employee.class);

        System.out.println(employee.toString());
    }
}
```

- By default the component scan process will create a bean of Employee.java class with name `"employee"`
if not specified otherwise `"majdur"`

<hr>

### `@Value` Annotaion

Employee.java : 

```java
@Component("employee")
public class Employee {

    @Value("121013")
    private int id;

    @Value("${firstName}")
    private String firstName;

    // we can use `${}` for variable injection
    @Value("${lastName}")
    private String lastName;

    // we can use `#{}` for calculating expression
    @Value("#{9 * 2 + 1.5}")
    private double salary;
}
```

<hr>

### `@Autowired` Annotation

Manager.java : 
```java
@Component
public class Manager {

    private Employee employee;

    // constructor injection
    @Autowired
    public Manager(Employee employee) {
        this.employee = employee;
    }

}
```
<center> OR </center>
 

```java
@Component
public class Manager {
    
    // feild injection
    @Autowired
    private Employee employee;
}
```

- Feild injection is normally used when we want to inject a lot of feilds, so it reduces the boilerplate code.
- Constructor Injection is usually recommended becoz it gives clarity, what is injected and where.

<hr>

<div style="text-align: center">

### Qualifiers

</div>

<hr>

- Qualifiers are used when we have multiple beans of same type registed with different names and we want to specify which one to consider.