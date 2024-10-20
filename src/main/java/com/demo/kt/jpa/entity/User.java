package com.demo.kt.jpa.entity;

import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
@SQLDelete(sql = "UPDATE T_USER SET enabled = false WHERE id=?")
@SQLRestriction(value = "enabled = true") 
public class User extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String email;
	private int age;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;
	
	@ManyToMany
	@JoinTable(name = "T_USERROLE",
				joinColumns = {@JoinColumn(name = "USER_ID")},
				inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")}
			  )
	private Set<Role> roles;
}
