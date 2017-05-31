/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charevolution;

/**
 *
 * @author Richard
 */
public class Sentence {
    private final String sentence;
    private int fitness;
    
    public Sentence(String chars){
        this.sentence = chars;
        fitness = 0;
    }

    public Sentence copyAndMutate(){
        return new Sentence(this.sentence);
    }
    
    public void setFitness(Sentence theTarget){
        fitness = 0;
        for (char parentChar : sentence.toCharArray()){
            for (char targetChar : theTarget.toString().toCharArray()){
                if (targetChar == parentChar){
                    fitness++;
                }
            }
        }
    }
    
    public int getFitness(){
        return fitness;
    }
    
    @Override
    public String toString() {
        return sentence;
    }
    
    
}
