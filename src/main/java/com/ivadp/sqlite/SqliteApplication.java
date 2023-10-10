package com.ivadp.sqlite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
@ComponentScan("com.ivadp")
public class SqliteApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        String sql = "SELECT name FROM sqlite_schema WHERE type ='table' AND name = 'user';";
//
//        Boolean created = jdbcTemplate.query(sql, null, null, new ResultSetExtractor<Boolean>() {
//            @Override
//            public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
//                // true if the new current row is valid; false if there are no more rows.
//                return rs.next();
//            }
//        });
//        if (Boolean.FALSE.equals(created)){
//            String createUser = "create table user(" +
//                    "id varchar(32) primary key," +
//                    "name varchar(20)," +
//                    "sex varchar(20)," +
//                    "age int" +
//                    ")";
//            jdbcTemplate.update(createUser);
//        }

    }

}