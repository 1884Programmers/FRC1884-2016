# FRC Team 1884 (The Griffins) - 2016 Robot Code
###Javadoc Rules###
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
2. @version (classes and interfaces only, required.)  
3. @param (methods and constructors only)  
4. @return (methods only)  
5. @exception (@throws is a synonym added in Javadoc 1.2)  
6. @see  
7. @since  
8. @serial (or @serialField or @serialData)  
9. @deprecated (see How and When To Deprecate APIs)  

###Updating The Master Repository
**Prerequisites**
* A Github Account
* [Github Desktop](http://desktop.github.com)
* Eclipse (set up with [WPILIB](https://wpilib.screenstepslive.com/s/4485/m/13809/l/145002-installing-eclipse-c-java)) (recommended)  
  
**Setup**  
1. Ask the programming team to add you to the 1884Programmers organization.  
2. Go to [the master repository](https://github.com/1884Programmers/FRC1884-2016/tree/test_code) and click "fork". This will create a copy of the repo that is linked to the master one.  
3. Open up Eclipse, and press "Navigate => Show In => Repositories" in the menu bar.  
4. In the Git Repositories view, press the button that says "git" on it and has a blue curved arrow pointing down. When you hover over it, it should say "Clone a Git Repository and add the clone to this view".  
5. In the box that pops up, put the link to your fork in the box labeled "URI", and put you login information in "Authentication". *Note:* If you click "Store in Secure Store", then your login credentials will be stored for future use. If you do not click this, you will have to log in every time you want to commit code.  
6. Go to the "Git Repositories" view, and expand the repository you just cloned. Right click on "Remotes", and select "Create Remote". Name it "upstream". In the next menu paste the url for the master 1884Programmers repository. When you expand "Remotes" you should now see "upstream". If you see any remote other than origin and upstream, remove it by right clicking on it an then selecting remove as it is not needed.  
7. In Github Desktop, you want to click the "+" icon in the top left. Click "browse", and browse to where you put the local files of your github repository, then click "Add Repository". *Note:* The default location for the local files of the github repository is in a folder named "git" under your user folder.  
8. Also in Github Desktop, click "+" again. Click "clone" in the top of the window, put in the link to the 1884Programmers version of the repository.  

**Committing Code to the Master Repository**  
TODO
