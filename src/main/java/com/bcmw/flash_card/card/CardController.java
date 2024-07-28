package com.bcmw.flash_card.card;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        Card card = cardService.getCardById(id);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createNewCard(@RequestBody Card card) {
        cardService.createNewCard(card);
        return new ResponseEntity<>("Card created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCard(@PathVariable Long id, @RequestBody Card card) {
        boolean isUpdated = cardService.updateCard(id, card);
        if (isUpdated) {
            return new ResponseEntity<>("Card updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable Long id) {
        boolean isDeleted = cardService.deleteCard(id);
        if (isDeleted) {
            return new ResponseEntity<>("Card deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
