package org.rsc.liferay.solr;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;

import com.liferay.portal.kernel.search.BooleanClauseOccur;

/**
 * The Interface SolrHelper.
 */
public interface SolrHelper {

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
    void addExactTerm(BooleanQuery booleanQuery, String field, String value);

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
    void addNumericRangeTerm(BooleanQuery booleanQuery, String field, String startValue, String endValue);

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
    void addRangeTerm(BooleanQuery booleanQuery, String field, String startValue, String endValue);

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
    void addRequiredTerm(BooleanQuery booleanQuery, String field, String value, boolean like);

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
    void addRequiredTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like);

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
    void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like);

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
    void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like,
            BooleanClauseOccur booleanClauseOccur);

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
    void addTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like);

    /**
     * Count scored field names.
     * 
     * @param query
     *            the query
     * @param fieldNames
     *            the field names
     * @return the int
     */
    int countScoredFieldNames(Query query, String[] fieldNames);

    /**
     * Gets the analyzer.
     * 
     * @return the analyzer
     */
    Analyzer getAnalyzer();

    /**
     * Gets the query terms.
     * 
     * @param query
     *            the query
     * @return the query terms
     */
    String[] getQueryTerms(Query query);

    /**
     * Gets the version.
     * 
     * @return the version
     */
    Version getVersion();

}
