import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //выбор чисел латинские или римские
        String str = scan.nextLine();
        String s=operation(str);
        int i= str.indexOf(s);
        String ch1=str.substring(0,i);
        String ch2=str.substring(i+1);
        Scanner scan2=new Scanner(ch1);
       if (scan2.hasNextInt()){
           int m=readLat(ch1);
           int n=readLat(ch2);
           switch (s){
               case "-":
                   System.out.println(subtraction(m,n));
                   break;
               case "+":
                   System.out.println(summa(m,n));
                   break;
               case "*":
                   System.out.println(multiplication(m,n));
                   break;
               case "/":
                   System.out.println(division(m,n));
                   break;
               default:
                   System.out.println("не известная операция");
           }
       } else{
           int m=convert2(ch1);
           int n=convert2(ch2);
           switch (s){
               case "-":
                   int r=subtraction(m,n);
                   if (r<=0){
                       System.out.println("в римской системе нет отрицательных чисел");
                       break;
                   }else{
                       System.out.println(convertBack(r));
                   }
                   break;
               case "+":
                    r=summa(m,n);
                   System.out.println(convertBack(r));
                   break;
               case "*":
                   r=multiplication(m,n);
                   System.out.println(convertBack(r));
                   break;
               case "/":
                   r=division(m,n);
                   System.out.println(convertBack(r));
                   break;
               default:
                   System.out.println("не известная операция");
           }
       }
        }
    public static int convert2(String ch){
        String [] rim=new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
  int namber=0;
        boolean ss=false;
        int b=0;
        while (!ss){
              String st = rim[b];
           if (ch.equals(st)){
                ss=true;
            }else {
                b = b + 1;
                if(b>10){
                    System.out.println("Не верный формат цифр");
                    namber=0;
                    System.exit(1);

                }else{
                    namber=b;
                }
            }

            }return namber+1;

        }           // считывает римские цифры
    public static String convertBack (int r){
        String [] rim=new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XXXX","XXXXI","XXXXII","XXXXIII","XXXXIV","XXXXV","XXXXVI","XXXXVII","XXXXVIII","XXXXIX","XXXXX","XXXXXI","XXXXXII","XXXXXIII","XXXXXIV","XXXXXV","XXXXXVI","XXXXXVII","XXXXXVIII","XXXXXIX","XXXXXX" ,"XXXXXXI","XXXXXXII","XXXXXXIII","XXXXXXIV","XXXXXXV","XXXXXXVI","XXXXXXVII","XXXXXXVIII","XXXXXXIX","XXXXXXX","XXXXXXXI","XXXXXXXII","XXXXXXXIII","XXXXXXXIV","XXXXXXXV","XXXXXXXVI","XXXXXXXVII","XXXXXXXVIII","XXXXXXXIX","XXXXXXXX","XXXXXXXXI","XXXXXXXXII","XXXXXXXXIII","XXXXXXXXIV","XXXXXXXXV","XXXXXXXXVI","XXXXXXXXVII","XXXXXXXXVIII","XXXXXXXXIX","XXXXXXXXX","XXXXXXXXXI","XXXXXXXXXII","XXXXXXXXXIII","XXXXXXXXXIV","XXXXXXXXXV","XXXXXXXXXVI","XXXXXXXXXVII","XXXXXXXXXVIII","XXXXXXXXXIX","XXXXXXXXXX"};

        String  g=rim[r-1];
        return g;
    }        // конвертирует результат в римские цифры

    public static int readLat (String ch){

        int n=0;
        try {
            n=Integer.parseInt(ch);
        }catch(NumberFormatException e){
            System.out.println("разные цифры");

        }
        if ((n>10)||(n<=0)){
            System.out.println("такие нельзя! только от 1 до 10 (включительно).");
            System.exit(1);
        }

        return n;
    }            // считыват латинские цифры
    public static String operation(String str){  //выбор перации
        int i= str.indexOf('+');
        String st=null;
        if (i>0){
            st="+";
        }else {
            i= str.indexOf('-');
            if (i>0){
                st="-";
            }else {
                i= str.indexOf('*');
                if (i>0){
                    st="*";
                }else {
                    i= str.indexOf('/');
                    if (i>0) {
                        st="/";
                    }else {
                        System.out.println("не корректное выражение");

                    }
                }
            }
        }return st;
    }        // выбор операции


    public static int summa(int m,int n){
        int sum=m+n;
        return sum;
    }               //+++++
    public static int subtraction (int m,int n){
        int sub=m-n;
        return sub;
    }        //-----
    public static int division (int m,int n){
        int div=m/n;
        return div;
    }           // //////
    public static int multiplication (int m,int n){
        int mult=m*n;
        return mult;
    }     //*******


    }




