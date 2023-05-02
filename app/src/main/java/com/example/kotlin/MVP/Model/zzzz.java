package com.example.kotlin.MVP.Model;

public class zzzz {
    public class c{
        public String name;

        public c(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public class d extends c{
        public String name1;



        public d(String name, String name1) {
            super(name);
            this.name1 = name1;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }
    }
    public static void main(String[] args) {

    }
}
