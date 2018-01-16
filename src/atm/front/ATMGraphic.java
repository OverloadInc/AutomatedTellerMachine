package atm.front;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

public class ATMGraphic extends JFrame {
    private JPanel atmPanel;
    private JPanel balancePanel;
    private JButton balances;
    private JButton button0;
    private JButton button000;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonX;
    private JButton buttonZ;
    private JButton cancel;
    private JButton delete;
    private JButton deposit;
    private JPanel depositPanel;
    private JButton enter;
    private JButton exit;
    private JLabel lblAtm;
    private JLabel lblBBalance;
    private JLabel lblWAmount;
    private JLabel lblWBalance;
    private JPanel mainPanel;
    private JPanel numberPanel;
    private JPanel operationPanel;
    private JButton settings;
    private JButton statement;
    private JButton transfer;
    private JTextField txtBBalance;
    private JTextField txtWAmount;
    private JTextField txtWBalance;
    private JPanel userPanel;
    private JPanel welcomePanel;
    private JButton withdraw;
    private JPanel withdrawPanel;

    public ATMGraphic() {
        this.initComponents();
    }

    private void initComponents() {
        this.atmPanel = new JPanel();
        this.lblAtm = new JLabel();
        this.numberPanel = new JPanel();
        this.button1 = new JButton();
        this.button2 = new JButton();
        this.button3 = new JButton();
        this.delete = new JButton();
        this.button4 = new JButton();
        this.button5 = new JButton();
        this.button6 = new JButton();
        this.cancel = new JButton();
        this.button7 = new JButton();
        this.button8 = new JButton();
        this.button9 = new JButton();
        this.enter = new JButton();
        this.buttonX = new JButton();
        this.button0 = new JButton();
        this.button000 = new JButton();
        this.buttonZ = new JButton();
        this.operationPanel = new JPanel();
        this.deposit = new JButton();
        this.transfer = new JButton();
        this.statement = new JButton();
        this.exit = new JButton();
        this.userPanel = new JPanel();
        this.withdraw = new JButton();
        this.balances = new JButton();
        this.settings = new JButton();
        this.mainPanel = new JPanel();
        this.welcomePanel = new JPanel();
        this.withdrawPanel = new JPanel();
        this.lblWBalance = new JLabel();
        this.txtWBalance = new JTextField();
        this.lblWAmount = new JLabel();
        this.txtWAmount = new JTextField();
        this.balancePanel = new JPanel();
        this.lblBBalance = new JLabel();
        this.txtBBalance = new JTextField();
        this.depositPanel = new JPanel();
        this.setDefaultCloseOperation(3);
        this.setTitle("Automated Teller Machine");
        this.setName("frmATM");
        this.setResizable(false);
        this.atmPanel.setName("atmPanel");
        this.atmPanel.setPreferredSize(new Dimension(500, 500));
        this.atmPanel.setLayout(new BorderLayout(10, 10));
        this.lblAtm.setFont(new Font("Ubuntu", 1, 15));
        this.lblAtm.setHorizontalAlignment(0);
        this.lblAtm.setText("Automated Teller Machine");
        this.lblAtm.setName("lblAtm");
        this.atmPanel.add(this.lblAtm, "First");
        this.numberPanel.setName("numberPanel");
        this.numberPanel.setLayout(new GridLayout(4, 4, 5, 5));
        this.button1.setText("1");
        this.button1.setName("button1");
        this.numberPanel.add(this.button1);
        this.button2.setText("2");
        this.button2.setName("button2");
        this.numberPanel.add(this.button2);
        this.button3.setText("3");
        this.button3.setName("button3");
        this.numberPanel.add(this.button3);
        this.delete.setText("Delete");
        this.delete.setName("delete");
        this.numberPanel.add(this.delete);
        this.button4.setText("4");
        this.button4.setName("button4");
        this.numberPanel.add(this.button4);
        this.button5.setText("5");
        this.button5.setName("button5");
        this.numberPanel.add(this.button5);
        this.button6.setText("6");
        this.button6.setName("button6");
        this.numberPanel.add(this.button6);
        this.cancel.setText("Cancel");
        this.cancel.setName("cancel");
        this.numberPanel.add(this.cancel);
        this.button7.setText("7");
        this.button7.setName("button7");
        this.numberPanel.add(this.button7);
        this.button8.setText("8");
        this.button8.setName("button8");
        this.numberPanel.add(this.button8);
        this.button9.setText("9");
        this.button9.setName("button9");
        this.numberPanel.add(this.button9);
        this.enter.setText("Enter");
        this.enter.setName("enter");
        this.numberPanel.add(this.enter);
        this.buttonX.setEnabled(false);
        this.buttonX.setName("buttonX");
        this.numberPanel.add(this.buttonX);
        this.button0.setText("0");
        this.button0.setName("button0");
        this.numberPanel.add(this.button0);
        this.button000.setText("000");
        this.button000.setName("button000");
        this.numberPanel.add(this.button000);
        this.buttonZ.setEnabled(false);
        this.buttonZ.setName("buttonZ");
        this.numberPanel.add(this.buttonZ);
        this.atmPanel.add(this.numberPanel, "South");
        this.operationPanel.setName("operationPanel");
        this.operationPanel.setLayout(new GridLayout(6, 1, 5, 20));
        this.deposit.setText("Deposit");
        this.deposit.setName("deposit");
        this.operationPanel.add(this.deposit);
        this.transfer.setText("Transfer");
        this.transfer.setName("transfer");
        this.operationPanel.add(this.transfer);
        this.statement.setText("Mini statement");
        this.statement.setName("statement");
        this.operationPanel.add(this.statement);
        this.exit.setText("Exit");
        this.exit.setName("exit");
        this.operationPanel.add(this.exit);
        this.atmPanel.add(this.operationPanel, "After");
        this.userPanel.setName("userPanel");
        this.userPanel.setLayout(new GridLayout(6, 1, 5, 20));
        this.withdraw.setText("Withdraw");
        this.withdraw.setName("withdraw");
        this.withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ATMGraphic.this.withdrawActionPerformed(evt);
            }
        });
        this.userPanel.add(this.withdraw);
        this.balances.setText("Balances");
        this.balances.setName("balances");
        this.balances.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ATMGraphic.this.balancesActionPerformed(evt);
            }
        });
        this.userPanel.add(this.balances);
        this.settings.setText("Settings");
        this.settings.setName("settings");
        this.userPanel.add(this.settings);
        this.atmPanel.add(this.userPanel, "Before");
        this.mainPanel.setBorder(BorderFactory.createTitledBorder(""));
        this.mainPanel.setName("mainPanel");
        this.mainPanel.setLayout(new CardLayout());
        this.welcomePanel.setName("welcomePanel");
        GroupLayout welcomePanelLayout = new GroupLayout(this.welcomePanel);
        this.welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(welcomePanelLayout.createParallelGroup(Alignment.LEADING).addGap(0, 281, 32767));
        welcomePanelLayout.setVerticalGroup(welcomePanelLayout.createParallelGroup(Alignment.LEADING).addGap(0, 327, 32767));
        this.mainPanel.add(this.welcomePanel, "welcomeCard");
        this.withdrawPanel.setName("withdrawPanel");
        GridBagLayout withdrawPanelLayout = new GridBagLayout();
        withdrawPanelLayout.columnWeights = new double[]{0.0D};
        withdrawPanelLayout.rowWeights = new double[]{0.0D};
        this.withdrawPanel.setLayout(withdrawPanelLayout);
        this.lblWBalance.setHorizontalAlignment(0);
        this.lblWBalance.setText("Balance");
        this.lblWBalance.setName("lblWBalance");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 2;
        this.withdrawPanel.add(this.lblWBalance, gridBagConstraints);
        this.txtWBalance.setHorizontalAlignment(0);
        this.txtWBalance.setName("txtWBalance");
        this.txtWBalance.setPreferredSize(new Dimension(80, 27));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 2;
        this.withdrawPanel.add(this.txtWBalance, gridBagConstraints);
        this.lblWAmount.setHorizontalAlignment(0);
        this.lblWAmount.setText("Withdrawal amount");
        this.lblWAmount.setHorizontalTextPosition(0);
        this.lblWAmount.setName("lblWAmount");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = 2;
        this.withdrawPanel.add(this.lblWAmount, gridBagConstraints);
        this.txtWAmount.setHorizontalAlignment(0);
        this.txtWAmount.setName("txtWAmount");
        this.txtWAmount.setPreferredSize(new Dimension(80, 27));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = 2;
        this.withdrawPanel.add(this.txtWAmount, gridBagConstraints);
        this.mainPanel.add(this.withdrawPanel, "withdrawCard");
        this.balancePanel.setName("balancePanel");
        GridBagLayout balancePanelLayout = new GridBagLayout();
        balancePanelLayout.columnWeights = new double[]{0.0D};
        balancePanelLayout.rowWeights = new double[]{0.0D};
        this.balancePanel.setLayout(balancePanelLayout);
        this.lblBBalance.setHorizontalAlignment(0);
        this.lblBBalance.setText("Balance");
        this.lblBBalance.setName("lblBBalance");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 2;
        this.balancePanel.add(this.lblBBalance, gridBagConstraints);
        this.txtBBalance.setHorizontalAlignment(0);
        this.txtBBalance.setName("txtBBalance");
        this.txtBBalance.setPreferredSize(new Dimension(150, 27));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = 2;
        this.balancePanel.add(this.txtBBalance, gridBagConstraints);
        this.mainPanel.add(this.balancePanel, "balanceCard");
        this.depositPanel.setName("depositPanel");
        GroupLayout depositPanelLayout = new GroupLayout(this.depositPanel);
        this.depositPanel.setLayout(depositPanelLayout);
        depositPanelLayout.setHorizontalGroup(depositPanelLayout.createParallelGroup(Alignment.LEADING).addGap(0, 281, 32767));
        depositPanelLayout.setVerticalGroup(depositPanelLayout.createParallelGroup(Alignment.LEADING).addGap(0, 327, 32767));
        this.mainPanel.add(this.depositPanel, "depositCard");
        this.atmPanel.add(this.mainPanel, "Center");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.atmPanel, -2, 500, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.atmPanel, -2, 500, -2).addGap(0, 0, 32767)));
        this.pack();
    }

    private void withdrawActionPerformed(ActionEvent evt) {
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, "withdrawCard");
    }

    private void balancesActionPerformed(ActionEvent evt) {
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, "balanceCard");
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(ATMGraphic.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(ATMGraphic.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(ATMGraphic.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(ATMGraphic.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new ATMGraphic()).setVisible(true);
            }
        });
    }
}
