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
public class CtCliente {

    MdCliente mdCliente;

    public CtCliente() {
        this.mdCliente = new MdCliente();
    }

    public boolean crearCliente(Cliente c) {
        try {
            this.mdCliente.crearCliente(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Cliente buscarCliente(String identificacion) {
        Cliente c = null;
        c = this.mdCliente.buscarCliente(identificacion);
        return c;
    }

    public boolean actualizarCliente(Cliente c) {
        return this.mdCliente.actualizarCliente(c);
    }

    public boolean borrarCliente(Cliente c) {
        return this.mdCliente.borrarCliente(c);
    }
    
     public String[][] retornarAllClientes() {
        return this.mdCliente.retornarClientes();
    }

}
