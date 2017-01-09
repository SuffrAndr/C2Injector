package com.miri.blephone.mediainjector.mgtv.jaxb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.StringUtils;

public class JaxbDateSerializer extends XmlAdapter<String, Date> {

    private static final String fmt1 = "yyyy/MM/dd HH:mm:ss";
    private static final String reg1 = "^\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}$";
    private static final String fmt2 = "yyyy-MM-dd HH:mm:ss";
    private static final String reg2 = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";

    private static final String fmt3 = "yyyy-MM-dd";
    private static final String reg3 = "^\\d{4}-\\d{2}-\\d{2}";

    @Override
    public Date unmarshal(final String v) throws Exception {
        if (StringUtils.isNotBlank(v)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(JaxbDateSerializer.fmt2);
                if (Pattern.compile(JaxbDateSerializer.reg2).matcher(v).matches()) {
                }
                else if (Pattern.compile(JaxbDateSerializer.reg1).matcher(v).matches()) {
                    sdf = new SimpleDateFormat(JaxbDateSerializer.fmt1);
                }
                else if (Pattern.compile(JaxbDateSerializer.reg3).matcher(v).matches()) {
                    sdf = new SimpleDateFormat(JaxbDateSerializer.fmt3);
                }
                return sdf.parse(v);
            }
            catch (final ParseException e) {
            }
        }
        return null;
    }

    @Override
    public String marshal(final Date v) throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat(JaxbDateSerializer.fmt2);
        return sdf.format(v);
    }
}
