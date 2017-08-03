/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Serializacao {

    public static ArrayList<Aluno> listaAluno = new ArrayList();
    public static final File file = new File("AlunoSerializado.bin");

    public static void main(String[] args) {
        Aluno aluno0 = new Aluno("Rafael", "CTC202");
        Aluno aluno1 = new Aluno("Rafael", "INE204");
        Aluno aluno2 = new Aluno("Rafael", "EFI304");
        listaAluno.add(aluno0);
        listaAluno.add(aluno1);
        listaAluno.add(aluno2);

        serializa("alunos.ser", listaAluno);

        //desserializa("alunos.ser");
        for (Aluno aluno : desserializa("alunos.ser")) {
            System.out.println("Nome: " + aluno.getNome() + ", Sala: " + aluno.getSala());

        }
    }

    public static void serializa(String arquivo, ArrayList<Aluno> alunos) {
        try {
            //file input(saida) a string passada é o nome do arquivo.
            FileOutputStream fos = new FileOutputStream(arquivo);

            //object input(saida) parametro é fileOutputStrem (fos)
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //ObjectOutput escrita (write)
            oos.writeObject(alunos);

            //fechamando dos métodos
            fos.close();
            oos.close();

            //try catch obrigatório
        } catch (IOException ex) {
            Logger.getLogger(Serializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Aluno> desserializa(String arquivo) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            //file input(entrada)
            FileInputStream fis = new FileInputStream(arquivo);

            //object input(entrada)
            ObjectInputStream ois = new ObjectInputStream(fis);

            //cast de object para Arraylist de Alunos
            alunos = (ArrayList<Aluno>) ois.readObject();

            //fechando os inputs
            fis.close();
            ois.close();

            //Exceptions obrigatórias
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Classe não encontrada");
        }
        //retorno do vetor de alunos
        return alunos;
    }

    // Metodos utilizados no trabalho Eleicao
    public void addFromFile(ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            listaAluno.add(aluno);
        }
    }

    public void serializacao() throws IOException {
        ArrayList<Aluno> aluno = this.listaAluno;

        FileOutputStream fos = new FileOutputStream(this.file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(aluno);

        fos.close();
        oos.close();
    }

    public void desserializacao() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Aluno> aluno;

        FileInputStream fis = new FileInputStream(this.file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.listaAluno.clear();

        this.listaAluno = (ArrayList<Aluno>) ois.readObject();

        fis.close();
        ois.close();
    }

}
