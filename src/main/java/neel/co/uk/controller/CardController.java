package neel.co.uk.controller;

import neel.co.uk.service.CardService;
import neel.co.uk.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jchondig on 30/03/2017.
 */
@RestController
@RequestMapping("/card")
public class CardController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardService cardService;
    //@RequestMapping(value ="/card", method = RequestMethod.GET )
    //or
    //@RequestMapping("/card")
    // are equal default is get method

    //The @RequestMapping annotation ensures that HTTP requests to /card are mapped to the getCard() method.
    @RequestMapping(value ="/card-temp", method = RequestMethod.GET )
    public ResponseEntity<Card> card(@RequestParam(value = "number") String number){
        Card card = cardService.getCardDetail(number);
        return new ResponseEntity<Card>(card, HttpStatus.OK);
    }

    //get singl card by number
    @RequestMapping(value ="/{number}", method = RequestMethod.GET )
    public ResponseEntity<Card> getCard(@PathVariable("number") String number){
        Card card = cardService.getCardDetail(number);
        return new ResponseEntity<Card>(card, HttpStatus.OK);
    }
    // get All cards
    @RequestMapping( method=RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards(){
        return new ResponseEntity<List<Card>>( cardService.getAllCards(),HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Card> createCard(@RequestBody Card card){
        LOGGER.info("Creating card -> " + card.getCardNumber());
        if(cardService.isCardExist(card.getCardNumber())){
            LOGGER.info("Card with cardnumber " + card.getCardNumber() +" already exist.");
            return new ResponseEntity<Card>(card, HttpStatus.CONFLICT);
        }
        cardService.saveCard(card);
        return new ResponseEntity<Card>(card, HttpStatus.CREATED);
    }
}
