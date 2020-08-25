
package oto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import javax.swing.JScrollPane;
import javax.swing.JSpinner; 
import javax.swing.ButtonGroup; 
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;  
import javax.swing.JTextField; 

import java.awt.Font; 
import javax.swing.UIManager;  
import java.awt.Image;
import javax.swing.JRadioButton; 
import javax.swing.SpinnerNumberModel;
import java.awt.Component; 
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants; 
import net.miginfocom.swing.MigLayout;
import javax.swing.SpinnerDateModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 

public class AnaEkran extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private JPanel panel,icerik;
	private JButton bt[];
	private JButton add;
	private JButton search;
	private AutoPark ap;
	private int kapasiti;
	private double ucret;
	private JButton uyebutonu;
	private JTextField plaka;
	private JPanel ara;
	private JLabel lblAraPlakas;
	private JButton btnAra,tmp;
	private JPanel ekle;
	private JLabel label;
	private JTextField plakaekle;
	private JButton btnEkle;
	private Image regulari,officiali,subsi;
	private LinkedList<Vehicle> arabalar; 
	private JLabel totallb;
	private JLabel income;
	private JPanel uyelik;
	private JTextField uyeplaka;
	private JSpinner gun1;
	private JSpinner ay1;
	private JSpinner yıl1;
	private JLabel lblNewLabel;
	private JLabel lblAy;
	private JLabel lblYl;
	private JLabel label_2;
	private JSpinner gun2;
	private JLabel label_3;
	private JSpinner ay2;
	private JSpinner yıl2;
	private JLabel label_4;
	private JButton degistir;
	private JButton ucretdegis;
	private JTextField saatlik;
	private JLabel lblSaatlikcret;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnaEkran() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1415, 940);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JFrame jf=this;
		
		kapasiti=50;
		ucret=10;
		
		arabalar=new LinkedList<Vehicle>();  
		ap= new AutoPark(ucret, kapasiti);
		contentPane.setLayout(null);
		
		search = new JButton("Araç Ara");
		search.setBounds(50, 400, 150, 75);
		contentPane.add(search);
		 
		
		JLabel capacitylb = new JLabel("Kapasite : ");
		
		capacitylb.setBounds(368, 13, 86, 29);
		contentPane.add(capacitylb);
		
		totallb = new JLabel("Toplam Araç Sayısı : " + ap.getParkRecordsIndex() );
		totallb.setBounds(917, 13, 184, 29);
		contentPane.add(totallb);
		
		uyebutonu = new JButton("Üyelik İşlemleri");

		uyebutonu.setBounds(50, 600, 150, 75);
		uyebutonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(!uyelik.isVisible()) {
					uyelik.setVisible(true);
					uyebutonu.setLocation(uyebutonu.getLocation().x, 500);
					
				} 
				else {
					uyebutonu.setLocation(uyebutonu.getLocation().x, 600);
					uyelik.setVisible(false);
				}
			}
		});
		contentPane.add(uyebutonu);
		
		ara = new JPanel();
		ara.setBounds(10, 400, 316, 100);
		ara.setVisible(false);
		contentPane.add(ara);
		ara.setLayout(null);
		
		plaka = new JTextField();
		plaka.setBounds(12, 49, 165, 37);
		ara.add(plaka);
		plaka.setColumns(10);
		
		lblAraPlakas = new JLabel("Araç Plakası");
		lblAraPlakas.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
		lblAraPlakas.setBounds(12, 13, 165, 23);
		ara.add(lblAraPlakas);
		
		btnAra = new JButton("Ara");
		
		btnAra.setBounds(205, 48, 97, 38);
		ara.add(btnAra);
		
				//scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
				
				panel = new JPanel();
				panel.setBounds(378, 74, 1007, 718);
				panel.setBackground(UIManager.getColor("ToggleButton.light"));
				contentPane.add(panel);
				JScrollPane sc=new JScrollPane();
				sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
				sc.setAlignmentY(Component.TOP_ALIGNMENT);
				sc.setAlignmentX(Component.LEFT_ALIGNMENT);
				
				
				
				ButtonGroup bg=new ButtonGroup();
				
				add = new JButton("Araç Girişi Yap");
				add.setBounds(50, 50, 150, 75);
				contentPane.add(add);
				
			 
				
				ekle = new JPanel();
				ekle.setBounds(12, 50, 341, 174);
				ekle.setVisible(false);
				contentPane.add(ekle);
				ekle.setLayout(null);
				
				JRadioButton normal = new JRadioButton("Normal Araç");
				normal.setSelected(true);
				normal.setBounds(8, 41, 127, 25);
				ekle.add(normal);
				bg.add(normal);
				
				JRadioButton resmi = new JRadioButton("Resmi Araç");
				resmi.setBounds(8, 71, 127, 25);
				ekle.add(resmi);
				bg.add(resmi);
				
				JRadioButton abone = new JRadioButton("Abone Araç");
				abone.setBounds(8, 100, 127, 25);
				ekle.add(abone);
				bg.add(abone);
				
				JLabel lblSaat = new JLabel("Saat");
				lblSaat.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
				lblSaat.setBounds(18, 136, 52, 38);
				ekle.add(lblSaat);
				
				

				 Calendar time = Calendar.getInstance(); 
				JSpinner dakika = new JSpinner();
				dakika.setModel(new SpinnerNumberModel(0, 0, 59, 1));
				dakika.setBounds(133, 138, 58, 30);
				ekle.add(dakika);
				 
				
				dakika.setValue((Object)time.get(Calendar.MINUTE));
				
				JSpinner saat = new JSpinner();

				saat.setModel(new SpinnerNumberModel(0, 0, 23, 1));
				saat.setBounds(73, 138, 58, 30);
				ekle.add(saat);

				saat.setValue((Object)time.get(Calendar.HOUR_OF_DAY));		 
				label = new JLabel("Araç Plakası");
				label.setBounds(22, 5, 135, 38);
				label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
				ekle.add(label);
				
				plakaekle = new JTextField();
				plakaekle.setBounds(137, 5, 190, 38);
				plakaekle.setColumns(10);
				ekle.add(plakaekle);
				
				btnEkle = new JButton("Ekle");
				
				btnEkle.setBounds(248, 122, 93, 38);
				ekle.add(btnEkle);
				
				income = new JLabel("Günlük Gelir : " + ap.getIncomeDaily());
				income.setBounds(1113, 13, 184, 29);
				contentPane.add(income);
				
				JPanel grid = new JPanel();
				grid.setMaximumSize(new Dimension(1200, 32767));
				grid.setAlignmentY(Component.TOP_ALIGNMENT);
				grid.setAlignmentX(Component.LEFT_ALIGNMENT);
				grid.setBounds(56, 237, 281, 124);
				sc.setViewportView(grid);
				grid.setLayout(new MigLayout("", "[305px]", "[3716px]"));
				
				icerik=new JPanel();
				icerik.setMaximumSize(new Dimension(1000, 32767));
				icerik.setAlignmentY(Component.TOP_ALIGNMENT);
				icerik.setAlignmentX(Component.LEFT_ALIGNMENT);
				icerik.setAutoscrolls(true);
				grid.add(icerik, "cell 0 0,grow");
				icerik.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(sc, GroupLayout.PREFERRED_SIZE, 1007, GroupLayout.PREFERRED_SIZE)
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(sc, GroupLayout.PREFERRED_SIZE, 718, GroupLayout.PREFERRED_SIZE)
				);
				panel.setLayout(gl_panel);
				
				uyelik = new JPanel();
				uyelik.setVisible(false);
				uyelik.setBounds(10, 548, 341, 294);
				contentPane.add(uyelik);
				uyelik.setLayout(null);
				
				JLabel label_1 = new JLabel("Araç Plakası");
				label_1.setBounds(12, 38, 90, 26);
				label_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
				uyelik.add(label_1);
				
				JButton btnUyeEkle = new JButton("Uye Ekle");
				btnUyeEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					Date giris = new Date((int)gun1.getValue(), (int)ay1.getValue(), (int)yıl1.getValue());
					Date cikis = new Date((int)gun2.getValue(), (int)ay2.getValue(), (int)yıl2.getValue());
					
					if(ap.searchVehicle(uyeplaka.getText())==null){
				 	Subscription sb=new Subscription(giris,cikis , uyeplaka.getText());
				 	SubscribedVehicle sv=new SubscribedVehicle(uyeplaka.getText(), sb);
				 	ap.addVehicle(sv);
					JOptionPane.showMessageDialog(jf, "Kayıt Oluşturuldu");
					}
					else
					{ 
				
					  ap.searchVehicle(uyeplaka.getText()).getSubscription().setBegin(giris);
					  ap.searchVehicle(uyeplaka.getText()).getSubscription().setEnd(cikis);
					  JOptionPane.showMessageDialog(jf, "Kayıt Güncellendi");
					}
					}
				});
				btnUyeEkle.setBounds(244, 256, 97, 38);
				uyelik.add(btnUyeEkle);
				
				uyeplaka = new JTextField();
				uyeplaka.setColumns(10);
				uyeplaka.setBounds(119, 35, 165, 37);
				uyelik.add(uyeplaka);
				
				JLabel lblBitiTarihi = new JLabel("Bitiş Tarihi");
				lblBitiTarihi.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
				lblBitiTarihi.setBounds(12, 184, 116, 26);
				uyelik.add(lblBitiTarihi);
				
				JLabel lblBalangTarihi = new JLabel("Başlangıç Tarihi");
				lblBalangTarihi.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
				lblBalangTarihi.setBounds(12, 107, 137, 26);
				uyelik.add(lblBalangTarihi);
				
				gun1 = new JSpinner();
				gun1.setModel(new SpinnerNumberModel(1, 1, 30, 1));
				gun1.setBounds(49, 141, 58, 30);
				uyelik.add(gun1);
				
				ay1 = new JSpinner();
				ay1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				ay1.setBounds(140, 141, 58, 30);
				uyelik.add(ay1);
				
				yıl1 = new JSpinner();
		
				yıl1.setModel(new SpinnerNumberModel(2018, 2018, 2150, 0));
				yıl1.setBounds(244, 141, 58, 30);
				JSpinner.NumberEditor editor = new JSpinner.NumberEditor(yıl1, "#");
				yıl1.setEditor(editor);
				uyelik.add(yıl1);
				
				lblNewLabel = new JLabel("Gün");
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				lblNewLabel.setBounds(22, 133, 33, 46);
				uyelik.add(lblNewLabel);
				
				lblAy = new JLabel("Ay");
				lblAy.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				lblAy.setBounds(119, 133, 33, 46);
				uyelik.add(lblAy);
				
				lblYl = new JLabel("Yıl");
				lblYl.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				lblYl.setBounds(210, 133, 33, 46);
				uyelik.add(lblYl);
				
				label_2 = new JLabel("Gün");
				label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				label_2.setBounds(22, 210, 33, 46);
				uyelik.add(label_2);
				
				gun2 = new JSpinner();
				gun2.setModel(new SpinnerNumberModel(1, 1, 30, 1));
				gun2.setBounds(49, 218, 58, 30);
				uyelik.add(gun2);
				
				label_3 = new JLabel("Ay");
				label_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				label_3.setBounds(119, 210, 33, 46);
				uyelik.add(label_3);
				
				ay2 = new JSpinner();
				ay2.setModel(new SpinnerNumberModel(1, 1, 12, 1));
				ay2.setBounds(140, 218, 58, 30);
				uyelik.add(ay2);
				
				yıl2 = new JSpinner();
				yıl2.setModel(new SpinnerNumberModel(2018, 2018, 2150, 1));
				yıl2.setBounds(244, 218, 58, 30);
				 editor = new JSpinner.NumberEditor(yıl2, "#");
				yıl2.setEditor(editor);
				
				uyelik.add(yıl2);
				
				label_4 = new JLabel("Yıl");
				label_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				label_4.setBounds(210, 210, 33, 46);
				uyelik.add(label_4);
				
				JTextField kapasite = new JTextField();
				kapasite.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						degistir.setVisible(true);
					}
				});
			 
				kapasite.setBounds(438, 16, 64, 22);
				contentPane.add(kapasite);
				kapasite.setColumns(10);
				kapasite.setText(String.valueOf(kapasiti));
				
		
				
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 
				if(!ekle.isVisible()) {
					 add.setLocation(add.getLocation().x, 225);
					 ekle.setVisible(true);
				}else {
					 add.setLocation(add.getLocation().x, 50);
					 ekle.setVisible(false);
					
				}
					 
				
			}
		});
		
		
		JButton bt[]=new JButton[500];
		
		for(int i =0;i<kapasiti;i++) 
			bt[i] = new JButton("Alan " + (i+1)); 		
								
		createArea(bt);
	 

		String regular = "/img/normalcar.png";
		String official= "/img/official.png";
		String subs = "/img/subscribedcar.png";
	 
		regulari=new ImageIcon(this.getClass().getResource(regular)).getImage();
	    officiali=new ImageIcon(this.getClass().getResource(official)).getImage();
	    subsi=new ImageIcon(this.getClass().getResource(subs)).getImage();
 
				
			  
		
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(kapasiti>ap.getParkRecordsIndex()){
				if(!ap.isParked(plakaekle.getText())) {
					if(normal.isSelected()) { 
					RegularVehicle v = new RegularVehicle(plakaekle.getText()); 
					ap.vehicleEnters(v.getPlate(),new Time((int)saat.getValue(),(int)dakika.getValue()),v.isOfficial());
					
					arabalar.add(v);
					}
					else if(resmi.isSelected()) {
					OfficialVehicle v=new OfficialVehicle(plakaekle. getText());
					arabalar.add(v);
					ap.vehicleEnters(v.getPlate(),new Time((int)saat.getValue(),(int)dakika.getValue()),v.isOfficial());
					
					}
					else {
						
						SubscribedVehicle sv=ap.searchVehicle(plakaekle.getText());
						if(sv!=null) {	
							
							if(sv.getSubscription().isValid()) {
							arabalar.add(sv);
							ap.vehicleEnters(sv.getPlate(),new Time((int)saat.getValue(),(int)dakika.getValue()),sv.isOfficial());
							}
							else
								JOptionPane.showMessageDialog(jf, "Kaydın üyelik süresi doldu.");
						 }
						else {
							JOptionPane.showMessageDialog(jf, "Bu plakada Kayıtlı bir araç bulunamadı.");
						}
						
					}
						 
						 
					totallb.setText("Toplam Araç Sayısı : " + arabalar.size());
					yenile(bt); 
				}
		
				else
					JOptionPane.showMessageDialog(jf, "Bu plakada kayıtlı bir araç var.");
				}	else
						JOptionPane.showMessageDialog(jf, "Garaj Kapasitesi Dolu");
			
				
			}
		});		
		 
		
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ap.isParked(plaka.getText())) {
					JOptionPane.showMessageDialog(jf, "Aranan Araç Bulunamadı.");
					System.out.println(plaka.getText());
				}
				else {
					for(JButton btn: bt) {
						btn.setVisible(false);
					}
					tmp=new JButton(plaka.getText());
					tmp.setPreferredSize(new Dimension(250,150));
					icerik.add(tmp); 	
					for(Vehicle ar: arabalar)
						if(ar.getPlate().equals(plaka.getText())){  
								if(ar.getClass().toString().equals("class oto.RegularVehicle"))
									tmp.setIcon(new ImageIcon(regulari));
								else if(ar.getClass().toString().equals("class oto.SubscribedVehicle"))
									tmp.setIcon(new ImageIcon(subsi));
								else
									tmp.setIcon(new ImageIcon(officiali));	
						}
					tmp.addActionListener(new java.awt.event.ActionListener() {
					    public void actionPerformed(java.awt.event.ActionEvent evt) {
					           jButtonActionPerformed(evt,bt);
								 search.setLocation(search.getLocation().x, 400);
								 ara.setVisible(false);
								 search.setText("Araç Ara");
								 search.setText("Tümünü Göster");
									for(JButton btn: bt) {
										btn.setVisible(true);
									}
									if(tmp!=null)
										tmp.setVisible(false);
					           
					    }
					});
				
				}
			}
		});
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ara.isVisible()) {
				 search.setLocation(search.getLocation().x, 300);
				 ara.setVisible(true);
				 search.setText("Tümünü Göster");
				
				}
				else
				{
					 search.setLocation(search.getLocation().x, 400);
					 ara.setVisible(false);
					 search.setText("Araç Ara");
						for(JButton btn: bt) {
							btn.setVisible(true);
						}
						if(tmp!=null)
							tmp.setVisible(false);
					 
				}
			}
		});
		 
		for(int i=0;i<kapasiti-1;i++)
		{
			bt[i].addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		           jButtonActionPerformed(evt,bt);
		    }
		});
			}
		
		System.out.println(ap.toString());
		
		
		degistir = new JButton("Degistir");
		degistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				degistir.setVisible(false);
				try {
				if(arabalar.size()<=Integer.parseInt(kapasite.getText())) {
				kapasiti=Integer.parseInt(kapasite.getText());
				ap.setCapacity(kapasiti);
				 createArea(bt);   
					JOptionPane.showMessageDialog(jf, "Otopark Kapasitesi Degistirildi");
				}
				else  
					JOptionPane.showMessageDialog(jf, "Once icerideki araçları çıkarın");
				}
			 
			 catch (Exception e) { 

					JOptionPane.showMessageDialog(jf,"Uygun Bir Sayı Girilmedi");
			}
				
			}
		});
		degistir.setVisible(false);
		degistir.setBounds(514, 15, 86, 22);
		contentPane.add(degistir);
		
		ucretdegis = new JButton("degistir");
		ucretdegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ucretdegis.setVisible(false);
				 try {
				ucret=Float.parseFloat(saatlik.getText().replaceAll(",","."));
				ucret=Math.round(ucret*100);
				ucret/=100;
				ap.setHourlyFee(ucret); 
				JOptionPane.showMessageDialog(jf, "Saatlik Fiyat "+ ucret +" TL Olarak Güncellendi");
				 }
				 catch (Exception e) { 

						JOptionPane.showMessageDialog(jf,"Uygun Bir Ücret Girilmedi");
				}
			}
		});
		ucretdegis.setVisible(false);
		ucretdegis.setBounds(788, 16, 86, 22);
		contentPane.add(ucretdegis);
		
		saatlik = new JTextField();
		saatlik.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ucretdegis.setVisible(true);
			}
		});
		saatlik.setBounds(712, 16, 64, 22);
		contentPane.add(saatlik);
		saatlik.setColumns(10);

		saatlik.setText(Double.toString(ucret));
		lblSaatlikcret = new JLabel("Saatlik Ücret : ");
		lblSaatlikcret.setBounds(614, 13, 86, 29);
		contentPane.add(lblSaatlikcret);
	
	}
	
	
	
	
	
	public void yenile(JButton bt[]){
		
		int i;
		
		for(i=0;i<arabalar.size();i++) {
			bt[i].setText(arabalar.get(i).getPlate());
			if(arabalar.get(i).getClass().toString().equals("class oto.RegularVehicle"))
				bt[i].setIcon(new ImageIcon(regulari));
			else if(arabalar.get(i).getClass().toString().equals("class oto.SubscribedVehicle"))
				bt[i].setIcon(new ImageIcon(subsi));
			else 
				bt[i].setIcon(new ImageIcon(officiali));
		}
			for(int j=i;j<kapasiti;j++) {
			bt[j].setText("Alan " + (j+1));
			bt[j].setIcon(null);
		}
		 
	}
	
	public void createArea( JButton bt[]) { 
		
		icerik.removeAll();
		for(int i =0;i<kapasiti;i++) { 		
			bt[i].setPreferredSize(new Dimension(250,100)); 
			icerik.add(bt[i]);
		}

	    icerik.revalidate();  
	    icerik.repaint();
	}
	
	private void jButtonActionPerformed(java.awt.event.ActionEvent evt,JButton bt[]){
	   	
		JButton btn=(JButton)evt.getSource();
		
			
		if(btn.getText().indexOf("Alan")==-1) { 
		ap.isParked(btn.getText());
		System.out.println(btn.getText()); 
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Bu aracın çıkışı yapılsın mı?", btn.getText(), dialogButton);
		if(dialogResult == 0) {
	
			
			if(ap.isParked(btn.getText())) {
				Calendar now=Calendar.getInstance();
				
				Time tm=new Time(now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE)); 

				if(ap.vehicleExits(btn.getText(),tm)) {
					for(Vehicle vc:arabalar)
						if(vc.getPlate().equals(btn.getText()))
								arabalar.remove(vc);
				} 
				yenile(bt);
			System.out.println(ap.toString()); 
			totallb.setText("Toplam Araç Sayısı : " + arabalar.size());
			income.setText("Günlük Gelir : " + ap.getIncomeDaily());
			}		
		} 
		
		}
		
	}
}
