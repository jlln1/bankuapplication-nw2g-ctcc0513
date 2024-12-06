import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class BankUApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}

// Login Screen
class LoginScreen {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginScreen() {
        JFrame frame = new JFrame("Bank-U - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 350);
        frame.setResizable(false); // Make the window non-resizable
        frame.setLayout(null); // Absolute positioning
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Left Panel
        JPanel panelLeft = new JPanel(); 
        panelLeft.setLayout(null); 
        panelLeft.setBackground(new Color(173, 216, 230)); 
        panelLeft.setBounds(0, 0, 400, 350);

        JLabel lblBankLogo = new JLabel();
        lblBankLogo.setIcon(new ImageIcon("bank-u.png")); 
        lblBankLogo.setBounds(120, 50, 200, 100); 

        JLabel lblBankSlogan1 = new JLabel("Bank-U: Secure and True,");  // First line of the slogan
        lblBankSlogan1.setFont(new Font("Century", Font.BOLD, 20));
        lblBankSlogan1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSlogan1.setForeground(Color.WHITE);
        lblBankSlogan1.setBounds(10, 160, 380, 30); 

        JLabel lblBankSlogan2 = new JLabel("Always Here for You!"); // Second line of the slogan
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
}

// Dashboard Screen
class Dashboard {
    private double balance = 0.0;
    private LinkedList<String> transactionLog = new LinkedList<>();
    private Queue<String> receiptQueue = new LinkedList<>();
    private final int MAX_RECEIPT_SIZE = 5; // The size can be changed
    private String username;

    public Dashboard(String username) {
        this.username = username;
        JFrame frame = new JFrame("Bank-U");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false); // Make the window non-resizable
        frame.setLayout(null); // Absolute positioning
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Left Panel
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(null);
        panelLeft.setBackground(new Color(173, 216, 230)); 
        panelLeft.setBounds(0, 0, 400, 350);

        JLabel lblBankLogo = new JLabel();
        lblBankLogo.setIcon(new ImageIcon("bank-u.png")); 
        lblBankLogo.setBounds(120, 30, 200, 100);

        JLabel lblBankSlogan1 = new JLabel("Bank-U: Secure and True,");
        lblBankSlogan1.setFont(new Font("Century", Font.BOLD, 20));
        lblBankSlogan1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSlogan1.setForeground(Color.WHITE);
        lblBankSlogan1.setBounds(10, 150, 380, 30); 

        JLabel lblBankSlogan2 = new JLabel("Always Here for You!");
        lblBankSlogan2.setFont(new Font("Century", Font.BOLD, 20));
        lblBankSlogan2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSlogan2.setForeground(Color.WHITE);
        lblBankSlogan2.setBounds(10, 185, 380, 30); 

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(0, 0, 128));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Century", Font.BOLD, 15));
        btnExit.setBounds(150, 250, 100, 30);
        btnExit.addActionListener(e -> System.exit(0));

        panelLeft.add(lblBankLogo);
        panelLeft.add(lblBankSlogan1);
        panelLeft.add(lblBankSlogan2);
        panelLeft.add(btnExit);

        // Right Panel
        JPanel panelRight = new JPanel();
        panelRight.setLayout(null); 
        panelRight.setBackground(Color.WHITE);
        panelRight.setBounds(400, 0, 400, 350);

        JLabel lblWelcomeUser = new JLabel("Hello, " + username + "!", SwingConstants.CENTER);
        lblWelcomeUser.setFont(new Font("Century", Font.BOLD, 20));
        lblWelcomeUser.setForeground(new Color(0, 102, 204)); 
        lblWelcomeUser.setBounds(100, 10, 200, 30);

        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBackground(new Color(0, 0, 128));
        btnCheckBalance.setForeground(Color.WHITE);
        btnCheckBalance.setFont(new Font("Century", Font.BOLD, 15));
        btnCheckBalance.setBounds(100, 50, 200, 35);
        btnCheckBalance.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Your current balance is: \u20B1" + String.format("%.2f", balance)));

