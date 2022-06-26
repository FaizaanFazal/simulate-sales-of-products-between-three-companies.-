
package com.mycompany.simulatesalesofproducts;

public class BigCappa {
     
    int crates; // random number of products generation btw 1 to 40 for depot
    int price;
    int deliveryprice;
    int cash;
    int Native;
    int External=0;
    
    
    
    public BigCappa(int cratesstock,int p,int delivery,int cashrand){
    crates=cratesstock;
    price=p;
    deliveryprice=delivery;
    cash=cashrand;
    Native=cratesstock; //initially native products are equalt to random generated stock
}
}
