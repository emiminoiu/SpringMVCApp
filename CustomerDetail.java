package springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_detail_Id")
	private int id;
	@Column(name="age")
	private int age;
	@Lob
	@Column(name="Customer_IMAGE", nullable=false, columnDefinition="mediumblob")
	private byte[] image;
	@Column(name="Faculty")
	private String faculty;
	@Column(name="Hobby")	
	private String hobby;
	public CustomerDetail() {}
															
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}																																													

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) { 
		this.age = age;
	}
	public byte[] getImage() {             
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
