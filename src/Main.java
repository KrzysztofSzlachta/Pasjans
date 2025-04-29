import java.util.ArrayList;
import java.util.Random;

class Pasjans{
    private int proba = 0;
    private String[] kier = new String[6];
    private String[] karo = new String[6];
    private String[] trefl = new String[6];
    private String[] pik = new String[6];
    private String[][] plansza = {kier, karo, trefl, pik};
    private ArrayList<ArrayList<String>> Figury = new ArrayList<>();
    private ArrayList<String> listaKier = new ArrayList<String>();
    private ArrayList<String> listaKaro = new ArrayList<String>();
    private ArrayList<String> listaTrefl = new ArrayList<String>();
    private ArrayList<String> listaPik = new ArrayList<>();
    private String reka;
    private String[][] zapis;
    private String zapisReki;
    private String[][] zaslonieta = {
            {"*************", "*************", "*************", "*************", "*************", "*************"},
            {"*************", "*************", "*************", "*************", "*************", "*************"},
            {"*************", "*************", "*************", "*************", "*************", "*************"},
            {"*************", "*************", "*************", "*************", "*************", ""}
    };

    void generacjaPlanszyFigur() {
        //Czyszczenie list
        listaKier.clear();
        listaKaro.clear();
        listaTrefl.clear();
        listaPik.clear();

        //Wypełnianie listy Kier
        listaKier.add(" kier_9      ");
        listaKier.add(" kier_10     ");
        listaKier.add(" kier_walet  ");
        listaKier.add(" kier_dama   ");
        listaKier.add(" kier_król   ");
        listaKier.add(" kier_as     ");

        //Wypełnianie listy Karo
        listaKaro.add(" karo_9      ");
        listaKaro.add(" karo_10     ");
        listaKaro.add(" karo_walet  ");
        listaKaro.add(" karo_dama   ");
        listaKaro.add(" karo_król   ");
        listaKaro.add(" karo_as     ");

        //Wypełnianie listy Trefl
        listaTrefl.add(" trefl_9     ");
        listaTrefl.add(" trefl_10    ");
        listaTrefl.add(" trefl_walet ");
        listaTrefl.add(" trefl_dama  ");
        listaTrefl.add(" trefl_król  ");
        listaTrefl.add(" trefl_as    ");

        //Wypełnianie listy Pik
        listaPik.add(" pik_9       ");
        listaPik.add(" pik_10      ");
        listaPik.add(" pik_walet   ");
        listaPik.add(" pik_dama    ");
        listaPik.add(" pik_król    ");
        listaPik.add(" pik_as      ");

        //Dodawanie mniejszych list do głównej listy
        Figury.add(listaKier);
        Figury.add(listaKaro);
        Figury.add(listaTrefl);
        Figury.add(listaPik);
    }

    void tworzeniePlanszy(){

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                int losowyWiersz = new Random().nextInt(Figury.size());
                if(Figury.get(losowyWiersz).isEmpty()) {
                    j-=1;
                    continue;
                }
                if (i==3 && j==5){
                    plansza[i][j] = "";
                    reka = Figury.get(losowyWiersz).getFirst();
                    continue;
                }
                int losowyElement = new Random().nextInt(Figury.get(losowyWiersz).size());
                plansza[i][j] = Figury.get(losowyWiersz).get(losowyElement);
                Figury.get(losowyWiersz).remove(losowyElement);
            }
        }
    }

    void wypisanie(int tura, String[][] plansza){
        System.out.print("Ruch numer " + tura + ":\n");
        for(int i = 0; i < 4; i++){
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("|");
            for(int j = 0; j < 6; j++){
                System.out.print(plansza[i][j] + "|");
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    boolean gra(){
        int index;
        String tmp;
        generacjaPlanszyFigur();
        tworzeniePlanszy();
        generacjaPlanszyFigur();

        proba += 1;
        zapisReki = reka;
        zapis = new String[4][6];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                zapis[i][j] = plansza[i][j];
            }
        }

        for(int i = 0; i < 24; i++){
            if (reka.isEmpty() || reka.equals(" pik_as      ")){
                break;
            }
            String kolor = reka.substring(1, 3);
            if (kolor.equals("ki")){
                index = Figury.get(0).indexOf(reka);
                tmp = plansza[0][index];
                plansza[0][index] = reka;
                reka = tmp;
            } else if (kolor.equals("ka")) {
                index = Figury.get(1).indexOf(reka);
                tmp = plansza[1][index];
                plansza[1][index] = reka;
                reka = tmp;
            }else if (kolor.equals("tr")){
                index = Figury.get(2).indexOf(reka);
                tmp = plansza[2][index];
                plansza[2][index] = reka;
                reka = tmp;
            }else if (kolor.equals("pi")){
                index = Figury.get(3).indexOf(reka);
                tmp = plansza[3][index];
                plansza[3][index] = reka;
                reka = tmp;
            }
        }
        if (plansza[3][5].isEmpty()) plansza[3][5] = reka;
        for(int i =0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                if(!plansza[i][j].equals(Figury.get(i).get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    void wypisanieGry() {
        int index, tura = 0;
        String tmp;
        generacjaPlanszyFigur();
        System.out.printf("Rozwiązano przy %d próbie:\n", proba+1);
        wypisanie(tura, zaslonieta);
        System.out.println("\nNa ręce: " + zapisReki + "\n\n");
        for (int i = 0; i < 25; i++) {
            if (zapisReki.equals(" pik_as      ")) break;
            String kolor = zapisReki.substring(1, 3);
            if (kolor.equals("ki")) {
                index = Figury.get(0).indexOf(zapisReki);
                tmp = zapis[0][index];
                zapis[0][index] = zapisReki;
                zaslonieta[0][index] = zapisReki;
                zapisReki = tmp;
            } else if (kolor.equals("ka")) {
                index = Figury.get(1).indexOf(zapisReki);
                tmp = zapis[1][index];
                zapis[1][index] = zapisReki;
                zaslonieta[1][index] = zapisReki;
                zapisReki = tmp;
            } else if (kolor.equals("tr")) {
                index = Figury.get(2).indexOf(zapisReki);
                tmp = zapis[2][index];
                zapis[2][index] = zapisReki;
                zaslonieta[2][index] = zapisReki;
                zapisReki = tmp;
            } else if (kolor.equals("pi")) {
                index = Figury.get(3).indexOf(zapisReki);
                tmp = zapis[3][index];
                zapis[3][index] = zapisReki;
                zaslonieta[3][index] = zapisReki;
                zapisReki = tmp;
            }
            tura += 1;
            wypisanie(tura, zaslonieta);
            System.out.println("Na ręce: " + zapisReki + "\n\n");
            if (zapis[3][5].equals(" pik_as      ")) break;
        }
        zapis[3][5] = " pik_as      ";
        wypisanie(tura, zapis);
    }

    public Pasjans() {}
}


public class Main {
    public static void main(String[] args) {
        Pasjans pasjans = new Pasjans();
        boolean check = false;
        while(!check) {
            check = pasjans.gra();
        }
        pasjans.wypisanieGry();
    }
}