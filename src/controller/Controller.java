package controller;

import gui.FormEvent;
import model.Database;
import model.Raamat;
import model.ZhanriModel;

import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Raamat> getRRaamat() {//vajalik tabeli jaoks
        return db.getRaamatud();
    }


    public void makeRaamat(FormEvent ev) {
        String pealkiri = ev.getPealkiri();
        String autor = ev.getAutor();
        String aasta = ev.getAasta();
        int zhanr = ev.getZhanr();
        boolean laenutatudcheck = ev.isKasLaenutatud();
        String laenutaja = ev.getLaenutaja();

        ZhanriModel zhanriModel = null;
        switch (zhanr) {
            case 0:
                zhanriModel = ZhanriModel.luuletused;
                break;
            case 1:
                zhanriModel = ZhanriModel.eneseabi;
                break;
            case 2:
                zhanriModel = ZhanriModel.lasteraamat;
                break;
            case 3:
                zhanriModel = ZhanriModel.elulood;
                break;
            case 4:
                zhanriModel = ZhanriModel.õpperaamat;
                break;
        }

        Raamat raamat = new Raamat(pealkiri, autor, aasta, zhanriModel, laenutatudcheck, laenutaja);
        db.addRaamat(raamat);



    }

}
