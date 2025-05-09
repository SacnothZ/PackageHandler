package model;


public class PackageHandler {



    public String weightCost(String wc)
    {
        int number=Integer.parseInt(wc);
        if(number>5000) {
            return "200";
        }
        return "0";
    }


    public String heightCost(String hc)
    {
        int number=Integer.parseInt(hc);
        if(number>100) {
            return "300";
        }
        return "0";

    }


    public String systemCost(String sc)
    {
        double increase=0.01;
        int charge=Integer.parseInt(sc);
        return Integer.toString((int)(increase*charge));
    }



}
