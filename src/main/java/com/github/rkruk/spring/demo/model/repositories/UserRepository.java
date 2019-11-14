package com.github.rkruk.spring.demo.model.repositories;

import com.github.rkruk.spring.demo.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

}
