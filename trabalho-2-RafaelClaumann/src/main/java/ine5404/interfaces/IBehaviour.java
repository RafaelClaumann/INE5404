/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.interfaces;

import ine5404.exceptions.ESizeLimiter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public interface IBehaviour {

    public void startGame(int dimension, int wordsQuantity) throws IOException, FileNotFoundException, ClassNotFoundException, ESizeLimiter;

    public char[][] returnBoard();

    public ArrayList returnWords();

    public void fillRandomBoard();

    public int generateLine(String word);

    public int generateColumn(String word);

    public void insertWords(ArrayList<String> words);

    public void insertVerticalNormal(ArrayList<String> words);

    public void insertHorizontalInverse(ArrayList<String> words);

    public void insertVerticalInverse(ArrayList<String> words);

    public boolean searchOnColumn(int row, int column, String word);

    public boolean searchOnRow(int row, int column, String word);

    public ArrayList<String> sortWords(int quantity) throws ESizeLimiter;

    public void readWordsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException;

}
