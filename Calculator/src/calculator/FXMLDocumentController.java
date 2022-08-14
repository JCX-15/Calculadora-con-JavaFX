package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 *
 * @author barre
 */
public class FXMLDocumentController implements Initializable {
    String numero1,numero2;
    int signo;
    
    @FXML
    private Label txtlabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void btn0(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"0");
    }
    
    @FXML
    private void btn1(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"1");
    }

    @FXML
    private void btn2(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"2");
    }
    
    @FXML
    private void btn3(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"3");
    }

    @FXML
    private void btn4(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"4");
    }
    
    @FXML
    private void btn5(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"5");
    }
    
    @FXML
    private void btn6(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"6");
    }
    
    @FXML
    private void btn7(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"7");
    }

    @FXML
    private void btn8(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"8");
    }
    @FXML
    private void btn9(ActionEvent event) {
        txtlabel.setText(txtlabel.getText()+"9");
    }
    

    @FXML
    private void btnpunto(ActionEvent event) {
        String linea=txtlabel.getText();
        if (linea.length()<=0){
            txtlabel.setText(txtlabel.getText()+"0.");
        }
        else{
            if(!existeP(txtlabel.getText())){
                txtlabel.setText(txtlabel.getText()+".");
            }
        }
    }
    private static boolean existeP(String s){
        boolean flaggy=false;
        for(int i=0;i<s.length();i++){
            if (s.contains(".")==true){
                flaggy=true;
            }
        }
        return flaggy;
    }
    
    @FXML
    private void btnmasmenos(ActionEvent event) {
        Double mun;
        String w=txtlabel.getText();
        if(w.length()>0){
            mun=(-1)*(Double.parseDouble(w));
            txtlabel.setText(mun.toString());
        }
    }

    @FXML
    private void btnmas(ActionEvent event) {
        if(!txtlabel.getText().equals("")){
            numero1=txtlabel.getText();
            signo=1;
            txtlabel.setText("");
        }
    }

    @FXML
    private void btnmenos(ActionEvent event) {
        if(!txtlabel.getText().equals("")){
            numero1=txtlabel.getText();
            signo=2;
            txtlabel.setText("");
        }
    }

    @FXML
    private void btnmulti(ActionEvent event) {
        if(!txtlabel.getText().equals("")){
            numero1=txtlabel.getText();
            signo=3;
            txtlabel.setText("");
        }
    }

    @FXML
    private void btndivi(ActionEvent event) {
        if(!txtlabel.getText().equals("")){
            numero1=txtlabel.getText();
            signo=4;
            txtlabel.setText("");
        }
    }
    
    @FXML
    private void btnigual(ActionEvent event) {
        String result;
        numero2=txtlabel.getText();
        if (!numero2.equals("")){
            result=calculosmatematicosdelacuesta(numero1,numero2,signo);
            txtlabel.setText(result);
        }
        
    }
    
    public static String calculosmatematicosdelacuesta(String c1,String c2, int sig) {
        String resultadofinal;
        Double numer=0.0;
        if(sig==1){
            numer=(Double.parseDouble(c1))+(Double.parseDouble(c2));
        }
        else{
            if(sig==2){
                numer=(Double.parseDouble(c1))-(Double.parseDouble(c2));
            }
            else{
                if(sig==3){
                    numer=(Double.parseDouble(c1))*(Double.parseDouble(c2));
                }
                else{
                    if (sig==4){
                        numer=(Double.parseDouble(c1))/(Double.parseDouble(c2));
                    }
                }
            }
        }
        resultadofinal=numer.toString();
        return resultadofinal;
    }
    
    @FXML
    private void btndiviinver(ActionEvent event) {
        String inv=txtlabel.getText();
        Double num;
        if(inv.length()>0){
            num=1/(Double.parseDouble(inv));
            txtlabel.setText(num.toString());
        }
    }

    @FXML
    private void btnclear(ActionEvent event) {
        txtlabel.setText("");
    }

    @FXML
    private void btnclearE(ActionEvent event) {
        String c= txtlabel.getText();
        if(c.length()>0){
            c=c.substring(0, c.length()-1);
        }
        txtlabel.setText(c);
    }

    @FXML
    private void infhandler(ActionEvent event) {
        final String msg="Informacion:\n"+"Creador: Julio César Barreto Torres\n"+"IS210\n"+"0800\n";
        Alert alerta= new Alert(AlertType.INFORMATION);
        alerta.setContentText(msg);
        alerta.setTitle("Acerca de");
        alerta.setHeaderText(null);
        alerta.showAndWait();
        
    }

}
