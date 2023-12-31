package com.sddevops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoWhenExampleTest {
    
    @Mock
    Iterator<String> i;

    Comparable<String> c;

    @Test
    void testMoreThanOneReturnValue(){
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        
        String result = i.next() + " " + i.next();

        assertEquals("Mockito rocks", result);
    }

    @Test
    void testReturnValueDependentOnMethodParameter(@Mock Comparable<String> c){
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);

        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Eclipse"));
    }

    @Test
    void testReturnValueInDependentOnMethodParameter2(@Mock Comparable<Integer> c){
        when(c.compareTo(isA(Integer.class))).thenReturn(0);

        assertEquals(0, c.compareTo(Integer.valueOf(4)));
    }
}   
