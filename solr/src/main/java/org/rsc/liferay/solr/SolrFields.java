package org.rsc.liferay.solr;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * The Class SolrFields.
 */
public final class SolrFields {

    /**
     * Private constructor.
     */
    private SolrFields() {
    }

    /**
     * Gets the date.
     * 
     * @param field
     *            the field
     * @return the date
     */
    public static Field getDate(String field) {
        return getDate(field, new Date());
    }

    /**
     * Gets the date.
     * 
     * @param field
     *            the field
     * @param date
     *            the date
     * @return the date
     */
    public static Field getDate(String field, Date date) {
        if (date == null) {
            return getDate(field);
        } else {
            return new Field(field, DateTools.dateToString(date, DateTools.Resolution.SECOND), Field.Store.YES,
                    Field.Index.NOT_ANALYZED);
        }
    }

    /**
     * Gets the file.
     * 
     * @param field
     *            the field
     * @param bytes
     *            the bytes
     * @param fileExt
     *            the file ext
     * @return the file
     */
    public static Field getFile(String field, byte[] bytes, String fileExt) {
        SolrFileExtractor fileExtractor = new SolrFileExtractor();

        return fileExtractor.getFile(field, bytes, fileExt);
    }

    /**
     * Gets the file.
     * 
     * @param field
     *            the field
     * @param file
     *            the file
     * @param fileExt
     *            the file ext
     * @return the file
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static Field getFile(String field, File file, String fileExt) throws IOException {

        SolrFileExtractor fileExtractor = new SolrFileExtractor();

        return fileExtractor.getFile(field, file, fileExt);
    }

    /**
     * Gets the file.
     * 
     * @param field
     *            the field
     * @param is
     *            the is
     * @param fileExt
     *            the file ext
     * @return the file
     */
    public static Field getFile(String field, InputStream is, String fileExt) {
        SolrFileExtractor fileExtractor = new SolrFileExtractor();

        return fileExtractor.getFile(field, is, fileExt);
    }

    /**
     * Gets the keyword.
     * 
     * @param field
     *            the field
     * @param keyword
     *            the keyword
     * @return the keyword
     */
    public static Field getKeyword(String field, double keyword) {
        return getKeyword(field, String.valueOf(keyword));
    }

    /**
     * Gets the keyword.
     * 
     * @param field
     *            the field
     * @param keyword
     *            the keyword
     * @return the keyword
     */
    public static Field getKeyword(String field, long keyword) {
        return getKeyword(field, String.valueOf(keyword));
    }

    /**
     * Gets the keyword.
     * 
     * @param field
     *            the field
     * @param keyword
     *            the keyword
     * @return the keyword
     */
    public static Field getKeyword(String field, Long keyword) {
        return getKeyword(field, keyword.longValue());
    }

    /**
     * Gets the keyword.
     * 
     * @param field
     *            the field
     * @param keyword
     *            the keyword
     * @return the keyword
     */
    public static Field getKeyword(String field, String keyword) {

        Field fieldObj = new Field(field, keyword, Field.Store.YES, Field.Index.NOT_ANALYZED);

        return fieldObj;
    }

    /**
     * Gets the number.
     * 
     * @param field
     *            the field
     * @param number
     *            the number
     * @return the number
     */
    public static NumericField getNumber(String field, String number) {
        NumericField numericField = new NumericField(field, Field.Store.YES, true);

        numericField.setLongValue(GetterUtil.getLong(number));

        return numericField;
    }

    /**
     * Gets the text.
     * 
     * @param field
     *            the field
     * @param text
     *            the text
     * @return the text
     */
    public static Field getText(String field, String text) {
        return new Field(field, text, Field.Store.YES, Field.Index.ANALYZED);
    }

    /**
     * Gets the text.
     * 
     * @param field
     *            the field
     * @param sb
     *            the sb
     * @return the text
     */
    public static Field getText(String field, StringBuilder sb) {
        return getText(field, sb.toString());
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @return the uid
     */
    public static String getUID(String portletId, long field1) {
        return getUID(portletId, String.valueOf(field1));
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @param field2
     *            the field2
     * @return the uid
     */
    public static String getUID(String portletId, long field1, String field2) {
        return getUID(portletId, String.valueOf(field1), field2);
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @return the uid
     */
    public static String getUID(String portletId, Long field1) {
        return getUID(portletId, field1.longValue());
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @param field2
     *            the field2
     * @return the uid
     */
    public static String getUID(String portletId, Long field1, String field2) {
        return getUID(portletId, field1.longValue(), field2);
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @return the uid
     */
    public static String getUID(String portletId, String field1) {
        return getUID(portletId, field1, null);
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @param field2
     *            the field2
     * @return the uid
     */
    public static String getUID(String portletId, String field1, String field2) {

        return getUID(portletId, field1, field2, null);
    }

    /**
     * Gets the uid.
     * 
     * @param portletId
     *            the portlet id
     * @param field1
     *            the field1
     * @param field2
     *            the field2
     * @param field3
     *            the field3
     * @return the uid
     */
    public static String getUID(String portletId, String field1, String field2, String field3) {

        String uid = portletId + UID_PORTLET + field1;

        if (field2 != null) {
            uid += UID_FIELD + field2;
        }

        if (field3 != null) {
            uid += UID_FIELD + field3;
        }

        return uid;
    }

    /** The Constant _UID_FIELD. */
    private static final String UID_FIELD = "_FIELD_";

    /** The Constant _UID_PORTLET. */
    private static final String UID_PORTLET = "_PORTLET_";

}
