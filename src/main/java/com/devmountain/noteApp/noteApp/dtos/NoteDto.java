package com.devmountain.noteApp.noteApp.dtos;

import com.devmountain.noteApp.noteApp.entities.Note;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto implements Serializable {
  private long id;
  private String body;
  private UserDto userDto;

  public NoteDto(Note note) {
    if(note.getId() != null) this.id = note.getId();
    if(note.getBody() != null) this.body = note.getBody();

  }
}
