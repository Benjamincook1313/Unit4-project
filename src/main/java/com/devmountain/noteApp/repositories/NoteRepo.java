package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
  List<Note> findAllByUserEquals(User user);
}
