package com.challenge.meli.jpa.stats;

import com.challenge.meli.model.stats.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private DataSource dataSource;


    public Stats getStats() {
        Stats stats = new Stats();
        try(Connection conn = dataSource.getConnection();
            CallableStatement callableStatement =  conn.prepareCall(
                    "SELECT SUM(mutant_dna) AS count_mutant_dna, SUM(human_dna) AS count_human_dna, " +
                    "CAST((SUM(mutant_dna) * 1.00 / SUM(human_dna)) AS DECIMAL(5,2)) as ratio  FROM magneto.mutants")) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                stats.setCount_mutant_dna(rs.getInt("count_mutant_dna"));
                stats.setCount_human_dna(rs.getInt("count_human_dna"));
                stats.setRatio(rs.getDouble("ratio"));
            }
        }catch (SQLException ex) {

        }
        return stats;
    }
}
