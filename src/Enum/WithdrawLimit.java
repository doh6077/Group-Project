package Enum;
public enum WithdrawLimit {
    TWOTHOUSAND(2000.00), THREETHOUSAND(3000.00);
    private final double value;

    private WithdrawLimit(double value){
        this.value=value;
    }

    public double getValue(){
        return this.value;
    }

}
