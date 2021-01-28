package com.ynz.demo.springjpaprojection.projections;

import org.springframework.beans.factory.annotation.Value;

public interface PersonView {
    String getFirstName();

    @Value("#{target.getFirstName() + ' ' + target.getLastName() }")
    String getFullName();
}
