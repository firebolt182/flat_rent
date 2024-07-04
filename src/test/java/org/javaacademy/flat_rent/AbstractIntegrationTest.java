package org.javaacademy.flat_rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "classpath:/schema-test.sql")
public abstract class AbstractIntegrationTest {
}
