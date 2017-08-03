package control;

import exceptions.EObjetoJaDefinido;
import interfaces.PartidoInterface;
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

public class PartidoControle implements PartidoInterface, Serializable {

    private static PartidoControle partidoControle;
    private final ArrayList<PartidoPolitico> partidoPoliticos;
    private final File file;

    public PartidoControle() {
        partidoPoliticos = new ArrayList();
        file = new File("PartidoPoliticoSerializado.bin");
    }

    public static PartidoControle getPartidoControle() {
        if (PartidoControle.partidoControle == null) {
            partidoControle = new PartidoControle();
        }
        return PartidoControle.partidoControle;
    }

    @Override
    public void insert(PartidoPolitico partidoPolitico) throws EObjetoJaDefinido {
        if (isUnique(partidoPolitico)) {
            partidoPoliticos.add(partidoPolitico);
        } else {
            throw new EObjetoJaDefinido("Partido já cadastrado!");
        }
    }

    @Override
    public ArrayList<PartidoPolitico> searchAll() {
        return partidoPoliticos;
    }

    @Override
    public PartidoPolitico searchBySigla(String sigla) {
        for (PartidoPolitico partidoPolitico : partidoPoliticos) {
            if (partidoPolitico.getSigla().equalsIgnoreCase(sigla)) {
                return partidoPolitico;
            }
        }
        return null;
    }

    @Override
    public PartidoPolitico searchByName(String nome) {
        for (PartidoPolitico partidoPolitico : partidoPoliticos) {
            if (partidoPolitico.getNome().equalsIgnoreCase(nome)) {
                return partidoPolitico;
            }
        }
        return null;
    }

    @Override
    public void printBySigla(String sigla) {
        for (PartidoPolitico partido : partidoPoliticos) {
            if (partido.getSigla().equalsIgnoreCase(sigla)) {
                System.out.println(partido.toString());
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (PartidoPolitico partido : partidoPoliticos) {
            texto += partido.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(PartidoPolitico partidoPolitico) {
        return searchBySigla(partidoPolitico.getSigla()) == null && searchByName(partidoPolitico.getNome()) == null;
    }

    @Override
    public void update(PartidoPolitico partidoPolitico) {
        int index = partidoPoliticos.indexOf(partidoPolitico);
        if (index > -1) {
            partidoPoliticos.remove(index);

            partidoPoliticos.add(index, partidoPolitico);
        }
    }

    @Override
    public void addFromFile(ArrayList<PartidoPolitico> partidos) {
        for (PartidoPolitico partido : partidos) {
            this.partidoPoliticos.add(partido);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<PartidoPolitico> partido = this.partidoPoliticos;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(partido);

        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<PartidoPolitico> partidos;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        partidos = (ArrayList<PartidoPolitico>) ois.readObject();

        fis.close();
        ois.close();

        this.partidoPoliticos.clear();

        addFromFile(partidos);
    }

}
