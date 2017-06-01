
package charevolution;

import static charevolution.Sentence.maxMutations;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Richard DeSilvey
 */
public class CharEvolution {

    public final static int NUM_OF_CHILDREN = 50;
    
    private final Sentence target;
    private Sentence parent;
    private final static String RAND_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
            + "abcdefghijklmnopqrstuvwxyz!'";
    
    public CharEvolution(Sentence target){
        this.target = target;
    }
    
    public static char rndChar() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return RAND_CHARS.charAt(random.nextInt(0, RAND_CHARS.length()));
    }
    
    public void evolve(){
        String randomText = randomText();
        parent = new Sentence(randomText);
        parent.setFitness(target);
        List<Sentence> offSpring = new ArrayList<>();
        int generation = 0;
        int maxFitness = target.toString().length();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        while(true){
            for (int i = 0; i < NUM_OF_CHILDREN; i++){
                offSpring.add(parent.copyAndMutate());
            }
            setFitnessLevels(offSpring);
            printGeneration(offSpring, generation);
            List<Sentence> bestOffSpring = getBestOffSpring(offSpring);
            List<Sentence> nextBestOffSpring = getBest(bestOffSpring);
            
            if (!nextBestOffSpring.isEmpty()){
                parent = nextBestOffSpring.get(random.nextInt(nextBestOffSpring.size()));
            }else{
                parent = offSpring.get(random.nextInt(offSpring.size()));
            }
            if (parent.getFitness() == maxFitness){
                break;
            }else{
                generation++;
                offSpring.clear();
            }
        }
        System.out.println("Original: " + randomText);
        System.out.println("Final:    " + parent);
    }
    
    private void printGeneration(List<Sentence> offSpring, int gen){
        System.out.println("------------------- GENERATION " 
                + gen + " -------------------");
        System.out.println("Parent: " + parent + " : " + parent.getFitness());
        
        offSpring.forEach(child -> {
            System.out.println("  " + child + " : " + child.getFitness());
        });
        System.out.println("----------------- END OF GENERATION " 
                + gen + " -----------------");
    }
    
    public List<Sentence> getBestOffSpring(List<Sentence> offSpring){
        
        List<Sentence> bestOffSpring = new ArrayList<>();
        int bestFitness = 0;
        
        for (Sentence child : offSpring){
            if (child.getFitness() >= bestFitness){
                bestOffSpring.add(child);
                bestFitness = child.getFitness();
            }
        }
        
        return bestOffSpring;
    }
    
    public List<Sentence> getBest(List<Sentence> offSpring){
        
        List<Sentence> bestOffSpring = new ArrayList<>();
        int bestFitness = 0;
        
        for (Sentence child : offSpring){
            if (child.getFitness() > bestFitness){
                bestOffSpring.clear();
                bestOffSpring.add(child);
                bestFitness = child.getFitness();
            }
        }
        
        return bestOffSpring;
    }
    
    public void setFitnessLevels(List<Sentence> offSpring){
        offSpring.forEach(child -> {
            child.setFitness(target);
        });
    }
    
    public String randomText(){
        StringBuilder sb = new StringBuilder();
        int length = target.toString().length();
        for (int i = 0; i < length; i++){
            sb.append(rndChar());
        }
        
        return sb.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String target = args[0];
        String target = "This is how evolution works";
        new CharEvolution(new Sentence(target)).evolve();
    }
    
}
