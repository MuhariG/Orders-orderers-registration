/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabika
 */
public class DBModel implements IModel {

    private Connection conn;
    private PreparedStatement addSzemelypstmt;
    private PreparedStatement updateSzemelypstmt;
    private PreparedStatement removeSzemelypstmt;
    private PreparedStatement getSzemelyekpstmt;
    private PreparedStatement getSzemelyekByNevpstmt;

    private PreparedStatement addRendelespstmt;
    private PreparedStatement updateRendelespstmt;
    private PreparedStatement removeRendelespstmt;
    private PreparedStatement getRendelesekpstmt;
    private PreparedStatement getSzemelyRendelesekpstmt;

    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        addSzemelypstmt = conn.prepareStatement("INSERT INTO szemely (nev, email) VALUES (?, ?)");
        updateSzemelypstmt = conn.prepareStatement("UPDATE szemely SET nev=?, email=? WHERE id=?");
        removeSzemelypstmt = conn.prepareStatement("DELETE FROM szemely WHERE id=?");
        getSzemelyekpstmt = conn.prepareStatement("SELECT * FROM szemely ORDER BY nev");
        getSzemelyekByNevpstmt = conn.prepareStatement("SELECT * FROM szemely WHERE nev LIKE ? ORDER BY nev");

        addRendelespstmt = conn.prepareStatement("INSERT INTO rendeles (rendeloid, osszeg, darabszam, teljesitve) VALUES (?, ?, ?, ?)");
        updateRendelespstmt = conn.prepareStatement("UPDATE rendeles SET rendeloid=?, osszeg=?, darabszam=?, teljesitve=? WHERE id=?");
        removeRendelespstmt = conn.prepareStatement("DELETE FROM rendeles WHERE id=?");
        getRendelesekpstmt = conn.prepareStatement("SELECT * FROM rendeles");
        getSzemelyRendelesekpstmt = conn.prepareStatement("SELECT * FROM rendeles WHERE rendeloid=?");
    }

    @Override
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public int addSzemely(Szemely sz) throws SQLException {
        addSzemelypstmt.setString(1, sz.getNev());
        addSzemelypstmt.setString(2, sz.getEmail());
        return addSzemelypstmt.executeUpdate();
    }

    @Override
    public int updateSzemely(Szemely sz) throws SQLException {
        updateSzemelypstmt.setString(1, sz.getNev());
        updateSzemelypstmt.setString(2, sz.getEmail());
        updateSzemelypstmt.setInt(3, sz.getId());
        return updateSzemelypstmt.executeUpdate();
    }

    @Override
    public int removeSzemely(Szemely sz) throws SQLException {
        removeSzemelypstmt.setInt(1, sz.getId());
        return removeSzemelypstmt.executeUpdate();
    }

    @Override
    public List<Szemely> getSzemelyek() throws SQLException {
        ResultSet rs = getSzemelyekpstmt.executeQuery();
        List<Szemely> szemelyek = new ArrayList<>();

        while (rs.next()) {
            Szemely sz = new Szemely(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("email"));
            szemelyek.add(sz);
        }
        rs.close();
        return szemelyek;
    }

    @Override
    public List<Szemely> getSzemelyekByNev(String nev) throws SQLException {
        getSzemelyekByNevpstmt.setString(1, nev + "%");
        ResultSet rs = getSzemelyekByNevpstmt.executeQuery();
        List<Szemely> szemelyek = new ArrayList<>();

        while (rs.next()) {
            Szemely sz = new Szemely(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("email"));
            szemelyek.add(sz);
        }
        rs.close();
        return szemelyek;
    }

    @Override
    public int addRendeles(Rendeles r) throws SQLException {
        addRendelespstmt.setInt(1, r.getRendeloId());
        addRendelespstmt.setInt(2, r.getOsszeg());
        addRendelespstmt.setInt(3, r.getDarabszam());
        addRendelespstmt.setBoolean(4, r.isTeljesitve());
        return addRendelespstmt.executeUpdate();
    }

    @Override
    public int updateRendeles(Rendeles r) throws SQLException {
        updateRendelespstmt.setInt(1, r.getRendeloId());
        updateRendelespstmt.setInt(2, r.getOsszeg());
        updateRendelespstmt.setInt(3, r.getDarabszam());
        updateRendelespstmt.setBoolean(4, r.isTeljesitve());
        updateRendelespstmt.setInt(5, r.getId());
        return updateRendelespstmt.executeUpdate();
    }

    @Override
    public int removRendeles(Rendeles r) throws SQLException {
        removeRendelespstmt.setInt(1, r.getId());
        return removeRendelespstmt.executeUpdate();
    }

    @Override
    public List<Rendeles> getRendelesek() throws SQLException {
        ResultSet rs = getRendelesekpstmt.executeQuery();
        List<Rendeles> rendelesek = new ArrayList<>();

        while (rs.next()) {
            Rendeles r = new Rendeles(
                    rs.getInt("id"),
                    rs.getInt("rendeloid"),
                    rs.getInt("osszeg"),
                    rs.getInt("darabszam"),
                    rs.getBoolean("teljesitve"));

            rendelesek.add(r);
        }
        rs.close();
        return rendelesek;
    }

    @Override
    public List<Rendeles> getSzemelyRendelesek(Szemely sz) throws SQLException {
        getSzemelyRendelesekpstmt.setInt(1, sz.getId());
        ResultSet rs = getSzemelyRendelesekpstmt.executeQuery();
        List<Rendeles> rendelesek = new ArrayList<>();

        while (rs.next()) {
            Rendeles r = new Rendeles(
                    rs.getInt("id"),
                    rs.getInt("rendeloid"),
                    rs.getInt("osszeg"),
                    rs.getInt("darabszam"),
                    rs.getBoolean("teljesitve"));

            rendelesek.add(r);
        }
        rs.close();
        return rendelesek;
    }

    @Override
    public void exportToCSV(File file) throws IOException, SQLException {
        PrintWriter pw = new PrintWriter(file);

        List<Szemely> szemelyek = getSzemelyek();
        pw.println("id;Név;email");
        for (Szemely sz : szemelyek) {
            pw.println(sz.getId() + ";" + sz.getNev() + ";" + sz.getEmail());
        }

        List<Rendeles> rendelesek = getRendelesek();
        pw.println("");
        pw.println("id;RendeloId;Összeg;Darabszám");
        for (Rendeles r : rendelesek) {
            pw.println(r.getId() + ";" + r.getRendeloId() + ";" + r.getOsszeg() + ";" + r.getDarabszam());
        }

        pw.close();
    }

}
