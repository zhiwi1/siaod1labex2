package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        LinkedList x = new LinkedList();
        while (true) {
            System.out.println("Нажмите 1, добавить абонента");
            System.out.println("Нажмите 2, если хотите найти номер через ФИО ");
            System.out.println("Нажмите 3, если хотите найти ФИО через номер телефона");
            System.out.println("Нажмите 4, чтобы выйти из программы");
            do {

                while (!in.hasNextInt()) {// проверка на ввод .Пока не будет int зациклил ввод
                    System.out.println("Неверный ввод");
                    in.next();
                }

                n = in.nextInt();
                in.nextLine();
            } while (n < 1 || n > 4);

            if (n == 1) {
                add(in, x);
            }
            if (n == 2) {
                System.out.println("Введите ФИО");
                String hey = in.nextLine();
                if (x.findN(hey) != null)
                    System.out.println(x.findN(hey).getNumber());else{
                        System.out.println("Не найдено");
                }
            }
            if (n == 3) {
                System.out.println("Введите номер");

                int h = input7(in);
                if (x.findF(h) != null)
                    System.out.println(x.findF(h).getFIO());
                else{
                    System.out.println("Не найдено");
            }}

            if (n == 4) {
                break;
            }
        }
    }

    static void add(Scanner in, LinkedList x) {
        System.out.println("Введите ФИО");

        String line = in.nextLine();

        System.out.println("Введите номер телефона ");

     int  m= input7(in);
        x.insert(new Link(line, m));
        System.out.println("Успешно добавлено");
    }
    static int input7(Scanner in){
        int n2 =0;

        do{
            while (!in.hasNextInt()) {
                System.out.println("Неверный ввод");
                in.next();
            }


            n2=in.nextInt();
            in.nextLine();
            if(n2>=10000000||n2<1000000){
                System.out.println("Число не является семизначным");
            }
        }while (n2>=10000000||n2<1000000);

        return n2;}
}

class LinkedList {
    private int size = 0;//размер листа
    private Link first; // Ссылка на первый элемент в списке

    // -------------------------------------------------------------


    public int size() {
        return size;
    }


    public LinkedList() // Конструктор
    {
        first = null;
    }



    public Link findF(int key)
    {
if(first!=null){
        Link current = first;
        while (current.getNumber() != key)
        {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }else return null; }

    public Link findN(String key)
    {if (first!=null){
        Link current = first;
        while (!current.getFIO().equals(key))
        {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }else return null;}



    public void insert(Link k) // Вставка (в порядке сортировки)
    {
        size++;
        Link newLink = new Link(k);
        Link previous = null;
        Link current = first;
        // До конца списка
        while (current != null && chars(current.getFIO().toLowerCase(), k.getFIO().toLowerCase())) { // или если ключ > current,
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;

        }
        else {

            previous.next = newLink;
        }

        newLink.next = current;
    }

    public Boolean chars(String y, String x) {   if (x.compareTo(y) >= 0)
            return true;
        else return false;

    }

    public Link getEl(int index) {
        Link current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


}


class Link {

    private String FIO;
    private int number;
    public Link next;

    Link(String p, int l) {
        this.FIO = p;
        this.number = l;

    }

    Link(Link x) {
        this.FIO = x.FIO;
        this.number = x.number;

    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override// переопределние метода ToString
    public String toString() {

        return getFIO() + "|" + getNumber() + "\n ";
    }
}