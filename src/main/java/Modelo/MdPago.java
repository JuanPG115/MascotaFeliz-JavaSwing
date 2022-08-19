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
 * @author jupgo
 */
public class MdPago {

    DbData dbData;

    public MdPago() {
        dbData = new DbData();
    }

    public String[] retornarMascotas() {
        ArrayList<String> mascotasList = new ArrayList<String>();
        String[] mascotas;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT id, codigo, nombre FROM Mascota";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                mascotasList.add(result.getString("id") + " - " + result.getString("codigo") + " - " + result.getString("nombre"));
            }

        } catch (Exception e) {
        }
        mascotas = new String[mascotasList.size()];
        mascotas = mascotasList.toArray(mascotas);
        return mascotas;
    }

    public String[] retornarPlanes() {
        ArrayList<String> planesList = new ArrayList<String>();
        String[] planes;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT id, codigo, nombre FROM Plan";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                planesList.add(result.getString("id") + " - " + result.getString("codigo") + " - " + result.getString("nombre"));
            }

        } catch (Exception e) {
        }
        planes = new String[planesList.size()];
        planes = planesList.toArray(planes);
        return planes;
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

    public boolean crearPago(Pago p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO pago (codigo, fecha, numeroCuotas, idMascota, idPlan) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, p.getCodigo());
            statement.setString(2, p.getFecha());
            statement.setString(3, p.getnCuotas());
            statement.setString(4, Integer.toString(p.getIdMascota()));
            statement.setString(5, Integer.toString(p.getIdPlan()));

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

    public Pago buscarPago(String codigo) {
        Pago pago = null;
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM pago AS p WHERE p.codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                //int id = result.getInt(1);
                //String codigo = result.getString(2);
                String fecha = result.getString(3);
                String nCuotas = result.getString(4);
                String idMascota = result.getString(5);
                String idPlan = result.getString(6);
                pago = new Pago(codigo, fecha, nCuotas, Integer.parseInt(idMascota), Integer.parseInt(idPlan));
            }
            return pago;
        } catch (Exception e) {
        }
        return pago;
    }

    public boolean actualizarPago(Pago p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "UPDATE pago SET fecha = ?, numeroCuotas = ?, idMascota = ?, idPlan = ? WHERE codigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setString(1, p.getFecha());
            statement.setString(2, p.getnCuotas());
            statement.setString(3, Integer.toString(p.getIdMascota()));
            statement.setString(4, Integer.toString(p.getIdPlan()));
            statement.setString(5, p.getCodigo());

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

    public boolean borrarPago(Pago p) {
        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "DELETE FROM pago WHERE codigo = ?";
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
    
    public String[][] retornarPagos() {
        String[][] listaPagos2 = {};

        try ( Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String consulta = "SELECT * FROM pago";
            String consulta2 = "SELECT COUNT(*) AS total FROM pago";
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement1 = conn.prepareStatement(consulta2, Statement.RETURN_GENERATED_KEYS);
            //statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement1.executeQuery();
            int i = 0;
            result2.next();
            int x = result2.getInt("total");
            listaPagos2 = new String[x][6];
            int j = 0;
            while (result.next()) {
                listaPagos2[j][0] = result.getString("id");
                listaPagos2[j][1] = result.getString("codigo");
                listaPagos2[j][2] = result.getString("fecha");
                listaPagos2[j][3] = result.getString("numeroCuotas");
                listaPagos2[j][4] = result.getString("idMascota");
                listaPagos2[j][5] = result.getString("idPlan");
                j++;
            }
            
        } catch (Exception e) {
        }
        return listaPagos2;
    }
}
