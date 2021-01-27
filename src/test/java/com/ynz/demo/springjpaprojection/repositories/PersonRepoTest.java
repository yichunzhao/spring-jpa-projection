package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import com.ynz.demo.springjpaprojection.projections.PersonView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Sql("classpath:insert-data.sql")
@Sql(scripts = {"classpath:delete-test-data.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;

    @Test
    void getAllPersons() {
        List<Person> persons = personRepo.findAll();
        assertThat(persons, hasSize(2));
    }

    @Test
    void getPersonViewByCity() {
        List<PersonView> personViews = personRepo.findByAddressCityIgnoreCase("Berlin");

        assertAll(
                () -> assertThat(personViews, hasSize(1)),
                () -> assertThat(personViews.get(0).getFirstName(), is("aaa"))
        );

    }

}