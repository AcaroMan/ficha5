package models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ParentsLog extends JFrame {
    private JButton btnAdicionarCrianca;
    private JButton btnNovoEvento;
    private JComboBox<Crianca> cbCriancas;
    private JList<Evento> lstEventos;
    private JPanel mekie;
    public ParentsLog(String title){
        super(title);
        btnAdicionarCrianca.addActionListener(this::BtnAdicionarCrianca);
        cbCriancas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEventos();
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mekie);
        pack();
    }

    private void atualizarCriancas(){
        cbCriancas.removeAllItems();
        for (Crianca crianca : DadosAplicacao.INSTANCE.getCriancas()) {
            cbCriancas.addItem(crianca);

        }
    }

    private void atualizarEventos(){
        lstEventos.removeAll();
        DefaultListModel<Evento> model = new DefaultListModel<>();
        for(Evento evento:DadosAplicacao.INSTANCE.getEventos((Crianca) cbCriancas.getSelectedItem())){
            model.addElement(evento);
            lstEventos.setModel(model);
        }
    }

    private void BtnAdicionarCrianca(ActionEvent e) {
        new DetalhesCrianca();

    }
    public static void main(String[] args) {
        new ParentsLog("SaldoManager").setVisible(true);
    }

}
