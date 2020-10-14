package com.example.demo.model;

public enum DbSelection {
    FvcDB1("FVC 2002 DB1(388x374)"),
    FvcDB2("FVC 2002 DB2(296x560)"),
    Sdumla("SDUMLA-HMT Fingerprint DB FPR620(256x304)");
    private String name;

    DbSelection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
