package com.example.erhan.varukontroll;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erhan on 2018-03-23.
 */


//This class is not really needed anymore, since all value read/writes are made trough FireBase.
    //This class is only yet here as an easy and fast way to write or restore default values on Firebase, mainly for testing.
public class Stock {
    public Product[] meats = new Product[17];
    public Product[] sausages = new Product[5];
    public Product[] cheeses = new Product[5];
    public Product[] sauces = new Product[14];
    public Product[] breads = new Product[9];
    public Product[] spices = new Product[15];
    public Product[] ingredients = new Product[35];
    public Product[] packings = new Product[2];

    void initializeData()
    {
        meats[0] = new Product("SalladsKyckling",1,"Kött");
        meats[1] = new Product("Souvlakikyckling",1,"Kött");
        meats[2] = new Product("Souvlaki spett",1,"Kött");
        meats[3] = new Product("Mörbit",1,"Kött");
        meats[4] = new Product("Hamburgare 200g",1,"Kött");
        meats[5] = new Product("Hamburgare 150g",1,"Kött");
        meats[6] = new Product("Hamburgare 90g",1,"Kött");
        meats[7] = new Product("Cajunburgare",1,"Kött");
        meats[8] = new Product("Hamburgare 45g",1,"Kött");
        meats[9] = new Product("Halloumiburgare ",1,"Kött");
        meats[10] = new Product("Köttbullar ",1,"Kött");
        meats[11] = new Product("Chicken bits ",1,"Kött");
        meats[12] = new Product("Fish & chips",1,"Kött");
        meats[13] = new Product("Greenburger ",1,"Kött");
        meats[14] = new Product("Kebab",1,"Kött");
        meats[15] = new Product("Kycklingkebab ",1,"Kött");
        meats[16] = new Product("Gyros ",1,"Kött");

        sausages[0] = new Product("Tjockkorv",1,"korv");
        sausages[1] = new Product("Grillkorv ",1,"korv");
        sausages[2] = new Product("Kokt korv ",1,"korv");
        sausages[3] = new Product("Choritzo ",1,"korv");
        sausages[4] = new Product("Bratwurst ",1,"korv");

        cheeses[0] = new Product("Pizza ost",1,"Ost");
        cheeses[1] = new Product("Mozzarella ost ",1,"Ost");
        cheeses[2] = new Product("Gorgonzolla ost",1,"Ost");
        cheeses[3] = new Product("Hamburgar ost",1,"Ost");
        cheeses[4] = new Product("Feta ost",1,"Ost");

        sauces[0] = new Product("Hamburgardressing",1,"Såser");
        sauces[1] = new Product("Chillidressing ",1,"Såser");
        sauces[2] = new Product("Mexicanadressing ",1,"Såser");
        sauces[3] = new Product("Tacosås",1,"Såser");
        sauces[4] = new Product("Bearnesås ",1,"Såser");
        sauces[5] = new Product("Vitlöksdressing",1,"Såser");
        sauces[6] = new Product("Remouladsås ",1,"Såser");
        sauces[7] = new Product("Rodhislandsås ",1,"Såser");
        sauces[8] = new Product("Currydressing ",1,"Såser");
        sauces[9] = new Product("Senap ",1,"Såser");
        sauces[10] = new Product("Ketchup",1,"Såser");
        sauces[11] = new Product("Stark senap ",1,"Såser");
        sauces[12] = new Product("Curryketchup ",1,"Såser");
        sauces[13] = new Product("French hotdog dressing",1,"Såser");

        spices[0] = new Product("Salt",1,"Kryddor");
        spices[1] = new Product("Peppar",1,"Kryddor");
        spices[2] = new Product("Socker",1,"Kryddor");
        spices[3] = new Product("Piffikrydda",1,"Kryddor");
        spices[4] = new Product("Cajunpeppar",1,"Kryddor");
        spices[5] = new Product("Oregano",1,"Kryddor");
        spices[6] = new Product("Persilja",1,"Kryddor");
        spices[7] = new Product("Basilika ",1,"Kryddor");
        spices[8] = new Product("Citronkrydda ",1,"Kryddor");
        spices[9] = new Product("Grillkrydda",1,"Kryddor");
        spices[10] = new Product("Vitpeppar",1,"Kryddor");
        spices[11] = new Product("Vitlökssalt",1,"Kryddor");
        spices[12] = new Product("Aromkrydda ",1,"Kryddor");
        spices[13] = new Product("Kryddpeppar  ",1,"Kryddor");
        spices[14] = new Product("Dill ",1,"Kryddor");

        breads[0] = new Product("Vetemjöl",1,"Bröd");
        breads[1] = new Product("Tunnbröd glutenfri",1,"Bröd");
        breads[2] = new Product("pizzaboten glutenfri",1,"Bröd");
        breads[3] = new Product("French hotdog bröd ",1,"Bröd");
        breads[4] = new Product("85s bröd",1,"Bröd");
        breads[5] = new Product("55s bröd",1,"Bröd");
        breads[6] = new Product("Korvbröd ",1,"Bröd");
        breads[7] = new Product("Kebab bröd ",1,"Bröd");
        breads[8] = new Product("Tunnbrödsrulle bröd",1,"Bröd");

        ingredients[0] = new Product("Skivad gurka",1,"Ingredienser");
        ingredients[1] = new Product("Rödbetor skivad ",1,"Ingredienser");
        ingredients[2] = new Product("Lök",1,"Ingredienser");
        ingredients[3] = new Product("Lingonsylt",1,"Ingredienser");
        ingredients[4] = new Product("Jalapeno",1,"Ingredienser");
        ingredients[5] = new Product("Oliver svarta",1,"Ingredienser");
        ingredients[6] = new Product("Banan",1,"Ingredienser");
        ingredients[7] = new Product("Skinka",1,"Ingredienser");
        ingredients[8] = new Product("Champinjoner",1,"Ingredienser");
        ingredients[9] = new Product("Paprika",1,"Ingredienser");
        ingredients[10] = new Product("Tonfisk",1,"Ingredienser");
        ingredients[11] = new Product("Annanas",1,"Ingredienser");
        ingredients[12] = new Product("Räkor",1,"Ingredienser");
        ingredients[13] = new Product("Musslor",1,"Ingredienser");
        ingredients[14] = new Product("Kronärtskocka",1,"Ingredienser");
        ingredients[15] = new Product("Majs",1,"Ingredienser");
        ingredients[16] = new Product("Salami",1,"Ingredienser");
        ingredients[17] = new Product("Portion kaffe ",1,"Ingredienser");
        ingredients[18] = new Product("smör ",1,"Ingredienser");
        ingredients[19] = new Product("vitkål ",1,"Ingredienser");
        ingredients[20] = new Product("matolja ",1,"Ingredienser");
        ingredients[21] = new Product("fritösolja ",1,"Ingredienser");
        ingredients[22] = new Product("Majonäs ",1,"Ingredienser");
        ingredients[23] = new Product("Rostad lök",1,"Ingredienser");
        ingredients[24] = new Product("Mjölk portion",1,"Ingredienser");
        ingredients[25] = new Product("Gräddfil ",1,"Ingredienser");
        ingredients[26] = new Product("Lättfil",1,"Ingredienser");
        ingredients[27] = new Product("Tomat",1,"Ingredienser");
        ingredients[28] = new Product("Jäst",1,"Ingredienser");
        ingredients[29] = new Product("Citron",1,"Ingredienser");
        ingredients[30] = new Product("yoghurt",1,"Ingredienser");
        ingredients[31] = new Product("pommes",1,"Ingredienser");
        ingredients[32] = new Product("Bostongurka",1,"Ingredienser");
        ingredients[33] = new Product("fefferoni",1,"Ingredienser");
        ingredients[34] = new Product("margarin",1,"Ingredienser");

        packings[0] = new Product("Plastförpackning",1,"Förpackningar");
        packings[1] = new Product("Aluminuimförpackning",1,"Förpackningar");



    }

