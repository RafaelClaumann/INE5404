/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 *
 * @author rafael
 * @param <T>
 */
public class DatabaseControl<T> {

    private static DatabaseControl instance;

    public static DatabaseControl getDatabaseControl() {
        if (DatabaseControl.instance == null) {
            DatabaseControl.instance = new DatabaseControl();
        }
        return DatabaseControl.instance;
    }

    public void writeData(T objeto, String arquivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(objeto);
        oos.close();
    }

    public void WriteList(Set<T> writeSet, String arquivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(writeSet);
        oos.close();
    }

    public T loadData(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (T) ois.readObject();
    }

    public Set<T> loadList(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Set<T>) ois.readObject();
    }

}
