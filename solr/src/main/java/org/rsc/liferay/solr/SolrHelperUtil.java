package org.rsc.liferay.solr;

import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

import com.liferay.portal.kernel.search.BooleanClauseOccur;

/**
 * The Class SolrHelperUtil.
 */
public class SolrHelperUtil {

    /**
     * Adds the date.
     * 
     * @param doc
     *            the doc
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addDate(Document doc, String field, Date value) {
        doc.add(SolrFields.getDate(field, value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, boolean value) {

        addExactTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, double value) {

        addExactTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, int value) {

        addExactTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, long value) {

        addExactTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, short value) {

        addExactTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the exact term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addExactTerm(BooleanQuery booleanQuery, String field, String value) {

        getSolrHelper().addExactTerm(booleanQuery, field, value);
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, int startValue, int endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, Integer startValue, Integer endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, long startValue, long endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, Long startValue, Long endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, short startValue, short endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the numeric range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addNumericRangeTerm(BooleanQuery booleanQuery, String field, Short startValue, Short endValue) {

        getSolrHelper().addNumericRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, int startValue, int endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, Integer startValue, Integer endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, long startValue, long endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, Long startValue, Long endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, short startValue, short endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, Short startValue, Short endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, String.valueOf(startValue), String.valueOf(endValue));
    }

    /**
     * Adds the range term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param startValue
     *            the start value
     * @param endValue
     *            the end value
     */
    public static void addRangeTerm(BooleanQuery booleanQuery, String field, String startValue, String endValue) {

        getSolrHelper().addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, boolean value) {

        addRequiredTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, double value) {

        addRequiredTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, int value) {

        addRequiredTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, long value) {

        addRequiredTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, short value) {

        addRequiredTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, String value) {

        addRequiredTerm(booleanQuery, field, value, false);
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     * @param like
     *            the like
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, String value, boolean like) {

        getSolrHelper().addRequiredTerm(booleanQuery, field, value, like);
    }

    /**
     * Adds the required term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param values
     *            the values
     * @param like
     *            the like
     */
    public static void addRequiredTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like) {

        getSolrHelper().addRequiredTerm(booleanQuery, field, values, like);
    }

    /**
     * Adds the term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addTerm(BooleanQuery booleanQuery, String field, long value) {

        addTerm(booleanQuery, field, String.valueOf(value));
    }

    /**
     * Adds the term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public static void addTerm(BooleanQuery booleanQuery, String field, String value) {

        addTerm(booleanQuery, field, value, false);
    }

    /**
     * Adds the term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     * @param like
     *            the like
     */
    public static void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like) {

        getSolrHelper().addTerm(booleanQuery, field, value, like);
    }

    /**
     * Adds the term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param value
     *            the value
     * @param like
     *            the like
     * @param booleanClauseOccur
     *            the boolean clause occur
     */
    public static void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like,
            BooleanClauseOccur booleanClauseOccur) {

        getSolrHelper().addTerm(booleanQuery, field, value, like, booleanClauseOccur);
    }

    /**
     * Adds the term.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param field
     *            the field
     * @param values
     *            the values
     * @param like
     *            the like
     */
    public static void addTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like) {

        getSolrHelper().addTerm(booleanQuery, field, values, like);
    }

    /**
     * Count scored field names.
     * 
     * @param query
     *            the query
     * @param fieldNames
     *            the field names
     * @return the int
     */
    public static int countScoredFieldNames(Query query, String[] fieldNames) {
        return getSolrHelper().countScoredFieldNames(query, fieldNames);
    }

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public static Version getVersion() {
        return getSolrHelper().getVersion();
    }

    /**
     * Gets the analyzer.
     * 
     * @return the analyzer
     */
    public static Analyzer getAnalyzer() {
        return getSolrHelper().getAnalyzer();
    }

    /**
     * Gets the query terms.
     * 
     * @param query
     *            the query
     * @return the query terms
     */
    public static String[] getQueryTerms(Query query) {
        return getSolrHelper().getQueryTerms(query);
    }

    /**
     * Gets the solr helper.
     * 
     * @return the solr helper
     */
    public static SolrHelper getSolrHelper() {
        return solrHelper;
    }

    /**
     * Sets the solr helper.
     * 
     * @param solrHelper
     *            the new solr helper
     */
    public void setSolrHelper(SolrHelper solrHelper) {
        SolrHelperUtil.solrHelper = solrHelper;
    }

    /** The _solr helper. */
    private static SolrHelper solrHelper;

}