/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author martin.vigil
 */
public class BancoDeDados<T> {
    
    public void gravar(T objeto, String arquivo) throws FileNotFoundException, IOException{
         FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(objeto);
        oos.close();
    }
           
     public T ler(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        return (T) ois.readObject();
    }
}
