import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    // Komponen 
    private JTextField txtNIK, txtNama, txtTempatLahir, txtTelepon, txtAlamat1, txtAlamat2;
    private JTextArea txtAlamat;
    private JComboBox<String> cmbTanggal, cmbBulan, cmbTahun;
    private JRadioButton rbLaki, rbPerempuan;
    private JComboBox<String> cmbStatus;

    public Main() {
      // Frame
        setTitle("Form Data Karyawan");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Posisinya ada di tengah layar
        setLayout(new BorderLayout());

        // Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Jarak antar KOmponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // NIK
        addLabel(mainPanel, "NIK:", 0, 0, gbc);
        txtNIK = new JTextField(20);
        addComponent(mainPanel, txtNIK, 1, 0, gbc);

        // Nama
        addLabel(mainPanel, "Nama:", 0, 1, gbc);
        txtNama = new JTextField(20);
        addComponent(mainPanel, txtNama, 1, 1, gbc);

        // Alamat
        addLabel(mainPanel, "Alamat:", 0, 2, gbc);
        txtAlamat = new JTextArea(3, 20);
        txtAlamat.setLineWrap(true);
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        addComponent(mainPanel, scrollAlamat, 1, 2, gbc);

        // TTL
        addLabel(mainPanel, "Tempta Lahir:", 0, 3, gbc);
        txtTempatLahir = new JTextField(20);
        addComponent(mainPanel, txtTempatLahir, 1, 3, gbc);

        addLabel(mainPanel, "Tanggal Lahir:", 0, 4, gbc);
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        String[] dates = new String[31];
        for(int i=0; i<31; i++) dates[i] = String.valueOf(i+1);
        cmbTanggal = new JComboBox<>(dates);
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Ags", "Sep", "Okt", "Nov", "Des"};
        cmbBulan = new JComboBox<>(months);
        
        String[] years = new String[100];
        int currentYear = 2026;
        for(int i=0; i<100; i++) years[i] = String.valueOf(currentYear - i);
        cmbTahun = new JComboBox<>(years);

        datePanel.add(cmbTanggal);
        datePanel.add(new JLabel(" "));
        datePanel.add(cmbBulan);
        datePanel.add(new JLabel(" "));
        datePanel.add(cmbTahun);
        addComponent(mainPanel, datePanel, 1, 4, gbc);

        // Jenis Kelamin
        addLabel(mainPanel, "Jenis Kelamin:", 0, 5, gbc);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup(); // Agar hanya bisa pilih satu
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);
        addComponent(mainPanel, genderPanel, 1, 5, gbc);

        // Telephone
        addLabel(mainPanel, "Telepon:", 0, 6, gbc);
        txtTelepon = new JTextField(20);
        addComponent(mainPanel, txtTelepon, 1, 6, gbc);

        // Status Nikah
        addLabel(mainPanel, "Status Pernikahan:", 0, 7, gbc);
        String[] status = {"Belum Menikah", "Menikah", "Cerai"};
        cmbStatus = new JComboBox<>(status);
        addComponent(mainPanel, cmbStatus, 1, 7, gbc);

        // Alamat 1
        addLabel(mainPanel, "Alamat 1:", 0, 8, gbc);
        txtAlamat1 = new JTextField(20);
        addComponent(mainPanel, txtAlamat1, 1, 8, gbc);

        // Alamat 2
        addLabel(mainPanel, "Alamat 2:", 0, 9, gbc);
        txtAlamat2 = new JTextField(20);
        addComponent(mainPanel, txtAlamat2, 1, 9, gbc);

        // Save 'Simpan'
        JButton btnSimpan = new JButton("Save Data");
        gbc.gridx = 1; gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnSimpan, gbc);

        // PopUP Hasil
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = "Data Tersimpan:\n" +
                        "Nama: " + txtNama.getText() + "\n" +
                        "NIK: " + txtNIK.getText() + "\n" +
                        "Tempat/Tgl Lahir: " + txtTempatLahir.getText() +  "\n" +
                        "Telepon: " + txtTelepon.getText() + "\n" +
                        "Status Kawin: " + cmbStatus.getSelectedItem() + "\n" +
                        "Alamat: " + txtAlamat.getText();

                JOptionPane.showMessageDialog(Main.this, info, "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Menambahkan ScrollPane utama (jika layar kecil)
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

    // Helper method untuk nambah Label
    private void addLabel(JPanel panel, String text, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        panel.add(new JLabel(text), gbc);
    }

    // Helper method untuk nambah Input Component
    private void addComponent(JPanel panel, Component comp, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 0.7;
        panel.add(comp, gbc);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi
        SwingUtilities.invokeLater(() -> {
            try {
                // OPSI 1 
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
                
                // OPSI 2
                // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new Main().setVisible(true);
        });
    }
}
