package interfaces;

import exceptions.EObjetoJaDefinido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.PartidoPolitico;
import model.Vereador;

public interface VereadorInterface {

    public void insert(Vereador vereador) throws EObjetoJaDefinido;

    public ArrayList<Vereador> searchAll();

    public ArrayList<Vereador> searchByPartido(PartidoPolitico partidoPolitico);

    public Vereador searchByNum(int num);

    public Vereador searchByTitulo(int titulo);

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(Vereador vereador);

    public void addFromFile(ArrayList<Vereador> vereadores);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException;

}
