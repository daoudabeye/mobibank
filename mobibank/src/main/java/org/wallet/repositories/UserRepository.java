package org.wallet.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wallet.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findOneByUsername(String username);
	
	@Modifying
	@Query("update User u set u.lastLogin=:lastLogin, u.lastIp=:lastIp where u.id=:id")
	int updateLastLogin(@Param("id")Long id, @Param("lastLogin")Date lastLogin, @Param("lastIp")String lastIp);
}
