package ru.gb;

import java.util.ArrayList;
import java.util.Scanner;

public class FP {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");

        ArrayList<Laptop> laptops = new ArrayList<>();

        Laptop laptop1 = new Laptop("Acer", 15, 16, 256, "Win11", 1.7, 10, 55000);
        laptops.add(laptop1);

        Laptop laptop2 = new Laptop("Honor", 15, 16, 256, "Win11", 1.4, 9, 65000);
        laptops.add(laptop2);

        Laptop laptop3 = new Laptop("Lenovo", 15, 16, 256, "Win11", 1.1, 11, 75000);
        laptops.add(laptop3);

        Laptop laptop4 = new Laptop("Acer", 14, 8, 256, "Win10", 1.2, 8, 80000);
        laptops.add(laptop4);

        Laptop laptop5 = new Laptop("Apple", 14, 8, 512, "macOS", 1.3, 7, 80000);
        laptops.add(laptop5);

        Laptop laptop6 = new Laptop("HP", 14, 8, 512, "Win10", 1.4, 8, 130000);
        laptops.add(laptop6);

        Laptop laptop7 = new Laptop("ASUS", 13, 32, 1000, "Win11 Pro", 1.5, 9, 120000);
        laptops.add(laptop7);

        Laptop laptop8 = new Laptop("MSI", 13, 32, 1000, "Win11 Pro", 1.6, 10, 110000);
        laptops.add(laptop8);

        Laptop laptop9 = new Laptop("noBrand", 16, 64, 2000, "Linux", 1.9, 15, 60000);
        laptops.add(laptop9);

        Laptop laptop10 = new Laptop("noBrand", 16, 64, 2000, "Linux", 2.2, 14, 700000);
        laptops.add(laptop10);

        System.out.println("Список ноутбуков: ");
        System.out.println(laptops);

        Laptop criteria = new Laptop("no", 0, 0, 0, "no", 0, 0, 0);
                      
        while (true) {

            System.out.println(
                    "Введите цифру, соответствующую необходимому критерию:\n0 - фирма\n1 - диагональ дисплея\n2 - объем ОЗУ\n3 - объем ЖД\n4 - ОС\n5 - вес\n6 - время автономной работы\n7 - цена\n8 - результат поиска");

            String str = sc.nextLine();

            if (str.equals("0")) {
                System.out.println("Введите фирму: ");
                String str0 = sc.nextLine();
                criteria.setLaptopmodel(str0);
            }

            if (str.equals("1")) {
                System.out.println("Введите диагональ дисплея в дюймах: ");
                String str1 = sc.nextLine();
                int number1 = Integer.valueOf(str1);
                criteria.setDisplaysize(number1);
            }

            if (str.equals("2")) {
                System.out.println("Введите объем оперативной памяти в Гб: ");
                String str2 = sc.nextLine();
                int number2 = Integer.valueOf(str2);
                criteria.setRamsize(number2);
            }

            if (str.equals("3")) {
                System.out.println("Введите объем жесткого диска в Гб: ");
                String str3 = sc.nextLine();
                int number3 = Integer.valueOf(str3);
                criteria.setHdcapacity(number3);
            }

            if (str.equals("4")) {
                System.out.println("Интересует операционная система: ");
                String str4 = sc.nextLine();
                criteria.setOperatingsystem(str4);
            }

            if (str.equals("5")) {
                System.out.println("Вес в кг: ");
                String str5 = sc.nextLine();
                double number5 = Double.valueOf(str5);
                criteria.setLaptopweight(number5);
            }

            if (str.equals("6")) {
                System.out.println("Введите минимальное время автономной работы в часах: ");
                String str6 = sc.nextLine();
                int number6 = Integer.valueOf(str6);
                criteria.setBatterylife(number6);
            }

            if (str.equals("7")) {
                System.out.println("Введите максимальную цену в руб.: ");
                String str7 = sc.nextLine();
                int number7 = Integer.valueOf(str7);
                criteria.setLaptopprice(number7);
            }

            if (str.equals("8")) {
                break;
            }
        }
        
        System.out.println(criteria);

        ArrayList<Laptop> out = new ArrayList<Laptop>();

        for (Laptop laptop : laptops) {

            if (criteria.getLaptopmodel().equals("no") || criteria.getLaptopmodel().equals(laptop.getLaptopmodel())) {
                if (criteria.getDisplaysize() == 0 || criteria.getDisplaysize() <= laptop.getDisplaysize()) {
                    if (criteria.getRamsize() == 0 || criteria.getRamsize() <= laptop.getRamsize()) {
                        if (criteria.getHdcapacity() == 0 || criteria.getHdcapacity() <= laptop.getHdcapacity()) {
                            if (criteria.getOperatingsystem().equals("no") || criteria.getOperatingsystem().equals(laptop.getOperatingsystem())) {
                                if (criteria.getLaptopweight() == 0 || criteria.getLaptopweight() >= laptop.getLaptopweight()) {
                                    if (criteria.getBatterylife() == 0 || criteria.getBatterylife() <= laptop.getBatterylife()) {
                                        if (criteria.getLaptopprice() == 0 || criteria.getLaptopprice() >= laptop.getLaptopprice()) {
                                            out.add(laptop);
                                        }
                                        else {
                                            continue;
                                        }
                                    }
                                    else {
                                        continue;
                                    }

                                }
                                else {
                                    continue;
                                }
                            }
                            else {
                                continue;
                            }
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        continue;
                    }
                }
                else {
                    continue;
                }
            }
            else {
                continue;
            }
        }

        if (out.isEmpty())

        {
            System.out.println("Таких ноутбуков нет. Проверьте параметры.");
        } else {
            System.out.println("Вот такие ноутбуки у нас есть: ");
            System.out.println(out);
        }

        sc.close();
    }
}
