package eder.padilla.personal.works.realmexample;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/**
 * Created by Eder on 22/05/2016.
 */
public class Modelo extends RealmObject {
    private String nombre;
    private String posicion;
    private int numeroDorsal;

    @PrimaryKey
    private String correo;

    public Modelo(String nombre, String posicion, int numeroDorsal,String correo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numeroDorsal = numeroDorsal;
        this.correo=correo;
    }
    public Modelo(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumeroDorsal() {
        return numeroDorsal;
    }

    public void setNumeroDorsal(int numeroDorsal) {
        this.numeroDorsal = numeroDorsal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



}
