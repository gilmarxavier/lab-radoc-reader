/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import activities.Activity;
import activities.*;
import data.PDFManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class ExtrairAtividades {
    public static void main(String[] args) throws IOException, ParseException {

        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("Radoc-2011-Final.pdf");
        String radoc = pdfManager.ToText();
        ArrayList<Activity> activities = new ArrayList<Activity>();
        
        Administrativas administrativas = new Administrativas(radoc);
        Ensino ensino = new Ensino(radoc);
        Especiais especiais = new Especiais(radoc);
        Extensao extensao = new Extensao(radoc);
        Orientacao orientacao = new Orientacao(radoc);
        Projeto projeto = new Projeto(radoc);
        Qualificacao qualificacao = new Qualificacao(radoc);
        PrintWriter out = new PrintWriter("atividades.txt");
        
        activities.addAll(administrativas.extractActivities());
        activities.addAll(ensino.extractActivities());
        activities.addAll(especiais.extractActivities());
        activities.addAll(extensao.extractActivities());
        activities.addAll(orientacao.extractActivities());
        activities.addAll(projeto.extractActivities());
        activities.addAll(qualificacao.extractActivities());
        
        for (Activity activity :activities) {
            out.println(activity.toString());
            System.out.println(activity.toString());
        }
        out.println(activities);
    }  
}
