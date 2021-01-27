package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

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

}