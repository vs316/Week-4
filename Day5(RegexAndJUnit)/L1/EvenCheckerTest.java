package junit_tests;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenCheckerTest {
    //parameterized test
    @ParameterizedTest
    @ValueSource(ints={2,4,6,7,9})
    void testEvenNumber(int num){
        //assertTrue(num%2==0 || num%2==1);
        assertTrue(EvenChecker.isEven(num));
    }

}