        JButton btnDeposit = new JButton("Deposit Money");
        btnDeposit.setBackground(new Color(0, 0, 128));
        btnDeposit.setForeground(Color.WHITE);
        btnDeposit.setFont(new Font("Century", Font.BOLD, 15));
        btnDeposit.setBounds(100, 100, 200, 35);
        btnDeposit.addActionListener(e -> depositMoney(frame));

        JButton btnTransfer = new JButton("Transfer Money");
        btnTransfer.setBackground(new Color(0, 0, 128));
        btnTransfer.setForeground(Color.WHITE);
        btnTransfer.setFont(new Font("Century", Font.BOLD, 15));
        btnTransfer.setBounds(100, 150, 200, 35);
        btnTransfer.addActionListener(e -> transferMoney(frame));

        JButton btnWithdraw = new JButton("Withdraw Money");
        btnWithdraw.setBackground(new Color(0, 0, 128));
        btnWithdraw.setForeground(Color.WHITE);
        btnWithdraw.setFont(new Font("Century", Font.BOLD, 15));
        btnWithdraw.setBounds(100, 200, 200, 35);
        btnWithdraw.addActionListener(e -> withdrawMoney(frame));

        JButton btnTransactionHistory = new JButton("Transaction History");
        btnTransactionHistory.setBackground(new Color(0, 0, 128));
        btnTransactionHistory.setForeground(Color.WHITE);
        btnTransactionHistory.setFont(new Font("Century", Font.BOLD, 15));
        btnTransactionHistory.setBounds(100, 250, 200, 35);
        btnTransactionHistory.addActionListener(e -> showTransactionHistory(frame));

        JButton btnGenerateReceipt = new JButton("Receipt");
        btnGenerateReceipt.setBackground(new Color(0, 0, 128));
        btnGenerateReceipt.setForeground(Color.WHITE);
        btnGenerateReceipt.setFont(new Font("Century", Font.BOLD, 15));
        btnGenerateReceipt.setBounds(100, 300, 200, 35);
        btnGenerateReceipt.addActionListener(e -> generateReceipt(frame));

        panelRight.add(lblWelcomeUser);
        panelRight.add(btnCheckBalance);
        panelRight.add(btnDeposit);
        panelRight.add(btnTransfer);
        panelRight.add(btnWithdraw);
        panelRight.add(btnTransactionHistory);
        panelRight.add(btnGenerateReceipt);

        frame.add(panelLeft);
        frame.add(panelRight);
        frame.setVisible(true);
    }

    private void addTransaction(String transaction) {
        transactionLog.addFirst(transaction); // Add to LinkedList
        receiptQueue.add(transaction); // Add to Queue and maintain its size
        if (receiptQueue.size() > MAX_RECEIPT_SIZE) {
            receiptQueue.poll(); // Remove the oldest transaction
        }
    }

