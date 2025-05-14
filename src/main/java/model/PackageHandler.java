package model;


public class PackageHandler {



    public Integer weightCost(Integer wc)
    {

        if(wc>5000) {
            return 200;
        }
        return 0;
    }


    public Integer heightCost(Integer hc)
    {

        if(hc>100) {
            return 300;
        }
        return 0;

    }


    public Integer systemCost(Integer sc)
    {
        double increase=0.01;
        return (int)(increase*sc);
    }



}
