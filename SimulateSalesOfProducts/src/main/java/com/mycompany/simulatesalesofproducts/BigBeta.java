
package com.mycompany.simulatesalesofproducts;

public class BigBeta {
    
    int braces; // random number of products generation btw 1 to 40 for depot
    int price;
    int deliveryprice;
    int cash;
    int Native;
    int External=0;
    
    
    
    public BigBeta(int bracesstock,int p,int delivery,int cashrand){
    braces=bracesstock;
    price=p;
    deliveryprice=delivery;
    cash=cashrand;
    Native=bracesstock; //initially native products are equalt to random generated stock
}
}
