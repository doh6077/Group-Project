package Enum;

public enum MiniDeposit {
    TWOTHOUSAND(2000.00);

    private final double value;
    private MiniDeposit(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    } 
}
