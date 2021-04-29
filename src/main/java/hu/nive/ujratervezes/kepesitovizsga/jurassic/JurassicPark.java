package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> checkOverpopulation() {

        List<String> result = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed;")
        ) {

            while (rs.next()) {
                result.add(rs.getString("breed"));
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed");
        }

        return result;
    }
}
