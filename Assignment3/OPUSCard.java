package comp248.Assignment3;

public class OPUSCard {
    private String cardType;
    private String cardHolderName;
    private int expiryMonth;
    private int expiryYear;

    OPUSCard(){}

    OPUSCard(String cardType, String cardName, int expMonth, int expYear){
        this.cardType = cardType;
        this.cardHolderName = cardName;
        setExpiryMonth(expMonth);
        setExpiryYear(expYear);
    }

    OPUSCard(OPUSCard card){
        this.cardType = card.cardType;
        this.cardHolderName = card.cardHolderName;
        this.expiryMonth = card.expiryMonth;
        this.expiryYear = card.expiryYear;
    }

    public void setExpiryMonth(int expiryMonth) {
        if (expiryMonth >= 1 && expiryMonth <= 12){
            this.expiryMonth = expiryMonth;
        }
        else {
            this.expiryMonth = 0;
        }
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

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

    // name:string, tye:str, month:int year:int
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
