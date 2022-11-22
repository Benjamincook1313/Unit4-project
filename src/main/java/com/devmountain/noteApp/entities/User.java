package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  @Column(unique=true)
  private String username;
  private String password;

  @OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  @JsonManagedReference
  private Set<Note> noteSet = new HashSet<>();

  public User(UserDto userDto) {
    if(userDto.getUsername() != null) this.username = userDto.getUsername();
    if(userDto.getPassword() != null) this.password = userDto.getPassword();
  }
}
