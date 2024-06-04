package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	//DSL-Domain specific language
	//grammarsyntax
	//select *from user where username='nilima'
	//select *from user where username='nilima' &password='1234'
	//select *from user where email='nilima@gmail.com'
	//select * from user  order by name asc
	
//	User findByusername(String username);
//	User findByUsernameAndPassword(String username,String password);
//	User findByUsernameorEmail(String username,String password);

}
