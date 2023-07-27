package com.sddevops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoThrowsTest {
    
    @Test
    void testMockitoThrows(){
        Properties properties = Mockito.mock(Properties.class);
        
        //define the rule whenever Properties tries to use the get method on any parameter, it will throw IllegalArgumentException
        when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("Stuff"));

        // verify if the usage of Properties get method would throw IllegalArgumentException
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> properties.get("A"));
        
        // test the value based on the exception message
        assertEquals("Stuff", exception.getMessage());
    }

}
