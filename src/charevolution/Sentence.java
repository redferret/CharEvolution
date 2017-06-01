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
    private String sentence;
    private int fitness;
    public static int maxMutations;
    
    static {
        maxMutations = 2;
    }
    
    public Sentence(String chars){
        this.sentence = chars;
        fitness = 0;
    }

    public Sentence copyParent(){
        return new Sentence(sentence);
    }
    
    public void mutate(int numMutations){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(sentence);
        
        for (int i = 0; i < numMutations; i++){
            int randomCharIndex = random.nextInt(0, sentence.length());
            sb.setCharAt(randomCharIndex, CharEvolution.rndChar());
        }
        sentence = sb.toString();
    }
    
    public Sentence copyAndMutate(){
        
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int numMutations = random.nextInt(1, maxMutations);
        Sentence child = copyParent();
        child.mutate(numMutations);
        
        return child;
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
