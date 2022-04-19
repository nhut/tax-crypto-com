package fi.donhut.taxcryptocom.csvconverter.cryptocom;

import java.util.Locale;

public enum TransactionType {
    BUY,
    SELL,
    TRADE,

    DONATION,

    FORK,
    AIRDROP,
    MINING,
    REWARD,
    REBATE,

    TRANSFER,

    GIFT,
    PAYMENT,
    ;

    public String getValue() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
