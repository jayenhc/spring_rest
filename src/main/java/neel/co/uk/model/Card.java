package neel.co.uk.model;

/**
 * Created by jchondig on 30/03/2017.
 */
public class Card {

    private  String cardNumber;
    private  String expDate;
    private  int cvv;

    public Card(){}
    public Card(String cardNumber, String expDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public int getCvv() {
        return cvv;
    }
}
