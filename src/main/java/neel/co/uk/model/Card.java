package neel.co.uk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jchondig on 30/03/2017.
 */
@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="cardnumber", nullable = false, unique = true)
    private  String cardNumber;

    @Column(name="expdate",length = 10)
    private  String expDate;

    @Column(name="cvv")
    private  int cvv;

    public Card(){}
    public Card(String cardNumber, String expDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setCvv(int cvv) {
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
