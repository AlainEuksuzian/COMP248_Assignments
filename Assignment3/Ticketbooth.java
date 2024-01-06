package comp248.Assignment3;

public class Ticketbooth {
    private Ticket tickets;
    private OPUSCard[] busCards;

    Ticketbooth(){
        this.tickets = null;
        this.busCards = null;
    }

    public Ticket getTickets() {
        return tickets;
    }

    Ticketbooth(Ticket ticket, OPUSCard[] cards){

        this.tickets = new Ticket(ticket);
        this.busCards = new OPUSCard[cards.length];

        for (int i = 0; i < busCards.length; i++){
            busCards[i] = new OPUSCard(cards[i]);
        }

       
    }

    public  boolean ticketboothValueEquals(Ticketbooth otherBooth){
        double floatError = 0.0001;
        return (tickets.ticketsTotal() - otherBooth.tickets.ticketsTotal())  < floatError;
    }

    public boolean equalTicketTypes(Ticketbooth otherBooth){
        return this.tickets.equals(otherBooth.tickets);
    }

    public int getTotalTicketsBooth(){
        return tickets.getDailyTickets() + tickets.getJuniorTickets() + tickets.getRegularTickets() +
        tickets.getSeniorTickets() + tickets.getWeeklyTickets();
    }

    public int getNumberOpusCardsBooth(){
        if (busCards == null){
            return 0;
        }
        return busCards.length;
    }

    public int addNewOpusCard(OPUSCard cardToAdd){
        if (busCards == null){
            busCards = new OPUSCard[1];
            busCards[0] = cardToAdd;
        }
        else {
            OPUSCard[] copyArray = new OPUSCard[busCards.length + 1];
            for (int i = 0; i < busCards.length; i++ ){
                copyArray[i] = busCards[i];
            }
            copyArray[copyArray.length - 1] = cardToAdd;
            busCards = copyArray;
        }
        return busCards.length;

    }

    public boolean removeOpusCard(OPUSCard cardToRemove){
       if (busCards == null){
        return false;
       }
       else {
        int index = 0;
        int counter = 0;

        for (OPUSCard element: busCards ){
            if (element.equals(cardToRemove)){
                index = counter;
                break;
            }
            counter++;
        }
        
        for (int i = index; i < busCards.length-1; i++ ){
            busCards[i] = busCards[i + 1];
        }
        OPUSCard[] copyArray = new OPUSCard[busCards.length - 1];

        for (int i =0; i < copyArray.length; i++ ){
            copyArray[i] = busCards[i];
        }
        busCards = copyArray;
        return true;
       }
    }

    public void updateExpMonthYear(int newMonth, int newYear, OPUSCard cardToUpdate){
        cardToUpdate.setExpiryMonth(newMonth);
        cardToUpdate.setExpiryYear(newYear);
    }


    public int addTicketToBooth(int regular, int junior, int senior, int daily, int weekly){
        tickets.addTickets(regular, junior, senior, daily, weekly);
        return getTotalTicketsBooth();


    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else {
            if (!(obj instanceof Ticketbooth)){
               return false;
            }
            else{
                 Ticketbooth otherObj = (Ticketbooth) obj;
                return this.busCards.length == otherObj.busCards.length;
            }

        }
    }

    @Override
    public String toString() {

        int[] cardNumbers = {tickets.getRegularTickets(),tickets.getJuniorTickets(),tickets.getSeniorTickets(),
             tickets.getDailyTickets(),tickets.getWeeklyTickets()};

        String[] description = {"the number of regular tickets: ", "the number of junior tickets: ",
        "the number of senior tickets: ", "the number of daily tickets: ", "the number of weekly tickets: " };
        
        final String NOCARD = " No OPUS cards";

        String outputTicketNumbers = "";

        for (int i = 0; i < cardNumbers.length; i++){
            if (cardNumbers[i] > 0){
                outputTicketNumbers += description[i] + cardNumbers[i];
            }
            else {
                outputTicketNumbers += description[i] + NOCARD;
            }
        }

        outputTicketNumbers+="\n";

        for (OPUSCard e: busCards){
            outputTicketNumbers += e.toString() + "\n";
           
        } 
        return outputTicketNumbers;
    }
}
