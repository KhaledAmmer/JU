package com.example.myapplication32;

public class addresses {
    private String Text1;
    private String Text2;
    private int idimage;

    public addresses(String mtext1,String mtext2 ){

       Text1=mtext1;
       Text2=mtext2;
    }
    public addresses(String mtext1,int Idimage ){
        Text1=mtext1;
        idimage=Idimage;
    }

    public addresses(String mtext1,String mtext2,int Idimage ){
        Text2=mtext2;
        Text1=mtext1;
        idimage=Idimage;
    }

    public String getText1(){
        return Text1;
    }
    public int getIdimage(){
        return idimage;
    }
    public String getText2(){
        return Text2;
    }

}
