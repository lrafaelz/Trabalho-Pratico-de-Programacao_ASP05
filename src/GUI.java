import java.io.File;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener {


    ImageIcon icon = new ImageIcon("src\\images\\JFrameIcon.png"); // copy the path of image and paste here
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
    JPanel emptyGraphPanel;
    JLabel text1;
    JLabel text2;
    JSpinner amountNodes;
    SpinnerModel minMax1 = new SpinnerNumberModel(0, 0, 100, 1);
    JSpinner amountEdge;
    SpinnerModel minMax2 = new SpinnerNumberModel(0, 0, 200, 1);
    JCheckBox weighedYes;
    JCheckBox weighedNo;
    JCheckBox edgeYes;
    JCheckBox edgeNo;

    


    


    final int frameWidth = 600;
    final int frameHeight = 360;

    GUI(){
        newGraphMenu();
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
        graphManagementTitle = new JLabel();
        graphManagementTitle.setBounds(0, 0, frameWidth, 50);
        graphManagementTitle.setText("Gerar grafo a partir de arquivo");
        graphManagementTitle.setHorizontalAlignment(JLabel.CENTER);
        graphManagementTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        graphManagementTitle.setBackground(new Color(0xBBCCE2));
        graphManagementTitle.setOpaque(true);

        emptyGraphPanel = new JPanel(new GridLayout(2,0,0,5));
        emptyGraphPanel.setBounds(0, 40, frameWidth/2, 200);
        emptyGraphPanel.setBackground(new Color(0xBBCCE2));
        
        text1 = new JLabel();
        text1.setText("<html>Insira o número de elementos:<br><br>Insira o número de arestas:</html>");
        text1.setHorizontalAlignment(JLabel.CENTER);
        text1.setVerticalAlignment(JLabel.CENTER);
        text1.setSize(frameWidth/2, 15);
        text1.setFont(new Font("Tahoma", Font.BOLD, 15));
        text1.setBackground(new Color(0xBBCCE2));
        text1.setOpaque(true);

        text2 = new JLabel();
        text2.setText("<html>O grafo será dirigido?<br><br>O grafo será ponderado?</html>");
        text2.setHorizontalAlignment(JLabel.CENTER);
        text2.setVerticalAlignment(JLabel.CENTER);
        text2.setSize(frameWidth/2, 5);
        text2.setFont(new Font("Tahoma", Font.BOLD, 15));
        text2.setBackground(new Color(0xBBCCE2));
        text2.setOpaque(true);

        emptyGraphPanel.add(text1);
        emptyGraphPanel.add(text2);

        amountNodes = new JSpinner();
        amountNodes.setBounds(frameWidth/2 + frameWidth/8 - 50, 50, 50, 30);
        amountNodes.setModel(minMax1);
        amountNodes.setValue(1);

        amountEdge = new JSpinner();
        amountEdge.setBounds(frameWidth/2 + frameWidth/8 - 50, 95, 50, 30);
        amountEdge.setModel(minMax2);
        amountEdge.setValue(1);

        // weighed check box
        weighedYes = new JCheckBox("Sim");
        weighedYes.setBounds(frameWidth/2 + frameWidth/8 - 50, 155, 50, 30);
        weighedYes.addActionListener(this);
        weighedYes.setBackground(null);
        weighedYes.setFont(new Font("Tahoma", Font.BOLD, 12));

        weighedNo = new JCheckBox("Não", true);
        weighedNo.setBounds(frameWidth/2 + frameWidth/8, 155, 50, 30);
        weighedNo.addActionListener(this);
        weighedNo.setBackground(null);
        weighedNo.setFont(new Font("Tahoma", Font.BOLD, 12));

        // Edge CheckBox
        edgeYes = new JCheckBox("Sim");
        edgeYes.setBounds(frameWidth/2 + frameWidth/8 - 50, 195, 50, 30);
        edgeYes.addActionListener(this);
        edgeYes.setBackground(null);
        edgeYes.setFont(new Font("Tahoma", Font.BOLD, 12));

        edgeNo = new JCheckBox("Não", true);
        edgeNo.setBounds(frameWidth/2 + frameWidth/8, 195, 50, 30);
        edgeNo.addActionListener(this);
        edgeNo.setBackground(null);
        edgeNo.setFont(new Font("Tahoma", Font.BOLD, 12));

        

        
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

        this.setTitle("Inserir arquivo");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(graphManagementTitle);
        this.add(emptyGraphPanel);
        this.add(amountNodes);
        this.add(amountEdge);
        this.add(weighedYes);
        this.add(weighedNo);
        this.add(edgeYes);
        this.add(edgeNo);
        this.add(returnToMainMenu);
        this.add(StartGraph);

        this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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


        if (e.getSource() == weighedYes || e.getSource() == weighedNo) {
			JCheckBox clicked = (JCheckBox) e.getSource();
			if (clicked == weighedYes) {
				if (clicked.isSelected())
					weighedNo.setSelected(false);
				else
                    weighedNo.setSelected(true);
			} else {
				if (clicked.isSelected())
					weighedYes.setSelected(false);
				else
					weighedYes.setSelected(true);
			}
		}
        

        if (e.getSource() == edgeYes || e.getSource() == edgeNo) {
            JCheckBox clicked = (JCheckBox) e.getSource();
            if (clicked == edgeYes) {
                if (clicked.isSelected())
                    edgeNo.setSelected(false);
                else
                    edgeNo.setSelected(true);
            } else {
                if (clicked.isSelected())
                    edgeYes.setSelected(false);
                else
                    edgeYes.setSelected(true);
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
