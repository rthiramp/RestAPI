//package com.evry.rentamovie.beans;
//
//import java.util.List;
//import java.util.Set;
//
//public class Customer_BK {
//
//	private Integer id;
//	private String name;
//	private Integer mob;
//	private Set<String> emails;
//	private List<Address> addresses;
//	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getMob() {
//		return mob;
//	}
//	public void setMob(Integer mob) {
//		this.mob = mob;
//	}
//	public Set<String> getEmails() {
//		return emails;
//	}
//	public void setEmails(Set<String> emails) {
//		this.emails = emails;
//	}
//	public List<Address> getAddresses() {
//		return addresses;
//	}
//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
//		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
//		result = prime * result + ((mob == null) ? 0 : mob.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer_BK other = (Customer_BK) obj;
//		if (addresses == null) {
//			if (other.addresses != null)
//				return false;
//		} else if (!addresses.equals(other.addresses))
//			return false;
//		if (emails == null) {
//			if (other.emails != null)
//				return false;
//		} else if (!emails.equals(other.emails))
//			return false;
//		if (mob == null) {
//			if (other.mob != null)
//				return false;
//		} else if (!mob.equals(other.mob))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//	
//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", name=" + name + ", mob=" + mob + ", emails=" + emails + ", addresses="
//				+ addresses + "]";
//	}
//	
//}
