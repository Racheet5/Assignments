package q1;
import java.util.Random;
class Person {
private final String name;
private final Float age;
public String getName() {
return name;
}
Person(String name, Float age) {
this.name = name;
this.age = age;
}
}
class Account {
private final Long accNumber;
private Double balance;
private final Person accHolder;
Account( Double balance, Person accHolder) {
this.accNumber = new Random().nextLong(10000000);
this.balance = balance;
this.accHolder = accHolder;
}
public void deposit(Double amount) {
this.balance = this.balance + amount;
System.out.println(amount + " Credited to your account \nAccount No : " + this.accNumber + "\nAccount HOlder : " + this.accHolder.getName() + ".");
}
public void withdraw(Double amount) {
if (this.balance - amount > 500) {
this.balance = this.balance - amount;
System.out.println(amount + " Debited from your account \nAccount No : " + this.accNumber + " \nAccount Holder : " + this.accHolder.getName() + ".");
} else {
System.out.println("Insufficient Balance");
}
}

public Double getBalance() {
return this.balance;
}

public String toString() {
return "Account Number: " + accNumber + ", Balance: " + balance + ", Account Holder: " + accHolder.getName();
}
}
public class Q1 {
public static void main(String[] args) {
Person p1 = new Person("Smith", 21F);
Account a1 = new Account( 2000.0, p1);
Person p2 = new Person("Kathy", 21F);
Account a2 = new Account( 3000.0, p2);
a1.deposit(2000.0);
a2.withdraw(2000.0);
System.out.println("Balance of Smith's account: " + a1.getBalance());
System.out.println("Balance of Kathy's account: " + a2.getBalance());}}