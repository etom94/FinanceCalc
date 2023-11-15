package model;

import java.awt.*;

public class GridBagBuilder {
    private GridBagConstraints constraints;
    private GridBagConstraints defaultConstraints;

    public GridBagBuilder() {
        constraints = new GridBagConstraints();
        defaultConstraints = new GridBagConstraints();
        setDefaultValues();
    }

    public GridBagBuilder setDefaultValues() {
        defaultConstraints.anchor = GridBagConstraints.CENTER;
        defaultConstraints.fill = GridBagConstraints.BOTH;
        defaultConstraints.gridx = 0;
        defaultConstraints.gridy = 0;
        defaultConstraints.gridheight = 1;
        defaultConstraints.gridwidth = 1;
        defaultConstraints.weightx = 1;
        defaultConstraints.weighty = 1;
        defaultConstraints.insets = new Insets(0, 0, 0, 0);
        return this;
    }

    public GridBagBuilder resetValues() {
        constraints.anchor = defaultConstraints.anchor;
        constraints.fill = defaultConstraints.fill;
        constraints.gridx = defaultConstraints.gridx;
        constraints.gridy = defaultConstraints.gridy;
        constraints.gridheight = defaultConstraints.gridheight;
        constraints.gridwidth = defaultConstraints.gridwidth;
        constraints.weightx = defaultConstraints.weightx;
        constraints.weighty = defaultConstraints.weighty;
        constraints.insets = defaultConstraints.insets;
        return this;
    }

    public GridBagBuilder gridx(int x) {
        constraints.gridx = x;
        return this;
    }

    public GridBagBuilder gridy(int y) {
        constraints.gridy = y;
        return this;
    }

    public GridBagBuilder gridwidth(int width) {
        constraints.gridwidth = width;
        return this;
    }

    public GridBagBuilder gridheight(int height) {
        constraints.gridheight = height;
        return this;
    }

    public GridBagBuilder weightx(double weightx) {
        constraints.weightx = weightx;
        return this;
    }

    public GridBagBuilder weighty(double weighty) {
        constraints.weighty = weighty;
        return this;
    }

    public GridBagBuilder fill(int fill) {
        constraints.fill = fill;
        return this;
    }

    public GridBagBuilder anchor(int anchor) {
        constraints.anchor = anchor;
        return this;
    }

    public GridBagBuilder insets(Insets insets) {
        constraints.insets = insets;
        return this;
    }

    public GridBagConstraints build() {
        return constraints;
    }
}
