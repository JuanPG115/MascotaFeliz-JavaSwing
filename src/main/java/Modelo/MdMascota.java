/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.*;
import Clases.Plan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jupgo
 */
public class MdMascota {

    DbData dbData;

    public MdMascota() {
        dbData = new DbData();
    }

    public String[] retornarNombresClientes() {
        ArrayList<String> clientesList = new ArrayList<String>();
        String[] clientes;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT id, identificacion, nombre, apellido FROM Cliente";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                clientesList.add(result.getString("id") + " - " + result.getString("identificacion") + " - " + result.getString("nombre") + " " + result.getString("apellido"));
            }

        } catch (Exception e) {
        }
        clientes = new String[clientesList.size()];
        clientes = clientesList.toArray(clientes);
        return clientes;
    }

    public boolean crearMascota(Mascota m) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO mascota (codigo, nombre, edad, peso, especie, idCliente) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, m.getCodigo());
            statement.setString(2, m.getNombre());
            statement.setString(3, m.getEdad());
            statement.setString(4, m.getPeso());
            statement.setString(5, m.getEspecie());
            statement.setString(6, Integer.toString(m.getIdCliente()));
            
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
    
    public Mascota buscarMascota(String codigo) {
        Mascota m = null;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM mascota AS m WHERE m.codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                //int id = result.getInt(1);
                //String codigo = result.getString(2);
                String nombre = result.getString(3);
                String edad = result.getString(4);
                String peso = result.getString(5);
                String especie = result.getString(6);
                String idCliente = result.getString(7);
                m = new Mascota(Integer.parseInt(idCliente), codigo, nombre, edad, peso, especie);
            }
            return m;
        } catch (Exception e) {
        }
        return m;
    }
    
    public boolean actualizarMascota(Mascota m) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "UPDATE mascota SET idCliente = ?, nombre = ?, edad = ?, peso = ?, especie = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, Integer.toString(m.getIdCliente()));
            statement.setString(2, m.getNombre());
            statement.setString(3, m.getEdad());
            statement.setString(4, m.getPeso());
            statement.setString(5, m.getEspecie());
            statement.setString(6, m.getCodigo());
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

    public boolean borrarMascota(Mascota m) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "DELETE FROM mascota WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, m.getCodigo());
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
    
    public String[][] retornarMascotas() {
        String[][] listaMascotas2 = {};

        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM mascota";
            String consulta2 = "SELECT COUNT(*) AS total FROM mascota";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement1 = conn.prepareStatement(consulta2, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement1.executeQuery();
            result2.next();
            int x = result2.getInt("total");
            listaMascotas2 = new String[x][7];
            int j = 0;
            while (result.next()) {
                listaMascotas2[j][0] = result.getString("id");
                listaMascotas2[j][1] = result.getString("codigo");
                listaMascotas2[j][2] = result.getString("nombre");
                listaMascotas2[j][3] = result.getString("edad");
                listaMascotas2[j][4] = result.getString("peso");
                listaMascotas2[j][5] = result.getString("especie");
                listaMascotas2[j][6] = result.getString("idCliente");
                j++;
            }
            
        } catch (Exception e) {
        }
        return listaMascotas2;
    }
    
    public String[][] retornarEspecies() {
        String[][] listaEspecies = {};

        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT especie, COUNT(especie) as cantidad FROM mascota GROUP BY especie";
            String consulta2 = "SELECT COUNT(*) AS total FROM mascota GROUP BY especie";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement1 = conn.prepareStatement(consulta2, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement1.executeQuery();
            int x = 0;
            while(result2.next()){
                x = result2.getRow();
            }
            
            listaEspecies = new String[x][2];
            int j = 0;
            while (result.next()) {
                listaEspecies[j][0] = result.getString("especie");
                listaEspecies[j][1] = result.getString("cantidad");
                j++;
            }
            
        } catch (Exception e) {
        }
        return listaEspecies;
    }
  
}
