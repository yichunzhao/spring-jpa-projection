package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import com.ynz.demo.springjpaprojection.projections.PersonView;
import com.ynz.demo.springjpaprojection.projections.classbased.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<PersonView> findByAddressCityIgnoreCase(String city);

    List<PersonDto> findByFirstName(String firstName);
}
