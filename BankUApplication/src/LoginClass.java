import javax.swing.*;
import java.awt.*;

public class LoginClass {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginClass() {
        JFrame frame = new JFrame("Bank-U - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 350);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Left Panel
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(null);
        panelLeft.setBackground(new Color(173, 216, 230));
        panelLeft.setBounds(0, 0, 400, 350);

        JLabel lblBankLogo = new JLabel();
        lblBankLogo.setIcon(new ImageIcon("bank-u.png"));
        lblBankLogo.setBounds(120, 50, 200, 100);

        JLabel lblBankSlogan1 = new JLabel("Bank-U: Secure and True,");
        lblBankSlogan1.setFont(new Font("Century", Font.BOLD, 20));
        lblBankSlogan1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSlogan1.setForeground(Color.WHITE);
        lblBankSlogan1.setBounds(10, 160, 380, 30);

        JLabel lblBankSlogan2 = new JLabel("Always Here for You!");
        lblBankSlogan2.setFont(new Font("Century", Font.BOLD, 20));
        lblBankSlogan2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSlogan2.setForeground(Color.WHITE);
        lblBankSlogan2.setBounds(10, 195, 380, 30);

        panelLeft.add(lblBankLogo);
        panelLeft.add(lblBankSlogan1);
        panelLeft.add(lblBankSlogan2);

        // Right Panel
        JPanel panelRight = new JPanel();
        panelRight.setLayout(null);
        panelRight.setBackground(Color.WHITE);
        panelRight.setBounds(400, 0, 400, 350);

        JLabel lblWelcome = new JLabel("WELCOME TO BANK-U", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Century", Font.BOLD, 24));
        lblWelcome.setForeground(new Color(0, 102, 204));
        lblWelcome.setBounds(50, 30, 300, 50);

        JLabel lblUsername = new JLabel("Enter Username:");
        lblUsername.setFont(new Font("Century", Font.BOLD, 13));
        lblUsername.setForeground(new Color(0, 102, 204));
        lblUsername.setBounds(50, 100, 120, 30);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Century", Font.BOLD, 13));
        txtUsername.setForeground(new Color(0, 102, 204));
        txtUsername.setBounds(180, 100, 150, 30);

        JLabel lblPassword = new JLabel("Enter Password:");
        lblPassword.setFont(new Font("Century", Font.BOLD, 13));
        lblPassword.setForeground(new Color(0, 102, 204));
        lblPassword.setBounds(50, 150, 120, 30);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Century", Font.BOLD, 13));
        txtPassword.setForeground(new Color(0, 102, 204));
        txtPassword.setBounds(180, 150, 150, 30);

        JButton btnLogIn = new JButton("Log In");
        btnLogIn.setBackground(new Color(0, 0, 128));
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setFont(new Font("Century", Font.BOLD, 15));
        btnLogIn.setBounds(140, 220, 100, 30);
        btnLogIn.addActionListener(e -> handleLogin(frame));

        panelRight.add(lblWelcome);
        panelRight.add(lblUsername);
        panelRight.add(txtUsername);
        panelRight.add(lblPassword);
        panelRight.add(txtPassword);
        panelRight.add(btnLogIn);

        frame.add(panelLeft);
        frame.add(panelRight);
        frame.setVisible(true);
    }

    private void handleLogin(JFrame loginFrame) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        if ("roque_nw2g".equalsIgnoreCase(username) && "nw2g".equals(password)) {
            loginFrame.dispose(); // Close login frame
            new Dashboard(username);
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginClass::new);
    }
}
