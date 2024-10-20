package com.demo.kt.jpa.entity;

import java.time.Instant;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

@MappedSuperclass
@ToString
public abstract class BaseEntity {
	
	@CreationTimestamp
	@Column
	private Instant createTime;
	
	@UpdateTimestamp
	@Column
	private Instant updateTime;
	
	@Column
	private Boolean enabled = true;
	
}
