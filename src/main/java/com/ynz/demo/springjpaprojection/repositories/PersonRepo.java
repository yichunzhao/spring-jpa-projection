package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
}
