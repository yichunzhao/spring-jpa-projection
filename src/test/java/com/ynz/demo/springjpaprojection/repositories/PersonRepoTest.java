package com.ynz.demo.springjpaprojection.repositories;

import com.ynz.demo.springjpaprojection.entities.Person;
import com.ynz.demo.springjpaprojection.projections.classbased.PersonDto;
import com.ynz.demo.springjpaprojection.projections.interfacebased.PersonView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
    @DisplayName("Closed Projection")
    void getPersonViewByCity() {
        List<PersonView> personViews = personRepo.findByAddressCityIgnoreCase("Berlin");

        assertAll(
                () -> assertThat(personViews, hasSize(1)),
                () -> assertThat(personViews.get(0).getFirstName(), is("aaa"))
        );
    }

    @Test
    @DisplayName("Open Projection")
    void getFullNameFromPersonView() {
        PersonView personViews = personRepo.findByAddressCityIgnoreCase("Berlin").get(0);
        assertThat(personViews.getFullName(), is("aaa bbb"));
    }

    @Test
    @DisplayName("class-based projection")
    void getPersonDtoFromRepo() {
        List<PersonDto> personDtos = personRepo.findByFirstName("ccc");

        assertAll(
                () -> assertThat(personDtos, hasSize(1)),
                () -> assertThat(personDtos.get(0).getLastName(), is("ddd"))
        );
    }

    @Test
    @DisplayName("dynamic projection: interface-based")
    void getPersonViewsByLastName() {
        List<PersonView> personViews = personRepo.findByLastName("bbb", PersonView.class);

        assertAll(
                () -> assertThat(personViews, hasSize(1)),
                () -> assertThat(personViews.get(0).getFirstName(), is(equalTo("aaa")))
        );
    }

    @Test
    @DisplayName("dynamic projection: class-based")
    void getPersonDtoByLastName() {
        List<PersonDto> personDtos = personRepo.findByLastName("bbb", PersonDto.class);

        assertAll(
                () -> assertThat(personDtos, hasSize(1)),
                () -> assertThat(personDtos.get(0).getFirstName(), is(equalTo("aaa"))),
                () -> assertThat(personDtos.get(0).getLastName(), is(equalTo("bbb")))
        );
    }


}