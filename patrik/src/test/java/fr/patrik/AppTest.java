package fr.patrik;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Operation operationAdd = new OperationAdd();
    Operation operationSubstract = new OperationSubstract();
    Operation operationMultiply = new OperationMultiply();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldReturnAdditionResult()
    {
        assertEquals(12, operationAdd.doOperation(4, 8));
    }

    @Test
    public void shouldReturnSubstractionResult()
    {
        assertEquals(3, operationSubstract.doOperation(5, 2));
    }

    @Test
    public void shouldReturnMultiplyResult()
    {
        assertEquals(48, operationMultiply.doOperation(6, 8));
    }
}
