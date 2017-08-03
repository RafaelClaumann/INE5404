package interfaces;

import exceptions.EObjetoJaDefinido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.Prefeito;

public interface PrefeitoInterface {

    public void insert(Prefeito prefeito) throws EObjetoJaDefinido;

    public ArrayList<Prefeito> searchAll();

    public Prefeito searchByNum(int num);

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(Prefeito prefeito);

    public void update(Prefeito prefeito);

    public void addFromFile(ArrayList<Prefeito> prefeitos);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
