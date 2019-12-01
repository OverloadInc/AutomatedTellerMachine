package atm.front;

import atm.bank.*;
import atm.logic.*;
import atm.parts.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ATMGraphic extends JFrame {
    private JPanel balancePanel;
    private JButton btnBalance;
    private JButton btnCancel;
    private JButton btnDelete;
    private JButton btnDeposit;
    private JButton btnDot;
    private JButton btnEight;
    private JButton btnEnter;
    private JButton btnExit;
    private JButton btnFive;
    private JButton btnFour;
    private JButton btnNine;
    private JButton btnOne;
    private JButton btnSettings;
    private JButton btnSeven;
    private JButton btnSix;
    private JButton btnStatement;
    private JButton btnThree;
    private JButton btnTransfer;
    private JButton btnTripleZero;
    private JButton btnTwo;
    private JButton btnWithdraw;
    private JButton btnZero;
    private JPanel centerPanel;
    private JPanel depositPanel;
    private JLabel lblAccount;
    private JLabel lblAppName;
    private JLabel lblAvailable;
    private JLabel lblDeposit;
    private static JLabel lblDepositMessage;
    private JLabel lblPin;
    private JLabel lblTotal;
    private JLabel lblWelcome;
    private JLabel lblWithdraw;
    private JPanel loginPanel;
    private JPanel northPanel;
    private JPanel operationPanel;
    private JScrollPane scroll;
    private JPanel settingsPanel;
    private JPanel southPanel;
    private JPanel statementPanel;
    private JPanel transferPanel;
    private JTextField txtAccount;
    private static JTextField txtAvailable;
    private JTextField txtDeposit;
    private JTextField txtOption;
    private JTextArea txtOptions;
    private JPasswordField txtPin;
    private static JTextField txtTotal;
    private JPanel welcomePanel;
    private JPanel withdrawPanel;

    private CardLayout oPanel = null;
    private boolean userAuthenticated = false;
    private int currentAccountNumber = 0;
    private Bank bank;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private DisplayScreen displayScreen;
    private CashDispenser cashDispenser;
    private static final int BALANCE = 1;
    private static final int WITHDRAW = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    private static String message = "Exiting the system";
    
    public ATMGraphic() {
        initComponents();
        enableButtons(false);

        bank = new Bank();
        keypad = new Keypad();
        depositSlot = new DepositSlot();
        displayScreen = new DisplayScreen();
        cashDispenser = new CashDispenser();
        oPanel = (CardLayout)this.operationPanel.getLayout();
    }
     
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        northPanel = new JPanel();
        lblAppName = new JLabel();
        centerPanel = new JPanel();
        btnWithdraw = new JButton();
        btnBalance = new JButton();
        btnSettings = new JButton();
        btnDeposit = new JButton();
        btnTransfer = new JButton();
        btnStatement = new JButton();
        btnExit = new JButton();
        operationPanel = new JPanel();
        loginPanel = new JPanel();
        lblAccount = new JLabel();
        txtAccount = new JTextField();
        lblPin = new JLabel();
        txtPin = new JPasswordField();
        depositPanel = new JPanel();
        lblDeposit = new JLabel();
        txtDeposit = new JTextField();
        lblDepositMessage = new JLabel();
        withdrawPanel = new JPanel();
        lblWithdraw = new JLabel();
        scroll = new JScrollPane();
        txtOptions = new JTextArea();
        txtOption = new JTextField();
        balancePanel = new JPanel();
        lblAvailable = new JLabel();
        txtAvailable = new JTextField();
        lblTotal = new JLabel();
        txtTotal = new JTextField();
        transferPanel = new JPanel();
        settingsPanel = new JPanel();
        statementPanel = new JPanel();
        welcomePanel = new JPanel();
        lblWelcome = new JLabel();
        southPanel = new JPanel();
        btnOne = new JButton();
        btnTwo = new JButton();
        btnThree = new JButton();
        btnDelete = new JButton();
        btnFour = new JButton();
        btnFive = new JButton();
        btnSix = new JButton();
        btnCancel = new JButton();
        btnSeven = new JButton();
        btnEight = new JButton();
        btnNine = new JButton();
        btnEnter = new JButton();
        btnDot = new JButton();
        btnZero = new JButton();
        btnTripleZero = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Automated Teller Machine");
        setMinimumSize(new Dimension(500, 450));
        setPreferredSize(new Dimension(500, 450));
        setResizable(false);

        northPanel.setBackground(Color.lightGray);
        northPanel.setBorder(null);
        northPanel.setName("northPanel");
        northPanel.setLayout(new BorderLayout());

        lblAppName.setFont(new Font("Tahoma", 1, 11));
        lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
        lblAppName.setText("  ");
        lblAppName.setToolTipText("");
        lblAppName.setHorizontalTextPosition(SwingConstants.CENTER);
        lblAppName.setName("lblAppName");
        northPanel.add(lblAppName, BorderLayout.CENTER);

        getContentPane().add(northPanel, BorderLayout.NORTH);

        centerPanel.setBackground(Color.lightGray);
        centerPanel.setBorder(null);
        centerPanel.setMinimumSize(new Dimension(500, 254));
        centerPanel.setName("centerPanel");
        centerPanel.setPreferredSize(new Dimension(500, 254));
        centerPanel.setLayout(new GridBagLayout());

        btnWithdraw.setFont(new Font("Ubuntu", 0, 15));
        btnWithdraw.setText("Withdraw");
        btnWithdraw.setMaximumSize(new Dimension(90, 40));
        btnWithdraw.setMinimumSize(new Dimension(90, 40));
        btnWithdraw.setName("btnWithdraw");
        btnWithdraw.setPreferredSize(new Dimension(90, 40));
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnWithdraw, gridBagConstraints);

        btnBalance.setText("Balance");
        btnBalance.setMaximumSize(new Dimension(90, 40));
        btnBalance.setMinimumSize(new Dimension(90, 40));
        btnBalance.setName("btnBalance");
        btnBalance.setPreferredSize(new Dimension(90, 40));
        btnBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBalanceActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnBalance, gridBagConstraints);

        btnSettings.setText("Settings");
        btnSettings.setMaximumSize(new Dimension(90, 40));
        btnSettings.setMinimumSize(new Dimension(90, 40));
        btnSettings.setName("btnSettings");
        btnSettings.setPreferredSize(new Dimension(90, 40));
        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnSettings, gridBagConstraints);

        btnDeposit.setText("Deposit");
        btnDeposit.setMaximumSize(new Dimension(90, 40));
        btnDeposit.setMinimumSize(new Dimension(90, 40));
        btnDeposit.setName("btnDeposit");
        btnDeposit.setPreferredSize(new Dimension(90, 40));
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnDeposit, gridBagConstraints);

        btnTransfer.setText("Transfer");
        btnTransfer.setMaximumSize(new Dimension(90, 40));
        btnTransfer.setMinimumSize(new Dimension(90, 40));
        btnTransfer.setName("btnTransfer");
        btnTransfer.setPreferredSize(new Dimension(90, 40));
        btnTransfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnTransfer, gridBagConstraints);

        btnStatement.setText("Statement");
        btnStatement.setMaximumSize(new Dimension(90, 40));
        btnStatement.setMinimumSize(new Dimension(90, 40));
        btnStatement.setName("btnStatement");
        btnStatement.setPreferredSize(new Dimension(90, 40));
        btnStatement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnStatementActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnStatement, gridBagConstraints);

        btnExit.setText("Exit");
        btnExit.setMaximumSize(new Dimension(90, 40));
        btnExit.setMinimumSize(new Dimension(90, 40));
        btnExit.setName("btnExit");
        btnExit.setPreferredSize(new Dimension(90, 40));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(btnExit, gridBagConstraints);

        operationPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        operationPanel.setMinimumSize(new Dimension(300, 250));
        operationPanel.setName("operationPanel");
        operationPanel.setPreferredSize(new Dimension(300, 250));
        operationPanel.setLayout(new CardLayout());

        loginPanel.setBackground(new Color(146, 195, 242));
        loginPanel.setName("loginPanel");
        loginPanel.setLayout(new GridBagLayout());

        lblAccount.setFont(new Font("Ubuntu", 1, 15));
        lblAccount.setForeground(Color.white);
        lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccount.setText("Account");
        lblAccount.setName("lblAccount");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(49, 119, 0, 0);
        loginPanel.add(lblAccount, gridBagConstraints);

        txtAccount.setMinimumSize(new Dimension(150, 30));
        txtAccount.setName("txtAccount");
        txtAccount.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 77, 0, 75);
        loginPanel.add(txtAccount, gridBagConstraints);

        lblPin.setFont(new Font("Ubuntu", 1, 15));
        lblPin.setForeground(Color.white);
        lblPin.setHorizontalAlignment(SwingConstants.CENTER);
        lblPin.setText("PIN");
        lblPin.setName("lblPin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 136, 0, 0);
        loginPanel.add(lblPin, gridBagConstraints);

        txtPin.setMinimumSize(new Dimension(150, 30));
        txtPin.setName("txtPin");
        txtPin.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 77, 51, 75);
        loginPanel.add(txtPin, gridBagConstraints);

        operationPanel.add(loginPanel, "loginPanel");

        depositPanel.setBackground(new Color(146, 195, 242));
        depositPanel.setName("depositPanel");
        depositPanel.setLayout(new GridBagLayout());

        lblDeposit.setFont(new Font("Ubuntu", 1, 15));
        lblDeposit.setForeground(Color.white);
        lblDeposit.setText("Amount to deposit");
        lblDeposit.setPreferredSize(new Dimension(150, 18));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(71, 92, 0, 0);
        depositPanel.add(lblDeposit, gridBagConstraints);

        txtDeposit.setMinimumSize(new Dimension(150, 30));
        txtDeposit.setName("txtDeposit");
        txtDeposit.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 92, 0, 0);
        depositPanel.add(txtDeposit, gridBagConstraints);

        lblDepositMessage.setFont(new Font("Ubuntu", 1, 15));
        lblDepositMessage.setForeground(Color.white);
        lblDepositMessage.setName("lblDepositMessage");
        lblDepositMessage.setPreferredSize(new Dimension(250, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 31, 65, 20);
        depositPanel.add(lblDepositMessage, gridBagConstraints);

        operationPanel.add(depositPanel, "depositPanel");

        withdrawPanel.setBackground(new Color(146, 195, 242));
        withdrawPanel.setName("withdrawPanel");
        withdrawPanel.setLayout(new GridBagLayout());

        lblWithdraw.setFont(new Font("Ubuntu", 1, 15));
        lblWithdraw.setForeground(Color.white);
        lblWithdraw.setText("Enter an option or withdrawal amount");
        lblWithdraw.setName("lblWithdraw");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 23, 0, 9);
        withdrawPanel.add(lblWithdraw, gridBagConstraints);

        scroll.setBorder(null);
        scroll.setMinimumSize(new Dimension(250, 90));
        scroll.setName("scroll");
        scroll.setPreferredSize(new Dimension(250, 90));

        txtOptions.setEditable(false);
        txtOptions.setBackground(new Color(146, 195, 242));
        txtOptions.setColumns(20);
        txtOptions.setFont(new Font("Ubuntu", 1, 15));
        txtOptions.setForeground(Color.white);
        txtOptions.setRows(5);
        txtOptions.setText("Withdrawal menu:   \n \n(1) - $20  \n(2) - $40  \n(3) - $60 \n(4) - $100  \n(5) - $200");
        txtOptions.setBorder(null);
        txtOptions.setMinimumSize(new Dimension(141, 120));
        txtOptions.setName("txtOptions");
        txtOptions.setPreferredSize(new Dimension(240, 120));
        scroll.setViewportView(txtOptions);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(12, 23, 0, 0);
        withdrawPanel.add(scroll, gridBagConstraints);

        txtOption.setMinimumSize(new Dimension(150, 30));
        txtOption.setName("txtOption");
        txtOption.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 92, 17, 0);
        withdrawPanel.add(txtOption, gridBagConstraints);

        operationPanel.add(withdrawPanel, "withdrawPanel");

        balancePanel.setBackground(new Color(146, 195, 242));
        balancePanel.setName("balancePanel");
        balancePanel.setLayout(new GridBagLayout());

        lblAvailable.setFont(new Font("Ubuntu", 1, 15));
        lblAvailable.setForeground(Color.white);
        lblAvailable.setText("Available balance");
        lblAvailable.setName("lblAvailable");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(46, 88, 0, 0);
        balancePanel.add(lblAvailable, gridBagConstraints);

        txtAvailable.setEditable(false);
        txtAvailable.setMinimumSize(new Dimension(150, 30));
        txtAvailable.setName("txtAvailable");
        txtAvailable.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 88, 0, 84);
        balancePanel.add(txtAvailable, gridBagConstraints);

        lblTotal.setFont(new Font("Ubuntu", 1, 15));
        lblTotal.setForeground(Color.white);
        lblTotal.setText("Total balance");
        lblTotal.setName("lblTotal");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 102, 0, 0);
        balancePanel.add(lblTotal, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.setMinimumSize(new Dimension(150, 30));
        txtTotal.setName("txtTotal");
        txtTotal.setPreferredSize(new Dimension(150, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(18, 88, 54, 84);
        balancePanel.add(txtTotal, gridBagConstraints);

        operationPanel.add(balancePanel, "balancePanel");

        transferPanel.setBackground(new Color(146, 195, 242));
        transferPanel.setName("transferPanel");

        GroupLayout transferPanelLayout = new GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);
        transferPanelLayout.setHorizontalGroup(
                transferPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 302, Short.MAX_VALUE)
        );
        transferPanelLayout.setVerticalGroup(
                transferPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );

        operationPanel.add(transferPanel, "transferPanel");

        settingsPanel.setBackground(new Color(146, 195, 242));
        settingsPanel.setName("settingsPanel");

        /*GroupLayout settingsPanelLayout = new GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
                settingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 302, Short.MAX_VALUE)
        );
        settingsPanelLayout.setVerticalGroup(
                settingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );*/

        operationPanel.add(settingsPanel, "settingsPanel");

        statementPanel.setBackground(new Color(146, 195, 242));
        statementPanel.setName("statementPanel");

        /*GroupLayout statementPanelLayout = new GroupLayout(statementPanel);
        statementPanel.setLayout(statementPanelLayout);
        statementPanelLayout.setHorizontalGroup(
                statementPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 302, Short.MAX_VALUE)
        );
        statementPanelLayout.setVerticalGroup(
                statementPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );*/

        operationPanel.add(statementPanel, "statementPanel");

        welcomePanel.setBackground(new Color(146, 195, 242));
        welcomePanel.setName("welcomePanel");
        welcomePanel.setLayout(new BorderLayout());

        lblWelcome.setFont(new Font("Ubuntu", 1, 15));
        lblWelcome.setForeground(Color.white);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setName("lblWelcome");
        welcomePanel.add(lblWelcome, BorderLayout.CENTER);

        operationPanel.add(welcomePanel, "welcomePanel");

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        centerPanel.add(operationPanel, gridBagConstraints);

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        southPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
        southPanel.setMinimumSize(new Dimension(500, 164));
        southPanel.setName("southPanel");
        southPanel.setPreferredSize(new Dimension(500, 164));
        southPanel.setLayout(new GridBagLayout());

        btnOne.setFont(new Font("Ubuntu", 0, 17));
        btnOne.setText("1");
        btnOne.setMaximumSize(new Dimension(80, 40));
        btnOne.setMinimumSize(new Dimension(80, 40));
        btnOne.setName("btnOne");
        btnOne.setPreferredSize(new Dimension(80, 40));
        btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnOne, gridBagConstraints);

        btnTwo.setFont(new Font("Ubuntu", 0, 17));
        btnTwo.setText("2");
        btnTwo.setMaximumSize(new Dimension(80, 40));
        btnTwo.setMinimumSize(new Dimension(80, 40));
        btnTwo.setName("btnTwo");
        btnTwo.setPreferredSize(new Dimension(80, 40));
        btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTwoActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnTwo, gridBagConstraints);

        btnThree.setFont(new Font("Ubuntu", 0, 17));
        btnThree.setText("3");
        btnThree.setMaximumSize(new Dimension(80, 40));
        btnThree.setMinimumSize(new Dimension(80, 40));
        btnThree.setName("btnThree");
        btnThree.setPreferredSize(new Dimension(80, 40));
        btnThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThreeActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnThree, gridBagConstraints);

        btnDelete.setText("Delete");
        btnDelete.setMaximumSize(new Dimension(80, 40));
        btnDelete.setMinimumSize(new Dimension(80, 40));
        btnDelete.setName("btnDelete");
        btnDelete.setPreferredSize(new Dimension(80, 40));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnDelete, gridBagConstraints);

        btnFour.setFont(new Font("Ubuntu", 0, 17));
        btnFour.setText("4");
        btnFour.setMaximumSize(new Dimension(80, 40));
        btnFour.setMinimumSize(new Dimension(80, 40));
        btnFour.setName("btnFour");
        btnFour.setPreferredSize(new Dimension(80, 40));
        btnFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFourActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnFour, gridBagConstraints);

        btnFive.setFont(new Font("Ubuntu", 0, 17));
        btnFive.setText("5");
        btnFive.setMaximumSize(new Dimension(80, 40));
        btnFive.setMinimumSize(new Dimension(80, 40));
        btnFive.setName("btnFive");
        btnFive.setPreferredSize(new Dimension(80, 40));
        btnFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFiveActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnFive, gridBagConstraints);

        btnSix.setFont(new Font("Ubuntu", 0, 17));
        btnSix.setText("6");
        btnSix.setMaximumSize(new Dimension(80, 40));
        btnSix.setMinimumSize(new Dimension(80, 40));
        btnSix.setName("btnSix");
        btnSix.setPreferredSize(new Dimension(80, 40));
        btnSix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSixActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnSix, gridBagConstraints);

        btnCancel.setText("Cancel");
        btnCancel.setMaximumSize(new Dimension(80, 40));
        btnCancel.setMinimumSize(new Dimension(80, 40));
        btnCancel.setName("btnCancel");
        btnCancel.setPreferredSize(new Dimension(80, 40));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnCancel, gridBagConstraints);

        btnSeven.setFont(new Font("Ubuntu", 0, 17));
        btnSeven.setText("7");
        btnSeven.setMaximumSize(new Dimension(80, 40));
        btnSeven.setMinimumSize(new Dimension(80, 40));
        btnSeven.setName("btnSeven");
        btnSeven.setPreferredSize(new Dimension(80, 40));
        btnSeven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnSeven, gridBagConstraints);

        btnEight.setFont(new Font("Ubuntu", 0, 17));
        btnEight.setText("8");
        btnEight.setMaximumSize(new Dimension(80, 40));
        btnEight.setMinimumSize(new Dimension(80, 40));
        btnEight.setName("btnEight");
        btnEight.setPreferredSize(new Dimension(80, 40));
        btnEight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEightActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnEight, gridBagConstraints);

        btnNine.setFont(new Font("Ubuntu", 0, 17));
        btnNine.setText("9");
        btnNine.setMaximumSize(new Dimension(80, 40));
        btnNine.setMinimumSize(new Dimension(80, 40));
        btnNine.setName("btnNine");
        btnNine.setPreferredSize(new Dimension(80, 40));
        btnNine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNineActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnNine, gridBagConstraints);

        btnEnter.setText("Enter");
        btnEnter.setMaximumSize(new Dimension(80, 40));
        btnEnter.setMinimumSize(new Dimension(80, 40));
        btnEnter.setName("btnEnter");
        btnEnter.setPreferredSize(new Dimension(80, 40));
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnEnter, gridBagConstraints);

        btnDot.setFont(new Font("Ubuntu", 0, 17));
        btnDot.setText(".");
        btnDot.setMaximumSize(new Dimension(80, 40));
        btnDot.setMinimumSize(new Dimension(80, 40));
        btnDot.setName("btnDot");
        btnDot.setPreferredSize(new Dimension(80, 40));
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnDot, gridBagConstraints);

        btnZero.setFont(new Font("Ubuntu", 0, 17));
        btnZero.setText("0");
        btnZero.setMaximumSize(new Dimension(80, 40));
        btnZero.setMinimumSize(new Dimension(80, 40));
        btnZero.setName("btnZero");
        btnZero.setPreferredSize(new Dimension(80, 40));
        btnZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnZero, gridBagConstraints);

        btnTripleZero.setFont(new Font("Ubuntu", 0, 17));
        btnTripleZero.setText("000");
        btnTripleZero.setMaximumSize(new Dimension(80, 40));
        btnTripleZero.setMinimumSize(new Dimension(80, 40));
        btnTripleZero.setName("btnTripleZero");
        btnTripleZero.setPreferredSize(new Dimension(80, 40));
        btnTripleZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTripleZeroActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        southPanel.add(btnTripleZero, gridBagConstraints);

        getContentPane().add(southPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void btnOneActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "1");
    }

    private void btnTwoActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "2");
    }

    private void btnThreeActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "3");
    }

    private void btnFourActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "4");
    }

    private void btnFiveActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "5");
    }

    private void btnSixActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "6");
    }

    private void btnSevenActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "7");
    }

    private void btnEightActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "8");
    }

    private void btnNineActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "9");
    }

    private void btnDotActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + ".");
    }

    private void btnZeroActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "0");
    }

    private void btnTripleZeroActionPerformed(ActionEvent evt) {
        txtAccount.setText(txtAccount.getText() + "000");
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        String account = txtAccount.getText();

        txtAccount.setText(txtAccount.getText().substring(0, account.length()-1));
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        txtAccount.setText("");
        txtPin.setText("");
    }

    private void btnEnterActionPerformed(ActionEvent evt) {
        String panel = getActivePanel();

        switch(panel){
            case "loginPanel": authenticateUser(); break;
            case "depositPanel": deposite(); break;
            case "withdrawPanel": withdraw(); break;
            case "balancePanel": balance(); break;
            case "transferPanel": System.out.println("transferPanel"); break;
            case "settingsPanel": System.out.println("settingsPanel"); break;
            case "statementPanel": System.out.println("statementPanel"); break;
        }
    }

    private void btnDepositActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "depositPanel");
        txtDeposit.requestFocusInWindow();
    }

    private void btnWithdrawActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "withdrawPanel");
        txtOption.requestFocusInWindow();
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(ATMGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }

        oPanel.show(this.operationPanel, "loginPanel");
    }

    private void btnBalanceActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "balancePanel");
        txtAvailable.requestFocusInWindow();
    }

    private void btnTransferActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "transferPanel");
    }

    private void btnSettingsActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "settingsPanel");
    }

    private void btnStatementActionPerformed(ActionEvent evt) {
        oPanel.show(this.operationPanel, "statementPanel");
    }

    private void enableButtons(boolean option){
        btnWithdraw.setEnabled(option);
        btnBalance.setEnabled(option);
        btnSettings.setEnabled(option);
        btnDeposit.setEnabled(option);
        btnTransfer.setEnabled(option);
        btnStatement.setEnabled(option);
        btnExit.setEnabled(option);
    }

    public String getActivePanel() {
        String panel = null;

        for(Component component : operationPanel.getComponents()){
            if(component.isVisible())
                panel = component.getName();
        }
        System.out.println(panel);

        return panel;
    }

    private void authenticateUser(){
        int accountNumber = Integer.parseInt(txtAccount.getText());
        int pin = Integer.parseInt(new String(txtPin.getPassword()));

        userAuthenticated = Authentication.isValidUser(accountNumber, pin);

        if (userAuthenticated){
            currentAccountNumber = accountNumber;

            JOptionPane.showMessageDialog(this.operationPanel, "User authenticated");

            oPanel.show(this.operationPanel, "welcomePanel");

            enableButtons(true);
        }
        else{
            JOptionPane.showMessageDialog(this.operationPanel,"Invalid account number or PIN.\nPlease try again.");
        }
    }

    public void deposite() {
        double deposit = Double.parseDouble(txtDeposit.getText());

        Transaction currentTransaction = createTransaction(DEPOSIT);
        ((Deposit)currentTransaction).execute(deposit);
    }

    public void withdraw() {
        String option = txtOption.getText();

        Transaction currentTransaction = createTransaction(WITHDRAW);
        ((Withdraw)currentTransaction).execute(Double.parseDouble(option));
    }

    public void balance() {
        Transaction currentTransaction = createTransaction(BALANCE);
        ((Balance)currentTransaction).execute(0D);
    }

    private Transaction createTransaction(int option) {
        Transaction transaction = null;

        switch(option) {
            case BALANCE:
                transaction = new Balance(currentAccountNumber, displayScreen, bank);
                break;
            case WITHDRAW:
                transaction = new Withdraw(currentAccountNumber, displayScreen, bank, keypad, cashDispenser);
                break;
            case DEPOSIT:
                transaction = new Deposit(currentAccountNumber, displayScreen, bank, keypad, depositSlot);
                break;
        }

        return (Transaction)transaction;
    }

    public static void setAvailableBalance(double amount) {
        txtAvailable.setText(amount + "");
    }

    public static void setTotalBalance(double amount) {
        txtTotal.setText(amount + "");
    }

    public static void setDepositAmount(String message) {
        lblDepositMessage.setText(message);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMGraphic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            new ATMGraphic().setVisible(true);
        });
    }
}
