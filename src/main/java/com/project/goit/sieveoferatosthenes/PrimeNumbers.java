package com.project.goit.sieveoferatosthenes;

import java.util.Arrays;

public class PrimeNumbers {

    public String[] getSimpleNumbers() {
        return new String[]{"Your prime numbers: " + simpleNumbers,
                "Quantity primes in your range = " + counterOfSimpleNumbers};
    }
    private static final StringBuilder simpleNumbers = new StringBuilder("2");//StringBuilder для создания строки
    // содержащей все найденные простые числа.
    //(Изначально 2 так как четные числа учитываться не будут,
    // а первое нечетное число 2 уже занесено в список).
    private int counterOfSimpleNumbers = 1;//Переменная для нахождения количества простых чисел.

    @Override
    public String toString() {
        return "Please enter positive number that is greater the 1: ";
    }

    public void sieveOfEratosthenes(int limit) {//Входные параметры(предел до которого
        // нужно найти все простые числа).
        boolean[] sieve = new boolean[limit + 1];//Создаем массив длинное предел+1
        // (дабы внем присутвовали все значения до предела).
        Arrays.fill(sieve, true); //Присваеваем всем ячейкам массива значение true.

        for (int i = 3; i <= limit; i+=2) { //Цикл от 1-го простого чила(2-а) до предела(вводится пользователем).
            if (sieve[i]) {    //Проверка условия, если i-й элемент массива = true(тоесть если число не
                // вычеркнуто из массива) то тело выполняется.
                counterOfSimpleNumbers++; //Увеличиваем значение counterOfSimpleNumbers,
                // так как если условие выполнилось то число простое.
                simpleNumbers.append(" ").append(i);//Записываем в строку новое число
                // отделяя его от предыдущего пробелом.
                int step = i % 2 == 0 ? i : 2 * i;//Устанавливаем значение шага(для всех нечетных чисел шаг можно
                // установить как 2i(посути это нужно только для 2-ки так как после нее все четные числа вычеркнутся))
                for (int k = i * i; k < limit + 1; k += step) {//Цикл для вычеркивания всех чисел
                    // от простого числа в квадрате
                    //(тоесть 1-го еще не вычеркнутого числа делящееся на взятое простое число)
                    sieve[k] = false;//Присваеваем элементу значение false
                    // (вычеркиваем это число из списка как не являющееся простым).
                }
            }
        }
    }

    /*public void printPrimeNumbers() {         //Я не вижу нужды в этом методе у нас есть
                                                //getSimpleNumbers который делает тоже самое.
        System.out.print("Your prime numbers: ");
        System.out.println(simpleNumbers.toString());//(Эту строку я только упростил,
        //в оригинале ты посимвольно выводила ее, а теперь она выведется полностью).
        System.out.println("Quantity primes in your range = " + counterOfSimpleNumbers);
    }*/
}

