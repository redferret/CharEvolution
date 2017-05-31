import charevolution.CharEvolution;
import charevolution.Sentence;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class CharEvolutionTest {
    
    private CharEvolution testClass;
    
    public CharEvolutionTest(){
        testClass = new CharEvolution(new Sentence("Test"));
    }
    
    @Test
    public void setFitnessLevelsTest(){
        List<Sentence> testChildren = new ArrayList<>();

        testChildren.add(new Sentence("Tsfa"));
        testChildren.add(new Sentence("Teaa"));
        testChildren.add(new Sentence("Test"));
        int expectedFitnessLevels[] = {1, 2, 4};
        testClass.setFitnessLevels(testChildren);
        
        for (int i = 0; i < 3; i++){
            Integer expectedFitness = expectedFitnessLevels[i];
            Integer actualFitness = testChildren.get(i).getFitness();
            assertEquals("Fitness level doesn't match", 
                    expectedFitness, actualFitness);
        }
    }
    
    @Test
    public void getBestTest(){
        
        List<Sentence> testChildren = new ArrayList<>();

        Sentence expected = new Sentence("Test");
        testChildren.add(new Sentence("Tsfa"));
        testChildren.add(new Sentence("Teaa"));
        testChildren.add(new Sentence(expected.toString()));
        
        testClass.setFitnessLevels(testChildren);
        Sentence bestChild = testClass.getBest(testChildren);
        
        assertNotNull("Stopped test, child is null", bestChild);
        
        assertEquals("Best not selected", 
                expected.toString(), bestChild.toString());
    }
    
}
