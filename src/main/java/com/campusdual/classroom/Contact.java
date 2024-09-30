package com.campusdual.classroom;


import java.text.Normalizer;
import java.util.regex.Pattern;


public class Contact implements ICallActions{


    String nombre;
    String apellidos;
    String numero;
    String codigo;


    public Contact(String nombre, String apellidos, String numero) {

        this.nombre = removeDiacritics(nombre);
        this.apellidos = removeDiacritics(apellidos);
        this.numero = numero;
        this.codigo = concatenar();


    }

    public String concatenar(){
        StringBuilder stringBuilder = new StringBuilder();
        String primLetNom = String.valueOf(nombre.toLowerCase().charAt(0));
        stringBuilder.append(primLetNom);
        String[] apellidos = this.apellidos.split(" ");
        for (int i = 0; i < apellidos.length; i++) {
            if(apellidos.length > 1){
                if(i == 0){
                    stringBuilder.append(apellidos[i].toLowerCase().charAt(0));
                }else{
                    stringBuilder.append(apellidos[i].toLowerCase());
                }
            }else{
                stringBuilder.append(apellidos[i].toLowerCase());
            }


        }
        return stringBuilder.toString();
    }


    /*public String concatenar(){
        String apellido1Concatenado = apellido1.split(" ")[0];
        String apellido2Concatenado = apellido2.isEmpty() ? "" : apellido2.split(" ")[apellido2.split(" ").length - 1];
        return nombre.concat(apellido1Concatenado).concat(apellido2Concatenado).replace(" ", "");

        /*int cont=0;
        String[] palabras = apellido1.split(" ");

        for(String p : palabras){
            cont++;
            if(cont==1){
                apellido1 = p.substring(0,1);
            }else{
                apellido1 = apellido1 + p;
            }
        }

        if(apellido2 == null) {
            return nombre.concat(apellido1).replace(" ","");
        }else{return nombre.concat(apellido1).concat(apellido2).replace(" ","");}
    }*/

    public static String removeDiacritics(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }

    @Override
    public void callMyNumber() {
        System.out.println("Calling "+nombre+" "+apellidos+" at "+numero);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Calling "+nombre+" "+apellidos+" at "+number);

    }

    @Override
    public void showContactDetails() {
        System.out.println("Name: " + nombre);
        System.out.println("Surnames: " + apellidos);
        System.out.println("Phone: " + numero);
        System.out.println("Code: " + codigo);
    }

    public String getName(){
        return nombre;
    }

    public String getSurnames(){
        return apellidos;
    }

    public String getPhone(){
        return numero;
    }

    public String getCode(){
        return codigo;
    }
}

