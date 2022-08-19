/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.MdPago;

/**
 *
 * @author jupgo
 */
public class CtPago {

    MdPago MdPago;

    public CtPago() {

        MdPago = new MdPago();

    }

    public String[] retornarMascotas() {
        String[] mascotas;
        mascotas = this.MdPago.retornarMascotas();
        return mascotas;
    }

    public String[] retornarPlanes() {
        String[] planes;
        planes = this.MdPago.retornarPlanes();
        return planes;
    }

    public boolean crearPago(Pago p) {
        try {
            this.MdPago.crearPago(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Pago buscarPago(String codigo) {

        Pago p = null;
        p = this.MdPago.buscarPago(codigo);
        return p;
    }

    public boolean actualizarPago(Pago p) {
        return this.MdPago.actualizarPago(p);
    }

    public boolean borrarPago(Pago p) {
        return this.MdPago.borrarPago(p);
    }
    
     public String[][] retornarAllPagos() {
        return this.MdPago.retornarPagos();
    }

}
