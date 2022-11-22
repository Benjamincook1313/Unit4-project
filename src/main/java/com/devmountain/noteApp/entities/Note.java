package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
  @Id
  @GeneratedValue
  private Long id;
  @Column(columnDefinition = "text")
  private String body;

  @ManyToOne
  @JsonBackReference
  private User user;

  public Note (NoteDto noteDto){
    if(noteDto.getBody() != null) this.body = noteDto.getBody();
  }

}
