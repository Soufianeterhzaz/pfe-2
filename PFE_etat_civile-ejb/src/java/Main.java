
import bean.Citoyen;
import bean.Nationalite;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YOU$$EF
 */
public class Main {

    public static void main(String[] args) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        Citoyen sfayn = new Citoyen();
        sfayn.setNomFr("BENSGHIR");
        sfayn.setPrenomFr("Soufiane");
        Nationalite n = new Nationalite();
        n.setLibelleFr("Marocaine");
        sfayn.setNationalite(n);
        try {
            jasperReport = JasperCompileManager.compileReport(
                    "input/extrait.jrxml");
            Map map = new HashMap();
            map.put("sfayn",sfayn);
            jasperPrint = JasperFillManager.fillReport(
                    jasperReport, map);
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint, "output/sfayn.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}