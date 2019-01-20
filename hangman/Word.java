package hangman;

public class Word {
    private String word;
    private String hint;

    public Word(String name, String hint){
        word = name;
        this.hint = hint;
    }

    public String getWord() {
        return word;
    }

    public String getHint() {
        return hint;
    }
}
