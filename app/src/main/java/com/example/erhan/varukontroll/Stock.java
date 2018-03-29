package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-03-23.
 */

public class Stock {
    Product[] meats = new Product[17];
    Product[] sausages = new Product[5];
    Product[] cheeses = new Product[5];
    Product[] sauces = new Product[14];
    Product[] breads = new Product[9];
    Product[] ingredients = new Product[35];
    Product[] packings = new Product[2];

    public void initializeData()
    {
        meats[0] = new Product("SalladsKyckling",5);
        meats[1] = new Product("Souvlakikyckling",5);
        meats[2] = new Product("Souvlaki spett",5);
        meats[3] = new Product("Mörbit",5);
        meats[4] = new Product("Hamburgare 200g",5);
        meats[5] = new Product("Hamburgare 150g",5);
        meats[6] = new Product("Hamburgare 90g",5);
        meats[7] = new Product("Cajunburgare",5);
        meats[8] = new Product("Hamburgare 45g",5);
        meats[9] = new Product("Halloumiburgare ",5);
        meats[10] = new Product("Köttbullar ",5);
        meats[11] = new Product("Chiken bits ",5);
        meats[12] = new Product("Fish & chips",5);
        meats[13] = new Product("Greenburger ",5);
        meats[14] = new Product("Kebab",5);
        meats[15] = new Product("Kycklingkebab ",5);
        meats[16] = new Product("Gyros ",5);

        sausages[0] = new Product("Tjockkorv",5);
        sausages[1] = new Product("Grillkorv ",5);
        sausages[2] = new Product("Kokt korv ",5);
        sausages[3] = new Product("Choritzo ",5);
        sausages[4] = new Product("Bratwurst ",5);

        cheeses[0] = new Product("Pizza ost",5);
        cheeses[1] = new Product("Mozzarella ost ",5);
        cheeses[2] = new Product("Gorgonzolla ost",5);
        cheeses[3] = new Product("Hamburgar ost",5);
        cheeses[4] = new Product("Feta ost",5);

        sauces[0] = new Product("Hamburgardressing",5);
        sauces[1] = new Product("Chillidressing ",5);
        sauces[2] = new Product("Mexicanadressing ",5);
        sauces[3] = new Product("Tacosås",5);
        sauces[4] = new Product("Bearnesås ",5);
        sauces[5] = new Product("Vitlöksdressing",5);
        sauces[6] = new Product("Remouladsås ",5);
        sauces[7] = new Product("Rodhislandsås ",5);
        sauces[8] = new Product("Currydressing ",5);
        sauces[9] = new Product("Senap ",5);
        sauces[10] = new Product("Ketchup",5);
        sauces[11] = new Product("Stark senap ",5);
        sauces[12] = new Product("Curryketchup ",5);
        sauces[13] = new Product("French hotdog dressing",5);

        breads[0] = new Product("Vetemjöl",5);
        breads[1] = new Product("Tunnbröd glutenfri",5);
        breads[2] = new Product("pizzaboten glutenfri",5);
        breads[3] = new Product("French hotdog bröd ",5);
        breads[4] = new Product("85s bröd",5);
        breads[5] = new Product("55s bröd",5);
        breads[6] = new Product("Korvbröd ",5);
        breads[7] = new Product("Kebab bröd ",5);
        breads[8] = new Product("Tunnbrödsrulle bröd",5);

        ingredients[0] = new Product("Skivad gurka",2);
        ingredients[1] = new Product("Rödbetor skivad ",2);
        ingredients[2] = new Product("Lök",2);
        ingredients[3] = new Product("Lingonsylt",2);
        ingredients[4] = new Product("Jalapeno",2);
        ingredients[5] = new Product("Oliver svarta",2);
        ingredients[6] = new Product("Banan",2);
        ingredients[7] = new Product("Skinka",2);
        ingredients[8] = new Product("Champinjoner",2);
        ingredients[9] = new Product("Paprika",2);
        ingredients[10] = new Product("Tonfisk",2);
        ingredients[11] = new Product("Annanas",2);
        ingredients[12] = new Product("Räkor",2);
        ingredients[13] = new Product("Musslor",2);
        ingredients[14] = new Product("Kronärtskocka",2);
        ingredients[15] = new Product("Majs",2);
        ingredients[16] = new Product("Salami",2);
        ingredients[17] = new Product("Portion kaffe ",2);
        ingredients[18] = new Product("smör ",2);
        ingredients[19] = new Product("vitkål ",2);
        ingredients[20] = new Product("matolja ",2);
        ingredients[21] = new Product("fritösolja ",2);
        ingredients[22] = new Product("Majonäs ",2);
        ingredients[23] = new Product("Rostad lök",2);
        ingredients[24] = new Product("Mjölk portion",2);
        ingredients[25] = new Product("Gräddfil ",2);
        ingredients[26] = new Product("Lättfil",2);
        ingredients[27] = new Product("Tomat",2);
        ingredients[28] = new Product("Jäst",2);
        ingredients[29] = new Product("Citron",2);
        ingredients[30] = new Product("yoghurt",2);
        ingredients[31] = new Product("pommes",2);
        ingredients[32] = new Product("Bostongurka",2);
        ingredients[33] = new Product("fefferoni",2);
        ingredients[34] = new Product("margarin",2);

        packings[0] = new Product("Plastförpackning",5);
        packings[1] = new Product("Aluminuimförpackning",5);



    }
}
