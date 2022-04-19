package fi.donhut.taxcryptocom.csvconverter.cryptocom;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@ToString
@Data
@NoArgsConstructor
/**
 * @see {@link https://tax.crypto.com/wallet-exchange/add}
 */
public class TaxCryptoComCsv extends CsvToBean {

    private static final String TIMESTAMP_FORMAT = "MM/dd/yyyy HH:mm:ss";

    @CsvBindByName(column = "Date", required = true)
    private String dateS;

    public Instant getDate() {
        try {
            final Date date = new SimpleDateFormat(TIMESTAMP_FORMAT).parse(dateS);
            return Instant.ofEpochMilli(date.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    @CsvBindByName(column = "Type", required = true)
    private String typeS;

    public TransactionType getType() {
        return TransactionType.valueOf(typeS);
    }

    @CsvBindByName(column = "Received Currency")
    private String receiveCurrency;
    @CsvBindByName(column = "Received Amount")
    private BigDecimal receivedAmount;

    @CsvBindByName(column = "Sent Currency", required = true)
    private String sentCurrency;
    @CsvBindByName(column = "Sent Amount", required = true)
    private BigDecimal sentAmount;

    @CsvBindByName(column = "Fee Currency")
    private String feeCurrency;
    @CsvBindByName(column = "Fee Amount")
    private BigDecimal feeAmount;

    @CsvBindByName(column = "Received Net worth")
    private BigDecimal receivedNetWorth;
    @CsvBindByName(column = "Sent Net worth")
    private BigDecimal sentNetWorth;
    @CsvBindByName(column = "Fee Net worth")
    private BigDecimal feeNetWorth;
}
