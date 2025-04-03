package org.example.delete9.repository;

import lombok.AllArgsConstructor;
import org.example.delete9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
