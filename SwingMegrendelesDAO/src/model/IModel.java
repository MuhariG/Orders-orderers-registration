/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gabika
 */
public interface IModel {

    void close()throws SQLException;
    
    int addSzemely(Szemely sz) throws SQLException;
    int updateSzemely(Szemely sz) throws SQLException;
    int removeSzemely(Szemely sz) throws SQLException;
    List<Szemely> getSzemelyek() throws SQLException;
    List<Szemely> getSzemelyekByNev(String nev) throws SQLException;

    int addRendeles(Rendeles r) throws SQLException;
    int updateRendeles(Rendeles r) throws SQLException;
    int removRendeles(Rendeles r) throws SQLException;
    List<Rendeles> getRendelesek() throws SQLException;
    List<Rendeles> getSzemelyRendelesek(Szemely sz) throws SQLException;

    void exportToCSV(File file) throws IOException, SQLException;
}
