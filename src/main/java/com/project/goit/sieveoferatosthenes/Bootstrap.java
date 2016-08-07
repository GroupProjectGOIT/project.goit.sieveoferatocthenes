package com.project.goit.sieveoferatosthenes;

public class Bootstrap {

    public static void main(String[] args) {
        boolean relay = true;

        while (relay) {
            Util.toGreetingUser();
            try {
                AnswerEnum answerEnum = AnswerEnum.valueOf(ConsoleReader.readString());
                switch (answerEnum) {
                    case YES:
                        PrimeNumbers sieve = new PrimeNumbers();
                        System.out.println(sieve);
                        sieve.sieveOfEratosthenes(ConsoleReader.readPositiveInteger());
                        Util.toReadOrWrite();
                        answerEnum = AnswerEnum.valueOf(ConsoleReader.readString());
                        relay = false;
                        switch (answerEnum) {
                            case YES:
                                FileEditor file = new FileEditor();
                                System.out.println(file);
                                file.setNameForTextFile(ConsoleReader.readString());
                                file.writeTextFile(sieve.getSimpleNumbers());
                                file.readFile();
                                Util.toGoodBye();
                                relay = false;
                                break;
                            case NO:
                                Util.toOutputPrimeNumbers(sieve);
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


