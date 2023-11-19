package CS2.model;

/**
 * @ClassName: ContactPerson
 * @description: Server 服务器端
 * @author: Lu Xintong
 * @Version 1.0
 **/
public class ContactPerson {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 住址
	 */
	private String address;
	
	
	public ContactPerson() {
	}
	
	public ContactPerson(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public ContactPerson(Integer id,
	                     String name,
	                     String phone,
	                     String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
