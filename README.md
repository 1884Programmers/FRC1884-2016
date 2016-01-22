# FRC Team 1884 (The Griffins) - 2016 Robot Code
**Javadoc Rules**  
Before the class body, Javadoc comments **MUST** have:  
• Description of the class
• @author _(Firstname Lastname)_  
• @version _(For every push, increment by 1)_  
• @since _(Date the class was created)_  

*Example:*
```java
//Import Statements

/**
* (Class Description)
*
* @author Kaito Arai
* @Version 1
* @since 1/1/2016
*/
//Class body
```
Before a method body, Javadoc comments **MUST** have:  
• Short one line description of the method  
• Longer description of the method  
• @param _(If any, describe every method parameter)_  
• @return _(Describe the return value)_  
• @exception/@throw _(If any, describe every exception that may be thrown from this method)_

*Example:*
```java
/**
* (One line description)
* <p>
* (Longer description)
* <p>
* @param paramName paramDescription
* @return returnDescription
* @throw exceptionDescription
*/
//Method body
```
Before a field declaration, Javadoc comments **MUST** have:  
• Short one line description of the field  

*Example:*
```java
/**
* (One line description)
*/
//Field Declaration
```

Order Of Tags:  
1. @author (classes and interfaces only, required)  
2. @version (classes and interfaces only, required. See footnote 1)  
3. @param (methods and constructors only)  
4. @return (methods only)  
5. @exception (@throws is a synonym added in Javadoc 1.2)  
6. @see  
7. @since  
8. @serial (or @serialField or @serialData)  
9. @deprecated (see How and When To Deprecate APIs)  
