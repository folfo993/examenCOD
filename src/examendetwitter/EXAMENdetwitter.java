/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examendetwitter;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author FOLFO
 */
public class EXAMENdetwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {

        String busqueda;
        String tweet;
        int opcion;

        metodostwitter obj = new metodostwitter();

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> TimeLine\n2 --> Buscar\n3 --> Tweettear\n4 --> Exit"));
            switch (opcion) {
                case 1:
                    obj.verTL();
                    break;
                case 2:
                    busqueda = JOptionPane.showInputDialog("Introduzca lo que desee buscar");
                    obj.buscarTrending(busqueda);
                    break;
                case 3:
                    tweet = JOptionPane.showInputDialog("Introduzca lo que desee twittear");
                    obj.tweetear(tweet);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opcion != 0 && opcion != 4);
        
    }
}
