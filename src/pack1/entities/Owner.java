package pack1.entities;

public class Owner {
private String name,address,password;
private long phone;
private int landlord_id;


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public long getPhone() {
	return phone;
}


public void setPhone(long phone) {
	this.phone = phone;
}


public int getLandlord_id() {
	return landlord_id;
}


public void setLandlord_id(int landlord_id) {
	this.landlord_id = landlord_id;
}


@Override
public String toString() {
	return "Owner [name=" + name + ", address=" + address + ", password=" + password + ", phone=" + phone
			+ ", landlord_id=" + landlord_id + "]";
}

}
