package lab3;
import java.util.Random;
class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {
super(message);}}
public class Q2 {
public static void main(String[] args) {
try {
Person1 p1 = new Person1("Smith", 13f);
Account1 a1 = new Account1(2000.0, p1);
Person1 p2 = new Person1("Kathy", 21F);
Account1 a2 = new Account1(3000.0, p2);
a1.deposit(2000.0);
a2.withdraw(2000.0);
System.out.println("Balance of Smith's account: " + a1.getBalance());
System.out.println("Balance of Kathy's account: " + a2.getBalance());
} catch (InvalidAgeException e) {
System.out.println("Error: " + e.getMessage());}}}
class Person1 {
private final String name;
private final Float age;
public String getName() {
return name;}
Person1(String name, Float age) throws InvalidAgeException {
this.name = name;
if (age <= 15) {
throw new InvalidAgeException("Age should be above 15.");}
this.age = age;}}
class Account1 {
private final Long accNumber;
private Double balance;
private final Person1 accHolder;
Account1(Double balance, Person1 accHolder) {
this.accNumber = new Random().nextLong(10000000);
this.balance = balance;
this.accHolder = accHolder;}
public void deposit(Double amount) {
this.balance = this.balance + amount;
System.out.println(amount + " Credited to your account \nAccount No : " + this.accNumber + "\nAccount Holder : " + this.accHolder.getName() + ".");}
public void withdraw(Double amount) {
if (this.balance - amount > 500) {
this.balance = this.balance - amount;
System.out.println(amount + " Debited from your account \nAccount No : " + this.accNumber + " \nAccount Holder : " + this.accHolder.getName() + ".");
} else {
System.out.println("Insufficient Balance");}}
public Double getBalance() {
return this.balance;
}
public String toString() {
return "Account Number: " + accNumber + ", Balance: " + balance + ", Account Holder: " + accHolder.getName();}}