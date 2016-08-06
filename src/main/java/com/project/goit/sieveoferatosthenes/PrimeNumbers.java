package com.project.goit.sieveoferatosthenes;

import java.util.Arrays;

public class PrimeNumbers {
    private int limit;
    private String primeNumbers;

    public void setLimit(int limit) throws NotPrimeNumberException {
        if (limit > 1) this.limit = limit;
        else {
            throw new NotPrimeNumberException("You must entered number greater the 1!!!");
        }
    }

    public String initLimit() {
        return "Please enter positive number that is greater the 1: ";
    }

    public String[] sieveOfEratosthenes() {//Входные параметры(предел до которого
        // нужно найти все простые числа).
        boolean[] sieve = new boolean[limit + 1];//Создаем массив длинное предел+1
        // (дабы внем присутвовали все значения до предела).
        Arrays.fill(sieve, true); //Присваеваем всем ячейкам массива значение true.
        int counter = 0;//Переменная counter для нахождения количества простых чисел.
        StringBuilder simpleNumbersStringBuilder = new StringBuilder();//StringBuilder для создания строки
        // содержащей все найденные простые числа.
        for (int i = 2; i <= limit; i++) { //Цикл от 1-го простого чила(2-а) до предела(вводится пользователем).
            if (sieve[i]) {    //Проверка условия, если i-й элемент массива = true(тоесть если число не
                // вычеркнуто из массива) то тело выполняется.
                counter++; //Увеличиваем значение counter, так как если условие выполнилось то число простое.
                simpleNumbersStringBuilder.append(i).append(" ");//Записываем в строку новое число
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
        primeNumbers = simpleNumbersStringBuilder.toString();
        return new String[]{"Your prime numbers: " + primeNumbers, "Quantity primes in your range = " + counter};//Возвращаем массив стрингов
        // где первый элемент это все простые числа до предела,
        // а второй элемент количество простых чисел в этом пределе.
    }

    public void printPrimeNumbers() {
        System.out.print("Your prime numbers: ");
        for (char number : primeNumbers.toCharArray()
                ) {
            System.out.print(number);
        }
        System.out.println();
        System.out.println("Quantity primes in your range = " + primeNumbers.toCharArray().length);
    }
}

