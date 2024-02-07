package com.example._13rsz1_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> poslovnice = new HashMap<>();

        System.out.print("Unesite broj poslovnica: ");
        int brojPoslovnica = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < brojPoslovnica; i++) {
            System.out.print("Unesite ime poslovnice " + (i + 1) + ": ");
            String ime = scanner.nextLine();
            poslovnice.put(ime, new ArrayList<>());
        }

        boolean radi = true;
        while (radi) {
            System.out.println("Izaberite opciju:");
            System.out.println("1. Unos profita");
            System.out.println("2. Ispis profita po poslovnici po mjesecu");
            System.out.println("3. Ispis profita po poslovnici po mjesecima");
            System.out.println("4. Ispis godišnjeg profita po poslovnici za sve poslovnice");
            System.out.println("5. Ispis mjesečnog profita po poslovnici za sve poslovnice");
            System.out.println("6. Ispis ukupnog profita po mjesecima");
            System.out.println("7. Ispis ukupnog godišnjeg profita");
            System.out.println("8. Dodaj poslovnicu");
            System.out.println("9. Obriši poslovnicu");
            System.out.println("10. KRAJ");


            int opcija = scanner.nextInt();
            scanner.nextLine();

            switch (opcija) {
                case 1:
                    unosProfita(poslovnice, scanner);
                    break;
                case 2:
                    ispisiProfitPoMjesecu(poslovnice, scanner);
                    break;
                case 3:
                    ispisiProfitPoMjesecima(poslovnice, scanner);
                    break;
                case 4:
                    ispisiGodisnjiProfitZaSvePoslovnice(poslovnice);
                    break;
                case 5:
                    ispisiMjesecniProfitZaSvePoslovnice(poslovnice);
                    break;
                case 6:
                    ispisiUkupniProfitPoMjesecima(poslovnice);
                    break;
                case 7:
                    ispisiUkupniGodisnjiProfit(poslovnice);
                    break;
                case 8:
                    dodajPoslovnicu(poslovnice, scanner);
                    break;
                case 9:
                    obrisiPoslovnicu(poslovnice, scanner);
                    break;
                case 10:
                    radi = false;
                    break;
                default:
                    System.out.println("Pogrešan unos, molimo izaberite ponovo.");
            }
        }

        scanner.close();
    }
    private static void dodajPoslovnicu(Map<String, List<Double>> poslovnice, Scanner scanner) {
        System.out.print("Unesite ime nove poslovnice: ");
        String imePoslovnice = scanner.nextLine();

        if (!poslovnice.containsKey(imePoslovnice)) {
            poslovnice.put(imePoslovnice, new ArrayList<>());
            System.out.println("Poslovnica " + imePoslovnice + " je uspješno dodana.");
        } else {
            System.out.println("Poslovnica sa unijetim imenom već postoji.");
        }
    }

    private static void obrisiPoslovnicu(Map<String, List<Double>> poslovnice, Scanner scanner) {
        System.out.print("Unesite ime poslovnice koju želite da obrišete: ");
        String imePoslovnice = scanner.nextLine();

        if (poslovnice.containsKey(imePoslovnice)) {
            poslovnice.remove(imePoslovnice);
            System.out.println("Poslovnica " + imePoslovnice + " je uspješno obrisana.");
        } else {
            System.out.println("Poslovnica sa unijetim imenom ne postoji.");
        }
    }

    private static void unosProfita(Map<String, List<Double>> poslovnice, Scanner scanner) {
        System.out.print("Unesite ime poslovnice: ");
        String imePoslovnice = scanner.nextLine();

        if (poslovnice.containsKey(imePoslovnice)) {
            System.out.print("Unesite mjesec (1-12): ");
            int mjesec = scanner.nextInt();
            scanner.nextLine();

            if (mjesec >= 1 && mjesec <= 12) {
                System.out.print("Unesite profit za mjesec " + mjesec + ": ");
                double profit = scanner.nextDouble();
                scanner.nextLine();

                List<Double> profitPoMjesecima = poslovnice.get(imePoslovnice);
                if (profitPoMjesecima == null) {
                    profitPoMjesecima = new ArrayList<>();
                }

                while (profitPoMjesecima.size() < mjesec) {
                    profitPoMjesecima.add(0.0);
                }
                profitPoMjesecima.set(mjesec - 1, profit);
                poslovnice.put(imePoslovnice, profitPoMjesecima);
                System.out.println("Profit za mjesec " + mjesec + " je uspješno dodan.");
            } else {
                System.out.println("Pogrešan unos. Molimo unesite ispravan mjesec (1-12).");
            }
        } else {
            System.out.println("Poslovnica sa unijetim imenom ne postoji.");
        }
    }

    private static void ispisiProfitPoMjesecu(Map<String, List<Double>> poslovnice, Scanner scanner) {
        System.out.print("Unesite ime poslovnice: ");
        String imePoslovnice = scanner.nextLine();

        if (poslovnice.containsKey(imePoslovnice)) {
            List<Double> profitPoMjesecima = poslovnice.get(imePoslovnice);
            System.out.print("Unesite mesec (1-12) za koji želite da ispišete profit: ");
            int mesec = scanner.nextInt();
            scanner.nextLine(); // Pročitaj prelazak u novi red nakon unosa meseca

            if (mesec >= 1 && mesec <= 12) {
                double profit = profitPoMjesecima.get(mesec - 1);
                System.out.println("Profit za mesec " + mesec + " (" + imePoslovnice + "): " + profit);
            } else {
                System.out.println("Nepostojeći mesec. Molimo unesite ispravan mesec (1-12).");
            }
        } else {
            System.out.println("Poslovnica sa unetim imenom ne postoji.");
        }
    }


    private static void ispisiProfitPoMjesecima(Map<String, List<Double>> poslovnice, Scanner scanner) {
        System.out.print("Unesite ime poslovnice: ");
        String imePoslovnice = scanner.nextLine();

        if (poslovnice.containsKey(imePoslovnice)) {
            List<Double> profitPoMjesecima = poslovnice.get(imePoslovnice);
            System.out.println("Profit po mjesecima za poslovnicu " + imePoslovnice + ":");
            for (int i = 0; i < profitPoMjesecima.size(); i++) {
                System.out.println("Mjesec " + (i + 1) + ": " + profitPoMjesecima.get(i));
            }
        } else {
            System.out.println("Poslovnica sa unijetim imenom ne postoji.");
        }
    }

    private static void ispisiGodisnjiProfitZaSvePoslovnice(Map<String, List<Double>> poslovnice) {
        for (String imePoslovnice : poslovnice.keySet()) {
            List<Double> profitPoMjesecima = poslovnice.get(imePoslovnice);
            double ukupanProfit = profitPoMjesecima.stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("Godišnji profit za poslovnicu " + imePoslovnice + ": " + ukupanProfit);
        }
    }

    private static void ispisiMjesecniProfitZaSvePoslovnice(Map<String, List<Double>> poslovnice) {
        for (int i = 0; i < 12; i++) {
            final int mjesec = i + 1;
            System.out.println("Mjesečni profit za mesec " + mjesec + ":");
            poslovnice.forEach((imePoslovnice, profitPoMjesecima) -> {
                if (mjesec <= profitPoMjesecima.size()) {
                    double profit = profitPoMjesecima.get(mjesec - 1);
                    System.out.println(imePoslovnice + ": " + profit);
                } else {
                    System.out.println(imePoslovnice + ": 0.0");
                }
            });
        }
    }


    private static void ispisiUkupniProfitPoMjesecima(Map<String, List<Double>> poslovnice) {
        double[] ukupniProfitiZaMjesec = new double[12];

        for (List<Double> profitPoMjesecima : poslovnice.values()) {
            for (int i = 0; i < profitPoMjesecima.size(); i++) {
                ukupniProfitiZaMjesec[i] += profitPoMjesecima.get(i);
            }
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Ukupni profit za mjesec " + (i + 1) + ": " + ukupniProfitiZaMjesec[i]);
        }
    }


    private static void ispisiUkupniGodisnjiProfit(Map<String, List<Double>> poslovnice) {
        double ukupniProfit = poslovnice.values().stream()
                .flatMapToDouble(profitPoMjesecima -> profitPoMjesecima.stream().mapToDouble(Double::doubleValue))
                .sum();
        System.out.println("Ukupni godišnji profit za sve poslovnice: " + ukupniProfit);
    }
}
