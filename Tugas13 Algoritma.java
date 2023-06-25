import java.util.Arrays;
import java.util.Scanner;

class Kamus {
    private final String[] words;
    private final String[] translations;

    public Kamus(String[] words, String[] translations) {
        this.words = words;
        this.translations = translations;
        Arrays.sort(this.words); // Mengurutkan kata-kata dalam array
    }
//by Ahmad Ibrahim
    public String translate(String word) {
        int index = binarySearch(word);
        if (index != -1) {
            return translations[index];
        }
        return "Kata tidak ditemukan";
    }

    private int binarySearch(String word) {
        int low = 0;
        int high = words.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = word.compareToIgnoreCase(words[mid]);

            if (result == 0) {
                return mid; // Kata ditemukan
            } else if (result < 0) {
                high = mid - 1; // Cari di setengah kiri
            } else {
                low = mid + 1; // Cari di setengah kanan
            }
        }

        return -1; // Kata tidak ditemukan
    }
}

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "durian", "grape", "melon", "orange", "pear"};
        String[] translations = {"apel", "pisang", "ceri", "durian", "anggur", "melon", "jeruk", "pir"};
        Kamus kamus = new Kamus(words, translations);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan kata: ");
            String word = scanner.nextLine();
            
            String translation = kamus.translate(word);
            System.out.println("Terjemahan: " + translation);
        }
    }
}
