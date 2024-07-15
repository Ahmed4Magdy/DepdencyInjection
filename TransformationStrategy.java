import java.util.*;


interface TransformationStrategy {
    String transform(String input);
}

class ReverseTransformation implements TransformationStrategy {
    @Override
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class UppercaseTransformation implements TransformationStrategy {
    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}

class LowercaseTransformation implements TransformationStrategy {
    @Override
    public String transform(String input) {
        return input.toLowerCase();
    }
}

class SortTransformation implements TransformationStrategy {
    @Override
    public String transform(String input) {
        List<Character> charList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            charList.add(c);
        }
        Collections.sort(charList);
        StringBuilder sortedString = new StringBuilder();
        for (char c : charList) {
            sortedString.append(c);
        }
        return sortedString.toString();
    }
}

class CompressionTransformation implements TransformationStrategy {
    @Override
    public String transform(String input) {
        StringBuilder compressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        compressed.append(currentChar).append(count);
        return compressed.toString();
    }
}