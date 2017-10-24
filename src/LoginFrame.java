import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginFrame  extends JFrame {
    private JLabel jLabelID = new JLabel("ID:");
    private JLabel jLabelPW = new JLabel("Password:");
    private JTextField jtfID = new JTextField();
    private JPasswordField jtfPW = new JPasswordField();
    private  JButton jbtExit = new JButton("Exit");
    private  JButton jbtLogin = new JButton("Login");
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private  int frmW =300, frmH=150, screenW, screenH;
    public LoginFrame(){
        initComp();

    }
    private  void initComp(){
        screenW = dim.width;
        screenH = dim.height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp = this.getContentPane();
        cp.setLayout( new GridLayout(3,2,3,3));
        jLabelID.setHorizontalAlignment(JLabel.RIGHT);
        jLabelPW.setHorizontalAlignment(JLabel.RIGHT);
        jbtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtfID.getText().equals("104021116") && (new String(jtfPW.getPassword())).equals("19970415")) {
                    MainFrame mainframe = new MainFrame(LoginFrame.this);
                    mainframe.setVisible(true);
                    LoginFrame.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                    System.out.println("No" + jtfID.getText() + "\tpw");
                }
            }
        });                jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp.add(jLabelID);
        cp.add(jtfID);
        cp.add(jLabelPW);
        cp.add(jtfPW);
        cp.add(jbtExit);
        cp.add(jbtLogin);

    }
    public  void reset(){
        jtfID.setText("");
        jtfPW.setText("");
    }
}
