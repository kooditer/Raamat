package model;

import java.io.*;
import java.util.*;

public class Database {
    //private ArrayList<Raamat> raamatud;
    private List<Raamat> raamatud;

    public Database() {
        raamatud = new LinkedList<Raamat>();
    }

    public void removeRaamat(int index) {
        raamatud.remove(index);
    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return Collections.unmodifiableList(raamatud);
    }
/// faili salvestamine ja faili avamine
    public void saveTofile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Raamat[] teosed = raamatud.toArray(new Raamat[raamatud.size()]);

        oos.writeObject(teosed);

        oos.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Raamat[] teosed = (Raamat[])ois.readObject();
            raamatud.clear();
            raamatud.addAll(Arrays.asList(teosed));


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ois.close();
    }
}
