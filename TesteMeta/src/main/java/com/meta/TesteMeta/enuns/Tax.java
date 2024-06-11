package com.meta.TesteMeta.enuns;

public enum Tax {
/*0 0 3,00 2,5%
1 10 12,00 0,0%
11 20 0,00 8,2%
21 30 0,00 6,9%
31 40 0,00 4,7%
41 50 0,00 1,7%
 */
//
//    TAX_0_0(3.00, 2.5),
//    TAX_1_10(12.00, 0.0),
//    TAX_11_20(0.00, 8.2),
//    TAX_21_30(0.00, 6.9),
//    TAX_31_40(0.00, 4.7),
//    TAX_41_50(0.00, 1.7);
//
//    private double value;
//    private double tax;
//
//    Tax(double value, double tax) {
//        this.value = value;
//        this.tax = tax;
//    }
//
//    public double getValue() {
//        return value;
//    }
//
//    public double getTax() {
//        return tax;
//    }
//
//    public double calculateTax() {
//        return value * tax / 100;
//    }


    TAX_0_0(0,0,3.00, 2.5),
    TAX_1_10(1,10,12.00, 0.0),
    TAX_11_20(11,20,0.00, 8.2),
    TAX_21_30(21,30,0.00, 6.9),
    TAX_31_40(31,40,0.00, 4.7),
    TAX_41_50(41,50,0.00, 1.7),
    TAX_NOT_APPLICABLE(0,0,0.00, 0.0);

    private int min;
    private int max;
    private double value;
    private double tax;

    Tax(int min, int max, double value, double tax) {
        this.min = min;
        this.max = max;
        this.value = value;
        this.tax = tax;
    }

    public double getValue() {
        return value;
    }

    public double getTax() {
        return tax;
    }

    public double calculateTax() {
        return value * tax / 100;
    }

    public static Tax getTax(int days) {

        for (Tax tax : Tax.values()) {
            if (tax != TAX_NOT_APPLICABLE) {
                if (days >= tax.min && days <= tax.max) {
                    return tax;
                }
            }

        }
        return TAX_NOT_APPLICABLE;
    }
}
