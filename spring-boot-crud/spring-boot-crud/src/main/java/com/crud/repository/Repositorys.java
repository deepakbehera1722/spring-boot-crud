package com.crud.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Where;
import org.hibernate.sql.ast.Clause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.dto.IUsersDto;
import com.crud.dto.UsersDto;
import com.crud.entity.Users;
@Repository
public interface Repositorys extends JpaRepository<Users, Long> {



	Page<IUsersDto> findByOrderById(Pageable paging, Class<IUsersDto> class1);

	Page<IUsersDto> findByEmailContainingIgnoreCaseOrderById(String trimLeadingWhitespace, Pageable paging,
			Class<IUsersDto> class1);



		
	
	
	 

}