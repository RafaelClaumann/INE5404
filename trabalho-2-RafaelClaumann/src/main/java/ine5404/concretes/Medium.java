/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ine5404.concretes;

import ine5404.exceptions.ESizeLimiter;
import ine5404.interfaces.IBehaviour;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public final class Medium implements IBehaviour {

    Random randomic = new Random();
    private char[][] board;
    final ArrayList<String> wordsList = new ArrayList();
    final ArrayList<String> sortedWords = new ArrayList();

    public Medium(int dimension, int wordsQuantity) throws IOException, FileNotFoundException, ClassNotFoundException, ESizeLimiter {
        startGame(dimension, wordsQuantity);
    }

    @Override
    public void startGame(int dimension, int wordsQuantity) throws IOException, FileNotFoundException, ClassNotFoundException, ESizeLimiter {
        board = new char[dimension][dimension];
        fillRandomBoard();
        readWordsFromFile();
        insertHorizontalInverse(sortWords(wordsQuantity / 4));
        insertVerticalInverse(sortWords(wordsQuantity / 4));

        insertWords(sortWords((wordsQuantity / 4)));
        insertVerticalNormal(sortWords((wordsQuantity / 4)));
    }

    @Override
    public char[][] returnBoard() {
        return this.board;
    }

    @Override
    public ArrayList returnWords() {
        return sortedWords;
    }

    @Override
    public void fillRandomBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = '-';
            }
        }
    }

    @Override
    public int generateLine(String word) {
        int row = (int) randomic.nextInt(board.length);
        while (word.length() > board.length - row) {
            row = (int) randomic.nextInt(board.length);
        }
        return row;
    }

    @Override
    public int generateColumn(String word) {
        int column = (int) randomic.nextInt(board.length);
        while (word.length() > board.length - column) {
            column = (int) randomic.nextInt(board.length);
        }
        return column;
    }

    @Override
    public void insertWords(ArrayList<String> words) {
        for (int k = 0; k < words.size(); k++) {
            char[] word = words.get(k).toCharArray();
            int wordVar = 0;

            int row = generateLine(words.get(k));
            int column = generateColumn(words.get(k));

            if (searchOnRow(row, column, words.get(k))) {
                for (int j = column; j < board.length; j++) {
                    if (wordVar < word.length) {
                        board[row][j] = word[wordVar];
                        wordVar++;
                    }
                }
                sortedWords.add(words.get(k));
            } else {
                k--;
            }
        }
    }

    @Override
    public void insertVerticalNormal(ArrayList<String> words) {
        for (int k = 0; k < words.size(); k++) {
            char[] word = words.get(k).toCharArray();
            int wordVar = 0;

            int row = generateLine(words.get(k));
            int column = generateColumn(words.get(k));

            if (searchOnColumn(row, column, words.get(k))) {
                for (int i = row; i < board.length; i++) {
                    if (wordVar < word.length) {
                        board[i][column] = word[wordVar];
                        wordVar++;
                    }
                }
                sortedWords.add(words.get(k));
            } else {
                k--;
            }
        }
    }

    @Override
    public void insertHorizontalInverse(ArrayList<String> words) {
        for (int k = 0; k < words.size(); k++) {
            char[] word = words.get(k).toCharArray();
            int wordVar = (words.get(k).length() - 1);

            int row = generateLine(words.get(k));
            int column = generateColumn(words.get(k));

            if (searchOnRow(row, column, words.get(k))) {
                for (int j = column; j < board.length; j++) {
                    if (wordVar >= 0) {
                        board[row][j] = word[wordVar];
                        wordVar--;
                    }
                }
                sortedWords.add(words.get(k));
            } else {
                k--;
            }
        }
    }

    @Override
    public void insertVerticalInverse(ArrayList<String> words) {
        for (int k = 0; k < words.size(); k++) {
            char[] word = words.get(k).toCharArray();
            int wordVar = (words.get(k).length() - 1);;

            int row = generateLine(words.get(k));
            int column = generateColumn(words.get(k));

            if (searchOnColumn(row, column, words.get(k))) {
                for (int i = row; i < board.length; i++) {
                    if (wordVar >= 0) {
                        board[i][column] = word[wordVar];
                        wordVar--;
                    }
                }
                sortedWords.add(words.get(k));
            } else {
                k--;
            }
        }
    }

    @Override
    public boolean searchOnColumn(int row, int column, String word) {
        int counter = 0;
        boolean verify = true;

        for (int i = row; counter < word.length(); i++) {
            if (board[i][column] != '-') {
                verify = false;
                break;
            }
            counter++;
        }
        return verify;
    }

    @Override
    public boolean searchOnRow(int row, int column, String word) {
        int counter = 0;
        boolean verify = true;

        for (int j = column; counter < word.length(); j++) {
            if (board[row][j] != '-') {
                verify = false;
                break;
            }
            counter++;
        }
        return verify;
    }

    @Override
    public ArrayList<String> sortWords(int quantity) throws ESizeLimiter {
        ArrayList<String> words = new ArrayList();

        if (board.length <= 16 && (quantity * 4) >= 8) {
            throw new ESizeLimiter();
        } else if (board.length == 20 && (quantity * 4) > 8) {
            throw new ESizeLimiter();
        }

        while (quantity > 0) {
            int randomIndex = (int) (Math.random() * this.wordsList.size() - 1);
            words.add(this.wordsList.get(randomIndex));
            this.wordsList.remove(randomIndex);
            quantity--;
        }
        System.out.println(words);
        return words;
    }

    @Override
    public void readWordsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("words");
        Scanner readLine = new Scanner(file);
        while (readLine.hasNext()) {
            String readedString = readLine.next();
            if (readedString.length() < (board.length - 6)) {
                wordsList.add(readedString);
            }
        }
    }
}
