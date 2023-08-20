import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    public String getSHA256Hash(String filePath) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, digest);
            
            // Read the file in chunks to compute the hash
            byte[] buffer = new byte[8192];
            while (digestInputStream.read(buffer) != -1) {
                // Read the file chunk by chunk
            }
            
            digestInputStream.close();
            
            byte[] hashBytes = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
