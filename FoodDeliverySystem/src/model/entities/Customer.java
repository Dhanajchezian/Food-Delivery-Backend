package model.entities;

public class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String address;

    public Customer(int customerId, String name, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
    
    public String getphone() {
    	return phone;
    }
    
    public String getaddress() {
    	return address;
    }
}
