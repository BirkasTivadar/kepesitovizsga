package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JurassicParkTest {

    private JurassicPark jurassicPark;

    @BeforeEach
    void init()  {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        jurassicPark = new JurassicPark(dataSource);

    }


    @Test
    void test_check() {
        assertEquals(List.of("Hypsilophodontida", "Maiasaurus", "Velociraptor"), jurassicPark.checkOverpopulation());
    }



}