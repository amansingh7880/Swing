package pack1.entities;

public class Customer {
	private int Cusromer_id;
	private String name,password,Address;
	private long phone;
	private String gender;
	private String rtype;
	private String atype;
	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCid() {
		return Cusromer_id;
	}
	
	public int getCusromer_id() {
		return Cusromer_id;
	}

	public void setCusromer_id(int cusromer_id) {
		Cusromer_id = cusromer_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [Cusromer_id=" + Cusromer_id + ", name=" + name + ", password=" + password + ", Address="
				+ Address + ", phone=" + phone + ", gender=" + gender + ", rtype=" + rtype + ", atype=" + atype + "]";
	}
	

}
