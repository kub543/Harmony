package com.example.harmonyapp.logicHarmony.tools;

public enum MenuConsoleChoice {
    k ("Wprowadź aby wyswietlić koła kwintowe."),
    t ("Wprowadź aby stworzyć triadę harmoniczną."),
    p ("Wprowadź aby sprawdzić swoją wiedzę."),
    s ("Wprowadź aby wyświetlić opis programu."),
    z ("Wprowadź aby zakoćczyć."),

    v ("Wpisz aby budować trójdźwięki."),
    b ("Wpisz aby znajdować akordy triady harmonicznej."),
    n ("Wpisz aby budować triadę harmoniczną."),
    q ("Wpisz aby wrócić do menu głóœnego.");

    final String description;

    MenuConsoleChoice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}