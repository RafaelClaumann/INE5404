package control;

import exceptions.EObjetoJaDefinido;
import interfaces.VereadorInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import model.PartidoPolitico;
import model.Vereador;

public class VereadorControle implements VereadorInterface, Serializable {

    private static VereadorControle vereadorControle;
    private final ArrayList<Vereador> vereadores;
    private final File file;

    public VereadorControle() {
        vereadores = new ArrayList();
        file = new File("VereadorSerializado.bin");
    }

    public static VereadorControle getVeradorControle() {
        if (VereadorControle.vereadorControle == null) {
            vereadorControle = new VereadorControle();
        }
        return VereadorControle.vereadorControle;
    }

    @Override
    public void insert(Vereador vereador) throws EObjetoJaDefinido {
        if (isUnique(vereador)) {
            vereadores.add(vereador);
        } else {
            throw new EObjetoJaDefinido("Vereador ja cadastrado");
        }
    }

    @Override
    public ArrayList<Vereador> searchAll() {
        return this.vereadores;
    }

    @Override
    public ArrayList<Vereador> searchByPartido(PartidoPolitico partidoPolitico) {
        ArrayList<Vereador> Auxiliar = new ArrayList<>();
        for (Vereador vereador : vereadores) {
            if (vereador.getPartidoPolitico().getNome().equals(partidoPolitico.getNome())) {
                Auxiliar.add(vereador);
            }
        }
        return Auxiliar;
    }

    @Override
    public Vereador searchByNum(int num) {
        for (Vereador vereador : vereadores) {
            if (vereador.getNumero() == num) {
                return vereador;
            }
        }
        return null;
    }

    @Override
    public Vereador searchByTitulo(int titulo) {
        for (Vereador vereador : vereadores) {
            if (vereador.getNumeroTitulo() == titulo) {
                return vereador;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (Vereador vereador : vereadores) {
            if (vereador.getNumero() == num) {
                vereador.toString();
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (Vereador vereador : vereadores) {
            texto += "numero: " + vereador.getNumero() + ", partido: " + vereador.getPartidoPolitico().getSigla() + ", " + vereador.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(Vereador vereador) {
        for (Vereador vereadorVar : vereadores) {
            if (vereadorVar.getNumeroTitulo() == vereador.getNumeroTitulo()
                    || vereadorVar.getNumero() == vereador.getNumero()
                    || vereadorVar.getPartidoPolitico().equals(vereador.getPartidoPolitico())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addFromFile(ArrayList<Vereador> vereadores) {
        for (Vereador vereador : vereadores) {
            this.vereadores.add(vereador);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<Vereador> vereador = this.vereadores;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(vereador);
        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Vereador> vereador;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        vereador = (ArrayList<Vereador>) ois.readObject();

        fis.close();
        ois.close();
        this.vereadores.clear();
        addFromFile(vereador);
    }
}
