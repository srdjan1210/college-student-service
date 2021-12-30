package utils;

import java.awt.*;

public class Constants {
    public enum MarksValue {
        SEST(6), SEDAM(7), OSAM(8), DEVET(9), DESET(10);

        private int value;

        MarksValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public enum Semester {
        ZIMSKI("ZIMSKI"), LETNJI("LETNJI");

        private String value;

        Semester(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum Status {
        BUDZET("BUDZET"), SAMOFINANSIRANJE("SAMOFINANSIRANJE");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static int ICON_BUTTON_HEIGHT = 20;
    public static int ICON_BUTTON_WIDTH = 20;
    public static String[] studentLabelNames = {"Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*",
            "Broj telefona*", "E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*",
            "Nacin finansiranja"};
    public static String[] finansingWayLabels = {"BUDZET", "SAMOFINANSIRANJE"};
    public static String[] yearsLabels = {"1", "2", "3", "4"};
    public static String[] marksLabels = {"6","7","8","9","10"};
    public static String[] professorLabelNames = {"Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*",
            "Broj telefona*", "E-mail adresa*", "Adresa kancelarije*", "Broj licne karte*", "Zvanje*",
            "Godine iskustva*"};
    public static String[] subjectLabelNames = {"Id predmeta*", "Naziv predmeta*", "Semestar*", "Profesor*", "Espb*",
            "Godina studija*"};
    public static String[] takingExamLabelNames = {"Id predmeta*","Naziv predmeta*","Ocena*","Datum*"};
    public static String[] semesterValues = {"ZIMSKI", "LETNJI"};
    public static String[] studentColumnNames = {"Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
    public static String[] professorColumnNames = {"Ime", "Prezime", "Titula", "E-mail adresa"};
    public static String[] subjectColumnNames = {"Sifra predmeta", "Naziv predmeta", "Broj ESPB bodova",
            "Godina na kojoj se predmet izvodi", "Semestar u kome se predmet izvodi"};
}
