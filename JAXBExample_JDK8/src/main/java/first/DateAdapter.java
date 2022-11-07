package first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

	@Override
	public String marshal(Date date) {
		return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(date);
	}

	@Override
	public Date unmarshal(String date) throws ParseException {
		return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(date);
	}
}