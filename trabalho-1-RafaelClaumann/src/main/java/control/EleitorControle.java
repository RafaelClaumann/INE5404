package control;

import exceptions.EObjetoJaDefinido;
import java.util.ArrayList;
import model.Eleitor;
import interfaces.EleitorInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EleitorControle implements EleitorInterface, Serializable {

    private static EleitorControle eleitorControle;
    private final ArrayList<Eleitor> eleitores;
    private final File file;

    public EleitorControle() {
        eleitores = new ArrayList();
        file = new File("EleitorSerializado.bin");
    }

    public static EleitorControle getEleitorControle() {
        if (EleitorControle.eleitorControle == null) {
            eleitorControle = new EleitorControle();
        }
        return EleitorControle.eleitorControle;
    }

    @Override
    public void insert(Eleitor eleitor) throws EObjetoJaDefinido {
        if (isUnique(eleitor)) {
            eleitores.add(eleitor);
        } else {
            throw new EObjetoJaDefinido("Eleitora já foi cadastrado!");
        }
    }

    @Override
    public ArrayList<Eleitor> searchAll() {
        return eleitores;
    }

    @Override
    public ArrayList<Eleitor> searchAllBySecaoNum(int num) {
        ArrayList<Eleitor> eleitors = new ArrayList();
        for (Eleitor eleitor : eleitores) {
            if (eleitor.getSecaoEleitoral().getNumero() == num) {
                eleitors.add(eleitor);
            }
        }
        return eleitors;
    }

    @Override
    public Eleitor searchByTitulo(int titulo) {
        for (Eleitor eleitor : eleitores) {
            if (eleitor.getNumeroTitulo() == titulo) {
                return eleitor;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (Eleitor eleitor : eleitores) {
            if (eleitor.getNumeroTitulo() == num) {
                eleitor.toString();
            }
        }
    }

    public String printAll() {
        String texto = "";
        for (Eleitor eleitor : eleitores) {
            texto += eleitor.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(Eleitor eleitor) {
        for (Eleitor eleitorVar : eleitores) {
            if (eleitorVar.getNumeroTitulo() == eleitor.getNumeroTitulo()) {
                return false;
            } else if (eleitorVar.getCpf().equalsIgnoreCase(eleitor.getCpf())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addFromFile(ArrayList<Eleitor> eleitores) {
        for (Eleitor eleitor : eleitores) {
            this.eleitores.add(eleitor);
        }
    }

    @Override
    public void serializacao() throws IOException {
        ArrayList<Eleitor> eleitor = this.eleitores;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(eleitor);

        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Eleitor> eleitor;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        eleitor = (ArrayList<Eleitor>) ois.readObject();

        fis.close();
        ois.close();

        this.eleitores.clear();

        addFromFile(eleitor);
    }

}
