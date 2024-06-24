package com.web.repositories.users;

import com.web.models.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    // EXPLAIN: TODO:
    Optional<Users> findByEmail(String email);

    Optional<Users> findByUsername(String username);

    Users findByName(String name);

}
