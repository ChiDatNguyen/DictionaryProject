package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();
    public void showAllWords()
    {
        try {
            dictionaryManagement.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.printf("|%-7s|%-110s|%-50s|\n","No","English","Vietnamese");
        int no = 1;
        for (Word element: dictionary.dictArr){
            System.out.printf("|%-7d|%-110s|%-50s|\n", no,element.getWord_target(),element.getWord_explain());
            no++;
        }
    }
    public void dictionarySeacher (){
        try {
            dictionaryManagement.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        String findWord = sc.nextLine();
        for (Word element : dictionary.dictArr) {
            if (element.getWord_target().contains(findWord)) {
                System.out.println(element.getWord_explain());
            }
        }
    }
    public void dictionaryBasic() {
        try {
            dictionaryManagement.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dictionaryManagement.insertFromCommandline(dictionary);
        dictionaryManagement.dictionaryExportToFile(dictionary);
        showAllWords();

    }
    public void dictionanyAdvance() {
        try {
            dictionaryManagement.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dictionaryManagement.insertFromCommandline(dictionary);
        dictionaryManagement.dictionaryExportToFile(dictionary);
        showAllWords();
        dictionaryManagement.dictionaryLookup(dictionary.dictArr);
    }
}
