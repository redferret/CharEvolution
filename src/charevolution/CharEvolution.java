
package charevolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Richard DeSilvey
 */
public class CharEvolution {

    private Sentence target, parent;
    private final static String RAND_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
            + "abcdefghijklmnopqrstuvwxyz";
    
    public CharEvolution(Sentence target){
        this.target = target;
    }
    
    public static char rndChar() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return RAND_CHARS.charAt(random.nextInt(0, RAND_CHARS.length()));
    }
    
    public void evolve(){
        this.target = target;
        
        parent = new Sentence(randomText());
        List<Sentence> children = new ArrayList<>();
        int iterations = 0;
        
        while(true){
            for (int i = 0; i < 10; i++){
                children.add(parent.copyAndMutate());
            }
            
        }
    }
    
    public Sentence getBest(List<Sentence> offSpring){
        return null;
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
        
        return null;
    }
    
    public String mutate(String toMutate){
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String target = args[0];
        new CharEvolution(new Sentence(target)).evolve();
    }
    
}
