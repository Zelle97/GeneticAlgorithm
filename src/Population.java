import java.util.ArrayList;
import java.util.List;

public class Population {
    private int mutationRate;
    private List<Element> elements;

    public Population(int populationSize, char [] searchWordArray, int mutationRate){
        this.mutationRate = mutationRate;
        this.elements = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            elements.add(new Element(searchWordArray));
        }
    }

    public Element getFittest(){
        Element fittestElement = this.elements.get(0);
        for (Element element : this.elements){
            if(fittestElement.getFitness() <= element.getFitness()) {
                fittestElement = element;
            }
        }
        return fittestElement;
    }

    public void removeElement(Element element) {
        this.elements.remove(element);
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void mutatePopulation() {
        for (int i = 0; i < (elements.size()-1); i++) {
            elements.get(i).mutate();
        }
    }
}
