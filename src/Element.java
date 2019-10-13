import java.util.Random;

public class Element {

    final char [] searchWordArray;

    private int length = 6;
    private char [] charArray;
    private Integer fitness = null;


    public Element(char [] searchWordArray){
        this.searchWordArray = searchWordArray;
        this.charArray = new char[this.length];
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < this.length; i++) {
            this.charArray[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
    }

    public char [] getCharArray(){
        return this.charArray;
    }

    public void setFitness(int fitness){
        this.fitness = fitness;
    }

    public int getFitness(){
        if (this.fitness != null) {
            return this.fitness;
        } else {
            int elementFitness = 0;
            char[] elementArray = this.charArray;
            for (int i = 0; i < elementArray.length; i++) {
                if(elementArray[i] == this.searchWordArray[i]) {
                    elementFitness++;
                }
            }
            this.fitness = elementFitness;
            return elementFitness;
        }
    }

    public void setCharArray(char [] charArray) {
        this.charArray = charArray;
    }

    public void mutate(){
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < this.length; i++) {
            this.charArray[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
        this.fitness = null;
    }
}
