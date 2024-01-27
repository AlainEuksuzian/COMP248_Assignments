package comp248.Assignment3;

public class OPUSCard {
    private String cardType;
    private String cardHolderName;
    private int expiryMonth;
    private int expiryYear;

    OPUSCard(){}

    // Called by OPUScar to set the type name and expiry month / year
    OPUSCard(String cardType, String cardName, int expMonth, int expYear){
        this.cardType = cardType;
        this.cardHolderName = cardName;
        setExpiryMonth(expMonth);
        setExpiryYear(expYear);
    }

    // Sets the fields of this opus card based on the values provided. Does not copy the fields
    OPUSCard(OPUSCard card){
        this.cardType = card.cardType;
        this.cardHolderName = card.cardHolderName;
        this.expiryMonth = card.expiryMonth;
        this.expiryYear = card.expiryYear;
    }

    /**
    * Sets the expiry month. Valid values are 1 to 12. If the value is out of range it will set it to 0
    * @param expiryMonth - the new expiry month
    */
    public void setExpiryMonth(int expiryMonth) {
        if (expiryMonth >= 1 && expiryMonth <= 12){
            this.expiryMonth = expiryMonth;
        }
        else {
            this.expiryMonth = 0;
        }
    }

    /**
    * Sets the expiry year. This is used to determine if the user is allowed to sign in or not
    * @param expiryYear - the year in which the user
    */
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
    * Returns the card type. This is used to distinguish between a number of cards that are part of the same card and an array of cards that are part of the same card.
    * @return the card type or null if there is no card type in the card's list of cards or if the card type is
    */
    public String getCardType() {
        return cardType;
    }

    /**
    * Returns the name of the card holder. This is used to distinguish cards from other cards that are part of the same bank.
    * @return the name of the card holder or null if there is no card holder in the bank ( for example if the bank doesn't have a card
    */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
    * Returns the expiry month. This is used to determine if the user has to be prompted for a new expiry month.
    * @return the expiry month 0 - 12 or - 1 if not set or expired ( never null / empty )
    */
    public int getExpiryMonth() {
        return expiryMonth;
    }

    /**
    * Returns the expiry year associated with this payment. This value is used to determine when the payment is valid for the year and time of expiry.
    * @return the expiry year associated with this payment or - 1 if there is no expiry year associated with this payment
    */
    public int getExpiryYear() {
        return expiryYear;
    }

    /**
    * Returns a String representation of this opus card. This is useful for debugging purposes.
     The format is : OPUS card type : November July November January November February Eastern Civil Harmony
    * @return a String representation of this opus
    */
    @Override
    public String toString() {
        String formatedDate = "";
        int month = getExpiryMonth();
        int year = getExpiryYear();

        if (month < 10){
            formatedDate = "0" + month + "/" + year;
        }
        else {
            formatedDate = month + "/" + year;
        }

        return "OPUS card type: " + getCardType() + "\nCard Holder Name: " + getCardHolderName() + "\nExpiry Date: " + formatedDate;
    }

    /**
    * Compares this card with another. Compares the card holder name type expiry month and expiry year of the two cards to determine if they are equal
    * @param obj - the opus card to compare
    * @return true if the cards are equal
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof OPUSCard)){
            return false;
        }
        else{
            OPUSCard otherObj = (OPUSCard) obj;
            return (this.getCardHolderName().equalsIgnoreCase(otherObj.getCardHolderName()) && 
            this.getCardType().equalsIgnoreCase(otherObj.getCardType()) && this.getExpiryMonth() == otherObj.getExpiryMonth() 
            && this.getExpiryYear() == otherObj.getExpiryYear());
        }

    }

}