    private void depositMoney(JFrame parentFrame) {
        String input = JOptionPane.showInputDialog(parentFrame, "Enter amount to deposit:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                double amount = Double.parseDouble(input.trim());
                balance += amount;
                String transaction = "Deposited: \u20B1" + String.format("%.2f", amount);
                addTransaction(transaction);
                JOptionPane.showMessageDialog(parentFrame, "Deposit successful!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parentFrame, "Invalid input. Please enter a numerical value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }    

    private void transferMoney(JFrame parentFrame) {
        String amountInput = JOptionPane.showInputDialog(parentFrame, "Enter amount to transfer:");
        if (amountInput != null && !amountInput.trim().isEmpty()) {
            try {
                double amount = Double.parseDouble(amountInput.trim());
                if (amount > balance) {
                    JOptionPane.showMessageDialog(parentFrame, "Insufficient balance. Cannot transfer \u20B1" + String.format("%.2f", amount), "Error", JOptionPane.ERROR_MESSAGE);
                } else if (amount <= 0) {
                    JOptionPane.showMessageDialog(parentFrame, "Invalid amount. Please enter a positive value.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String recipientName = JOptionPane.showInputDialog(parentFrame, "Enter recipient's name:");
                    if (recipientName != null && !recipientName.trim().isEmpty()) {
                        balance -= amount;
                        String transaction = "Transferred: \u20B1" + String.format("%.2f", amount) + " to " + recipientName;
                        addTransaction(transaction);
                        JOptionPane.showMessageDialog(parentFrame, "Transfer to " + recipientName + " successful!");
                    } else {
                        JOptionPane.showMessageDialog(parentFrame, "Recipient name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parentFrame, "Invalid input. Please enter a numerical value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }       

    private void withdrawMoney(JFrame parentFrame) {
        String input = JOptionPane.showInputDialog(parentFrame, "Enter amount to withdraw:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                double amount = Double.parseDouble(input.trim());
                if (amount > balance) {
                    JOptionPane.showMessageDialog(parentFrame, "Insufficient balance. Cannot withdraw \u20B1" + String.format("%.2f", amount), "Error", JOptionPane.ERROR_MESSAGE);
                } else if (amount <= 0) {
                    JOptionPane.showMessageDialog(parentFrame, "Invalid amount. Please enter a positive value.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    balance -= amount;
                    String transaction = "Withdrew: \u20B1" + String.format("%.2f", amount);
                    addTransaction(transaction);
                    JOptionPane.showMessageDialog(parentFrame, "Withdrawal successful!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parentFrame, "Invalid input. Please enter a numerical value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }      

    private void showTransactionHistory(JFrame parentFrame) {
        if (transactionLog.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, "No transactions found.", "Transaction History", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder history = new StringBuilder();
            history.append("Transaction History:\n\n");
            for (String transaction : transactionLog) {
                history.append(transaction.replace("\u20B1", "₱")).append("\n");
            }
    
            JTextArea textArea = new JTextArea(history.toString());
            textArea.setEditable(false);
            textArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(350, 200));
    
            JOptionPane.showMessageDialog(parentFrame, scrollPane, "Transaction History", JOptionPane.INFORMATION_MESSAGE);
        }
    }     

    private void generateReceipt(JFrame parentFrame) {
        parentFrame.setVisible(false); // Hide the dashboard when opening the receipt
        JFrame receiptFrame = new JFrame("Receipt");
        receiptFrame.setSize(400, 400);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiptFrame.setLayout(null);
        receiptFrame.setResizable(false);
        receiptFrame.setLocationRelativeTo(parentFrame); // Center relative to the dashboard

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 400, 400);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(245, 245, 245));

        JLabel titleLabel = new JLabel("BANK-U RECEIPT");
        titleLabel.setBounds(50, 10, 300, 30);
        titleLabel.setFont(new Font("Century", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        receiptArea.setBackground(Color.WHITE);

        StringBuilder receiptText = new StringBuilder();
        receiptText.append("================ BANK-U RECEIPT ===============\n\n");
        receiptText.append("User: ").append(username).append("\n");
        receiptText.append("Balance: ₱").append(String.format("%.2f", balance)).append("\n\n");
        receiptText.append("Transaction History:\n");
        if (receiptQueue.isEmpty()) {
            receiptText.append("No transactions found.\n");
        } else {
            for (String transaction : receiptQueue) {
                receiptText.append("- ").append(transaction.replace("\u20B1", "₱")).append("\n");
            }
        }
        receiptText.append("\n===========================================\n");
        receiptArea.setText(receiptText.toString());

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setBounds(20, 50, 350, 250);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128), 2));
    
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(80, 320, 100, 30);
        btnBack.setBackground(new Color(0, 0, 128));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Century", Font.BOLD, 13));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128)));
        btnBack.addActionListener(e -> {
            receiptFrame.dispose(); // Close the receipt frame
            parentFrame.setVisible(true); // Show the dashboard again
        });
    
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(220, 320, 100, 30);
        btnExit.setBackground(new Color(0, 0, 128));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Century", Font.BOLD, 13));
        btnExit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128)));
        btnExit.addActionListener(e -> System.exit(0));
    
        backgroundPanel.add(titleLabel);
        backgroundPanel.add(scrollPane); 
        backgroundPanel.add(btnBack);
        backgroundPanel.add(btnExit);
    
        receiptFrame.add(backgroundPanel);
        receiptFrame.setVisible(true);
    }    
}
