package com.user.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserDetails;
import com.user.model.UserModel;


public interface UserRepository extends JpaRepository<UserDetails, Long> {
       UserDetails findByUserId(long id);
       boolean existsByMobile(String mobile);
       boolean existsByEmail(String email);
	UserDetails save(UserModel user);
}
 