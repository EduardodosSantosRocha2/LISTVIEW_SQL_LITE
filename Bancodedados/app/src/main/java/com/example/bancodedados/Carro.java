package com.example.bancodedados;

public class Carro {

    private String Cod;
    private String Modelo;
    private String Marca;
    private String Ano;


    public Carro(String c, String mo, String ma, String a){
        this.Cod= c;
        this.Modelo= mo;
        this.Marca= ma;
        this.Ano= a;

    }

    public String getCod() {
        return Cod;
    }
    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public String getAno() {
        return Ano;
    }


}
