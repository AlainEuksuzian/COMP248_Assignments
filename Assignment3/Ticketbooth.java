package comp248.Assignment3;

public class Ticketbooth {
    private Ticket tickets;
    private OPUSCard[] busCards;

    Ticketbooth(){
        this.tickets = null;
        this.busCards = null;
    }

    Ticketbooth(Ticket ticket, OPUSCard[] cards){

        this.tickets = new Ticket(ticket);
        this.busCards = new OPUSCard[cards.length];

        for (int i =0; i < busCards.length; i++){
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
        return busCards.length;
    }

}
