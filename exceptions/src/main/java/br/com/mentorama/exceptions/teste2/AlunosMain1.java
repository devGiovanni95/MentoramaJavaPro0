package br.com.mentorama.exceptions.teste2;

public class AlunosMain1 {
    public static void main(String[] args) {
////        String stringX = args[3];//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 0
//        String stringY = null; //java.lang.NullPointerException: Cannot invoke "String.contains(java.lang.CharSequence)" because "stringY" is null at br.com.mentorama.exceptions.AlunosMain1.main(AlunosMain1.java:9)
//
////        System.out.println(stringX.contains("x"));
//        System.out.println(stringY.contains("x"));

        //jeitos de tratar excessoes
        if (args.length > 0 ){
            String stringX = args[0];
            System.out.println(stringX.contains("x"));
        }else {
            System.out.println("Não tem nada");
        }

    }

}
