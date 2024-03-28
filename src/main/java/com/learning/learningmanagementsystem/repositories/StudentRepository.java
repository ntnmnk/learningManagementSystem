package com.learning.learningmanagementsystem.repositories;

import com.learning.learningmanagementsystem.models.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Override
  @RestResource(exported = false) // Disable default DELETE mapping
  void deleteById(Long id);

  Optional<Student>  findByName(@Param("name") String name);
}
