package comp248.Assignment3;

public class Ticket{
    private int regularTickets;
    private int juniorTickets;
    private int seniorTickets;
    private int dailyTickets;
    private int weeklyTickets;

    private static final double REGULARTICKETPRICE = 3.5;
    private static final double JUNIORTICKETPRICE = 2.5;
    private static final int SENIORTICKETPRICE = 1;
    private static final int DAILYTICKETPRICE = 10;
    private static final int WEEKLYTICKETPRICE = 40;

    Ticket(){}

    Ticket(int regularUnits, int juniorUnits, int seniorUnits, int dailyUnits, int weeklyUnits){
        setRegularTickets(regularUnits);
        setJuniorTickets(juniorUnits);
        setSeniorTickets(seniorUnits);
        setDailyTickets(dailyUnits);
        setWeeklyTickets(weeklyUnits);
    } 

    Ticket(Ticket ticket){
        this.regularTickets = ticket.regularTickets;
        this.juniorTickets = ticket.juniorTickets;
        this.seniorTickets = ticket.seniorTickets;
        this.dailyTickets = ticket.dailyTickets;
        this.weeklyTickets = ticket.weeklyTickets;
    }


    public void setRegularTickets(int regularTickets) {
        this.regularTickets = regularTickets;
    }

    public void setJuniorTickets(int juniorTickets) {
        this.juniorTickets = juniorTickets;
    }

    public void setSeniorTickets(int seniorTickets) {
        this.seniorTickets = seniorTickets;
    }

    public void setDailyTickets(int dailyTickets) {
        this.dailyTickets = dailyTickets;
    }

    public void setWeeklyTickets(int weeklyTickets) {
        this.weeklyTickets = weeklyTickets;
    }

    public int getRegularTickets() {
        return regularTickets;
    }

    public int getJuniorTickets() {
        return juniorTickets;
    }

    public int getSeniorTickets() {
        return seniorTickets;
    }

    public int getDailyTickets() {
        return dailyTickets;
    }

    public int getWeeklyTickets() {
        return weeklyTickets;
    }

    public void addTickets(int regularTicketsSold, int juniorTicketsSold, int seniorTicketsSold, int dailyTicketsSold, int weeklyTicketsSold){
        this.regularTickets += regularTicketsSold;
        this.juniorTickets += juniorTicketsSold;
        this.seniorTickets += seniorTicketsSold;
        this.dailyTickets += dailyTicketsSold;
        this.weeklyTickets += weeklyTicketsSold;
    }

    public double ticketsTotal(){
        double totalRegularTickets = getRegularTickets() * REGULARTICKETPRICE;
        double totalJuniorTickets = getJuniorTickets() * JUNIORTICKETPRICE;
        double totalSeniorTickets = getSeniorTickets() * SENIORTICKETPRICE;
        double totalDailyTickets = getDailyTickets() * DAILYTICKETPRICE;
        double totalWeeklyTickets = getWeeklyTickets() * WEEKLYTICKETPRICE;
        
        return (totalRegularTickets + totalJuniorTickets + totalSeniorTickets + totalDailyTickets + totalWeeklyTickets );
    }

    @Override
    public String toString() {

        String regularTickets = "Regular Tickets count is at: " + getRegularTickets();
        String juniorTickets = "Junior Tickets count is at : " + getJuniorTickets();
        String seniorTickets = "Senior Tickets count is at: " + getSeniorTickets();
        String dailyTickets = "Daily tickets count is at: " + getDailyTickets();
        String weeklyCount = "Weekly tickets count is at: " + getWeeklyTickets();

        return regularTickets + "\n" + juniorTickets + "\n" + seniorTickets + "\n" + dailyTickets + "\n" + weeklyCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof Ticket)){
            return false;
        }
        else {
            Ticket otherObj = (Ticket) obj;
            return this.getRegularTickets() == otherObj.getRegularTickets() 
            && this.getJuniorTickets() == otherObj.getJuniorTickets()
            && this.getSeniorTickets() == otherObj.getSeniorTickets()
            && this.getDailyTickets() == otherObj.getDailyTickets()
            && this.getWeeklyTickets() == otherObj.getWeeklyTickets();
        }
    }

}