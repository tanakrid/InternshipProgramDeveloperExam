package hangman;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        HangManGame hangManGame = new HangManGame();
        hangManGame.loadCategoryFromFile("Animal.txt");
        hangManGame.loadCategoryFromFile("Movie.txt");
        hangManGame.displayCategory();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose Category: ");
        hangManGame.runGame(sc.nextInt());
//        StringBuilder sb = new StringBuilder();
//        sb.append("kak");
//        String s = "kak";
//        System.out.println(sb.toString().equals(s));
    }
}
