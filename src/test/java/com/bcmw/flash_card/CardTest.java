package com.bcmw.flash_card;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.bcmw.flash_card.card.Card;
import com.bcmw.flash_card.card.CardRepository;
import com.bcmw.flash_card.card.CardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.comparator.JSONCompareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CardTest {

    @Autowired
    private CardService cardService;

    @Mock
    private CardRepository cardRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this); // Initialize Mockito annotations
    }
    @Test
    public void testCreateCard() {
//        when(cardRepository.findAll()).thenReturn(Arrays.asList(new Card(), new Card()));
//
//        List<Card> result = cardService.getAllCards();
//
//        assertEquals(2, result.size());
    }
}
