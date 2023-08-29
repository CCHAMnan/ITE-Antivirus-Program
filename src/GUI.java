import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;

public class GUI extends JFrame {

    public void displayGUI() {
        Sha256 sha256 = new Sha256();
        MalwareDataset malwareDataset = new MalwareDataset();

        HashSet<String> maliciousHashes = malwareDataset.getMaliciousHashes("data\\dataset.csv");



        // create secure icon
        ImageIcon secure = new ImageIcon("src\\templates\\secure.png");
        Image image = secure.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        secure = new ImageIcon(image);



        // create secure button
        JButton buttonSe = new JButton();
        buttonSe.setBounds(10, 30, 80, 85);
        buttonSe.setOpaque(false);
        buttonSe.setContentAreaFilled(false);
        buttonSe.setBorderPainted(false);
        buttonSe.setText("Secure");
        buttonSe.setIcon(secure);
        buttonSe.setHorizontalTextPosition(JButton.CENTER);
        buttonSe.setVerticalTextPosition(JButton.BOTTOM);
        buttonSe.setForeground(Color.white);



        // create scan icon
        ImageIcon scan = new ImageIcon("src\\templates\\scan.png");
        Image image1 = scan.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        scan = new ImageIcon(image1);



        // create scan button
        JButton buttonSc = new JButton();
        buttonSc.setBounds(10, 120, 85, 85);
        buttonSc.setOpaque(false);
        buttonSc.setContentAreaFilled(false);
        buttonSc.setBorderPainted(false);
        buttonSc.setText("Scan");
        buttonSc.setIcon(scan);
        buttonSc.setHorizontalTextPosition(JButton.CENTER);
        buttonSc.setVerticalTextPosition(JButton.BOTTOM);
        buttonSc.setForeground(Color.white);



        // create notification icon
        ImageIcon noti = new ImageIcon("src\\templates\\notification.png");
        Image image2 = noti.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        noti = new ImageIcon(image2);



        // create notification button
        JButton buttonNo = new JButton();
        buttonNo.setBounds(10, 410, 85, 85);
        buttonNo.setOpaque(false);
        buttonNo.setContentAreaFilled(false);
        buttonNo.setBorderPainted(false);
        buttonNo.setText("Notification");
        buttonNo.setIcon(noti);
        buttonNo.setHorizontalTextPosition(JButton.CENTER);
        buttonNo.setVerticalTextPosition(JButton.BOTTOM);
        buttonNo.setForeground(Color.white);



        // create setting icon
        ImageIcon setting = new ImageIcon("src\\templates\\gear.png");
        Image image3 = setting.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        setting = new ImageIcon(image3);




        // create setting button
        JButton buttonSet = new JButton();
        buttonSet.setBounds(10, 500, 85, 85);
        buttonSet.setOpaque(false);
        buttonSet.setContentAreaFilled(false);
        buttonSet.setBorderPainted(false);
        buttonSet.setText("Setting");
        buttonSet.setIcon(setting);
        buttonSet.setHorizontalTextPosition(JButton.CENTER);
        buttonSet.setVerticalTextPosition(JButton.BOTTOM);
        buttonSet.setForeground(Color.white);




        // create line label
        Icon line1 = new ImageIcon("src\\templates\\line.png");
        JLabel line = new JLabel();
        line.setBounds(10, 400, 80, 2);
        line.setIcon(line1);



        // create panel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.black);
        panel1.setBounds(0, 0, 100, 650);
        panel1.setLayout(null);
        panel1.add(buttonSe);
        panel1.add(buttonSc);
        panel1.add(buttonNo);
        panel1.add(buttonSet);
        panel1.add(line);



        // create Antivirus icon
        ImageIcon antivi = new ImageIcon("src\\templates\\antivirus.png");
        Image image4 = antivi.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        antivi = new ImageIcon(image4);




        // Add button to select files
        JButton selectFileButton = new JButton();
        selectFileButton.setBounds(280, 200, 200, 200);
        selectFileButton.setOpaque(false);
        selectFileButton.setContentAreaFilled(false);
        selectFileButton.setBorderPainted(false);
        selectFileButton.setText("Scanning");
        selectFileButton.setIcon(antivi);
        selectFileButton.setHorizontalTextPosition(JButton.CENTER);
        selectFileButton.setVerticalTextPosition(JButton.BOTTOM);
        selectFileButton.setForeground(Color.white);




        // create panel 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(36, 36, 36));
        panel2.setBounds(100, 0, 850, 650);
        panel2.setLayout(null);
        panel2.add(selectFileButton);

        






        // Add an ActionListener to the selectFileButton
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String selectedFilePath = selectedFile.getAbsolutePath();

                    String sha256Hash = sha256.getSHA256Hash(selectedFilePath);
                    System.out.println("SHA-256 Hash of the file: " + sha256Hash);
                    boolean isMalicious = maliciousHashes.contains(sha256Hash);

                    if (isMalicious) {
                        System.out.println("The file is detected as malicious.");
                    } else {
                        System.out.println("The file is not detected as malicious.");
                    }
                }
            }
        });







        // create main layout
        ImageIcon logo = new ImageIcon("src\\templates\\antivirus.png");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(950, 650);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Khmer Antivirus Development");
        frame.setIconImage(logo.getImage());
        frame.add(panel1);
        frame.add(panel2);
    }
}
