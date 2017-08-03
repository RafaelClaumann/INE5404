/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author martin.vigil
 */
public class Main {
    public static void main(String args[]){
        try{
           testaLer();
           
        }
        catch(FileNotFoundException e){
            System.out.println("O arquivo nao existe!");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static void testaGravar() throws FileNotFoundException, IOException{
        Secao secao = new Secao(5, "Trindade");
        Candidato fierre = new Candidato(1, "fierre");
        Candidato marcel = new Candidato(2, "marcel");
        Candidato david = new Candidato(3, "david");
        Partido partido = new Partido();
        
        partido.setPrefeito(fierre);
        partido.addPrefeito(david);
        partido.addPrefeito(marcel);
        
        BancoDeDados banco = new BancoDeDados();
        banco.gravar(partido, "partido.bin");
        banco.gravar(secao, "secao.bin");
    }
    
    public static void testaLer() throws IOException, FileNotFoundException, ClassNotFoundException{
        BancoDeDados<Partido> bancoDePartidos = new BancoDeDados();
        BancoDeDados<Secao> bancoDeSecoes = new BancoDeDados();
        
       
       Partido partido = bancoDePartidos.ler("partido.bin");
       Secao secao = bancoDeSecoes.ler("secao.bin");
       
        System.out.println(partido.getPrefeito().getNome());
        System.out.println(secao.getEndereco());
       
    }
}
