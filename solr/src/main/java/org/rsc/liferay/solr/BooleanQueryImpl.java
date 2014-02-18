package org.rsc.liferay.solr;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.BooleanQuery;

import com.liferay.portal.kernel.search.BaseBooleanQueryImpl;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanClauseOccurImpl;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;

/**
 * The Class BooleanQueryImpl.
 */
public class BooleanQueryImpl extends BaseBooleanQueryImpl {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2745539990545241613L;

    /**
     * Instantiates a new boolean query impl.
     */
    public BooleanQueryImpl() {
    	BooleanQuery.setMaxClauseCount(2048);
        booleanQuery = new org.apache.lucene.search.BooleanQuery();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#add(com.liferay.portal.kernel.search.Query,
     * com.liferay.portal.kernel.search.BooleanClauseOccur)
     */
    @Override
    public void add(Query query, BooleanClauseOccur booleanClauseOccur) throws ParseException {
        booleanQuery.add((org.apache.lucene.search.Query) QueryTranslatorUtil.translate(query),
                BooleanClauseOccurTranslator.translate(booleanClauseOccur));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#add(com.liferay.portal.kernel.search.Query, java.lang.String)
     */
    @Override
    public void add(Query query, String occur) throws ParseException {
        BooleanClauseOccur booleanClauseOccur = new BooleanClauseOccurImpl(occur);

        add(query, booleanClauseOccur);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, boolean)
     */
    @Override
    public void addExactTerm(String field, boolean value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.Boolean)
     */
    @Override
    public void addExactTerm(String field, Boolean value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, double)
     */
    @Override
    public void addExactTerm(String field, double value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.Double)
     */
    @Override
    public void addExactTerm(String field, Double value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, int)
     */
    @Override
    public void addExactTerm(String field, int value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.Integer)
     */
    @Override
    public void addExactTerm(String field, Integer value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, long)
     */
    @Override
    public void addExactTerm(String field, long value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.Long)
     */
    @Override
    public void addExactTerm(String field, Long value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, short)
     */
    @Override
    public void addExactTerm(String field, short value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.Short)
     */
    @Override
    public void addExactTerm(String field, Short value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addExactTerm(java.lang.String, java.lang.String)
     */
    @Override
    public void addExactTerm(String field, String value) {
        SolrHelperUtil.addExactTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, int, int)
     */
    @Override
    public void addNumericRangeTerm(String field, int startValue, int endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public void addNumericRangeTerm(String field, Integer startValue, Integer endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, long, long)
     */
    @Override
    public void addNumericRangeTerm(String field, long startValue, long endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, java.lang.Long,
     * java.lang.Long)
     */
    @Override
    public void addNumericRangeTerm(String field, Long startValue, Long endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, short, short)
     */
    @Override
    public void addNumericRangeTerm(String field, short startValue, short endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addNumericRangeTerm(java.lang.String, java.lang.Short,
     * java.lang.Short)
     */
    @Override
    public void addNumericRangeTerm(String field, Short startValue, Short endValue) {

        SolrHelperUtil.addNumericRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, int, int)
     */
    @Override
    public void addRangeTerm(String field, int startValue, int endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public void addRangeTerm(String field, Integer startValue, Integer endValue) {

        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, long, long)
     */
    @Override
    public void addRangeTerm(String field, long startValue, long endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, java.lang.Long, java.lang.Long)
     */
    @Override
    public void addRangeTerm(String field, Long startValue, Long endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, short, short)
     */
    @Override
    public void addRangeTerm(String field, short startValue, short endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, java.lang.Short,
     * java.lang.Short)
     */
    @Override
    public void addRangeTerm(String field, Short startValue, Short endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRangeTerm(java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public void addRangeTerm(String field, String startValue, String endValue) {
        SolrHelperUtil.addRangeTerm(booleanQuery, field, startValue, endValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, boolean)
     */
    @Override
    public void addRequiredTerm(String field, boolean value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.Boolean)
     */
    @Override
    public void addRequiredTerm(String field, Boolean value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, double)
     */
    @Override
    public void addRequiredTerm(String field, double value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.Double)
     */
    @Override
    public void addRequiredTerm(String field, Double value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, int)
     */
    @Override
    public void addRequiredTerm(String field, int value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.Integer)
     */
    @Override
    public void addRequiredTerm(String field, Integer value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, long)
     */
    @Override
    public void addRequiredTerm(String field, long value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.Long)
     */
    @Override
    public void addRequiredTerm(String field, Long value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, short)
     */
    @Override
    public void addRequiredTerm(String field, short value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.Short)
     */
    @Override
    public void addRequiredTerm(String field, Short value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.String)
     */
    @Override
    public void addRequiredTerm(String field, String value) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addRequiredTerm(java.lang.String, java.lang.String, boolean)
     */
    @Override
    public void addRequiredTerm(String field, String value, boolean like) {
        SolrHelperUtil.addRequiredTerm(booleanQuery, field, value, like);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addTerm(java.lang.String, long)
     */
    @Override
    public void addTerm(String field, long value) {
        SolrHelperUtil.addTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addTerm(java.lang.String, java.lang.String)
     */
    @Override
    public void addTerm(String field, String value) {
        SolrHelperUtil.addTerm(booleanQuery, field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addTerm(java.lang.String, java.lang.String, boolean)
     */
    @Override
    public void addTerm(String field, String value, boolean like) {
        SolrHelperUtil.addTerm(booleanQuery, field, value, like);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#addTerm(java.lang.String, java.lang.String, boolean,
     * com.liferay.portal.kernel.search.BooleanClauseOccur)
     */
    @Override
    public void addTerm(String field, String value, boolean like, BooleanClauseOccur booleanClauseOccur) {

        SolrHelperUtil.addTerm(booleanQuery, field, value, like, booleanClauseOccur);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#clauses()
     */
    @Override
    public List<BooleanClause> clauses() {
        List<org.apache.lucene.search.BooleanClause> luceneBooleanClauses = booleanQuery.clauses();

        List<BooleanClause> booleanClauses = new ArrayList<BooleanClause>(luceneBooleanClauses.size());

        for (int i = 0; i < luceneBooleanClauses.size(); i++) {
            BooleanClause booleanClause = new BooleanClauseImpl(luceneBooleanClauses.get(i));

            booleanClauses.add(booleanClause);
        }

        return booleanClauses;
    }

    /**
     * Gets the boolean query.
     * 
     * @return the boolean query
     */
    public org.apache.lucene.search.BooleanQuery getBooleanQuery() {
        return booleanQuery;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BaseQueryImpl#getWrappedQuery()
     */
    @Override
    public Object getWrappedQuery() {
        return getBooleanQuery();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQuery#hasClauses()
     */
    @Override
    public boolean hasClauses() {
        return !clauses().isEmpty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return booleanQuery.toString();
    }

    /** The _boolean query. */
    private final org.apache.lucene.search.BooleanQuery booleanQuery;

}
