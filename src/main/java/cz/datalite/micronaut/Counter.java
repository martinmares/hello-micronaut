package cz.datalite.micronaut;

import javax.inject.Singleton;

@Singleton
public class Counter {

    public Counter() {
        this.i = 0;
    }
    public Integer get() {
        return i;
    }
    public void add(Integer i) {
        this.i += i;
    }
    Integer i;
}
