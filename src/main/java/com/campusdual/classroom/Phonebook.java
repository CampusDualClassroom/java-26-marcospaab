package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
        Map<String, Contact> hMap;

        public Phonebook(){
            this.hMap = new HashMap<>();
        }

        public Map<String, Contact> gethMap(){
            return hMap;
        }

        public void addContact(Contact contact){
            hMap.put(contact.codigo, contact);
        }

        public void deleteContact(String codigo){
            hMap.remove(codigo);
        }

        public void showPhonebook(){
            for(Contact contact: hMap.values()){
                System.out.println("Name: "+contact.nombre);
                System.out.println("Surnames: "+contact.apellidos);
                System.out.println("Phone: "+contact.numero);
                System.out.println("Code: "+contact.codigo);
                System.out.println();
            }
        }
}
