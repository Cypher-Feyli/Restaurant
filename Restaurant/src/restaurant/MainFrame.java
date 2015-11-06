package restaurant;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;

import java.awt.Component;
import java.awt.Cursor;
import java.sql.SQLException;
import javafx.scene.paint.Color;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import static restaurant.SQLStringReturn.*;

public class MainFrame {

	public JFrame frame;
        public JTabbedPane tabbedPane;
        private String[] name,tel,address;

	
	/**
	 * Create the application.
	 */
	public MainFrame() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(902, 600);
                frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
                frame.setResizable(false);
                frame.setUndecorated(true);
                
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
                panel.setBackground(java.awt.Color.DARK_GRAY);
                
                JLabel ExitTool = new JLabel("");
                ExitTool.setBounds(867, 1, 40, 40);
		ExitTool.addMouseListener(new MouseAdapter() {
                    
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cur1 = new Cursor(Cursor.HAND_CURSOR);
				ExitTool.setCursor(cur1);
                                ExitTool.setIcon(new ImageIcon(getClass().getResource("/resources/closeButtonHover.png")));
			}
                        @Override
                        public void mouseExited(MouseEvent e){
                            ExitTool.setIcon(new ImageIcon(getClass().getResource("/resources/closeButton.png")));
                        }
		});
		ExitTool.setIcon(new ImageIcon(getClass().getResource("/resources/closeButton.png")));
		panel.add(ExitTool);
                
                JFormattedTextField UserLogin = new JFormattedTextField();
		UserLogin.setText(" Username/Email");
                UserLogin.setBackground(java.awt.Color.DARK_GRAY);
                UserLogin.setForeground(java.awt.Color.WHITE);
		UserLogin.setBounds(10, 3, 122, 20);
		panel.add(UserLogin);

		JPasswordField PassLogin = new JPasswordField();
		PassLogin.setBounds(142, 3, 128, 20);
                PassLogin.setBackground(java.awt.Color.DARK_GRAY);
                PassLogin.setForeground(java.awt.Color.WHITE);
		PassLogin.setText("jjjjjjjjjjjj");
		panel.add(PassLogin);

		JButton EnterLogin = new JButton("Enter");
		EnterLogin.setBounds(280, 3, 89, 20);
		panel.add(EnterLogin);
                EnterLogin.addMouseListener(new MouseAdapter() {
                    
			@Override
			public void mouseClicked(MouseEvent e) {
                            JOptionPane.showMessageDialog(null, "This action is not yet applicable");
			}
		});
                
                
                JTextField searchbar = new JTextField();
		searchbar.setBounds(33, 60, 174, 20);
                searchbar.setText("Enter search terms here");
                searchbar.setFont(new Font("Arial", Font.ITALIC, 13));
                searchbar.setBorder(null);
		panel.add(searchbar);
		searchbar.setColumns(10);
                searchbar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
                searchbar.setText("");
			}
		});
                
                
		JTextPane txtpnPleaseSelectThe = new JTextPane();
		txtpnPleaseSelectThe.setEditable(false);
		txtpnPleaseSelectThe.setOpaque(false);
		txtpnPleaseSelectThe.setFont(new Font("Arial", Font.BOLD, 14));
		txtpnPleaseSelectThe.setText("Please select the cuisine");
                txtpnPleaseSelectThe.setForeground(java.awt.Color.white);
		txtpnPleaseSelectThe.setBounds(50, 107, 318, 20);
		panel.add(txtpnPleaseSelectThe);
		
		JComboBox cuisinecomboBox = new JComboBox(selectCuisine());
		cuisinecomboBox.setBounds(53, 135, 150, 20);
                cuisinecomboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		panel.add(cuisinecomboBox);
                
		JTextPane txtpnSelectBudget = new JTextPane();
		txtpnSelectBudget.setOpaque(false);
		txtpnSelectBudget.setEditable(false);
		txtpnSelectBudget.setFont(new Font("Arial", Font.BOLD, 15));
		txtpnSelectBudget.setText("Select budget");
                txtpnSelectBudget.setForeground(java.awt.Color.white);
		txtpnSelectBudget.setBounds(50, 200, 197, 25);
		panel.add(txtpnSelectBudget);
		
		JCheckBox sek15_20 = new JCheckBox("15-50 SEK");
		sek15_20.setBounds(53, 225, 109, 23);
                sek15_20.setOpaque(false);
                sek15_20.setFont(new Font("Arial", Font.PLAIN, 13));
                sek15_20.setForeground(java.awt.Color.white);
		panel.add(sek15_20);
		
		JCheckBox sek50_75 = new JCheckBox("50-75 SEK");
		sek50_75.setBounds(53, 255, 109, 23);
                sek50_75.setOpaque(false);
                sek50_75.setFont(new Font("Arial", Font.PLAIN, 13));
                sek50_75.setForeground(java.awt.Color.white);
		panel.add(sek50_75);
		
		JCheckBox sek75_125 = new JCheckBox("75-125 SEK");
		sek75_125.setBounds(53, 285, 109, 23);
                sek75_125.setOpaque(false);
                sek75_125.setFont(new Font("Arial", Font.PLAIN, 13));
                sek75_125.setForeground(java.awt.Color.white);
		panel.add(sek75_125);
		
		ButtonGroup btnG=new ButtonGroup();
		btnG.add(sek15_20);
		sek15_20.setSelected(true);
		btnG.add(sek50_75);
		btnG.add(sek75_125);
		
		JButton selectbutton = new JButton("Select");
                selectbutton.setBounds(50, 340, 253, 29);
		selectbutton.addMouseListener(new MouseAdapter() {
                        
			@Override
			public void mousePressed(MouseEvent e) {
                        //Selected cuisine in combobox placed in variable cuisine
                		String cuisine = cuisinecomboBox.getSelectedItem().toString();
                		
                		//Gets Name address and phone of all restaurants that been 
                		//filterde out with SQL filtering query in the class SQLFilter.  
                		String[] restName = selectFilterCuisineName(cuisine);
                		String[] address = selectFilterCuisineAddress(cuisine);
                		String[] phone = selectFilterCuisinePhone(cuisine);
                		
                		//If the tabbedPane is empty puts restaurant names in to tabbs
                		//and puts restaurant information into ResultPanel.
                		if (tabbedPane.getSelectedIndex() == -1) {
                		for(int i = 0; i < restName.length; i++){  
                            getResultPanel(tabbedPane, restName[i], phone[i], address[i]);
                            }
                		}
                		//If the tabbedPane is not empty. Empties the tabbedPane
                		// first and than puts restaurant names in to tabbs
                		//and puts restaurant information into ResultPanel.
                		else {
                			tabbedPane.removeAll();
                			for(int i = 0; i < restName.length; i++){  
                                getResultPanel(tabbedPane, restName[i], phone[i], address[i]);
                                }
                		}
			}
		});
		
		panel.add(selectbutton);
                
                JList jpanel = new JList(selectRestName());
                jpanel.setBounds(207, 31, 567, 357);
                JScrollPane jscroll = new JScrollPane(jpanel);
                panel.add(jscroll);
                
                tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
                tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPane.setBounds(310, 67, 560, 510);
                tabbedPane.setBackground(java.awt.Color.white);
		panel.add(tabbedPane);
                
                
                JLabel backgroundlayout = new JLabel("");
                backgroundlayout.setIcon(new ImageIcon(getClass().getResource("/resources/TestBackground.png")));
                backgroundlayout.setBounds(0, 0, 902, 608);
                panel.add(backgroundlayout);
                
                name = selectRestName();
                tel = selectRestTel();
                address = selectRestAddress();
                
		for(int i = 0; i < 50; i++){  
                getResultPanel(tabbedPane, name[i], tel[i], address[i]);
                }
                 
        }
        
        private static void getResultPanel(JTabbedPane tabbedPane, String name, String tel, String address){
            tabbedPane.addTab(name, new ImageIcon("C:\\Users\\Beroo94\\Desktop\\restaurant_12_2x.png"), new ResultPanel(name, tel, address));
        }
        
        private static JTabbedPane getJTabbedPane(){
            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setToolTipText("Hello\r\n");
            tabbedPane.setBounds(207, 31, 567, 352);
            
            return tabbedPane;
        }
                
                

    private Object getclass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
        
}
