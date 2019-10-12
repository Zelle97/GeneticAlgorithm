
public class Main {
    public static void main(String[] args) {

        String searchWord = "senpai";
        int populationStartSize = 10;
        int mutationRate = 100;

        char [] searchWordArray = searchWord.toCharArray();

        Population population = new Population(populationStartSize, searchWordArray, mutationRate);
        int generations = 0;

        while (population.getFittest().getFitness() != 6){
            Element parentOne = population.getFittest();
            population.removeElement(parentOne);
            Element parentTwo = population.getFittest();
            population.removeElement(parentTwo);
            population.addElement(parentOne);
            population.addElement(parentTwo);
            Element childElement = createChild(parentOne, parentTwo, searchWordArray);
            population.addElement(childElement);
            population.mutatePopulation();
            generations++;
        }

        Element finalElement = population.getFittest();

        String finalString = "";

        for (char elementChar :finalElement.getCharArray()) {
            finalString = finalString.concat(String.valueOf(elementChar));
        }

        System.out.println("Success: " + finalString);
        System.out.println("Generations: " + generations);

    }

    private static Element createChild(Element parentOne, Element parentTwo, char [] searchWordArray) {

        Element child = new Element(searchWordArray);
        char [] childArray = new char[child.getCharArray().length];

        char[] parentOneCharArray = parentOne.getCharArray();
        char[] parentTwoCharArray = parentTwo.getCharArray();

        childArray[0] = parentOneCharArray[0];
        childArray[1] = parentOneCharArray[1];
        childArray[2] = parentOneCharArray[2];

        childArray[3] = parentTwoCharArray[3];
        childArray[4] = parentTwoCharArray[4];
        childArray[5] = parentTwoCharArray[5];

        child.setCharArray(childArray);
        return child;
    }

}
