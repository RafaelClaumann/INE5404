package control;

import exceptions.EObjetoJaDefinido;
import java.util.ArrayList;
import model.SecaoEleitoral;
import interfaces.SecaoEleitoralInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SecaoEleitoralControle implements SecaoEleitoralInterface, Serializable {

    private static SecaoEleitoralControle secaoControle;
    private final ArrayList<SecaoEleitoral> secoesEleitorais;
    private final File file;

    public SecaoEleitoralControle() {
        secoesEleitorais = new ArrayList();
        file = new File("SecaoSerializada.bin");
    }

    public static SecaoEleitoralControle getSecaoControle() {
        if (SecaoEleitoralControle.secaoControle == null) {
            SecaoEleitoralControle.secaoControle = new SecaoEleitoralControle();
        }
        return SecaoEleitoralControle.secaoControle;
    }

    @Override
    public void insert(SecaoEleitoral secaoEleitoral) throws EObjetoJaDefinido {
        if (isUnique(secaoEleitoral)) {
            secoesEleitorais.add(secaoEleitoral);
        } else {
            throw new EObjetoJaDefinido("A Seção Eleitoral já foi cadastrada!");
        }
    }

    @Override
    public ArrayList<SecaoEleitoral> searchAll() {
        return secoesEleitorais;
    }

    @Override
    public ArrayList<SecaoEleitoral> searchAllByNum(int num) {
        ArrayList<SecaoEleitoral> secoes = new ArrayList();
        for (SecaoEleitoral secao : secoesEleitorais) {
            if (secao.getNumero() == num) {
                secoes.add(secao);
            }
        }
        return secoes;
    }

    @Override
    public ArrayList<SecaoEleitoral> searchAllByZonaNum(int num) {
        ArrayList<SecaoEleitoral> secoes = new ArrayList();
        for (SecaoEleitoral secao : secoesEleitorais) {
            if (secao.getZonaEleitoral().getNumero() == num) {
                secoes.add(secao);
            }
        }
        return secoes;
    }

    @Override
    public SecaoEleitoral searchByNum(int num) {
        for (SecaoEleitoral secao : secoesEleitorais) {
            if (secao.getNumero() == num) {
                return secao;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (SecaoEleitoral secao : secoesEleitorais) {
            if (secao.getNumero() == num) {
                System.out.println(secao.toString());
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (SecaoEleitoral secao : secoesEleitorais) {
            texto += secao.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(SecaoEleitoral secaoEleitoral) {
        for (SecaoEleitoral secao : secoesEleitorais) {
            if (secao.getNumero() == secaoEleitoral.getNumero()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addFromFile(ArrayList<SecaoEleitoral> secoes) {
        for (SecaoEleitoral secao : secoes) {
            this.secoesEleitorais.add(secao);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<SecaoEleitoral> secoes = this.secoesEleitorais;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(secoes);

        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<SecaoEleitoral> secoes;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        secoes = (ArrayList<SecaoEleitoral>) ois.readObject();

        fis.close();
        ois.close();

        this.secoesEleitorais.clear();

        addFromFile(secoes);

    }
}
