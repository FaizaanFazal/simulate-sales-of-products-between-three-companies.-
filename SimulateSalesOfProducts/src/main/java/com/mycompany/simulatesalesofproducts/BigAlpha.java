package com.mycompany.simulatesalesofproducts;

public class BigAlpha {
    
    int widgets; // random number of products generation btw 1 to 40 for depot
    int price;
    int deliveryprice;
    int cash;
    int Native;
    int External=0;
    
    
    
    public BigAlpha(int widgetstock,int p,int delivery,int cashrand){
    widgets=widgetstock;
    price=p;
    deliveryprice=delivery;
    cash=cashrand;
    Native=widgetstock; //initially native products are equalt to random generated stock
}
    
}
