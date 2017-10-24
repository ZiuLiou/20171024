    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
    import java.util.Random;

    public class MainFrame extends JFrame {
        private Container cp;
        private JMenuItem jMenuItemFEixt = new JMenuItem("Exit");
        private JMenuItem jMenuItemGLoto = new JMenuItem("Loto");
        private JMenuBar jmb = new JMenuBar();
        private  JMenu jmf = new JMenu("File");
        private  JMenu jms = new JMenu("Set");
        private  JMenu jmg = new JMenu("Game");
        private  JMenu jma = new JMenu("About");

        private  Container jlfCP;
        private  JInternalFrame jInternalFrame = new JInternalFrame();
        private  JDesktopPane jdp = new JDesktopPane();
        private  JPanel jpn = new JPanel(new GridLayout(3,3));
        private  JLabel jlbs[] = new JLabel[6];
        private  int data[] = new int[6];
        private Random rnd = new Random(System.currentTimeMillis());

        private  JTextField jtf = new JTextField();
        private  JButton jbtns[] = new JButton[9];
        private  LoginFrame loginFrame;
        public  MainFrame(LoginFrame login){
            loginFrame = login;
            initComp();
        }
        private void initComp(){
            cp = this.getContentPane();
            cp.setLayout(new BorderLayout(5,5));
            this.setBounds(100 ,100,400,600);
            this.setJMenuBar(jmb);
            this.setContentPane(jdp);
            jmb.add(jmf);
            jmb.add(jms);
            jmb.add(jmg);
            jmb.add(jma);
            jmf.add(jMenuItemFEixt);
            jmg.add(jMenuItemGLoto);
            jInternalFrame.setBounds(0,0,200,80);
            jMenuItemGLoto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    jdp.add(jInternalFrame);
                    jInternalFrame.setVisible(true);
                }
            });
            jMenuItemFEixt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.exit(0);
                }
            });
            jMenuItemFEixt.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    loginFrame.reset();
                    loginFrame.setVisible(true);

                }
            });
            // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            cp.add(jtf, BorderLayout.NORTH);
            cp.add(jpn,BorderLayout.CENTER);
            jtf.setEditable(false);
            for(int i=0; i<9; i++){
                jbtns[i] = new JButton(Integer.toString(i));
                jpn.add(jbtns[i]);
                jbtns[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpButton = (JButton) e.getSource();
                        jtf.setText(jtf.getText()+tmpButton.getText());
                    }
                });
            }

        }
    }


