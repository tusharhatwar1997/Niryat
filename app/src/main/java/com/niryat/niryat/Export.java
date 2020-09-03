package com.niryat.niryat;

public class Export {
    private String product;
    private String category;
    private String year;
    private double transport_cost;
    private double handling_cost;
    private double insurance_cost;
    private double delivery_duty;



    public Export(String product, String categgory, String year, double transport_cost, double handling_cost, double insurance_cost,
                  double delivery_duty){
        this.product= product;
        this.category= categgory;
        this.year= year;
        this.transport_cost= transport_cost;
        this.handling_cost= handling_cost;
        this.insurance_cost= insurance_cost;
        this.delivery_duty= delivery_duty;
    }


    public String getProduct() {
        return product;
    }

    public String getCategory() {
        return category;
    }



    public String getYear() {
        return year;
    }


public double getTransportCost() {
        return transport_cost;
        }


public double getHandlingCost() {
        return handling_cost;


        }
public double getInsurance() {
        return insurance_cost;


        }
public double getDelivery() {
        return delivery_duty;


        }}