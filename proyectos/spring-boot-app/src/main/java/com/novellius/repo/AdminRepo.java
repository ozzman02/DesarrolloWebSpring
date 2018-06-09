package com.novellius.repo;

import org.springframework.data.repository.CrudRepository;

import com.novellius.domain.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

}
