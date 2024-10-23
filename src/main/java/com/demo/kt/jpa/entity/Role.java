package com.demo.kt.jpa.entity;

import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString(exclude = {"users"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_ROLE")
@SQLDelete(sql = "UPDATE T_ROLE SET enabled = false WHERE id=?")
@SQLRestriction(value = "enabled = true") 
public class Role extends BaseEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String roleName;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "T_USERROLE",
				joinColumns = {@JoinColumn(name = "ROLE_ID")},
				inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
			  )
	private Set<User> users;
}
