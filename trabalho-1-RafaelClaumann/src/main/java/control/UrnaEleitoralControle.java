package control;

import exceptions.EObjetoJaDefinido;
import java.util.ArrayList;
import model.UrnaEleitoral;
import interfaces.UrnaEleitoralInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.Prefeito;
import model.Vereador;

public class UrnaEleitoralControle implements UrnaEleitoralInterface, Serializable {

    private static UrnaEleitoralControle urnaControle;
    private final ArrayList<UrnaEleitoral> urnasEleitorais;
    private final File file;

    public UrnaEleitoralControle() {
        urnasEleitorais = new ArrayList();
        file = new File("UrnaSerializada.bin");
    }

    public static UrnaEleitoralControle getUrnaControle() {
        if (UrnaEleitoralControle.urnaControle == null) {
            urnaControle = new UrnaEleitoralControle();
        }
        return UrnaEleitoralControle.urnaControle;
    }

    @Override
    public ArrayList<UrnaEleitoral> searchAll() {
        return urnasEleitorais;
    }

    public void insert(UrnaEleitoral urna) throws EObjetoJaDefinido {
        if (isUnique(urna)) {
            urnasEleitorais.add(urna);
        } else {
            throw new EObjetoJaDefinido("A urna ja foi cadastrada");
        }
    }

    @Override
    public ArrayList<UrnaEleitoral> searchAllBySecaoNum(int num) {
        ArrayList<UrnaEleitoral> urnas = new ArrayList();
        for (UrnaEleitoral urna : urnasEleitorais) {
            if (urna.getSecao().getNumero() == num) {
                urnas.add(urna);
            }
        }
        return urnas;
    }

    @Override
    public ArrayList<UrnaEleitoral> searchAllBySerial(int serial) {
        ArrayList<UrnaEleitoral> urnas = new ArrayList<>();
        for (UrnaEleitoral urna : urnasEleitorais) {
            if (urna.getSerial() == serial) {
                urnas.add(urna);
            }
        }
        return urnas;
    }

    @Override
    public UrnaEleitoral searchByNum(int num) {
        for (UrnaEleitoral urna : urnasEleitorais) {
            if (urna.getSecao().getNumero() == num) {
                return urna;
            }
        }
        return null;
    }

    @Override
    public void printByNum(int num) {
        for (UrnaEleitoral urna : urnasEleitorais) {
            if (urna.getSecao().getNumero() == num) {
                System.out.println(urna.toString());
            }
        }
    }

    @Override
    public String printAll() {
        String texto = "";
        for (UrnaEleitoral urna : urnasEleitorais) {
            texto += urna.toString() + "\n";
        }
        return texto;
    }

    @Override
    public boolean isUnique(UrnaEleitoral urna) {
        for (UrnaEleitoral u : urnasEleitorais) {
            if (u.getSecao().getNumero() == urna.getSecao().getNumero()) {
                return false;
            }
        }
        return true;
    }

    public void updateVotes(Prefeito prefeito, Vereador vereador) throws NullPointerException {
        if (prefeito != null || vereador != null) {
            prefeito.setVotos(prefeito.getVotos() + 1);
            vereador.setVotos(vereador.getVotos() + 1);
        }else{
            throw new NullPointerException("Prefeito, ou Verador não econtrado!");
        }
    }

    public Prefeito apuraPrefeito() {
        PrefeitoControle prefeitoControle = PrefeitoControle.getPrefeitoControle();
        Prefeito prefeitoEleito = null;

        int maior = 0;
        for (Prefeito prefeito : prefeitoControle.searchAll()) {
            if (prefeito.getVotos() > maior) {
                maior = prefeito.getVotos();
                prefeitoEleito = prefeito;
            }
        }
        return prefeitoEleito;
    }

    public Vereador apuraVereador() {
        VereadorControle vereadorControle = VereadorControle.getVeradorControle();
        Vereador vereadorEleito = null;

        int maior = 0;
        for (Vereador vereador : vereadorControle.searchAll()) {
            if (vereador.getVotos() > maior) {
                maior = vereador.getVotos();
                vereadorEleito = vereador;
            }
        }
        return vereadorEleito;
    }

    public void abrirUrnas() {
        for (UrnaEleitoral urna : this.urnasEleitorais) {
            urna.setAberta(true);
        }
    }

    public void fecharUrnas() {
        for (UrnaEleitoral urna : this.urnasEleitorais) {
            urna.setAberta(false);
        }
    }

    @Override
    public void addFromFile(ArrayList<UrnaEleitoral> urnas) {
        for (UrnaEleitoral urna : urnas) {
            this.urnasEleitorais.add(urna);
        }
    }

    @Override
    public void serializacao() throws IOException, ClassNotFoundException {
        ArrayList<UrnaEleitoral> urna = this.urnasEleitorais;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(urna);
        fos.close();
        oos.close();
    }

    @Override
    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<UrnaEleitoral> urna;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        urna = (ArrayList<UrnaEleitoral>) ois.readObject();

        fis.close();
        ois.close();
        this.urnasEleitorais.clear();
        addFromFile(urna);
    }
}
