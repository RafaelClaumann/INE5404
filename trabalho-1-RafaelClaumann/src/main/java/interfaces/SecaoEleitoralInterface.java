package interfaces;

import exceptions.EObjetoJaDefinido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.SecaoEleitoral;

public interface SecaoEleitoralInterface {

    public void insert(SecaoEleitoral secaoEleitoral) throws EObjetoJaDefinido;

    public ArrayList<SecaoEleitoral> searchAll();

    public ArrayList<SecaoEleitoral> searchAllByZonaNum(int num);

    public ArrayList<SecaoEleitoral> searchAllByNum(int num);

    public SecaoEleitoral searchByNum(int num);

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(SecaoEleitoral secaoEleitoral);

    public void addFromFile(ArrayList<SecaoEleitoral> secoes);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws IOException, ClassNotFoundException, FileNotFoundException;
}
