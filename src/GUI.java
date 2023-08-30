import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.ArrayList;

public class GUI extends JFrame {
    private int malwareFileCount = 0;

    private Sha256 sha256 = new Sha256();
    private MalwareDataset malwareDataset = new MalwareDataset();

    // Read data
    private HashSet<String> maliciousHashes = malwareDataset.getMaliciousHashes("data\\dataset.csv");

    //Display GUI
    public void displayGUI() {
        

// -----------------------------------------Icons-------------------------------------------------------------------

        // create secure icon
        ImageIcon secure = new ImageIcon("src\\templates\\secure.png");
        Image image = secure.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        secure = new ImageIcon(image);

        // create scan icon
        ImageIcon scan = new ImageIcon("src\\templates\\scan.png");
        Image image1 = scan.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        scan = new ImageIcon(image1);

        // create notification icon
        ImageIcon noti = new ImageIcon("src\\templates\\notification.png");
        Image image2 = noti.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        noti = new ImageIcon(image2);

        // create setting icon
        ImageIcon setting = new ImageIcon("src\\templates\\gear.png");
        Image image3 = setting.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        setting = new ImageIcon(image3);

        // create line label
        Icon line1 = new ImageIcon("src\\templates\\line.png");
        

        // create search icon
        ImageIcon searchIcon = new ImageIcon("src\\templates\\search.png");
        Image image4 = searchIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(image4);

        // create clickScan icon
        ImageIcon click = new ImageIcon("src\\templates\\click.png");
        Image image5 = click.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        click = new ImageIcon(image5);
        
        // create scanfile icon
        ImageIcon filescan = new ImageIcon("src\\templates\\scanfile.png");
        Image image6 = filescan.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        filescan = new ImageIcon(image6);

        //create drive icon
        ImageIcon drive = new ImageIcon("src\\templates\\antivirus.png");
        Image image7 = drive.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        drive = new ImageIcon(image7);

        // create file scan icon
        ImageIcon filescanicon = new ImageIcon("src\\templates\\files.png");
        Image image8 = filescanicon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        filescanicon = new ImageIcon(image8);

        // create drive scan icon
        ImageIcon drivescanicon = new ImageIcon("src\\templates\\drive.png");
        Image image9 = drivescanicon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        drivescanicon = new ImageIcon(image9);   




// -----------------------------------------Labels-------------------------------------------------------------------

        // Line label
        JLabel line = new JLabel();
        line.setBounds(10, 400, 80, 2);
        line.setIcon(line1);


        // create scanNow Label
        JLabel search = new JLabel();
        search.setIcon(searchIcon);
        search.setBounds(367, 180, 200, 200);

        // create file scan label
        JLabel filescan2 = new JLabel();
        filescan2.setBounds(160, 250, 100, 100);
        filescan2.setIcon(filescan);

        // create file scan label
        JLabel drivescan = new JLabel();
        drivescan.setBounds(580, 250, 100, 100);
        drivescan.setIcon(drive);




// -----------------------------------------Buttons-------------------------------------------------------------------

        // create secure button
        JButton buttonSe = new JButton();
        buttonSe.setBounds(10, 30, 80, 85);
        buttonSe.setOpaque(false);
        buttonSe.setContentAreaFilled(false);
        buttonSe.setBorderPainted(false);
        buttonSe.setText("Status");
        buttonSe.setIcon(secure);
        buttonSe.setHorizontalTextPosition(JButton.CENTER);
        buttonSe.setVerticalTextPosition(JButton.BOTTOM);
        buttonSe.setForeground(Color.white);


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

        

        // create Click scan button
        JButton buttonClickScan = new JButton();
        buttonClickScan.setBounds(280, 270, 250, 200);
        buttonClickScan.setOpaque(false);
        buttonClickScan.setContentAreaFilled(false);
        buttonClickScan.setBorderPainted(false);
        buttonClickScan.setIcon(click);
        buttonClickScan.setHorizontalTextPosition(JButton.CENTER);
        buttonClickScan.setVerticalTextPosition(JButton.BOTTOM);
        buttonClickScan.setForeground(Color.white);


        // create file scan button
        JButton filescanbut = new JButton();
        filescanbut.setBounds(123, 360, 170, 70);
        filescanbut.setOpaque(false);
        filescanbut.setContentAreaFilled(false);
        filescanbut.setBorderPainted(false);
        filescanbut.setIcon(filescanicon);
        filescanbut.setHorizontalTextPosition(JButton.CENTER);
        filescanbut.setVerticalTextPosition(JButton.BOTTOM);
        filescanbut.setForeground(Color.white);


        // create drive scan button
        JButton drivescanbut = new JButton();
        drivescanbut.setBounds(543, 360, 170, 70);
        drivescanbut.setOpaque(false);
        drivescanbut.setContentAreaFilled(false);
        drivescanbut.setBorderPainted(false);
        drivescanbut.setIcon(drivescanicon);
        drivescanbut.setHorizontalTextPosition(JButton.CENTER);
        drivescanbut.setVerticalTextPosition(JButton.BOTTOM);
        drivescanbut.setForeground(Color.white);


// -----------------------------------------PANELS-------------------------------------------------------------------

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


        // create panel 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(36, 36, 36));
        panel2.setBounds(100, 0, 850, 650);
        panel2.setLayout(null);
        panel2.add(search);
        panel2.add(buttonClickScan);


// -----------------------------------------Functions-------------------------------------------------------------------

        //Go to Status Menu
        buttonSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.revalidate();
                panel2.repaint();
                panel2.add(search);
                panel2.add(buttonClickScan);
            }
        });

        //Go to Scan Menu
        buttonClickScan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.revalidate();
                panel2.repaint();
                panel2.add(filescan2);
                panel2.add(drivescan);
                panel2.add(drivescanbut);
                panel2.add(filescanbut);
            }
        });

        //Go to Scan Menu
        buttonSc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.revalidate();
                panel2.repaint();
                panel2.add(filescan2);
                panel2.add(drivescan);
                panel2.add(drivescanbut);
                panel2.add(filescanbut);
            }
        });
            

        //Select file to scan
        filescanbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                
                // Show "Desktop" path as the initial directory
                File thisPC = FileSystemView.getFileSystemView().getHomeDirectory();
                fileChooser.setCurrentDirectory(thisPC);

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


        drivescanbut.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            // Show the root directory of a known drive
            File rootDrive = new File("C:\\");
            fileChooser.setCurrentDirectory(rootDrive);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                ArrayList<String> malwareFilePaths = new ArrayList<>();
                scanDrive(selectedDirectory, malwareFilePaths);

                if (malwareFileCount > 0) {
                    System.out.println(malwareFileCount + " Malicious files detected!");
                    for (String path : malwareFilePaths) {
                        System.out.println(path);
                    }
                } else {
                    System.out.println("Files is clean!");
                }
            }
        }
    });




// -----------------------------------------Frame-------------------------------------------------------------------


        // create main layout
        ImageIcon logo = new ImageIcon("src\\templates\\searchIconrus.png");
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


//-------------------------------------------Methods------------------------------------------------------------------

    // scan directory
    private void scanDrive(File directory, ArrayList<String> malwareFilePaths) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String filePath = file.getAbsolutePath();
                        String sha256Hash = sha256.getSHA256Hash(filePath);
                        System.out.println("Scanning file: " + filePath);
                        
                        boolean isMalicious = maliciousHashes.contains(sha256Hash);
    
                        if (isMalicious) {
                            System.out.println("Malicious file detected: " + filePath);
                            malwareFilePaths.add(filePath);
                            malwareFileCount++;
                        }

                    } else if (file.isDirectory()) {
                        scanDrive(file, malwareFilePaths); // Recursive call for subdirectories
                    }
                }
            }
        }
        
    }


}
