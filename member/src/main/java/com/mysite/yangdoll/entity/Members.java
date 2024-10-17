package com.mysite.yangdoll.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Members {
	@Id
	private Integer memId;
	@Column(length = 250)
	private String memPwd;
	@Column(length = 25)
	private String memName;
	@Column(length = 25)
	private String email;
	@Column(length = 30)
	private String phone;
	@Lob
	private Integer count;
	@Column(length = 3)
	private Integer grade;
}

