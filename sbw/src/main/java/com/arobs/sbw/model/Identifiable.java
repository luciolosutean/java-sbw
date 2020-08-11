package com.arobs.sbw.model;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> extends Serializable {

    T getId();
}
