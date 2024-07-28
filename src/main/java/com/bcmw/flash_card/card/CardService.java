package com.bcmw.flash_card.card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();

    void createNewCard(Card card);

    Card getCardById(Long id);

    boolean updateCard(Long id, Card card);

    boolean deleteCard(Long id);
}
