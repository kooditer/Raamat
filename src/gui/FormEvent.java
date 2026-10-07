package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String pealkiri;
    private String autor;
    private String aasta;
    private int zhanr;
    private boolean kasLaenutatud;
    private String laenutaja;

    public FormEvent(Object source) {super(source);}

    public FormEvent(Object source, String pealkiri, String autor, String aasta,
    int zhanr, boolean kasLaenutatud, String laenutaja) {
        super(source);
        this.pealkiri = pealkiri;
        this.autor = autor;
        this.aasta = aasta;
        this.zhanr = zhanr;
        this.kasLaenutatud = kasLaenutatud;
        this.laenutaja = laenutaja;

    }

    public void setPealkiri(String pealkiri) {
        this.pealkiri = pealkiri;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAasta(String aasta) {
        this.aasta = aasta;
    }

    public boolean isKasLaenutatud() {
        return kasLaenutatud;
    }

    public int getZhanr() {
        return zhanr;
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public String getAutor() {
        return autor;
    }

    public String getAasta() {
        return aasta;
    }

    public String getLaenutaja() {
        return laenutaja;
    }
}
