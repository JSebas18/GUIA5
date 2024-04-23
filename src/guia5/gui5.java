package guia5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFileChooser;
public class gui5 extends javax.swing.JFrame {
    int filas=0, columnas=0;
    private String nombreEstudianteSeleccionado;
    DefaultTableModel tabla1 = new DefaultTableModel();;
    DefaultTableModel tabla2 = new DefaultTableModel();
    ArrayList<ArrayList<String>> data1 = new ArrayList<>();
    ArrayList<ArrayList<String>> data2 = new ArrayList<>();
    JFileChooser archivo=new JFileChooser(System.getProperty("user.dir"));
    private void tomarDatos(){
                filas = Integer.parseInt(jTextField1.getText());
                columnas = Integer.parseInt(jTextField2.getText());
                columnas++;
    }
   private void cargar() {
    archivo.showOpenDialog(this);
    File abrir = archivo.getSelectedFile();
    
    if (abrir != null) {
        try {
            FileReader fichero = new FileReader(abrir);
            BufferedReader leer = new BufferedReader(fichero);
           
            String texto;
            ArrayList<String[]> registros = new ArrayList<>();
            while ((texto = leer.readLine()) != null) {
                registros.add(texto.split(";"));
            }
            leer.close();
            fichero.close();
            
            
            DefaultTableModel modeloTabla1 = (DefaultTableModel) jTable1.getModel();
            modeloTabla1.setRowCount(0);
            modeloTabla1.setColumnCount(0);
            
            
            filas = registros.size();
            columnas = registros.get(0).length; 
            
            
            Object[] titulos = new Object[columnas];
            titulos[0] = "Nombre";
            for (int i = 1; i < columnas; i++) {
                titulos[i] = "Nota " + i;
            }
            modeloTabla1.setColumnIdentifiers(titulos);
            
            
            for (String[] registro : registros) {
                modeloTabla1.addRow(registro);
            }
            jTable1.setModel(modeloTabla1);
            
            
            prepararTablaResultados();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void prepararTablaResultados() {
    DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
    modelo.setRowCount(0);  
    modelo.setColumnCount(0);  

    String[] titulo2 = {"Nombre", "Promedio", "Final"};
    modelo.setColumnIdentifiers(titulo2);
    modelo.setRowCount(Integer.parseInt(jTextField1.getText()));  
}




    public gui5() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setModel(tabla1);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(tabla2);
        jScrollPane2.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Añadir Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Resultados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Historico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Estadisticas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero De Estudiantes");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero De Notas");

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Importar CSV");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Limpiar tablas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exportar Tabla de Notas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Exportar Tabla de Resultados");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton5)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(5, 5, 5)
                        .addComponent(jButton5)
                        .addGap(5, 5, 5)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
tomarDatos();
    int numEstudiantes = Integer.parseInt(jTextField1.getText());
    int numNotas = Integer.parseInt(jTextField2.getText());
    
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0);  
    modelo.setColumnCount(0);  


    Object[] columnNames = new Object[numNotas + 1];  
    columnNames[0] = "Nombre";
    for (int i = 1; i <= numNotas; i++) {
        columnNames[i] = "Nota " + i;
    }
    modelo.setColumnIdentifiers(columnNames);
    modelo.setRowCount(numEstudiantes);

    
    prepararTablaResultados();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
DefaultTableModel modeloTabla1 = (DefaultTableModel) jTable1.getModel();
    DefaultTableModel modeloTabla2 = (DefaultTableModel) jTable2.getModel();
    
    modeloTabla2.setRowCount(modeloTabla1.getRowCount()); 

    for (int i = 0; i < modeloTabla1.getRowCount(); i++) {
        String nombreEstudiante = modeloTabla1.getValueAt(i, 0).toString();
        float suma = 0;
        int conteoNotas = 0;
        for (int j = 1; j < modeloTabla1.getColumnCount(); j++) {
            String valor = modeloTabla1.getValueAt(i, j).toString();
            if (!valor.isEmpty()) {
                suma += Float.parseFloat(valor);
                conteoNotas++;
            }
        }
        float promedio = (conteoNotas > 0) ? suma / conteoNotas : 0;
        String resultado = promedio >= 3 ? "Aprobado" : "Reprobado";

        modeloTabla2.setValueAt(nombreEstudiante, i, 0);
        modeloTabla2.setValueAt(String.format("%.2f", promedio), i, 1);
        modeloTabla2.setValueAt(resultado, i, 2);
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      String nombreEstudiante = jTextField3.getText(); 

        
        int filaEstudiante = -1;
        for (int i = 0; i < tabla1.getRowCount(); i++) {
            if (tabla1.getValueAt(i, 0).equals(nombreEstudiante)) {
                filaEstudiante = i;
                break;
            }
        }

        
        if (filaEstudiante == -1) {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        XYSeries series = new XYSeries("Historico de Notas de " + nombreEstudiante);
        for (int i = 1; i < tabla1.getColumnCount(); i++) {
            double nota = Double.parseDouble((String) tabla1.getValueAt(filaEstudiante, i));
            series.add(i, nota);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Histórico de Notas de " + nombreEstudiante, 
                "Nota", 
                "Valor", 
                dataset 
        );

        
        ChartFrame frame = new ChartFrame("Histórico de Notas", chart);
        frame.pack();
        frame.setVisible(true);
                                            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int totalEstudiantes = tabla2.getRowCount();
        int aprobados = 0;
        for (int i = 0; i < totalEstudiantes; i++) {
            String resultado = (String) tabla2.getValueAt(i, 2);
            if (resultado.equals("Aprobado")) {
                aprobados++;
            }
        }
        double porcentajeAprobados = (double) aprobados / totalEstudiantes * 100;
        double porcentajeReprobados = 100 - porcentajeAprobados;

       
        String mensaje = String.format("Aprobó: %.2f%% Reprobó: %.2f%%", porcentajeAprobados, porcentajeReprobados);
        JOptionPane.showMessageDialog(this, mensaje, "Estadísticas de Mortalidad", JOptionPane.INFORMATION_MESSAGE);


        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Aprobados", porcentajeAprobados);
        dataset.setValue("Reprobados", porcentajeReprobados);

       
        JFreeChart chart = ChartFactory.createPieChart(
                "Estadísticas de Mortalidad", 
                dataset, 
                true, 
                true, 
                false
        );

        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false); 

       
        ChartFrame frame = new ChartFrame("Estadísticas de Mortalidad", chart);
        frame.pack();
        frame.setVisible(true);
                                          

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        cargar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    DefaultTableModel modeloTabla1 = (DefaultTableModel) jTable1.getModel();
    modeloTabla1.setRowCount(0);  
    modeloTabla1.setColumnCount(0); 
    

    DefaultTableModel modeloTabla2 = (DefaultTableModel) jTable2.getModel();
    modeloTabla2.setRowCount(0);
    modeloTabla2.setColumnCount(0);
    
    
    data1.clear();
    data2.clear();

    
    jTextField1.setText("");
    jTextField2.setText("");
    
    JOptionPane.showMessageDialog(this, "Tablas limpias. Listo para nuevos datos.", "Información", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            Guia5 obj;
        try {
            obj = new Guia5();
            obj.exportarExcel(jTable1);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                Guia5 obj;
        try {
            obj = new Guia5();
            obj.exportarExcel(jTable2);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
