package interfaces;

import exceptions.EObjetoJaDefinido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.PartidoPolitico;

public interface PartidoInterface {

    public void insert(PartidoPolitico partidoPolitico) throws EObjetoJaDefinido;

    public ArrayList<PartidoPolitico> searchAll();

    public PartidoPolitico searchByName(String nome);

    public PartidoPolitico searchBySigla(String sigla);

    public void printBySigla(String sigla);

    public String printAll();

    public boolean isUnique(PartidoPolitico partidoPolitico);

    public void update(PartidoPolitico partidoPolitico);

    public void addFromFile(ArrayList<PartidoPolitico> partidos);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
