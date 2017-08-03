package interfaces;

import exceptions.EObjetoJaDefinido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.Eleitor;

public interface EleitorInterface {

    public void insert(Eleitor eleitor) throws EObjetoJaDefinido;

    public ArrayList<Eleitor> searchAllBySecaoNum(int num);

    public ArrayList<Eleitor> searchAll();

    public Eleitor searchByTitulo(int num) throws EObjetoJaDefinido;

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(Eleitor eleitor);

    public void addFromFile(ArrayList<Eleitor> eleitores);

    public void serializacao() throws IOException;

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
