package com.codexiodevcamp.demojsonwebtoken.repository;

import com.codexiodevcamp.demojsonwebtoken.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
