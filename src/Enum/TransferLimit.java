package Enum;
public enum TransferLimit {
    ONETHOUSAND(1000),TWOTHOUSAND(2000);

    private final double value;
    private TransferLimit(int value){
        this.value=value;
    }

    public double getValue(){
        return this.value;
    }
}
