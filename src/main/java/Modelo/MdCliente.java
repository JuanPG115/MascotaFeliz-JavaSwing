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

/**
 *
 * @author jupgo
 */
public class MdCliente {

    DbData dbData;

    public MdCliente() {
        this.dbData = new DbData();
    }

    public boolean crearCliente(Cliente c) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO cliente (identificacion, nombre, apellido, direccion, telefono) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, c.getIdCliente());
            statement.setString(2, c.getNombres());
            statement.setString(3, c.getApellidos());
            statement.setString(4, c.getDireccion());
            statement.setString(5, c.getTelefono());
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

    public Cliente buscarCliente(String id) {
        Cliente c = null;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM Cliente AS c WHERE c.identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                //int id = result.getInt(1);
                String identificacion = result.getString(2);
                String nombre = result.getString(3);
                String apellido = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                c = new Cliente(identificacion, nombre, apellido, direccion, telefono);
            }
            return c;
        } catch (Exception e) {
        }
        return c;
    }

    public boolean actualizarCliente(Cliente c) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "UPDATE cliente SET identificacion = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, c.getIdCliente());
            statement.setString(2, c.getNombres());
            statement.setString(3, c.getApellidos());
            statement.setString(4, c.getDireccion());
            statement.setString(5, c.getTelefono());
            statement.setString(6, c.getIdCliente());
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

    public boolean borrarCliente(Cliente c) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "DELETE FROM cliente WHERE identificacion = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, c.getIdCliente());
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

    public String[][] retornarClientes() {
        String[][] listaClientes2 = {};

        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM cliente";
            String consulta2 = "SELECT COUNT(*) AS total FROM cliente";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement1 = conn.prepareStatement(consulta2, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement1.executeQuery();
            int i = 0;
            result2.next();
            int x = result2.getInt("total");
            listaClientes2 = new String[x][6];
            int j = 0;
            while (result.next()) {
                listaClientes2[j][0] = result.getString("id");
                listaClientes2[j][1] = result.getString("identificacion");
                listaClientes2[j][2] = result.getString("nombre");
                listaClientes2[j][3] = result.getString("apellido");
                listaClientes2[j][4] = result.getString("direccion");
                listaClientes2[j][5] = result.getString("telefono");
                j++;
            }
            
        } catch (Exception e) {
        }
        return listaClientes2;
    }
    
}
