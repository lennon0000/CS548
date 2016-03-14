package edu.stevens.cs548.clinic.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name="RADDATE")
public class RadDate {
	@Id
	private long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "radiology_fk", referencedColumnName = "id")
	private Radiology radiology;//这里是否需要定义oneToMany关系，还是不用定义，系统会自动生成
}
