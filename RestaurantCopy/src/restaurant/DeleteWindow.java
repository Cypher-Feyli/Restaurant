package restaurant;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import static restaurant.SQLDelete.*;

/**
 * Class: This is the Interface frame for deleting the restauran
 * @author Obada
 */
public class DeleteWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private String name, tel, address;

    /**
     * Create the frame.
     */
    public DeleteWindow(ResultPanel res) {
        initialize();
        textField.setText(res.name);
        textField_1.setText(res.address);
        textField_2.setText(res.tel);
    }

    public DeleteWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    
    public void initialize() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 364, 191);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel_3 = new JLabel("Delete");
        lblNewLabel_3.setForeground(SystemColor.window);
        lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 14));
        lblNewLabel_3.setIcon(new ImageIcon(DeleteWindow.class.getResource("/resources/Cancel-32.png")));
        lblNewLabel_3.setBounds(217, 137, 111, 46);
        lblNewLabel_3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Cursor cur1 = new Cursor(Cursor.HAND_CURSOR);
                lblNewLabel_3.setCursor(cur1);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                //add Restaurant
                deleteRestaurant(textField.getText(), textField_1.getText(), textField_2.getText());
                JOptionPane.showMessageDialog(null, "Delete Success!");
            }
        });
        contentPane.add(lblNewLabel_3);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                lblNewLabel_2.setIcon(new ImageIcon(AddWindow.class.getResource("/resources/closeButtonHover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblNewLabel_2.setIcon(new ImageIcon(AddWindow.class.getResource("/resources/closeButton.png")));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                dispose();
            }
        });
        lblNewLabel_2.setIcon(new ImageIcon(AddWindow.class.getResource("/resources/closeButton.png")));
        lblNewLabel_2.setBounds(328, 0, 26, 30);
        contentPane.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(85, 11, 209, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(85, 44, 209, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(85, 78, 209, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JTextPane txtpnNameAddress = new JTextPane();
        txtpnNameAddress.setForeground(SystemColor.inactiveCaptionBorder);
        txtpnNameAddress.setFont(new Font("Stencil", Font.PLAIN, 14));
        txtpnNameAddress.setOpaque(false);
        txtpnNameAddress.setText("Name:\r\n\r\nAddress :\r\n\r\nTel:");
        txtpnNameAddress.setBackground(SystemColor.control);
        txtpnNameAddress.setEditable(false);
        txtpnNameAddress.setBounds(10, 11, 102, 239);
        contentPane.add(txtpnNameAddress);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(AddWindow.class.getResource("/resources/TestBackground.png")));
        lblNewLabel.setBounds(-476, -25, 845, 403);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(282, 153, 46, 14);
        contentPane.add(lblNewLabel_1);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResultPanel res = new ResultPanel("gf", "gf", "gf", "gf");
                    EditWindow frame = new EditWindow(res);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
