package Algorithms;

import javax.swing.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
 */
public class ImplementTriePrefixTree {
    Set<String> hashSet = new HashSet<>();

    public void insert(String word){
        hashSet.add(word);
    }

    public Boolean search(String word){
        if(hashSet.contains(word)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean startsWith(String word){
        Iterator iterator = hashSet.iterator();
        Boolean startsWith = false;

        while (iterator.hasNext()){
            String data = (String) iterator.next();
            if(data.substring(0, word.length()).equals(word)){
                return true;
            }else{
                startsWith =  false;
            }
        }
        return startsWith;
    }

    //Debug
    public void printSet(){
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class TrieDriver{
    public static void main(String[] args) {
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();

        String element1 = "apple";
        trie.insert(element1);

        Boolean isThere = trie.search(element1);
        System.out.println(element1 + " is there? " + isThere);

        String element2 = "app";
        isThere = trie.search(element2);
        System.out.println(element2 + " is there? " + isThere);

        String element3 = "app";
        Boolean isStartsWith = trie.startsWith(element3);
        System.out.println("element start with " + element3 + " is there? " + isStartsWith);

        trie.insert("app");

        isThere = trie.search("app");
        System.out.println(element3 + " is there? " + isThere);

    }
}