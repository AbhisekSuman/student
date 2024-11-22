package com.abhi.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
        public  void createTable()
        {
            var q = "CREATE TABLE student(id SERIAL PRIMARY KEY , name VARCHAR(255) NOT NULL, city VARCHAR(200) NOT NULL)" ;

            int update =  this.jdbcTemplate.update(q);
            System.out.println(update);
        }

//        for inserting

    public void insertData(String name, String city) {
            var q = "insert into student(name,city) values(?,?)";
            int update = this
                    .jdbcTemplate.update(q, name, city);
            System.out.println(update+"inserted");
    }


}
