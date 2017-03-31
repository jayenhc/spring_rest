package neel.co.uk.model;

import java.time.LocalDate;

/**
 * Created by jchondig on 30/03/2017.
 */
public class Card {

    private final String cardNumber;
    private final LocalDate expDate;
    private final int cvv;

    public Card(String cardNumber, LocalDate expDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public int getCvv() {
        return cvv;
    }
}
