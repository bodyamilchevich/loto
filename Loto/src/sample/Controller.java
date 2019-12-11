package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Controller {

    //<editor-fold desc="anotations">
    @FXML
    Label winLabel;
    @FXML
    Label getNum1;
    @FXML
    Label getNum2;
    @FXML
    Label getNum3;
    @FXML
    Label getNum4;
    @FXML
    Label getNum5;

    @FXML
    TextField inputText1;
    @FXML
    TextField inputText2;
    @FXML
    TextField inputText3;
    @FXML
    TextField inputText4;
    @FXML
    TextField inputText5;
@FXML
    Pane mainPane;
@FXML
    Pane alertPane;
@FXML
    Label alertLabel;
    //</editor-fold>

    //<editor-fold desc="variables">
    private final int MIN=1;
     private final int MAX=49;
    private int setNum1;
    private int setNum2;
    private int setNum3;
    private int setNum4;
    private int setNum5;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;

    //</editor-fold>
@FXML
private void alert ( ActionEvent e){
    //System.err.println(e);
    alertPane.setVisible(false);
    mainPane.setDisable(false);
    mainPane.setOpacity(1);
    //mainPane.setVisible(true);

}

  @FXML
  private void start (ActionEvent event) {


        ArrayList<Integer> array2 = setInputText1();
      if(array2!=null) {
          ArrayList<Integer> array1= getRandomArray();

          getNum1.setText(String.valueOf(array1.get(0)));
          getNum2.setText(String.valueOf(array1.get(1)));
          getNum3.setText(String.valueOf(array1.get(2)));
          getNum4.setText(String.valueOf(array1.get(3)));
          getNum5.setText(String.valueOf(array1.get(4)));
          HashSet<Integer> checkText = new HashSet<>();
          checkText.addAll(array1);
          checkText.addAll(array2);
          switch (checkText.size()) {
              case 10:
                  winLabel.setText("win 0");         //Операторы
                  break; //необязательно
              case 9:
                  winLabel.setText("win 1");
                  break; //необязательно
              case 8:
                  winLabel.setText("win 2");
                  break; //необязательно
              case 7:
                  winLabel.setText("win 3");
                  break; //необязательно
              case 6:
                  winLabel.setText("win 4");
                  break; //необязательно
              case 5:
                  winLabel.setText("win 5");
                  break; //необязательно
          }
      }

//      getNum1.setText(String.valueOf(getRandomNumber()));
//      getNum2.setText(String.valueOf(getRandomNumber()));
//      getNum3.setText(String.valueOf(getRandomNumber()));
//      getNum4.setText(String.valueOf(getRandomNumber()));
//      getNum5.setText(String.valueOf(getRandomNumber()));
//      num1=0;
//      num2=0;
//      num3=0;
//      num4=0;
//      num5=0;
//        num1=getRandomNumber();
//        num2=getRandomNumber();
//        num3=getRandomNumber();
//        num4=getRandomNumber();
//        num5=getRandomNumber();

     // setInputText1();
     // System.out.println(getRandomArray());

  }
private int getRandomNumber(){
      int a =(int) (Math.random()*MAX)+MIN;
      if (a==num1 || a==num2 || a==num3 || a==num4 || a==num5  ){
          System.out.println(a);
          return getRandomNumber();
      }
      return a;
}

    private ArrayList<Integer> setInputText1 () {
      try {
          setNum1= Integer.parseInt(inputText1.getText());
          setNum2= Integer.parseInt(inputText2.getText());
          setNum3= Integer.parseInt(inputText3.getText());
          setNum4= Integer.parseInt(inputText4.getText());
          setNum5= Integer.parseInt(inputText5.getText());
      }catch (Exception e){
         // System.err.println(e);
          alertCheck("you need to write numbers ");
          return null;
      }


        Set s= new HashSet<Integer>();
        s.add(setNum1);
        s.add(setNum2);
        s.add(setNum3);
        s.add(setNum4);
        s.add(setNum5);
        if(s.size()<5){
            alertCheck("you cant write the same numbers ");
            return null;
        }
        ArrayList<Integer> finnum = new ArrayList<>(s);
        for (Integer k: finnum
             ) {
            if(k<MIN || k>MAX ){
                alertCheck("you need write numbers from 1 to 49");
                return null;
            }

        }
        return finnum;

}

private ArrayList<Integer> getRandomArray(){
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i=1; i<=MAX;i++){
        arr.add(i);
    }
    Random random=new Random();
    ArrayList<Integer> res=new ArrayList<>();
    for(int i=0; i<5; i++ ) {

        res.add(arr.remove(random.nextInt(arr.size())));
    }

    return res;
}

    private void alertCheck(String a){
        alertPane.setVisible(true);
        mainPane.setDisable(true);
        mainPane.setOpacity(0.3);
        //alertLabel.setText("bvcbdfvndbvbdfvbhfd");
        alertLabel.setText(a);
    }



}
