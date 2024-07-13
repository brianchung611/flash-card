package com.bcmw.flash_card.card;

import com.bcmw.flash_card.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
