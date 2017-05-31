
import charevolution.Sentence;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the class Sentence
 * @author Richard
 */
public class SentenceTest {
    
    public SentenceTest(){
        
    }
    
    @Test
    public void copyAndMutateTest(){
        
        Sentence testSentence = new Sentence("This is a Test");
        Sentence child = testSentence.copyAndMutate();
        
        assertFalse("Sentences should not match", 
                testSentence.toString().equalsIgnoreCase(child.toString()));
        
    }
    
    @Test
    public void setFitnessTest(){
        String testString = "This is a Test";
        Integer testLength = testString.length();
        
        Sentence testTarget = new Sentence(testString);
        Sentence perfectMatch = new Sentence(testString);
        
        Sentence testMatch = new Sentence("This IS fwokit");
        
        testMatch.setFitness(testTarget);
        Integer expectedFitness = 7;
        Integer testMatchFitness = testMatch.getFitness();
        assertEquals("Fitness is not correct", expectedFitness, testMatchFitness);
        
        perfectMatch.setFitness(testTarget);
        testMatchFitness = perfectMatch.getFitness();
        assertEquals("Fitness is not a perfect match", testMatchFitness, testLength);
    }
    
}
