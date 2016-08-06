package com.project.goit.sieveoferatosthenes;

public class Bootstrap {

    public static void main(String[] args) {
        boolean relay = true;

        while (relay) {
            Util.toGreetingUser();
            try {
                String enteredData = ConsoleReader.readString();
                AnswerEnum answerEnum = AnswerEnum.valueOf(enteredData);
                switch (answerEnum) {
                    case YES:
                        PrimeNumbers sieve = new PrimeNumbers();
                        System.out.println(sieve.initLimit());
                        sieve.setLimit(ConsoleReader.readPositiveInteger());
                        Util.toReadOrWrite();
                        String enterData = ConsoleReader.readString();
                        answerEnum = AnswerEnum.valueOf(enterData);
                        relay = false;
                        switch (answerEnum) {
                            case YES:
                                FileEditor file = new FileEditor();
                                System.out.println(file.initName());
                                file.setNameForTextFile(ConsoleReader.readString());
                                file.writeTextFile(sieve.sieveOfEratosthenes());
                                file.readFile();
                                Util.toGoodBye();
                                relay = false;
                                break;
                            case NO:
                                sieve.sieveOfEratosthenes();
                                sieve.printPrimeNumbers();
                                Util.toGoodBye();
                                relay = false;
                                break;
                            case EXIT:
                                Util.toGoodBye();
                                System.exit(1);

                        }
                        break;
                    case EXIT:
                        Util.toGoodBye();
                        System.exit(1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

