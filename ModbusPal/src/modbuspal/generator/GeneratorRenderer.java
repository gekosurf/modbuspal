/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GeneratorRenderer.java
 *
 * HISTORY:
 * - background color changes when "generatorHasStarted" or
 *   "generatorHasEnded" events occur.
 *
 * Created on 21 déc. 2008, 21:03:38
 */
package modbuspal.generator;

import modbuspal.automation.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Builds a Swing panel which is embedded into the AutomationEditor and represents
 * the configuration of a generator.
 * @author nnovic
 */
public class GeneratorRenderer
extends javax.swing.JPanel
implements GeneratorListener
{

    private Generator generator;
    private JPanel customPanel;
    private AutomationEditor editor;


    /** Creates new form GeneratorRenderer */
    public GeneratorRenderer(AutomationEditor parent, Generator gen)
    {
        editor = parent;
        generator = gen;
        customPanel = gen.getControlPanel();
        customPanel.setOpaque(false);
        setName( generator.getClassName() );
        initComponents();
    }


    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        upButton.setEnabled(enabled);
        deleteButton.setEnabled(enabled);
        downButton.setEnabled(enabled);
        setEnabled(customPanel,enabled);
        durationTextField.setEnabled(enabled);
    }


    private void setEnabled(Component comp, boolean enabled)
    {
        comp.setEnabled(enabled);

        if( comp instanceof Container )
        {
            Container container = (Container)comp;
            int nb = container.getComponentCount();
            for( int i=0; i<nb; i++ )
            {
                Component comp2 = container.getComponent(i);
                setEnabled(comp2, enabled);
            }
        }
    }

    public Generator getGenerator() {
        return generator;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iconPanel = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        durationTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setLayout(new java.awt.BorderLayout());

        iconPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        iconPanel.setLayout(new java.awt.GridBagLayout());

        iconLabel.setIcon(generator.getIcon());
        iconLabel.setToolTipText(generator.getClassName());
        iconPanel.add(iconLabel, new java.awt.GridBagConstraints());

        add(iconPanel, java.awt.BorderLayout.WEST);

        optionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        optionPanel.setOpaque(false);
        optionPanel.setLayout(new java.awt.BorderLayout());
        add(optionPanel, java.awt.BorderLayout.CENTER);
        optionPanel.add( customPanel, BorderLayout.CENTER );

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(upButton, gridBagConstraints);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(deleteButton, gridBagConstraints);

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(downButton, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Duration:");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        durationTextField.setText(String.valueOf(generator.getDuration()));
        durationTextField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        durationTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        durationTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                durationTextFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(durationTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        buttonsPanel.add(jPanel1, gridBagConstraints);

        add(buttonsPanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void durationTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_durationTextFieldFocusLost
        String exp = durationTextField.getText();
        double val = Double.parseDouble(exp);
        generator.setDuration(val);
    }//GEN-LAST:event_durationTextFieldFocusLost

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        editor.remove(this);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        editor.down(this);
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        editor.up(this);
    }//GEN-LAST:event_upButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton downButton;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    public void generatorHasEnded(Generator gen)
    {
        if (gen == generator)
        {
            setBackground(UIManager.getColor("Panel.background"));
        }
    }

    public void generatorHasStarted(Generator gen)
    {
        if (gen == generator)
        {
            setBackground(UIManager.getColor("List.selectionBackground"));
        }
    }
}
