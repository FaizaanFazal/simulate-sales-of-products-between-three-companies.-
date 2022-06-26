package com.mycompany.simulatesalesofproducts;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner; 
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SimulateSalesOfProducts {
    
     static void trans(int tindex_,String buyer_,int buyerDepotNumber_,String seller_,int sellerDepotNumber_,int Quantity_,int price_,int totalprice_) {
//      transactions[] depotT;   
      int t=tindex_;
      String buyer=buyer_;
      int buyerDepotNumber= buyerDepotNumber_ ;
      String seller= seller_;
      int sellerDepotNumber= sellerDepotNumber_;
      int Quantity=Quantity_ ;
      int price= price_;
     int totalprice= totalprice_;
     depotT[t] = new transactions( buyer,buyerDepotNumber, seller, sellerDepotNumber, Quantity, price, totalprice);
//      System.out.println(depotT[tindex].buyer+ "seller:"+depotT[tindex].seller);
  }
     
 public void RecordFile(String s) throws IOException {   //creating a file to record tansaction history
     
    File file = new File(s+"/Records.txt");
      BufferedWriter o = new BufferedWriter(
                new FileWriter(s+"/Records.txt", true));
      String his="**********Transaction History**************\n";
      try {
        boolean createFile = file.createNewFile();
        if (createFile) {
          System.out.println("New File is created.");
          o.write(his);
          o.close();
        
        }
        else{
          System.out.println("File already exists.");
        }
        
      } catch (Exception e) {
          System.out.println(e);
      }
  } 
 public void WrtieIntoFile(String s,transactions[] depotT,int tindex) {   //Writing records to a file 
    
     try 
     {
         BufferedWriter out = new BufferedWriter(
                new FileWriter(s+"/Records.txt", true));
           String sd;
           sd = "Buyer-Company: "+depotT[tindex].buyer+" | Buyer Depot Number: "+depotT[tindex].buyerDepotNumber+" | Seller-Company: "+depotT[tindex].seller+" | Seller Depot Number: "+depotT[tindex].sellerDepotNumber+" | Quantity of Prodcut: "+depotT[tindex].Quantity+" | Unit Price: "+depotT[tindex].price+" | (TotalCost+deliveryCharges) Price: "+depotT[tindex].totalprice;
            out.write(sd+"\n");
            out.close();
       }
        catch(Exception e)
     {
        System.out.println(e);
        }
    
     }  
  public void ReadWholeFile(String s) throws IOException {   //Writing records to a file 
    
    try  
      {  
        File file=new File(s+"/Records.txt");   //creates a new file instance  
        FileReader fr=new FileReader(file);   //reads the file  
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
        String line;  
        while((line=br.readLine())!=null)  
        {  
        sb.append(line);      //appends line to string buffer  
        sb.append("\n");     //line feed   
          }  
           fr.close();    //closes the stream and release the resources  
        System.out.println("Contents of File: ");  
        System.out.println(sb.toString());   //returns a string that textually represents the object  
        }  
        catch(IOException e)  
        {  
        System.out.println(e);  
        }  
    
     }  
    
    static transactions[] depotT = new transactions[100]; // records 100 transactions in one execution
    
    public static void main(String[] args) throws IOException {
        String s=System.getProperty("user.dir"); //File will be created in porject folder
        SimulateSalesOfProducts objf=new SimulateSalesOfProducts();
        objf.RecordFile(s);
   
    Scanner in = new Scanner(System.in);
   
    
    int tindex=0;
    depotT[tindex] = new transactions( "norecord",0, "norecord", 0, 0, 0, 0); //setting records to zeor when initializing
    int cashmax=100;        ///initially max random cash can be 100
    int cashmin=50;         ///initially min random cash can be 50 only
    int stockmax=40;
    int stockmin=15;
    int pricemin=1;
    int pricemax=10;
           
    int widgets; 
    int braces;
    int crates;
    
    int price;
    int deliveryprice;
    int cash;
    int minNative=15;
    int maxNative=40;
    int minExternal=2;
    int maxExternal=30;
    
    //Generating 40 depots with random stock price , delivery price and initial cash for Big Alpha
    BigAlpha[] depot = new BigAlpha[40]; 
    for(int i=0; i<40; i++) {
     widgets=ThreadLocalRandom.current().nextInt(stockmin, stockmax + 1); // random number of products generation btw 1 to 40 for depot
   
     
     price=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     deliveryprice=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     cash=ThreadLocalRandom.current().nextInt(cashmin, cashmax + 1);
     
    depot[i] = new BigAlpha(widgets,price,deliveryprice,cash);
}
     //Generating 40 depots with random stock price , delivery price and initial cash for BigBeta
    BigBeta[] depotB = new BigBeta[40]; 
    for(int i=0; i<40; i++) {
    
     braces=ThreadLocalRandom.current().nextInt(stockmin, stockmax + 1); // random number of products generation btw 1 to 40 for depot
      price=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     deliveryprice=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     cash=ThreadLocalRandom.current().nextInt(cashmin, cashmax + 1);
     
    depotB[i] = new BigBeta(braces,price,deliveryprice,cash);
}
      //Generating 40 depots with random stock price , delivery price and initial cash for Big Alpha
    BigCappa[] depotC = new BigCappa[40]; 
    for(int i=0; i<40; i++) {

     crates=ThreadLocalRandom.current().nextInt(stockmin, stockmax + 1);// random number of products generation btw 1 to 40 for depot
      price=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     deliveryprice=ThreadLocalRandom.current().nextInt(pricemin, pricemax + 1);
     cash=ThreadLocalRandom.current().nextInt(cashmin, cashmax + 1);
     
    depotC[i] = new BigCappa(crates,price,deliveryprice,cash);
}
        
    //Menu
    boolean t=true;
    int x;
    int ch=0;
    int db;
    int ds;
    int q;
    int pr; //unit price of product at depot
   
    while(t){
     
        System.out.println("Choose Operation");
        System.out.println("1.Big-Alpha Buying");
        System.out.println("2.Big-Beta Buying");
        System.out.println("3.Big-Cappa Buying");
        System.out.println("0.Exit Menu and go to Transactions");
        x=in.nextInt();
        if (x == 0){
            t=false;
            continue;
        }
        System.out.println("1.buyer depot number from 0-39");
        db=in.nextInt();
        System.out.println("2.seller depot number from 0-39");
        ds=in.nextInt();
        System.out.println("Enter Quantity of product you will choose below:");
        q=in.nextInt();
        switch(x) {
            case 0 -> {
                t=false;
            }
            case 1 -> {
                System.out.println("Choose prodcut:");
                System.out.println("1.braces");
                System.out.println("2.carates");
                ch=in.nextInt();
                if(ch==1){
//                   CaculateSale(depot,depotB,q);
                     int tprice= (depotB[ds].price*q)+depotB[ds].deliveryprice;
                     pr=depotB[ds].price;
                     int space=depot[db].External+q;
                     //checking trading conditions
                     if(tprice<=depot[db].cash && space<=maxExternal && minNative<=depotB[ds].Native && maxNative>=depot[db].External+q)
                     {
                         //trading
                         depotB[ds].braces=depotB[ds].braces-q;
                         depotB[ds].Native=depotB[ds].braces;
                         depotB[ds].cash=depotB[ds].cash+ tprice;
                         
                         depot[db].External=depot[db].External+q;
                         depot[db].cash=depot[db].cash- tprice;
                         //recording transaction
                         ++tindex; 
                         trans(tindex,"Big-Alpha", db, "Big-Beta", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);// record in file
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                }
                else if(ch==2){
                     int tprice= (depotC[ds].price*q)+depotC[ds].deliveryprice;
                      pr=depotC[ds].price;
                     int space=depot[db].External+q;
                     //checking trading conditions
                     if(tprice<=depot[db].cash && space<=maxExternal && minNative<=depotC[ds].Native && maxNative>=depot[db].External+q)
                     {
                         //trading
                         depotC[ds].crates=depotC[ds].crates-q;
                         depotC[ds].Native=depotC[ds].crates;
                         depotC[ds].cash=depotC[ds].cash+ tprice;
                         
                         depot[db].External=depot[db].External+q;
                         depot[db].cash=depot[db].cash- tprice;
                          ++tindex; 
                         trans(tindex,"Big-Alpha", db, "Big-Cappa", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                    
                }
                else{}
            }
            case 2 -> {
                 System.out.println("Choose prodcut:");
                System.out.println("1.widgets");
                System.out.println("2.carates");
                ch=in.nextInt();
                if(ch==1){
//                   CaculateSale(depot,depotB,q);
                     int tprice= (depot[ds].price*q)+depot[ds].deliveryprice;
                      pr=depot[ds].price;
                     int space=depotB[db].External+q;
                     //checking trading conditions
                     if(tprice<=depotB[db].cash && space<=maxExternal && minNative<=depot[ds].Native && maxNative>=depotB[db].External+q)
                     {
                         //trading
                         depot[ds].widgets=depot[ds].widgets-q;
                         depot[ds].Native=depot[ds].widgets;
                         depot[ds].cash=depot[ds].cash+ tprice;
                         
                         depotB[db].External=depotB[db].External+q;
                         depotB[db].cash=depotB[db].cash- tprice;
                         ++tindex; 
                         trans(tindex,"Big-Beta", db, "Big-Alpha", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                }
                else if(ch==2){
                     int tprice= (depotC[ds].price*q)+depotC[ds].deliveryprice;
                      pr=depotC[ds].price;
                     int space=depotB[db].External+q;
                     //checking trading conditions
                     if(tprice<=depotB[db].cash && space<=maxExternal && minNative<=depotC[ds].Native && maxNative>=depotB[db].External+q)
                     {
                         //trading
                         depotC[ds].crates=depotC[ds].crates-q;
                         depotC[ds].Native=depotC[ds].crates;
                         depotC[ds].cash=depotC[ds].cash+ tprice;
                         
                         depotB[db].External=depot[db].External+q;
                         depotB[db].cash=depotB[db].cash- tprice;
                         ++tindex; 
                         trans(tindex,"Big-Beta", db, "Big-Cappa", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                    
                }
                else{}
                
            }
            case 3 -> {
                System.out.println("Choose prodcut:");
                System.out.println("1.widgets");
                System.out.println("2.braces");
                ch=in.nextInt();
                if(ch==1){
//                   CaculateSale(depot,depotB,q);
                     int tprice= (depot[ds].price*q)+depot[ds].deliveryprice;
                      pr=depot[ds].price;
                     int space=depotC[db].External+q;
                     //checking trading conditions
                     if(tprice<=depotC[db].cash && space<=maxExternal && minNative<=depot[ds].Native && maxNative>=depotC[db].External+q)
                     {
                         //trading
                         depot[ds].widgets=depot[ds].widgets-q;
                         depot[ds].Native=depot[ds].widgets;
                         depot[ds].cash=depot[ds].cash+ tprice;
                         
                         depotC[db].External=depotC[db].External+q;
                         depotC[db].cash=depotC[db].cash- tprice;
                          ++tindex; 
                         trans(tindex,"Big-Cappa", db, "Big-Alpha", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                }
                else if(ch==2){
                     int tprice= (depotB[ds].price*q)+depotB[ds].deliveryprice;
                      pr=depotB[ds].price;
                     int space=depotC[db].External+q;
                     //checking trading conditions
                     if(tprice<=depotC[db].cash && space<=maxExternal && minNative<=depotB[ds].Native && maxNative>=depotC[db].External+q)
                    {
                         //trading
                         depotB[ds].braces=depotB[ds].braces-q;
                         depotB[ds].Native=depotB[ds].braces;
                         depotB[ds].cash=depotB[ds].cash+ tprice;
                         
                         depotC[db].External=depotC[db].External+q;
                         depotC[db].cash=depotC[db].cash- tprice;
                         ++tindex; 
                         trans(tindex,"Big-Cappa", db, "Big-Beta", ds, q,pr, tprice);
                         objf.WrtieIntoFile(s,depotT,tindex);
                    }
                     else{
                         System.out.println("Transaction not possible");
                     }
                    
                }
                else{}
            }
            default -> System.out.println("Wrong Input");
        }
         }
        
         boolean tz=true;
        int cho;
        while(tz){
     
        System.out.println("Choose Operation");
        System.out.println("1.Transactions history");
        System.out.println("2.Transactions history of Big-Alpha");
        System.out.println("3.Transactions history of Big-Beta");
        System.out.println("4.Transactions history of Big-Cappa");
        System.out.println("5.Read Records File");
        System.out.println("6.Big-Alpha Depots(cash ,native products,external products etc) ");
        System.out.println("7.Big-Beta Depots(cash ,native products,external products etc) ");
        System.out.println("8.Big-Cappa Depots(cash ,native products,external products etc) ");
         
        System.out.println("0.Exit");
        x=in.nextInt();
   
        switch(x) {
            case 0 -> {
                tz=false;
            }
            case 1 -> {
                    for (transactions i : depotT){
                        if(i==null){
                        break;
                        }
                System.out.println("Buyer:"+i.buyer+"BuyerDepotNumber: "+i.buyerDepotNumber+" Seller:"+i.seller+"sellerDepotNumber :"+i.sellerDepotNumber+" Quantity:"+i.Quantity+" Price:"+i.price+" Total Price:"+i.totalprice);
                }
                }
            
            case 2 -> {
                for (transactions i : depotT){
                    if(i==null){
                        break;
                        }
                if("Big-Alpha".equals(i.buyer)){
                    System.out.println(" Buyer: "+i.buyer+" | BuyerDepotNumber: "+i.buyerDepotNumber+" | Seller: "+i.seller+" | sellerDepotNumber: "+i.sellerDepotNumber+" | Quantity: "+i.Quantity+" | Price: "+i.price+" | Total Price: "+i.totalprice);
                }
                }
                
            }
            case 3 -> {
               for (transactions i : depotT){
                   if(i==null){
                        break;
                        }
                if("Big-Beta".equals(i.buyer)){
                    System.out.println("Buyer:"+i.buyer+"BuyerDepotNumber: "+i.buyerDepotNumber+" Seller:"+i.seller+"sellerDepotNumber :"+i.sellerDepotNumber+" Quantity:"+i.Quantity+" Price:"+i.price+" Total Price:"+i.totalprice);
                }
                }
                }
            case 4-> {
                for (transactions i : depotT){
                    if(i==null){
                        break;
                        }
                if("Big-Cappa".equals(i.buyer)){
                    System.out.println("Buyer:"+i.buyer+"BuyerDepotNumber: "+i.buyerDepotNumber+" Seller:"+i.seller+"sellerDepotNumber :"+i.sellerDepotNumber+" Quantity:"+i.Quantity+" Price:"+i.price+" Total Price:"+i.totalprice);
                }
                }
            }
            case 5->{
                    objf.ReadWholeFile(s);
                }
            case 6->{
                     for (BigAlpha i : depot){
                       if(i==null){
                        break;
                        }
                System.out.println(" | Widget Stock: "+i.widgets+" | Unit Price: "+i.price+" | DeliveryPrice: "+i.deliveryprice+" | Cash: "+i.cash+" | Quantity: "+i.Native+" | External Products: "+i.External);
                }
                }
            case 7->{
                     for (BigBeta i : depotB){
                        if(i==null){
                        break;
                        }
                System.out.println(" | Braces Stock: "+i.braces+" | Unit Price: "+i.price+" | DeliveryPrice: "+i.deliveryprice+" | Cash: "+i.cash+" | Quantity: "+i.Native+" | External Products: "+i.External);
                }
                }
            case 8->{
                     for (BigCappa i : depotC){
                        if(i==null){
                        break;
                        }
                System.out.println(" | Crates Stock: "+i.crates+" | Unit Price: "+i.price+" | DeliveryPrice: "+i.deliveryprice+" | Cash: "+i.cash+" | Quantity: "+i.Native+" | External Products: "+i.External);
                }
                }
            default -> System.out.println("Wrong Input");
        }
     
            
        }
    }
    }
