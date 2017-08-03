package control;

import exceptions.EObjetoJaDefinido;
import interfaces.PrefeitoInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import model.Prefeito;

public class PrefeitoControle implements PrefeitoInterface, Serializable {

    private static PrefeitoControle prefeitoControle;
    private final ArrayList<Prefeito> prefeitos;
    private final File file;

    public PrefeitoControle() {
        prefeitos = new ArrayList();
        file = new File("PrefeitoSerializado.bin");
    }

    public static PrefeitoControle getPrefeitoControle() {
        if (PrefeitoControle.prefeitoControle == null) {
            prefeitoControle = new PrefeitoControle();
        }
        return PrefeitoControle.prefeitoControle;
    }

    @Override
    public void insert(Prefeito prefeito) throws EObjetoJaDefinido {
        if (isUnique(prefeito)) {
            prefeitos.add(prefeito);
        } else {
            throw new EObjetoJaDefinido("Prefeito ja cadastrado");
        }
    }

    @Override
    public ArrayList<Prefeito> searchAll() {
        return prefeitos;
    }

    @Override
    public Prefeito searchByNum(int num) {
        for (Prefeito prefeito : prefeitos) {
            if (prefeito.getNumero() == num) {
                return prefeito;
            }
        }
        return null;
    }

    public Prefeito searchByTitulo(int titulo) {
        for (Prefeito prefeito : prefeitos) {
            if (prefeito.getNumeroTitulo() == titulo) {
                return prefeito;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (Prefeito prefeito : prefeitos) {
            if (prefeito.getNumero() == num) {
                System.out.println(prefeito.toString());
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (Prefeito prefeito : prefeitos) {
            texto += "numero: " + prefeito.getNumero() + ", partido: " + prefeito.getPartidoPolitico().getSigla() + ", " + prefeito.toString()  + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(Prefeito prefeito) {
        for (Prefeito prefeitoVar : this.prefeitos) {
            if (prefeitoVar.getNumeroTitulo() == prefeito.getNumeroTitulo()
                    || prefeitoVar.getNumero() == prefeito.getNumeroTitulo()
                    || prefeitoVar.getPartidoPolitico().equals(prefeito.getPartidoPolitico())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(Prefeito prefeito) {
        int index = prefeitos.indexOf(prefeito);
        if (index > -1) {
            prefeitos.add(index, prefeito);
        }
    }

    @Override
    public void addFromFile(ArrayList<Prefeito> prefeitos) {
        for (Prefeito prefeito : prefeitos) {
            this.prefeitos.add(prefeito);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<Prefeito> prefeito = this.prefeitos;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(prefeito);

        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Prefeito> prefeito;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        prefeito = (ArrayList<Prefeito>) ois.readObject();

        fis.close();
        ois.close();

        this.prefeitos.clear();

        addFromFile(prefeito);
    }

}
