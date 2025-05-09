package controller;

@lombok.Data
public class PackageHandlerJson {

    private String packageId;
    private int packageHeight;
    private int packageWeight;
    private int packageValue;
    private int packageFees;
    private String handlingDate;

}
