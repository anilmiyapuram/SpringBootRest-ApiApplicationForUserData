package com.user.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserDetails;
import com.user.model.UserModel;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmailIgnoreCase(String email);
       UserDetails findByUserId(long id);

    @Override
    boolean existsById(Long id);
    boolean existsByMobile(String mobile);
    boolean existsByEmail(String email);
	UserDetails save(UserModel user);
}
 