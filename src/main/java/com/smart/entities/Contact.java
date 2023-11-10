package com.smart.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cfirstname;
	private String csecondname;
	private String cwork;
	private String cemai;
	private String cphone;
	private String cimage;
	@Column(length = 50000)
	private String description;
	
	@ManyToOne
	private User user;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int cid, String cfirstname, String csecondname, String cwork, String cemai, String cphone,
			String cimage, String description) {
		super();
		this.cid = cid;
		this.cfirstname = cfirstname;
		this.csecondname = csecondname;
		this.cwork = cwork;
		this.cemai = cemai;
		this.cphone = cphone;
		this.cimage = cimage;
		this.description = description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCfirstname() {
		return cfirstname;
	}
	public void setCfirstname(String cfirstname) {
		this.cfirstname = cfirstname;
	}
	public String getCsecondname() {
		return csecondname;
	}
	public void setCsecondname(String csecondname) {
		this.csecondname = csecondname;
	}
	public String getCwork() {
		return cwork;
	}
	public void setCwork(String cwork) {
		this.cwork = cwork;
	}
	public String getCemai() {
		return cemai;
	}
	public void setCemai(String cemai) {
		this.cemai = cemai;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", cfirstname=" + cfirstname + ", csecondname=" + csecondname + ", cwork="
				+ cwork + ", cemai=" + cemai + ", cphone=" + cphone + ", cimage=" + cimage + ", description="
				+ description + "]";
	}
	
	
	
}
