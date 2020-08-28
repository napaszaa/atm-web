package th.go.rd.atm.model;

public class BankAccount {
    private int id;
    private String name;
    private String type;
    private double balance;


    public BankAccount(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = 100;
    }

    public BankAccount(int id, String name, String type, double balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance=balance + amount;    //balance เป็นฟิลด์   amount เป็นพารามิเตอร์ที่เข้ามา
    }

    public void withdraw(double amount){
        balance=balance - amount;    //balance เป็นฟิลด์   amount เป็นพารามิเตอร์ที่เข้ามา
    }
    //----gether----------------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
