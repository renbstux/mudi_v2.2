package br.com.renbstux.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.renbstux.mvc.mudi.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	User findByUsername(String username);

}
