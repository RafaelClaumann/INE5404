package control;

import exceptions.EObjetoJaDefinido;
import interfaces.ZonaEleitoralInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import model.ZonaEleitoral;

public class ZonaEleitoralControle implements ZonaEleitoralInterface, Serializable {

    private static ZonaEleitoralControle zonaControle;
    private final ArrayList<ZonaEleitoral> zonasEleitorais;
    private final File file;

    public ZonaEleitoralControle() {
        zonasEleitorais = new ArrayList();
        file = new File("ZonaSerializada.bin");
    }

    public static ZonaEleitoralControle getZonaControle() {
        if (ZonaEleitoralControle.zonaControle == null) {
            ZonaEleitoralControle.zonaControle = new ZonaEleitoralControle();
        }
        return ZonaEleitoralControle.zonaControle;
    }

    @Override
    public void insert(ZonaEleitoral zonaEleitoral) throws EObjetoJaDefinido {
        if (isUnique(zonaEleitoral)) {
            zonasEleitorais.add(zonaEleitoral);
        } else {
            throw new EObjetoJaDefinido("Zona eleitoral já cadastrada!");
        }
    }

    @Override
    public ArrayList<ZonaEleitoral> searchAll() {
        return zonasEleitorais;
    }

    @Override
    public ZonaEleitoral searchByNum(int num) {
        for (ZonaEleitoral zona : zonasEleitorais) {
            if (zona.getNumero() == num) {
                return zona;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (ZonaEleitoral zona : zonasEleitorais) {
            if (zona.getNumero() == num) {
                System.out.println(zona.toString());
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (ZonaEleitoral zona : zonasEleitorais) {
            texto += zona.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(ZonaEleitoral zonaEleitoral) {
        for (ZonaEleitoral zona : zonasEleitorais) {
            if (zona.getNumero() == zonaEleitoral.getNumero()) {
                return false;
            } else if (zona.getLocalizacao().equalsIgnoreCase(zonaEleitoral.getLocalizacao())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addFromFile(ArrayList<ZonaEleitoral> zonas) {
        for (ZonaEleitoral zona : zonas) {
            this.zonasEleitorais.add(zona);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<ZonaEleitoral> zonas = this.zonasEleitorais;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(zonas);

        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<ZonaEleitoral> zona;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        zona = (ArrayList<ZonaEleitoral>) ois.readObject();

        fis.close();
        ois.close();

        this.zonasEleitorais.clear();

        addFromFile(zona);

    }
}
