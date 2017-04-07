package neel.co.uk.controller;

import neel.co.uk.CardService;
import neel.co.uk.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jchondig on 30/03/2017.
 */
@RestController
@RequestMapping
public class CardController {

    @Autowired
    CardService cardService;
//
    @RequestMapping(value ="/card", method = RequestMethod.GET )
    public ResponseEntity<Card> card(@RequestParam(value = "number") String number){
        Card card = cardService.getCardDetail(number);
        return new ResponseEntity<Card>(card, HttpStatus.OK);
    }
}