    public List<String> getListNames(int index)
    {
        List<String> items = new ArrayList<>();

        switch (index){
            case 0:
                for(int i = 0; i < meats.length; i++){items.add(meats[i].getName());}
                break;

            case 1:
                for(int i = 0; i < sausages.length; i++){items.add(sausages[i].getName());}
                break;

            case 2:
                for(int i = 0; i < cheeses.length; i++){items.add(cheeses[i].getName());}
                break;

            case 3:
                for(int i = 0; i < sauces.length; i++){items.add(sauces[i].getName());}
                break;

            case 4:  for(int i = 0; i < breads.length; i++){items.add(breads[i].getName());}
                break;

            case 5:  for(int i = 0; i < spices.length; i++){items.add(spices[i].getName());}
                break;

            case 6:  for(int i = 0; i < ingredients.length; i++){items.add(ingredients[i].getName());}
                break;

            case 7:  for(int i = 0; i < packings.length; i++){items.add(packings[i].getName());}
                break;
        }
        return items;
    }



    public static void resetAllData(int value) {
        //Just to get the class template up to Firebase quick, and to set default values, or restore them
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference meatRef = database.getReference("Stock").child("Kött");
        DatabaseReference sausageRef = database.getReference("Stock").child("Korv");
        DatabaseReference cheeseRef = database.getReference("Stock").child("Ost");
        DatabaseReference sauceRef = database.getReference("Stock").child("Såser");
        DatabaseReference breadRef = database.getReference("Stock").child("Bröd");
        DatabaseReference spiceRef = database.getReference("Stock").child("Kryddor");
        DatabaseReference ingredientsRef = database.getReference("Stock").child("Ingredienser");
        DatabaseReference packingsRef = database.getReference("Stock").child("Förpackningar");


        for (int i = 0; i < MainActivity.stock.meats.length; i++)
        {
            String loc = MainActivity.stock.meats[i].getName();
            DatabaseReference locRef = meatRef.child(loc).child("Antal");
            DatabaseReference locRef2 = meatRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.meats[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.sausages.length; i++)
        {
            String loc = MainActivity.stock.sausages[i].getName();
            DatabaseReference locRef = sausageRef.child(loc).child("Antal");
            DatabaseReference locRef2 = sausageRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.sausages[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.cheeses.length; i++)
        {
            String loc = MainActivity.stock.cheeses[i].getName();
            DatabaseReference locRef = cheeseRef.child(loc).child("Antal");
            DatabaseReference locRef2 = cheeseRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.cheeses[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.sauces.length; i++)
        {
            String loc = MainActivity.stock.sauces[i].getName();
            DatabaseReference locRef = sauceRef.child(loc).child("Antal");
            DatabaseReference locRef2 = sauceRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.sauces[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.breads.length; i++)
        {
            String loc = MainActivity.stock.breads[i].getName();
            DatabaseReference locRef = breadRef.child(loc).child("Antal");
            DatabaseReference locRef2 = breadRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.breads[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.spices.length; i++)
        {
            String loc = MainActivity.stock.spices[i].getName();
            DatabaseReference locRef = spiceRef.child(loc).child("Antal");
            DatabaseReference locRef2 = spiceRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.spices[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.ingredients.length; i++)
        {
            String loc = MainActivity.stock.ingredients[i].getName();
            DatabaseReference locRef = ingredientsRef.child(loc).child("Antal");
            DatabaseReference locRef2 = ingredientsRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.ingredients[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.packings.length; i++)
        {
            String loc = MainActivity.stock.packings[i].getName();
            DatabaseReference locRef = packingsRef.child(loc).child("Antal");
            DatabaseReference locRef2 = packingsRef.child(loc).child("Namn");
            locRef.setValue(value);
            locRef2.setValue(MainActivity.stock.packings[i].getName());
        }
    }
}
