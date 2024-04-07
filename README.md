# AOP_looging
This project is used to demonstrate the logging by **AOP** on a **Spring MVC project**.

**AOP** stands for **Aspect-Oriented Programming**.

AOP is used to add logging, auditing and for many more purposes.

For adding **AOP support** in the **spring boot** project, add **dependency** in **pom.xml** file

<br>

We can create different advices by using annotations.
1. **@Before** Advice is use to run before the target method call. <br>
2. **@AfterThrowing** advice is use to run when the target method encounters an exception. <br>
3. **@AfterReturning** advice is use to run when the target method completed successfully. <br>
4. **@After** advice is use to run after the target method ends.(Just like finally block) <br> 
5. **@Around** advice is use to run before and after the target method calls. <br>

<br>
AOP is use to keep the logging code in separate files. So, that the we can have clean code. <br>
With the help of AOP, we can manage the code and if any changes required at any point of time, it can be managed from one file rather than chaning in all files.
