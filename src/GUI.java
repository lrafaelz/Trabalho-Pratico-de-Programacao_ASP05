import java.io.File;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener {

    // Frame icon
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
    JLabel emptyGraphTitle;
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

    // Graph management frame
    JLabel graphManagementTitle;
    JButton editExistentNode;
    JButton removeExistentNode;
    JButton undoGraph;
    JButton finishEdits;

    // Edit node frame
    JLabel editNodeTitle;
    JPanel editNodePanel;
    JLabel selectNode;
    JLabel selectEdge;
    JLabel weightEdges;
    JComboBox<Integer> nodeComboBox; // shared with remove node frame
    String[] nodeList = {};
    JTextField edgesTextField;
    JTextField weightEdgesTextField;
    JButton undoNodeEdits;
    JButton saveNodeEdits;

    // Remove node frame
    JLabel removeNodeTitle;
    JLabel removeText;
    JButton undoRemoveEdits;
    JButton saveRemoveEdits;
    
    // Choose a algorithm frame
    JLabel algorithmChooserTitle;
    JButton DFSButton;
    JButton BFSButton;
    JButton TopologicalSortingButton;
    JButton minimumSpanningTree;
    JButton shortestPath;

    // Last frame
    JLabel finishedGraph;
    JButton animationButton;
    JButton finalUndoGraph;
    JButton finalSaveGraph;

    // Frame size
    final int frameWidth = 600;
    final int frameHeight = 360;

    // Graph attributes
    boolean isFile;
    File selectedFile = null;
    boolean isWeighted;
    boolean isDirected;


    // iniciate graph
    Graph graph;

    GUI(){
        mainMenu();
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);
    }
         
    public void newGraphMenu(){
        emptyGraphTitle = new JLabel();
        emptyGraphTitle.setBounds(0, 0, frameWidth, 50);
        emptyGraphTitle.setText("Configurar grafo vazio");
        emptyGraphTitle.setHorizontalAlignment(JLabel.CENTER);
        emptyGraphTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        emptyGraphTitle.setBackground(new Color(0xBBCCE2));
        emptyGraphTitle.setOpaque(true);

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
        amountNodes.setValue(0);

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

        this.setTitle("Configurações - novo grafo");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setLocationRelativeTo(null);
        this.add(emptyGraphTitle);
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void graphManagement(){
        graphManagementTitle = new JLabel();
        graphManagementTitle.setBounds(0, 0, frameWidth, 50);
        graphManagementTitle.setText("Selecione a opção desejada");
        graphManagementTitle.setHorizontalAlignment(JLabel.CENTER);
        graphManagementTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        graphManagementTitle.setBackground(new Color(0xBBCCE2));
        graphManagementTitle.setOpaque(true);

        editExistentNode = new JButton("Editar nodo existente");
        editExistentNode.setBounds(frameWidth/4 - 250/2, 80, 250, 40);
        editExistentNode.addActionListener(this);
        editExistentNode.setFocusable(false); // remove rectangle under text of button
        editExistentNode.setFont(new Font("Tahoma", Font.BOLD, 20));
        editExistentNode.setForeground(Color.WHITE);
        editExistentNode.setBackground(new Color(59, 89, 182));
        editExistentNode.setBorder(BorderFactory.createEtchedBorder());

        removeExistentNode = new JButton("Remover nodo");
        removeExistentNode.setBounds(3*frameWidth/4 - 180/2, 80, 180, 40);
        removeExistentNode.addActionListener(this);
        removeExistentNode.setFocusable(false); // remove rectangle under text of button
        removeExistentNode.setFont(new Font("Tahoma", Font.BOLD, 20));
        removeExistentNode.setForeground(Color.WHITE);
        removeExistentNode.setBackground(new Color(59, 89, 182));
        removeExistentNode.setBorder(BorderFactory.createEtchedBorder());
        
        
        // Button undo current graph
        undoGraph = new JButton("Desfazer grafo");
        undoGraph.setBounds(50, 250, 170, 40);
        undoGraph.addActionListener(this);
        undoGraph.setFocusable(false); // remove rectangle under text of button
        undoGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        undoGraph.setForeground(Color.WHITE);
        undoGraph.setBackground(new Color(59, 89, 182));
        undoGraph.setBorder(BorderFactory.createEtchedBorder());
        
        // Button start graph
        finishEdits = new JButton("Finalizar grafo");
        finishEdits.setBounds(370, 250, 170, 40);
        finishEdits.addActionListener(this);
        finishEdits.setFocusable(false); // remove rectangle under text of button
        finishEdits.setFont(new Font("Tahoma", Font.BOLD, 20));
        finishEdits.setForeground(Color.WHITE);
        finishEdits.setBackground(new Color(59, 89, 182));
        finishEdits.setBorder(BorderFactory.createEtchedBorder());
        

        this.setTitle("Gestão do grafo");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(graphManagementTitle);
        this.add(editExistentNode);
        this.add(removeExistentNode);
        this.add(undoGraph);
        this.add(finishEdits);
        this.setVisible(true);
    }

    public void editNode(boolean isWeight){

        editNodeTitle = new JLabel();
        editNodeTitle.setBounds(0, 0, frameWidth, 50);
        editNodeTitle.setText("Editar nodo");
        editNodeTitle.setHorizontalAlignment(JLabel.CENTER);
        editNodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        editNodeTitle.setBackground(new Color(0xBBCCE2));
        editNodeTitle.setOpaque(true);

        editNodePanel = new JPanel(new GridLayout(2,0,0,5));
        editNodePanel.setBounds(0, 40, frameWidth/2, 200);
        editNodePanel.setBackground(new Color(0xBBCCE2));

        selectNode = new JLabel();
        selectNode.setText("<html>Escolha o elemento a ser editado<br><br>&emsp;&emsp;&ensp;Partindo conexão para:</html>");
        selectNode.setHorizontalAlignment(JLabel.CENTER);
        selectNode.setVerticalAlignment(JLabel.CENTER);
        selectNode.setSize(frameWidth/2, 15);
        selectNode.setFont(new Font("Tahoma", Font.BOLD, 15));
        selectNode.setBackground(new Color(0xBBCCE2));
        selectNode.setOpaque(true);

        weightEdges = new JLabel();
        weightEdges.setText("<html>Defina o peso respectivo de cada conexão:</html>");

        weightEdges.setHorizontalAlignment(JLabel.CENTER);
        weightEdges.setVerticalAlignment(JLabel.CENTER);
        weightEdges.setBounds(40, 165, 220, 50);
        weightEdges.setFont(new Font("Tahoma", Font.BOLD, 15));
        weightEdges.setBackground(new Color(0xBBCCE2));
        weightEdges.setOpaque(true);

        editNodePanel.add(selectNode);

        // 
        nodeComboBox = new JComboBox<Integer>();
        // nodeComboBox.setSelectedIndex(0);
        nodeComboBox.setBounds(frameWidth/2 + frameWidth/8 - 50, 55, 100, 30);

        edgesTextField = new JTextField();
        edgesTextField.setBounds(frameWidth/2 + frameWidth/8 - 50, 95, 200, 30);
        edgesTextField.setFont(new Font("Comic Sans", Font.BOLD, 25));

        weightEdgesTextField = new JTextField();
        weightEdgesTextField.setBounds(frameWidth/2 + frameWidth/8 - 50, 175, 200, 30);
        weightEdgesTextField.setFont(new Font("Comic Sans", Font.BOLD, 25));

        // Button return to graph management
        undoNodeEdits = new JButton("Desfazer edições");
        undoNodeEdits.setBounds(50, 250, 200, 40);
        undoNodeEdits.addActionListener(this);
        undoNodeEdits.setFocusable(false); // remove rectangle under text of button
        undoNodeEdits.setFont(new Font("Tahoma", Font.BOLD, 20));
        undoNodeEdits.setForeground(Color.WHITE);
        undoNodeEdits.setBackground(new Color(59, 89, 182));
        undoNodeEdits.setBorder(BorderFactory.createEtchedBorder());
        
        // Button save graph edits
        saveNodeEdits = new JButton("Salvar edições");
        saveNodeEdits.setBounds(370, 250, 170, 40);
        saveNodeEdits.addActionListener(this);
        saveNodeEdits.setFocusable(false); // remove rectangle under text of button
        saveNodeEdits.setFont(new Font("Tahoma", Font.BOLD, 20));
        saveNodeEdits.setForeground(Color.WHITE);
        saveNodeEdits.setBackground(new Color(59, 89, 182));
        saveNodeEdits.setBorder(BorderFactory.createEtchedBorder());
       

        this.setTitle("Gestão do grafo");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setLocationRelativeTo(null);
        this.add(editNodeTitle);
        this.add(editNodePanel);
        this.add(undoNodeEdits);
        this.add(saveNodeEdits);
        this.add(nodeComboBox);
        this.add(edgesTextField);
        if(isWeighted){
            this.add(weightEdges);
            this.add(weightEdgesTextField);
        }
        this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void removeNode(){
        removeNodeTitle = new JLabel();
        removeNodeTitle.setBounds(0, 0, frameWidth, 50);
        removeNodeTitle.setText("Remover nodo");
        removeNodeTitle.setHorizontalAlignment(JLabel.CENTER);
        removeNodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        removeNodeTitle.setBackground(new Color(0xBBCCE2));
        removeNodeTitle.setOpaque(true);

        removeText = new JLabel();
        removeText.setText("Escolha o elemento a ser removido");
        removeText.setBounds(0, 85, frameWidth/2, 200);
        removeText.setHorizontalAlignment(JLabel.CENTER);
        removeText.setVerticalAlignment(JLabel.CENTER);
        removeText.setSize(frameWidth/2, 15);
        removeText.setFont(new Font("Tahoma", Font.BOLD, 15));
        removeText.setBackground(new Color(0xBBCCE2));
        removeText.setOpaque(true);

        // 
        nodeComboBox = new JComboBox<Integer>();
        // nodeComboBox.setSelectedIndex(0);
        nodeComboBox.setBounds(frameWidth/2 + frameWidth/8 - 50, 80, 100, 30);
        // nodeComboBox.setSelectedIndex(0);
        
        // Button return to graph management
        undoRemoveEdits = new JButton("Desfazer edições");
        undoRemoveEdits.setBounds(50, 250, 200, 40);
        undoRemoveEdits.addActionListener(this);
        undoRemoveEdits.setFocusable(false); // remove rectangle under text of button
        undoRemoveEdits.setFont(new Font("Tahoma", Font.BOLD, 20));
        undoRemoveEdits.setForeground(Color.WHITE);
        undoRemoveEdits.setBackground(new Color(59, 89, 182));
        undoRemoveEdits.setBorder(BorderFactory.createEtchedBorder());
        
        // Button save graph edits
        saveRemoveEdits = new JButton("Salvar edições");
        saveRemoveEdits.setBounds(370, 250, 170, 40);
        saveRemoveEdits.addActionListener(this);
        saveRemoveEdits.setFocusable(false); // remove rectangle under text of button
        saveRemoveEdits.setFont(new Font("Tahoma", Font.BOLD, 20));
        saveRemoveEdits.setForeground(Color.WHITE);
        saveRemoveEdits.setBackground(new Color(59, 89, 182));
        saveRemoveEdits.setBorder(BorderFactory.createEtchedBorder());
       

        this.setTitle("Remover nodo");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setLocationRelativeTo(null);
        this.add(removeNodeTitle);
        this.add(removeText);
        this.add(nodeComboBox);
        this.add(undoRemoveEdits);
        this.add(saveRemoveEdits);
        this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void chooseAlgorithm(){
        algorithmChooserTitle = new JLabel();
        algorithmChooserTitle.setBounds(0, 0, frameWidth, 50);
        algorithmChooserTitle.setText("Escolha o algoritmo para percorrer o grafo");
        algorithmChooserTitle.setHorizontalAlignment(JLabel.CENTER);
        algorithmChooserTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        algorithmChooserTitle.setBackground(new Color(0xBBCCE2));
        algorithmChooserTitle.setOpaque(true);

        DFSButton = new JButton("Depth-First-Search");
        DFSButton.setBounds(frameWidth/4 - 250/2, 70, 250, 40);
        DFSButton.addActionListener(this);
        DFSButton.setFocusable(false); // remove rectangle under text of button
        DFSButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        DFSButton.setForeground(Color.WHITE);
        DFSButton.setBackground(new Color(59, 89, 182));
        DFSButton.setBorder(BorderFactory.createEtchedBorder());

        BFSButton = new JButton("Breadth-First-Search");
        BFSButton.setBounds(3*frameWidth/4 - 240/2, 70, 240, 40);
        BFSButton.addActionListener(this);
        BFSButton.setFocusable(false); // remove rectangle under text of button
        BFSButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        BFSButton.setForeground(Color.WHITE);
        BFSButton.setBackground(new Color(59, 89, 182));
        BFSButton.setBorder(BorderFactory.createEtchedBorder());

        TopologicalSortingButton = new JButton("Topological Sorting");
        TopologicalSortingButton.setBounds(frameWidth/4 - 250/2, 130, 250, 40);
        TopologicalSortingButton.addActionListener(this);
        TopologicalSortingButton.setFocusable(false); // remove rectangle under text of button
        TopologicalSortingButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        TopologicalSortingButton.setForeground(Color.WHITE);
        TopologicalSortingButton.setBackground(new Color(59, 89, 182));
        TopologicalSortingButton.setBorder(BorderFactory.createEtchedBorder());

        minimumSpanningTree = new JButton("Minimum Spanning Tree");
        minimumSpanningTree.setBounds(3*frameWidth/4 - 260/2, 130, 260, 40);
        minimumSpanningTree.addActionListener(this);
        minimumSpanningTree.setFocusable(false); // remove rectangle under text of button
        minimumSpanningTree.setFont(new Font("Tahoma", Font.BOLD, 20));
        minimumSpanningTree.setForeground(Color.WHITE);
        minimumSpanningTree.setBackground(new Color(59, 89, 182));
        minimumSpanningTree.setBorder(BorderFactory.createEtchedBorder());

        shortestPath = new JButton("Shortest path");
        shortestPath.setBounds(frameWidth/2 - 180/2, 190, 180, 40);
        shortestPath.addActionListener(this);
        shortestPath.setFocusable(false); // remove rectangle under text of button
        shortestPath.setFont(new Font("Tahoma", Font.BOLD, 20));
        shortestPath.setForeground(Color.WHITE);
        shortestPath.setBackground(new Color(59, 89, 182));
        shortestPath.setBorder(BorderFactory.createEtchedBorder());

        this.setTitle("Select algorithm");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setLocationRelativeTo(null);
        this.add(algorithmChooserTitle);
        this.add(DFSButton);
        this.add(BFSButton);
        this.add(TopologicalSortingButton);
        this.add(minimumSpanningTree);
        this.add(shortestPath);
        this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void finalPage(){
        algorithmChooserTitle = new JLabel();
        algorithmChooserTitle.setBounds(0, 0, frameWidth, 50);
        algorithmChooserTitle.setText("Algorithm chosen");
        algorithmChooserTitle.setHorizontalAlignment(JLabel.CENTER);
        algorithmChooserTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        algorithmChooserTitle.setBackground(new Color(0xBBCCE2));
        algorithmChooserTitle.setOpaque(true);

        

        animationButton = new JButton("Representação");
        animationButton.setBounds(frameWidth/2 - 180/2, 70, 180, 40);
        animationButton.addActionListener(this);
        animationButton.setFocusable(false); // remove rectangle under text of button
        animationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        animationButton.setForeground(Color.WHITE);
        animationButton.setBackground(new Color(59, 89, 182));
        animationButton.setBorder(BorderFactory.createEtchedBorder());

        // Button undo current graph
        finalUndoGraph = new JButton("Desfazer grafo");
        finalUndoGraph.setBounds(50, 250, 170, 40);
        finalUndoGraph.addActionListener(this);
        finalUndoGraph.setFocusable(false); // remove rectangle under text of button
        finalUndoGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        finalUndoGraph.setForeground(Color.WHITE);
        finalUndoGraph.setBackground(new Color(59, 89, 182));
        finalUndoGraph.setBorder(BorderFactory.createEtchedBorder());

        // Button start graph
        finalSaveGraph = new JButton("Finalizar grafo");
        finalSaveGraph.setBounds(370, 250, 170, 40);
        finalSaveGraph.addActionListener(this);
        finalSaveGraph.setFocusable(false); // remove rectangle under text of button
        finalSaveGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        finalSaveGraph.setForeground(Color.WHITE);
        finalSaveGraph.setBackground(new Color(59, 89, 182));
        finalSaveGraph.setBorder(BorderFactory.createEtchedBorder());

        this.setTitle("Select algorithm");
        this.setSize(frameWidth, frameHeight);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0xBBCCE2));
        this.setLocationRelativeTo(null);
        this.add(algorithmChooserTitle);
        this.add(animationButton);
        this.add(finalUndoGraph);
        this.add(finalSaveGraph);
        this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        // Main menu actions ////////////////////
        if(e.getSource() == addFileGraph){ // Start by file button
            System.out.println("Add file graph");
            this.remove(mainMenuTitle);
            this.remove(addFileGraph);
            this.remove(initNewGraph);
            this.dispose();
            isFile = true;
            fileGraphMenu();
        }

        if(e.getSource() == initNewGraph){ // Start new graph button
            System.out.println("Start new graph");
            this.remove(mainMenuTitle);
            this.remove(addFileGraph);
            this.remove(initNewGraph);
            this.dispose();
            isFile = false;
            newGraphMenu();
        }
        //////////////////////////////////////////

        // Insert file actions ///////////////////
        if(e.getSource() == addFileButton){ // Browse button
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home"))); // Set initial user files
            
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.GTgraph", "gr");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            //if the user click on save in Jfilechooser
            if(result == JFileChooser.APPROVE_OPTION){
                this.selectedFile = file.getSelectedFile();
                fileNameLabel.setText("Arquivo: " + this.selectedFile.getName() + " selecionado");
            }
            //if the user click on save in Jfilechooser
            else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("No File Select");
            }
        }
        /////////////////////////////////////////////////

        // Start from empty graph ///////////////////////
        // check box directed graph
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

        // check box weighed graph
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

        // Return to menu button - shared with Start from file frame
        if(e.getSource() == returnToMainMenu){
            System.out.println("Return to main menu Button");
            if(isFile){ // Insert file
                
                this.remove(addFileButton);
                this.remove(fileNameLabel);
                this.remove(insertFileTitle);
            }
            else{ // Start new graph
                this.remove(emptyGraphTitle);
                this.remove(emptyGraphPanel);
                this.remove(amountNodes);
                this.remove(amountEdge);
                this.remove(weighedYes);
                this.remove(weighedNo);
                this.remove(edgeYes);
                this.remove(edgeNo);
            }
            this.remove(returnToMainMenu);
            this.remove(StartGraph);
            this.dispose();
            mainMenu();
        }

        // Start graph button - shared with Start from file frame
        if(e.getSource() == StartGraph){

            System.out.println("Start graph Button");
            if(isFile){ // Insert file
                if(this.selectedFile != null){
                    graph = new Graph(0, true, true, true, selectedFile);
                    this.remove(addFileButton);
                    this.remove(fileNameLabel);
                    this.remove(insertFileTitle);
                    this.remove(returnToMainMenu);
                    this.remove(StartGraph);
                    this.dispose();

                    chooseAlgorithm();
                //     ArrayList<String> splitSelectFile = new ArrayList<String>(Arrays.asList(this.selectedFile.getName().split("."))); 
                //     System.out.println(splitSelectFile.get(1));
                //     if (splitSelectFile.get(1) == "gr")                        
                //         graphManagement();
                //     else
                //         System.out.println("selected file does not match gr type");
                } else
                    System.out.println("No file selected");                
            } 
            else{
                if((int)amountNodes.getValue() > 0){
                    int numNodes = (int)amountNodes.getValue();
                    int numEdge = (int)amountEdge.getValue();
                    this.isWeighted = !weighedYes.isSelected();
                    this.isDirected = !edgeYes.isSelected();
                    System.out.println("Is directed: "+ isDirected);
                    System.out.println("Is weighed: "+ isDirected);
        
                    // Call graph class
                    graph = new Graph(numNodes, this.isDirected, this.isWeighted, false, null);
                    graph.fillGraph(numNodes);
                    graph.randomEdge(numEdge, numNodes);
                    graph.print();
                    // System.out.println(s);

                    // close the current frame to open the next
                        this.remove(emptyGraphTitle);
                        this.remove(emptyGraphPanel);
                        this.remove(amountNodes);
                        this.remove(amountEdge);
                        this.remove(weighedYes);
                        this.remove(weighedNo);
                        this.remove(edgeYes);
                        this.remove(edgeNo);
                        this.remove(returnToMainMenu);
                        this.remove(StartGraph);
                        this.dispose();
                        
                        chooseAlgorithm();
                    } else if((int)amountNodes.getValue() == 0)
                    System.out.println("zero cannot be the number of vertices");
            }
        }
        //////////////////////////////////////////
        
        // Graph maganement ////////////////////// Removed ;-;
        // Edit existent node button
        if(e.getSource() == editExistentNode){
            System.out.println("Edit existent node");
            this.remove(graphManagementTitle);
            this.remove(editExistentNode);
            this.remove(removeExistentNode);
            this.remove(undoGraph);
            this.remove(finishEdits);
            this.dispose();
            editNode(this.isWeighted);
        }

        // Remove existent node button
        if(e.getSource() == removeExistentNode){
            System.out.println("Remove Existent Node");
            this.remove(graphManagementTitle);
            this.remove(editExistentNode);
            this.remove(removeExistentNode);
            this.remove(undoGraph);
            this.remove(finishEdits);
            this.dispose();
            removeNode();
        }

        // Undo graph button
        if(e.getSource() == undoGraph){
            System.out.println("Undo graph");

            // add frame to confirm choice
             
            this.remove(graphManagementTitle);
            this.remove(editExistentNode);
            this.remove(removeExistentNode);
            this.remove(undoGraph);
            this.remove(finishEdits);
            this.dispose();
        }

        if(e.getSource() == finishEdits){
            System.out.println("Finish edits in graph");
            this.remove(graphManagementTitle);
            this.remove(editExistentNode);
            this.remove(removeExistentNode);
            this.remove(undoGraph);
            this.remove(finishEdits);
            this.dispose();

            chooseAlgorithm();
        }
        //////////////////////////////////////////


        // Edit existent node frame ////////////// Removed
        // Undo node edits button
        if(e.getSource() == undoNodeEdits){
            System.out.println("Undo node edits");
            this.remove(editNodeTitle);
            this.remove(editNodePanel);
            this.remove(undoNodeEdits);
            this.remove(saveNodeEdits);
            this.remove(nodeComboBox);
            this.remove(edgesTextField);
            if(this.isWeighted){
                this.remove(weightEdges);
                this.remove(weightEdgesTextField);
            }
            this.dispose();
            graphManagement();
        }
        
        // Save existent node edits button
        if(e.getSource() == saveNodeEdits){
            System.out.println("Save edits");
            // int nodeSelectedToEdit = (Integer)nodeComboBox.getSelectedItem();
            String edgeTo = edgesTextField.getText();
            String  edgeWeight = null;
            if(this.isWeighted)
                edgeWeight = weightEdgesTextField.getText();
            // Graph.editMethod(nodeSelectedToEdit, edgeTo, edgeWeight, this.isDirected);

            this.remove(editNodeTitle);
            this.remove(editNodePanel);
            this.remove(undoNodeEdits);
            this.remove(saveNodeEdits);
            this.remove(nodeComboBox);
            this.remove(edgesTextField);
            if(this.isWeighted){
                this.remove(weightEdges);
                this.remove(weightEdgesTextField);
            }
            this.dispose();
            graphManagement();
        }
        //////////////////////////////////////////

        // Remove existent node frame ////////////  Removed

        // Undo remove edits button
        if(e.getSource() == undoRemoveEdits){
            System.out.println("Undo node remove edits");


            this.remove(removeNodeTitle);
            this.remove(removeText);
            this.remove(nodeComboBox);
            this.remove(undoRemoveEdits);
            this.remove(saveRemoveEdits);
            this.dispose();
            graphManagement();


        }

        // Save remove edits button
        if(e.getSource() == saveRemoveEdits){
            System.out.println("Save remove edits");
            // int nodeSelectedToEdit = (Integer)nodeComboBox.getSelectedItem();

            // Graph.removeMethod(nodeSelectedToEdit, this.isWeighed, this.isDirected);

            this.remove(removeNodeTitle);
            this.remove(removeText);
            this.remove(nodeComboBox);
            this.remove(undoRemoveEdits);
            this.remove(saveRemoveEdits);
            this.dispose();
            graphManagement();
        }
        //////////////////////////////////////////


        // Choose algorithm frame ////////////////
        // DFS Button
        if(e.getSource() == DFSButton){
            System.out.println("DFS selected");
            System.out.println("Digite o valor a ser buscado: ");
            Scanner IO = new Scanner(System.in);
            int value = IO.nextInt();


            graph.depthFirstSearch(value);

            // call DFS method
            this.remove(algorithmChooserTitle);
            this.remove(DFSButton);
            this.remove(BFSButton);
            this.remove(TopologicalSortingButton);
            this.remove(minimumSpanningTree);
            this.remove(shortestPath);
            this.dispose();
            
            finalPage();
        }

        // BFS Button
        if(e.getSource() == BFSButton){
            System.out.println("BFS selected");
            System.out.println("Digite o valor a ser buscado: ");
            Scanner IO = new Scanner(System.in);
            int value = IO.nextInt();


            graph.breadthFirstSearch(value);

            // call BFS method

            this.remove(algorithmChooserTitle);
            this.remove(DFSButton);
            this.remove(BFSButton);
            this.remove(TopologicalSortingButton);
            this.remove(minimumSpanningTree);
            this.remove(shortestPath);
            this.dispose();
            
            finalPage();
        }

        // Topological sorting Button
        if(e.getSource() == TopologicalSortingButton){
            System.out.println("Topological sorting selected");

            // call TopologicalSorting method

            this.remove(algorithmChooserTitle);
            this.remove(DFSButton);
            this.remove(BFSButton);
            this.remove(TopologicalSortingButton);
            this.remove(minimumSpanningTree);
            this.remove(shortestPath);
            this.dispose();
            
            finalPage();
        }

        // Minimum spanning tree sorting Button
        if(e.getSource() == minimumSpanningTree){
            System.out.println("minimum spanning tree selected");

            // call minimumSpanningTree method

            this.remove(algorithmChooserTitle);
            this.remove(DFSButton);
            this.remove(BFSButton);
            this.remove(TopologicalSortingButton);
            this.remove(minimumSpanningTree);
            this.remove(shortestPath);
            this.dispose();
            
            finalPage();
        }

        // Shortest path tree sorting Button
        if(e.getSource() == shortestPath){
            System.out.println("Shortest path selected");

            // call shortestPath method

            this.remove(algorithmChooserTitle);
            this.remove(DFSButton);
            this.remove(BFSButton);
            this.remove(TopologicalSortingButton);
            this.remove(minimumSpanningTree);
            this.remove(shortestPath);
            this.dispose();
            
            finalPage();
        }
        //////////////////////////////////////////

        // final page frame //////////////////////
        if(e.getSource() == animationButton){
            System.out.println("Representation");
            // call animation method and do not close final page frame
        }

        if(e.getSource() == finalUndoGraph){
            // just finish program
            System.out.println("Undo whole graph");
            this.dispose();
        }

        if(e.getSource() == finalSaveGraph){
            // call save method
            System.out.println("Finish and save graph");
            this.dispose();
        }
        //////////////////////////////////////////
    }
}
