/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class MdPlan {

    DbData dbData;

    public MdPlan() {
        this.dbData = new DbData();
    }

    public boolean crearPlan(Plan p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO plan (codigo,nombre,precio) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getCodigo());
            statement.setString(2, p.getNombre());
            statement.setInt(3, p.getPrecio());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            return false;
        }

    }

    public Plan buscarPlan(String codigo) {
        Plan p = null;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM plan AS p WHERE p.codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                //int id = result.getInt(1);
                String cod = result.getString(2);
                String nombre = result.getString(3);
                int precio = result.getInt(4);
                p = new Plan(cod, nombre, precio);
            }
            return p;
        } catch (Exception e) {
        }
        return p;
    }

    public boolean actualizarPlan(Plan p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "UPDATE plan SET codigo = ?, nombre = ?, precio = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, p.getCodigo());
            statement.setString(2, p.getNombre());
            statement.setInt(3, p.getPrecio());
            statement.setString(4, p.getCodigo());
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarPlan(Plan p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "DELETE FROM plan WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, p.getCodigo());
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String[][] retornarPlanes() {
        String[][] listaPlanes2 = {};

        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM plan";
            String consulta2 = "SELECT COUNT(*) AS total FROM plan";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement1 = conn.prepareStatement(consulta2, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement1.executeQuery();
            int i = 0;
            result2.next();
            int x = result2.getInt("total");
            listaPlanes2 = new String[x][4];
            int j = 0;
            while (result.next()) {
                listaPlanes2[j][0] = result.getString("id");
                listaPlanes2[j][1] = result.getString("codigo");
                listaPlanes2[j][2] = result.getString("nombre");
                listaPlanes2[j][3] = result.getString("precio");
                j++;
            }
            
        } catch (Exception e) {
        }
        return listaPlanes2;
    }

}
