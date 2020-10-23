package e3;

public class Clock {

    public enum Period {AM, PM};
    private String s;

    
    private int hours; // en 24h
    private int minutes;
    private int seconds;


    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour .
     */
    public Clock ( String s) {
        this.s=s;
        String[] PartesPorEspacio = s.split(" ", 2);
        String[] PartesPorPuntos = PartesPorEspacio[0].split(":", 3);

        int temp_hours;
        int temp_minutes;
        int temp_seconds;

        if (PartesPorPuntos.length==3) {
            if (PartesPorEspacio.length==2) {
                if (PartesPorEspacio[1].equals("AM"))
                    if(Integer.parseInt(PartesPorPuntos[0])!=12)
                    temp_hours = Integer.parseInt(PartesPorPuntos[0]);
                    else temp_hours =0;
                else if (PartesPorEspacio[1].equals("PM"))
                    if(Integer.parseInt(PartesPorPuntos[0])!=12)
                    temp_hours = Integer.parseInt(PartesPorPuntos[0])+12;
                    else temp_hours =Integer.parseInt(PartesPorPuntos[0]);
                else
                    throw new IllegalArgumentException();
            }
            else if (PartesPorEspacio.length==1) {
                temp_hours = Integer.parseInt(PartesPorPuntos[0]);
            }
            else {
                throw new IllegalArgumentException();
            }

            temp_minutes = Integer.parseInt(PartesPorPuntos[1]);
            temp_seconds = Integer.parseInt(PartesPorPuntos[2]);
        }
        else {
            throw new IllegalArgumentException();
        }
        if ((temp_hours<0) || temp_hours>23) throw new IllegalArgumentException();
        if ((temp_minutes<0) || temp_minutes>59) throw new IllegalArgumentException();
        if ((temp_seconds<0) || temp_seconds>59) throw new IllegalArgumentException();

        this.hours = temp_hours;
        this.minutes = temp_minutes;
        this.seconds = temp_seconds;
    }
    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours , int minutes , int seconds ) {
        if ((hours<0) || (hours>24))
            throw new IllegalArgumentException("La Hora" + Integer.toString(hours) + "es incorrecta");

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock ( int hours , int minutes , int seconds , Period period ) {
        if ((hours<0) || (hours>12))
            throw new IllegalArgumentException("La Hora" + Integer.toString(hours) + "es incorrecta");

        if (period == Clock.Period.AM)
            if(hours!=12)
                this.hours = hours;
            else this.hours =0;
        else //period == PM
            if(hours!=12)
                this.hours = hours+12;
            else this.hours = hours;

        this.minutes = minutes;
        this.seconds = seconds;
    }
    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */
    public int getHours24 () {
        return this.hours;
    }
    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */
    public int getHours12 () {
        if(this.hours==12)return 0;
        else if(this.hours==0)return 12;
        else if (this.hours>12)
            return this.hours-12;
        return this.hours;  //if then else
    }
    /**
     * Returns the minutes of the clock
     * @return the minutes
     */
    public int getMinutes () {
        return this.minutes;
    }
    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds () {
        return this.seconds;
    }
    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */
    public Period getPeriod () {
        if(this.hours==12) return Period.PM;
        else if(this.hours>12) return Period.PM;
        else return Period.AM;
    }
    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour24 () {
        return (this.hours<10 ? "0"+Integer.toString(this.hours) : Integer.toString(this.hours)) + ":"
                + (this.minutes<10 ? "0"+Integer.toString(this.minutes) : Integer.toString(this.minutes)) + ":"
                + (seconds<10 ? "0"+Integer.toString(this.seconds) : Integer.toString(this.seconds));
    }
    /**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour12 () {
        return (this.getHours12()<10 ? "0"+Integer.toString(this.getHours12()) : Integer.toString(this.getHours12())) + ":"
                + (this.minutes<10 ? "0"+Integer.toString(this.minutes) : Integer.toString(this.minutes)) + ":"
                + (seconds<10 ? "0"+Integer.toString(this.seconds) : Integer.toString(this.seconds)) + " "
                + (this.getPeriod()==Period.AM ? "AM" : "PM");
    }





    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param o The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     */
    @Override
    public boolean equals ( Object o) {
        if (o==null) return false;
        return this.hashCode() == o.hashCode();
    }
    /**
     * Returns a integer that is a hash code representation of the clock using
     * the " hash 31" algorithm .
     * Clocks that are equals must have the same hash code .
     * @return the hash code
     */
    @Override
    public int hashCode () {
        int result;
        result = this.hours;
        result = 31 * result + this.minutes;
        result = 31 * result + this.seconds;
        return result;
    }
}
