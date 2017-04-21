package neel.co.uk.repository;

import neel.co.uk.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by jchondig on 20/04/2017.
 */
@Repository
public interface CardRepository  extends JpaRepository<Card,Long>{

    @Query("SELECT c from Card c where c.cardNumber =?")
    Card findByCardNumber(String cardNumber);
}
