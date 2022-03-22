import java.awt.event.*;
import java.io.File;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener {


    ImageIcon icon = new ImageIcon("path\\images\\JFrameIcon.png"); // copy the path of image and paste here
    // Main menu frame
    JLabel mainMenuTitle;
    JButton addFileGraph;
    JButton initNewGraph;
    
    // Start graph from file frame
    JLabel insertFileTitle;
    JLabel fileNameLabel;
    JButton addFileButton;
    JButton returnToMainMenu; // shared with empty graph management frame
    JButton StartGraph; // shared with empty graph management frame

    // Start graph from empty graph/empty graph management frame
    JLabel graphManagementTitle;


    final int frameWidth = 600;
    final int frameHeight = 360;

    GUI(){
        fileGraphMenu();
    }

    public void mainMenu(){

        // Title
        mainMenuTitle = new JLabel();
        mainMenuTitle.setBounds(0, 0, frameWidth, 50);
        mainMenuTitle.setText("Graph generator");
        mainMenuTitle.setHorizontalAlignment(JLabel.CENTER);
        mainMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        mainMenuTitle.setBackground(new Color(0xBBCCE2));
        mainMenuTitle.setOpaque(true);

        // Button start from file
        addFileGraph = new JButton();
        addFileGraph.setBounds((frameWidth)/2 - 360/2, 100, 360, 50);
        addFileGraph.addActionListener(this);
        addFileGraph.setText("Iniciar a partir de um arquivo");
        addFileGraph.setFocusable(false); // remove rectangle under text of button
        addFileGraph.setHorizontalTextPosition(JButton.CENTER);
        addFileGraph.setVerticalTextPosition(JButton.BOTTOM);
        addFileGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        addFileGraph.setForeground(Color.WHITE);
        addFileGraph.setBackground(new Color(59, 89, 182));
        addFileGraph.setBorder(BorderFactory.createEtchedBorder());

        // Buton start new graph
        initNewGraph = new JButton("Iniciar novo grafo vazio");
        initNewGraph.setBounds((frameWidth)/2 - 300/2, 200, 300, 50);
        initNewGraph.addActionListener(this);
        initNewGraph.setFocusable(false); // remove rectangle under text of button
        initNewGraph.setHorizontalTextPosition(JButton.CENTER);
        initNewGraph.setVerticalTextPosition(JButton.BOTTOM);
        initNewGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        initNewGraph.setForeground(Color.WHITE);
        initNewGraph.setBackground(new Color(59, 89, 182));
        initNewGraph.setBorder(BorderFactory.createEtchedBorder());

        //JFrame
        this.setTitle("Main menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.add(mainMenuTitle);
        this.add(addFileGraph);
        this.add(initNewGraph);
    }

    public void fileGraphMenu(){

        // Title
        insertFileTitle = new JLabel();
        insertFileTitle.setBounds(0, 0, frameWidth, 50);
        insertFileTitle.setText("Gerar grafo a partir de arquivo");
        insertFileTitle.setHorizontalAlignment(JLabel.CENTER);
        insertFileTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        insertFileTitle.setBackground(new Color(0xBBCCE2));
        insertFileTitle.setOpaque(true);

        // File text
        fileNameLabel = new JLabel();
        fileNameLabel.setBounds(frameWidth/2 - 90,-30,frameWidth/2,frameHeight);
        
        // Button add file
        addFileButton = new JButton("Browse");
        addFileButton.setBounds(frameWidth/2 - 100/2, frameHeight/2 - 90,100,40);
        addFileButton.addActionListener(this);
        addFileButton.setFocusable(false); // remove rectangle under text of button
        addFileButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        addFileButton.setForeground(Color.WHITE);
        addFileButton.setBackground(new Color(59, 89, 182));
        addFileButton.setBorder(BorderFactory.createEtchedBorder());

        // Button return to main manu
        returnToMainMenu = new JButton("Voltar ao menu");
        returnToMainMenu.setBounds(50, 250, 200, 40);
        returnToMainMenu.addActionListener(this);
        returnToMainMenu.setFocusable(false); // remove rectangle under text of button
        returnToMainMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        returnToMainMenu.setForeground(Color.WHITE);
        returnToMainMenu.setBackground(new Color(59, 89, 182));
        returnToMainMenu.setBorder(BorderFactory.createEtchedBorder());
        
        // Button start graph
        StartGraph = new JButton("Iniciar grafo");
        StartGraph.setBounds(390, 250, 150, 40);
        StartGraph.addActionListener(this);
        StartGraph.setFocusable(false); // remove rectangle under text of button
        StartGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        StartGraph.setForeground(Color.WHITE);
        StartGraph.setBackground(new Color(59, 89, 182));
        StartGraph.setBorder(BorderFactory.createEtchedBorder());

        // JFrame
        this.setTitle("Inserir arquivo");
        this.setIconImage(icon.getImage());
        this.add(addFileButton);
        this.add(returnToMainMenu);
        this.add(StartGraph);
        this.add(fileNameLabel);
        this.add(insertFileTitle);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);
        
    }
         
    public void newGraphMenu(){

    }

    public void graphManagement(){

    }

    public void editNode(){

    }

    public void removeNode(){

    }

    public void chooseAlgorithm(){

    }

    public void finalPage(){

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Main menu actions
        if(e.getSource() == addFileGraph){
            System.out.println("addFileGraph");
        }

        if(e.getSource() == initNewGraph){
            System.out.println("initNewGraph");
        }
        
        // Insert file actions
        if(e.getSource() == addFileButton){
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home"))); // Set initial user files
            
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.GTgraph", "gr");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            //if the user click on save in Jfilechooser
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = file.getSelectedFile();
                fileNameLabel.setText("Arquivo: " + selectedFile.getName() + " selecionado");
            }
            //if the user click on save in Jfilechooser
            else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("No File Select");
            }
        }

        if(e.getSource() == returnToMainMenu){
            System.out.println("Return to main menu");
        }

        if(e.getSource() == StartGraph){
            System.out.println("Start graph");
        }
    }
}
