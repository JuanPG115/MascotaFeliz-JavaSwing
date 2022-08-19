/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelo.*;

/**
 *
 * @author jupgo
 */
public class CtMascota {

    MdMascota MdMascota;

    public CtMascota() {

        MdMascota = new MdMascota();

    }

    public String[] retornarNombresClientes() {
        String[] clientes;
        clientes = this.MdMascota.retornarNombresClientes();
        return clientes;
    }

    public boolean crearMascota(Mascota m) {
        try {
            this.MdMascota.crearMascota(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Mascota buscarMascota(String codigo) {

        Mascota m = null;
        m = this.MdMascota.buscarMascota(codigo);
        return m;
    }

    public boolean actualizarMascota(Mascota m) {
        return this.MdMascota.actualizarMascota(m);
    }

    public boolean borrarMascota(Mascota m) {
        return this.MdMascota.borrarMascota(m);
    }

    public String[][] retornarAllMascotas() {
        return this.MdMascota.retornarMascotas();
    }

    public String[][] retornarAllEspecies() {
        return this.MdMascota.retornarEspecies();
    }
}
