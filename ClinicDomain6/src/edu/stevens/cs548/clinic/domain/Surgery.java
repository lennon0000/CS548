package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DrugTreatment
 *
 */
@Entity
@DiscriminatorValue("S")
//是否需要再指定table名
public class Surgery extends Treatment implements Serializable {


	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String type;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Surgery() {
		super();
	}
   
}
