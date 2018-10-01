package poo;

import personagens.Aldeao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tela extends JPanel {

    private ArrayList<Aldeao> aldeoes;

    public Tela() {

        //TODO preciso ser melhorado

        this.setBackground(Color.white);
        this.aldeoes = new ArrayList<>();
    }

    /**
     * Método que invocado sempre que o JPanel precisa ser resenhado.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //TODO preciso ser melhorado

        // percorrendo a lista de aldeões e pedindo para cada um se desenhar na tela
        aldeoes.forEach(aldeao -> aldeao.desenhar(g));

        // liberando o contexto gráfico
        g.dispose();
    }

    /**
     * Cria um aldeao nas coordenadas X e Y, desenha-o neste JPanel
     * e adiciona o mesmo na lista de aldeoes
     *
     * @param x coordenada X
     * @param y coordenada Y
     */
    public void criarAldeao(int x, int y) {
        Aldeao a = new Aldeao(this, "aldeao", x, y);
        a.desenhar(super.getGraphics());
        aldeoes.add(a);
    }

    /**
     * Atualiza as coordenadas X ou Y de todos os aldeoes
     *
     * @param direcao
     */
    public void movimentarAldeao(int direcao) {
        //TODO preciso ser melhorado

        aldeoes.forEach(aldeao -> aldeao.mover(direcao));
        // Depois que as coordenadas foram atualizadas é necessário repintar o
        //JPanel
        this.repaint();
    }

    /**
     * Altera o estado do aldeão de atacando para não atacando e vice-versa
     */
    public void atacarAldeao() {

        //TODO preciso ser melhorado

        // Percorrendo a lista de aldeões e pedindo para todos atacarem
        aldeoes.forEach(aldeao -> aldeao.atacar());

        // Fazendo o JPanel ser redesenhado
        this.repaint();
    }
}
