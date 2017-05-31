
package charevolution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Richard DeSilvey
 */
public class CharEvolution {

    private Sentence target, parent;
    
    public void evolve(Sentence target){
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
        new CharEvolution().evolve(new Sentence(target));
    }
    
}
