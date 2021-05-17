package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DetalhesCrianca extends JDialog {
    private JFormattedTextField nomeField;
    private JFormattedTextField dataField;
    private JFormattedTextField localField;
    private JButton aceitarButton;
    private JButton cancelarButton;
    private JPanel mekie;
    private Crianca crianca;

    public DetalhesCrianca() {
        aceitarButton.addActionListener(this::BtnAceitar);
        cancelarButton.addActionListener(this::btnCancelarActionPerfomed);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setContentPane(mekie);
        setVisible(true);
        pack();
    }

 /*   public static Crianca mostrarCriacaoCrianca(Frame parent){
        JOptionPane.showMessageDialog(parent, "Data inválida. A data deve ter o formato dd/mm/aaaa");

    }*/

    private void fechar(){
        setVisible(false);
        dispose();
    }
    private void btnCancelarActionPerfomed(ActionEvent e){
        fechar();
    }

    private void BtnAceitar(ActionEvent e) {
        if (isNomeValido(nomeField.getText()) && isDataValida(dataField.getText()) && isLocalNascimentoValido(localField.getText())) {
            if(!existeCriancaComNome(nomeField.getText())) {
                crianca = new Crianca(nomeField.getText(), Data.parseData(dataField.getText()), localField.getText());
                DadosAplicacao.INSTANCE.adicionarCrianca(crianca);
                fechar();
                ParentsLog.
                //mostrarCriacaoCrianca(Frame.getFrames()[0]);
            }
        }
    }

    private boolean isNomeValido(String nome) {
        int count = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) > ' '){
                count++;
            }
        }
        if (count < 2) {
            JOptionPane.showMessageDialog(getParent(), "Nome inválido. O nome deve conter pelo menos 2 carateres não-brancos");
            return false;
        }
        return true;
    }

    private boolean isLocalNascimentoValido(String local) {
        int count = 0;
        for (int i = 0; i < local.length(); i++) {
            if (local.charAt(i) > ' '){
                count++;
            }
        }
        if (count < 2) {
            JOptionPane.showMessageDialog(getParent(), "Nome inválido. O nome deve conter pelo menos 2 carateres não-brancos");
            return false;
        }
        return true;
    }

    private boolean isDataValida(String data) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(getParent(), "Data inválida. A data deve ter o formato dd/mm/aaaa");
            return false;
        }
        return true;

    }
    private boolean existeCriancaComNome(String nome){
        if(DadosAplicacao.INSTANCE.existeCriancaComNome(nome)){
            JOptionPane.showMessageDialog(getParent(), "Já existe uma criança com o nome dado");
        }
        return DadosAplicacao.INSTANCE.existeCriancaComNome(nome);
    }
}
