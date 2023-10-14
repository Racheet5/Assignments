package lab3;
class InvalidException extends Exception {
public InvalidException(String message) {
super(message);
}
}
class Person {
private String firstname;
private String lastname;
private char gender;

public String getFirstname() {
return firstname;
}

public void setFirstname(String firstname) throws InvalidException {
if (firstname == null || firstname.trim().isEmpty()) {
throw new InvalidException("First name cannot be blank.");
}
this.firstname = firstname.trim();
}

public String getLastname() {
return lastname;
}

public void setLastname(String lastname) throws InvalidException {
if (lastname == null || lastname.trim().isEmpty()) {
throw new InvalidException("Last name cannot be blank.");
}
this.lastname = lastname.trim();
}

public char getGender() {
return gender;
}

public void setGender(char gender) {
this.gender = gender;
}

Person(String first_name, String last_name, char Gender) throws InvalidException {
setFirstname(first_name);
setLastname(last_name);
this.gender = Gender;
}

}

class PersonMain {
public static void main(String[] args) {
try {
Person p1 = new Person("Hari", "Haran", 'M');
System.out.println("Personal Details :");
System.out.println("____________");
System.out.println("");
System.out.println("First Name : " + p1.getFirstname());
System.out.println("Last Name : " + p1.getLastname());
System.out.println("Gender : " + p1.getGender());
} catch (InvalidException e) {
System.out.println("Error: " + e.getMessage());
}
}
}