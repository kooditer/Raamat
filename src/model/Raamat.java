package model;

public class Raamat {
    private static int count = 0;
    private int raamatuId;
    private String pealkiri;
    private String autor;
    private String aasta;
    private ZhanriModel zhanr;
    private boolean clicked;
    private String laenutaja;

    public Raamat(String pealkiri, String autor, String aasta, ZhanriModel zhanr, boolean clicked,
                  String laenutaja) {
        this.pealkiri = pealkiri;
        this.autor = autor;
        this.aasta = aasta;
        this.zhanr = zhanr;
        this.clicked = clicked;
        this.laenutaja = laenutaja;
        this.raamatuId = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Raamat.count = count;
    }

    public int getRaamatuId() {
        return raamatuId;
    }

    public void setRaamatuId(int raamatuId) {
        this.raamatuId = raamatuId;
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public void setPealkiri(String pealkiri) {
        this.pealkiri = pealkiri;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ZhanriModel getZhanr() {
        return zhanr;
    }

    public void setZhanr(ZhanriModel zhanr) {
        this.zhanr = zhanr;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String getLaenutaja() {
        return laenutaja;
    }

    public void setLaenutaja(String laenutaja) {
        this.laenutaja = laenutaja;
    }

    public String getAasta() {
        return aasta;
    }

    public void setAasta(String aasta) {
        this.aasta = aasta;
    }
}
