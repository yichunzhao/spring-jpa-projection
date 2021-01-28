package com.ynz.demo.springjpaprojection.projections.classbased;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PersonDto {
    private final String firstName;
    private final String lastName;
}
