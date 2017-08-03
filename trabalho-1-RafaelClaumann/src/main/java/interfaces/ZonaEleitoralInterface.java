package interfaces;

import exceptions.EObjetoJaDefinido;
import exceptions.EObjetoNaoEncontrado;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.ZonaEleitoral;

public interface ZonaEleitoralInterface {

    public void insert(ZonaEleitoral zonaEleitoral) throws EObjetoJaDefinido;

    public ArrayList<ZonaEleitoral> searchAll();

    public ZonaEleitoral searchByNum(int num) throws EObjetoNaoEncontrado;

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(ZonaEleitoral zonaEleitoral);

    public void addFromFile(ArrayList<ZonaEleitoral> zonas);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws IOException, ClassNotFoundException, FileNotFoundException;
}
