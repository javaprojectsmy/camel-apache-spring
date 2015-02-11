

package org.camelcookbook.extend.dataformat;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.util.ExchangeHelper;

/**
 * This is a duplicate of the StringDataFormat already in Camel...
 */
public class EbcdicDataFormat implements DataFormat {
    private String codepage = "CP037"; // US EBCDIC code page 000037

    public EbcdicDataFormat() {
    }

    public EbcdicDataFormat(String codepage) {
        this.codepage = codepage;
    }

    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        final String str = ExchangeHelper.convertToMandatoryType(exchange, String.class, graph);
        stream.write(str.getBytes(codepage));
    }

    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        final byte[] bytes = ExchangeHelper.convertToMandatoryType(exchange, byte[].class, stream);
        return new String(bytes, codepage);
    }
}
