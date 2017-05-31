/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charevolution;

import java.util.concurrent.ThreadLocalRandom;

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
        
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomCharIndex;
        
        StringBuilder sb = new StringBuilder(sentence);
        
        randomCharIndex = random.nextInt(0, sentence.length());
        sb.setCharAt(randomCharIndex, CharEvolution.rndChar());
        
        return new Sentence(sb.toString());
    }
    
    public void setFitness(Sentence theTarget){
        fitness = 0;
        String target = theTarget.toString();
        
        for (int i = 0; i < target.length(); i++){
            if (target.charAt(i) == sentence.charAt(i)){
                fitness++;
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
