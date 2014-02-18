package org.rsc.liferay.solr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.lucene.document.Field;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The Class SolrFileExtractor.
 */
public class SolrFileExtractor {

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
    public Field getFile(String field, byte[] bytes, String fileExt) {
        InputStream is = new UnsyncByteArrayInputStream(bytes);

        return getFile(field, is, fileExt);
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
    public Field getFile(String field, File file, String fileExt) throws IOException {

        InputStream is = new FileInputStream(file);

        return getFile(field, is, fileExt);
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
    public Field getFile(String field, InputStream is, String fileExt) {
        String text = FileUtil.extractText(is, fileExt);

        if (Validator.isNotNull(PropsUtil.get(PropsKeys.LUCENE_FILE_EXTRACTOR_REGEXP_STRIP))) {

            text = regexpStrip(text);
        }

        return SolrFields.getText(field, text);
    }

    /**
     * Regexp strip.
     * 
     * @param text
     *            the text
     * @return the string
     */
    protected String regexpStrip(String text) {
        char[] array = text.toCharArray();

        for (int i = 0; i < array.length; i++) {
            String s = String.valueOf(array[i]);

            if (!s.matches(PropsUtil.get(PropsKeys.LUCENE_FILE_EXTRACTOR_REGEXP_STRIP))) {
                array[i] = CharPool.SPACE;
            }
        }

        return new String(array);
    }
}
