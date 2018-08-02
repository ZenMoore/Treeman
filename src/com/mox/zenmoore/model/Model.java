package com.mox.zenmoore.model;

import java.io.Serializable;

public abstract class Model implements Serializable {
    protected String filename;

    public abstract void refresh();
}
