package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: DrugTreatment
 *
 */
@Entity
@DiscriminatorValue("R")
//是否需要再指定table名
public class Radiology extends Treatment implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
//	@Temporal(TemporalType.DATE)//如何是list的话，能否这样注解
//	private List<Date> dates;//这样是否可以？还是得写成 private Set<RadDate> dates???
	private String type;
	@OneToMany(mappedBy = "radiology", cascade = REMOVE, targetEntity = edu.stevens.cs548.clinic.domain.RadDate.class)
	private Set<RadDate> dates;


	public Set<RadDate> getDates() {
		return dates;
	}

	public void setDates(Set<RadDate> dates) {
		this.dates = dates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Radiology() {
		super();
	}
   
}
