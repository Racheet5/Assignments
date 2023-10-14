package lab3;
class expAge extends Exception{
	public expAge(String msg) {
		super(msg);
	}
}
class Persons{
	String name;
	float age;
	Persons(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public Persons(float age) throws expAge{
		if(age<=15) {
			throw new expAge("Invalid age ,it should be greater than 15");
		}
		this.age=age;
	}
}
class Accounts extends Persons{
	long accNum=100;
	double balance;
	String accHolder;
	public String toString() {
		return "accnumber "+accNum+" balance "+balance+" accHolder "+accHolder;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Accounts(String name,double initialbalance) {
		accNum=accNum+1;
		balance=initialbalance;
		accHolder=name;
	}
	void deposit(double amount) {
		balance=balance+amount;
	}
	void withdraw(double amount) {
		balance=balance-amount;
	}
	double getBalance() {
		return balance;
	}
}
public class Q3 {
	public static void main(String[] args) {
		Accounts smith=new Accounts("Smith", 2000.0);
		Accounts kathy=new Accounts("Kathy", 3000.0);
		
		try {
		smith.deposit(2000.0);
		kathy.withdraw(2000.0);
		System.out.println("smith updated balance is "+smith.getBalance());
		System.out.println("kathy updated balance is "+kathy.getBalance());
		System.out.println(smith);
		System.out.println(kathy);
		}
		catch(Exception e) {
			System.out.println("error : "+e.getMessage());
		}
	}
}
