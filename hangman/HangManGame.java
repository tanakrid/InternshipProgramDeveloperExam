package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class HangManGame {
    private ArrayList<Category> categories;
    private int score, limit;
    private StringBuilder displayWord, displayWrong;
    private String cwd = System.getProperty("user.dir");
    private String fileSep = System.getProperty("file.separator");

    public HangManGame(){
        limit = 10;
        categories = new ArrayList<>();
        displayWord = new StringBuilder();
        displayWrong = new StringBuilder();
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public void loadCategoryFromFile(String fileName){
        Category category = new Category(fileName.split("\\.")[0]);
        File file = new File(cwd+fileSep+fileSep+"Vocab"+fileSep+fileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String temp[] = line.split("\\|");
                category.addWord(new Word(temp[0], temp[1]));
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        addCategory(category);

    }

    public void displayCategory(){
        int i = 0;
        System.out.println("--- My Category ---");
        for (Category category:categories) {
            System.out.println(++i +" "+category.getName());
        }
    }

    public boolean checkAnswer(String target, String ans){
        String form = ans.toLowerCase().charAt(0)+"";
        if (target.toLowerCase().contains(form)
                && !displayWord.toString().toLowerCase().contains(form)) {
            for (int i = 0; i < displayWord.length(); i++) {
                if (form.charAt(0) == target.toLowerCase().charAt(i)){
                    displayWord.setCharAt(i,target.charAt(i));
                }
            }
            score += 10;
            return true;
        }else{
            displayWrong.append(form);
            score -= 3;
            return false;
        }
    }

    public void setDisplayWord(String target){
        for (int i = 0; i < target.length(); i++) {
            if (Character.isLetter(target.charAt(i)))
                displayWord.append("-");
            else
                displayWord.append(target.charAt(i));
        }
    }

    public void displayWrongGuess(){
        if (displayWrong.length() != 0) {
            System.out.print("Wrong guess: ");
            for (int i = 0; i < displayWrong.length(); i++) {
                System.out.print(displayWrong.charAt(i) + " ");
            }
        }
        System.out.println();
    }

    public void runGame(int categoryChoice){
        Scanner sc = new Scanner(System.in);
        Word target = categories.get(categoryChoice-1).getRandomWord();
        setDisplayWord(target.getWord());
        System.out.println("Hint: "+target.getHint());
        int i = 0;
        for (; i < limit && !displayWord.toString().equals(target.getWord()); i++) {
            System.out.print(displayWord+" score "+score+", remaining wrong guess "+(limit-i)+" ");
            displayWrongGuess();
            System.out.print("Your answer: ");
            String temp = sc.nextLine();
            if (temp.length() != 1){// check answer one character
                i--;
                System.out.println("Answer must be one character");
                continue;
            }
            if (displayWord.toString().toLowerCase().contains(temp.toLowerCase())){ // check duplicate answer
                i--;
                System.out.println("Don't duplicate answer");
                continue;
            }
            checkAnswer(target.getWord(),temp);
            if (displayWord.toString().equals(target.getWord())) // find character complete
                break;
        }
        if (i == limit && !displayWord.toString().equals(target.getWord())){ // check win or lose
            System.out.println("you lose");
        }else
            System.out.println("you win");
        System.out.println("your score: " + score);

    }
}
