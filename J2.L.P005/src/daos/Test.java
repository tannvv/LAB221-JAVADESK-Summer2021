/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Brand;
import dtos.Motocycle;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author TanNV
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        MotocycleDAO dao = new MotocycleDAO();
        System.out.println(dao.numberOfMotoByBrandID("SZ"));
    }
}
