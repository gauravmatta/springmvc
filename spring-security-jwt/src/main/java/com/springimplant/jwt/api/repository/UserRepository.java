package com.springimplant.jwt.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.projections.UserProjection;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUserName(String username);

	Optional<User> findByUserId(String userId);

	@Query(value ="select ju.id,ju.email from javaimplant_roles jr inner join javaimplant_user_role jur on jr.id =jur.role_id inner join javaimplant_users ju on jur.user_id = ju.id where jr.code = :rolename",nativeQuery=true)
	List<UserProjection> findUserByRoleName(@Param("rolename") String rolename);
	
	@Query(value = "select ju.id,ju.email from javaimplant_users ju",nativeQuery = true)
	List<UserProjection> findUserByRoleName();
}
