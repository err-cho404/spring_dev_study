package com.mysite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee{
	@Id //primary key로 만들어 줄 것 지정
	private Integer empid;
	@Column(length = 25)
	private String empName;
	private String email;
	private String empAddress;
}
