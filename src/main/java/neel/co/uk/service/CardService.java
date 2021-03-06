package neel.co.uk.service;

import neel.co.uk.model.Card;
import neel.co.uk.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jchondig on 31/03/2017.
 */
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    private Map<String, Card> cardMap = new HashMap<>();

    public CardService() {
        Card card1 = new Card("1111", "01/01/2017",111);
        Card card2 = new Card("2222", "02/02/2017",222);
        Card card3 = new Card("3333", "03/03/2017",333);
        Card card4 = new Card("1234", "04/04/2017",123);
        cardMap.put(card1.getCardNumber(),card1);
        cardMap.put(card2.getCardNumber(),card2);
        cardMap.put(card3.getCardNumber(),card3);
        cardMap.put(card4.getCardNumber(),card4);
    }

    public Card getCardDetail(String cardNumber){
        /*if(cardMap.containsKey(cardNumber)){
            return cardMap.get(cardNumber);
        }else{
            return null;
        }*/
        return cardRepository.findByCardNumber(cardNumber);
    }

    public Card getCardByNumber(Long cardId){
        return cardRepository.findOne(cardId);
    }

    public boolean isCardExist(String cardNumber){
        /*if(cardMap.containsKey(cardNumber)) {
            return true;
        }*/
        if(cardRepository.findByCardNumber(cardNumber) != null){
            return true;
        }
        return false;
    }

    public List<Card> getAllStaticCards(){
        return cardMap.entrySet().stream().map(x -> x.getValue() ).collect(Collectors.toList());
    }

    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    public void saveCard(Card card) {
        //cardMap.put(card.getCardNumber(), card);

        cardRepository.save(card);
    }

    public void delete(Card card){
        cardRepository.delete(card);
    }
}
