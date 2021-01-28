package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import com.ynz.demo.springjpaprojection.projections.classbased.PersonDto;
import com.ynz.demo.springjpaprojection.projections.interfacebased.PersonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<PersonView> findByAddressCityIgnoreCase(String city);

    List<PersonDto> findByFirstName(String firstName);

    <T> List<T> findByLastName(String lastName, Class<T> typeName);
}
