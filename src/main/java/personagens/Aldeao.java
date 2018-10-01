package personagens;


import poo.Principal;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Aldeao {

    private JPanel pai;  // referência ao JPanel onde será desenhado o Aldeao
    private Image icone; // imagem do Aldeao
    private String imagemNome; // nome da imagem do Aldeao
    private int largura; // largura da imagem
    private int altura;  // altura da imagem
    private int posX;    // posição X no JPanel onde a imagem será desenhada
    private int posY;    // posição Y no JPanel onde a imagem será desenhada
    private boolean atacando; // indica se está atacando ou não

    public Aldeao(JPanel p, String img, int x, int y) {

        this.imagemNome = img;
        this.icone = this.carregarImagem(this.imagemNome);
        this.largura = this.icone.getWidth(null);
        this.altura = this.icone.getHeight(null);

        this.pai = p;
        this.posX = x;
        this.posY = y;
        this.atacando = false;
    }


    /**
     * Desenhando o Aldeão, nas coordenadas X e Y, com a imagem 'icone'
     * no JPanel 'pai'
     *
     * @param g objeto do JPanel que será usado para desenhar o Aldeão
     */
    public void desenhar(Graphics g) {
        // verificando qual imagem carregar
        if (atacando == true) {
            this.icone = this.carregarImagem(this.imagemNome + "2");
        } else {
            this.icone = this.carregarImagem(this.imagemNome);
        }
        // desenhando de fato a imagem no pai
        g.drawImage(this.icone, this.posX, this.posY, this.pai);
    }

    /**
     * Atualiza as coordenadas X e Y do personagem
     * 0 para cima
     * 1 para baixo
     * 2 para esquerda
     * 3 para direita
     *
     * @param direcao inteiro que indica a direcao a ir.
     */
    public void mover(int direcao) {
        switch (direcao) {
            case 0: // subir
                this.posY -= 10;
                break;
            case 1: // descer
                this.posY += 10;
                break;
            case 2: // esquerda
                this.posX -= 10;
                break;
            case 3: // direita
                this.posX += 10;
                break;
        }
        //Não deixa a imagem ser desenhada fora dos limites do JPanel pai
        if (this.posX > this.pai.getWidth() - this.largura) {
            this.posX = this.pai.getWidth() - this.largura;
        } else if (this.posX < 0) {
            this.posX = 0;
        }
        //Não deixa a imagem ser desenhada fora dos limites do JPanel pai
        if (this.posY > this.pai.getHeight() - this.altura) {
            this.posY = this.pai.getHeight() - this.altura;
        } else if (this.posY < 0) {
            this.posY = 0;
        }
    }


    public void atacar() {
        this.atacando = !this.atacando;
    }

    /**
     * Método auxiliar para carregar uma imagem do disco
     *
     * @param imagem Caminho da imagem
     * @return Retorna um objeto Image
     */
    private Image carregarImagem(String imagem) {
        URL url = Principal.class.getResource("../../resources/" + imagem + ".png");

        ImageIcon iicon = new ImageIcon(url);
        return iicon.getImage();
    }

}
