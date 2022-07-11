package com.helloworld.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
 
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest 
{
    @InjectMocks
    MainClass mainClass;
     
    @Mock
    DatabaseDAO dependentClassOne;
     
    @Mock
    NetworkDAO dependentClassTwo;
     
    @Before
    public void init() {
        //MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void validateTest()
    {
        boolean saved = mainClass.save("temp.txt");
        assertEquals(true, saved);
    }
}