package hangman;

import java.util.ArrayList;
import java.util.Random;

public class Category {
    private String name;
    private ArrayList<Word> words;

    public Category(String name){
        this.name = name;
        words = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Word getRandomWord(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    public void addWord(Word word){
        words.add(word);
    }

    public int getAmountOfWord(){
        return words.size();
    }
}
