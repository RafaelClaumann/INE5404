package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.UrnaEleitoral;

public interface UrnaEleitoralInterface {

    public ArrayList<UrnaEleitoral> searchAll();

    public ArrayList<UrnaEleitoral> searchAllBySecaoNum(int num);

    public ArrayList<UrnaEleitoral> searchAllBySerial(int num);

    public UrnaEleitoral searchByNum(int num);

    public void printByNum(int num);

    public String printAll();

    public boolean isUnique(UrnaEleitoral urna);

    public void addFromFile(ArrayList<UrnaEleitoral> urnas);

    public void serializacao() throws IOException, ClassNotFoundException;

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
