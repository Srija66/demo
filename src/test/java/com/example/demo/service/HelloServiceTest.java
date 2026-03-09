package com.example.demo.service;

import com.example.demo.dto.HelloResponse;
import com.example.demo.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)      //This tells JUnit to enable Mockito.
public class HelloServiceTest {
    //Arrange

    @Mock           //Mockito creates a fake repository.
    private VisitorRepository repository;

    @InjectMocks //Mockito creates:HelloService(repository) Automatically.
    private HelloService service;

    @Test
    //@Test tells JUnit to run this method.
    public void buildGreetingContainsName(){

        //If service calls repository.getRecentVisitors()
        //return this fake list
        when(repository.getRecentVisitors())
                .thenReturn(List.of("Srija"));
        //Act
        HelloResponse response= service.buildGreeting("Srija");

        //Assert
        //assertEquals(expected, actual)
        assertEquals("Srija", response.getName());
    }

    @Test
    public void visitorCountTestIncrement(){

        when(repository.getRecentVisitors())
                .thenReturn(List.of("Shiva","Manoj"));

        HelloResponse first= service.buildGreeting("Shiva");
        HelloResponse second= service.buildGreeting("Manoj");
        assertEquals(1,first.getVisitorNumber());
        assertEquals(2,second.getVisitorNumber());
    }

    @Test
    public void verifyGreetingNotNUll(){

        when(repository.getRecentVisitors())
                .thenReturn(List.of());

        HelloResponse result=service.buildGreeting("Srija");
        assertNotNull(result.getGreeting());
    }

    //Mockito can check if dependency methods were called.
    @Test
    public void testVisitorSavedInRepository(){
        when(repository.getRecentVisitors())
                .thenReturn(List.of("Shiva"));
        service.buildGreeting("Shiva");
        verify(repository).saveVisitor("Shiva");
    }
}
