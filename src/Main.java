import java.util.HashSet;

import templates.GUI;

public class Main {
    public static void main(String[] args) {
        Sha256 sha256 = new Sha256();
        MalwareDataset malwareDataset = new MalwareDataset();
        GUI display = new GUI();

        display.displayGUI();
        HashSet<String> maliciousHashes = malwareDataset.getMaliciousHashes("data\\data.csv");
        String filePath = "tests\\TestFile.txt";
        String sha256Hash = sha256.getSHA256Hash(filePath);
        System.out.println("SHA-256 Hash of the file: " + sha256Hash);


        boolean isMalicious = maliciousHashes.contains(sha256Hash);
    

        if (isMalicious) {
            System.out.println("The file is detected as malicious.");
        } else {
            System.out.println("The file is not detected as malicious.");
        }
    }
}
