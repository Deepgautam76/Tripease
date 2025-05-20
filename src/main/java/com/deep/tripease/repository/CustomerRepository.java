package com.deep.tripease.repository;

import com.deep.tripease.enums.Gender;
import com.deep.tripease.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByGender(Gender gender);

    List<Customer> findByGenderAndAge(Gender gender, int age);

   /**
    * This is called hibernate query language(HQL)
    * */
    @Query(value = "Select c from Customer c where c.gender=:gender and c.age > :age")
    List<Customer> getCustomerByGenderAndGraterThanAge(@Param("gender") Gender gender,
                                                       @Param("age") int age);
    @Query(value = "Select * from customer where gender=:gender and age > :age",nativeQuery = true)
    List<Customer> getCustomerByGenderAndGraterThanAge(@Param("gender") String gender,
                                                       @Param("age") int age);

    Optional<Customer> findByEmailId(String emailId);
}
