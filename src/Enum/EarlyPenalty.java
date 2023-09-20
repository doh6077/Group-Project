package Enum;

public enum EarlyPenalty {
    FIVEPERCENT(0.05);
    private final double value;
    private EarlyPenalty(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }
}
