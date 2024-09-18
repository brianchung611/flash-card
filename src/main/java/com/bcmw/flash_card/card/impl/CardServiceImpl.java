package com.bcmw.flash_card.card.impl;

import com.bcmw.flash_card.card.Card;
import com.bcmw.flash_card.card.CardRepository;
import com.bcmw.flash_card.card.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCard(Long id, Card updatedCard) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            card.setQuestion(updatedCard.getQuestion());
            card.setHint(updatedCard.getHint());
            card.setAnswer(updatedCard.getAnswer());
            card.setAccount(updatedCard.getAccount());
            cardRepository.save(card);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCard(Long id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void createNewCard(Card card) {
        cardRepository.save(card);
    }


}
