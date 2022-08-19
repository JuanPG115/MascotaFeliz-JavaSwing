/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Pago {

    private String codigo;
    private String fecha;
    private String nCuotas;
    private int idMascota;
    private int idPlan;

    public Pago(String codigo, String fecha, String nCuotas, int idMascota, int idPlan) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.nCuotas = nCuotas;
        this.idMascota = idMascota;
        this.idPlan = idPlan;
    }
    

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nCuotas
     */
    public String getnCuotas() {
        return nCuotas;
    }

    /**
     * @param nCuotas the nCuotas to set
     */
    public void setnCuotas(String nCuotas) {
        this.nCuotas = nCuotas;
    }

    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    /**
     * @return the idPlan
     */
    public int getIdPlan() {
        return idPlan;
    }

    /**
     * @param idPlan the idPlan to set
     */
    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

}
