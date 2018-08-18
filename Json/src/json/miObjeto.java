/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author dmolina
 */
public class miObjeto {
    protected int id=28139283;
    protected String nombre="Diego";
    protected Vector vec= new Vector();
    public miObjeto () {
    vec.add("81212839");
    vec.add(258032193);
    vec.add((char)35);
    vec.add((char)64);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Vector getVec() {
        return vec;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.vec);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final miObjeto other = (miObjeto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miObjeto{" + "id=" + id + ", nombre=" + nombre + ", vec=" + vec + '}';
    }

   
    
}
