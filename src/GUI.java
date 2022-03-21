import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    JButton addFileGraph;
    JButton initNewGraph;
    JLabel mainMenuTitle;

    Image image;
    Image newimg;
    ImageIcon icon = new ImageIcon("D:\\Rafae\\SubDesktop\\Unipampa\\2021.2\\POO\\Codes\\Trabalho-Pratico-de-Programacao_ASP05\\src\\images\\JFrameIcon.png"); // copy the path of image and paste here

    final int frameWidth = 600;
    final int frameHeight = 360;

    GUI(){
        mainMenu();
        this.setTitle("Main menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.lightGray);
        this.add(mainMenuTitle);
        this.add(addFileGraph);
        this.add(initNewGraph);
    }

    public void mainMenu(){
        mainMenuTitle = new JLabel();
        mainMenuTitle.setBounds(0, 0, frameWidth, 50);
        mainMenuTitle.setText("Graph generator");
        mainMenuTitle.setHorizontalAlignment(JLabel.CENTER);
        mainMenuTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        mainMenuTitle.setBackground(Color.lightGray);
        mainMenuTitle.setOpaque(true);

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

        initNewGraph = new JButton();
        initNewGraph.setBounds((frameWidth)/2 - 300/2, 200, 300, 50);
        initNewGraph.addActionListener(this);
        initNewGraph.setText("Iniciar novo grafo vazio");
        initNewGraph.setFocusable(false); // remove rectangle under text of button
        initNewGraph.setHorizontalTextPosition(JButton.CENTER);
        initNewGraph.setVerticalTextPosition(JButton.BOTTOM);
        initNewGraph.setFont(new Font("Tahoma", Font.BOLD, 20));
        initNewGraph.setForeground(Color.WHITE);
        initNewGraph.setBackground(new Color(59, 89, 182));
        initNewGraph.setBorder(BorderFactory.createEtchedBorder());
    }

    public void fileGraphMenu(){

    }

    public void newGraphMenu(){

    }

    public void graphManagment(){

    }

    public void editNode(){

    }

    public void 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addFileGraph){
            System.out.println("addFileGraph");
        }
        if(e.getSource() == initNewGraph){
            System.out.println("initNewGraph");
        }
    }
    
}
