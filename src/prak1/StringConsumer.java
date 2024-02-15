package prak1;

import java.util.function.Consumer;

public class StringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        if(s == null || s.length() < 3){
            System.out.println("Строка слишком маленькая");
            return;
        }

        StringBuilder res = new StringBuilder(s);
        for(int i = 2; i < s.length(); i += 3){
            res.setCharAt(i, Character.toUpperCase(s.charAt(i)));
        }

        System.out.println("Новая строка: " + res);
    }
}
