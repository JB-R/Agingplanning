package tounzcompagny.agingplanning.Objects;


import java.sql.Date;

public class Study {

    private String nStudy;
    private String customer;
    private int nbSample;
    private Date dateStart;
    private int nbDayStart;
    private int nbDayEnd;
    private Date dateEnd;
    private int chamber;
    private String test;
    private State state;

    public Study(String nStudy, String customer, int nbSample, Date dateStart, int nbDayStart, int nbDayEnd, Date dateEnd, int chamber, String test, State state) {
        this.nStudy = nStudy;
        this.customer = customer;
        this.nbSample = nbSample;
        this.dateStart = dateStart;
        this.nbDayStart = nbDayStart;
        this.nbDayEnd = nbDayEnd;
        this.dateEnd = dateEnd;
        this.chamber = chamber;
        this.test = test;
        this.state = state;
    }

    public String getnStudy() {
        return nStudy;
    }

    public void setnStudy(String nStudy) {
        this.nStudy = nStudy;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNbSample() {
        return nbSample;
    }

    public void setNbSample(int nbSample) {
        this.nbSample = nbSample;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public int getNbDayStart() {
        return nbDayStart;
    }

    public void setNbDayStart(int nbDayStart) {
        this.nbDayStart = nbDayStart;
    }

    public int getNbDayEnd() {
        return nbDayEnd;
    }

    public void setNbDayEnd(int nbDayEnd) {
        this.nbDayEnd = nbDayEnd;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getChamber() {
        return chamber;
    }

    public void setChamber(int chamber) {
        this.chamber = chamber;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}