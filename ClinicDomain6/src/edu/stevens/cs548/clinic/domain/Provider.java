package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@Table(name="PROVIDER")

public class Provider implements Serializable {

	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	public long npi;
	public String name;
//	public String specialization;//应该定义成枚举类型还是直接定义成一个类？定义成类应该怎么设定关系
	public enum specialization {physician,surgeon,radiologist};
	
	@OneToMany
	@JoinColumn(name = "treatments_fk", referencedColumnName = "id")//这里的referencedColumnName应该是啥
	private List<Treatment> treatments;
	
	public long getNpi() {
		return npi;
	}
	public void setNpi(long npi) {
		this.npi = npi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
	public Provider() {
		super();
	}
   
}
