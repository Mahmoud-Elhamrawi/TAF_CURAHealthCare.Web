package com.HealthCure.Driver;

public enum BrowserEnum {

    CHROME {
        @Override
        public AbstractClass getDriver() {
            return new ChromeFact();
        }
    },FIREFOX {
        @Override
        public AbstractClass getDriver() {
            return new FireFoxFact();
        }
    },EDGE {
        @Override
        public AbstractClass getDriver() {
            return new EdgeFact();
        }
    };

    public abstract AbstractClass getDriver();









}
