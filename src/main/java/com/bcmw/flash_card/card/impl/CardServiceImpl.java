package com.bcmw.flash_card.card.impl;

import com.bcmw.flash_card.card.CardRepository;
import com.bcmw.flash_card.card.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}
