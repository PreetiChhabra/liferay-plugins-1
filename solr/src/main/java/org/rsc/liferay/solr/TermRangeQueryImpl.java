package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.BaseQueryImpl;
import com.liferay.portal.kernel.search.TermRangeQuery;

/**
 * The Class TermRangeQueryImpl.
 */
public class TermRangeQueryImpl extends BaseQueryImpl implements TermRangeQuery {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8485726388828537619L;

    /**
     * Instantiates a new term range query impl.
     * 
     * @param field
     *            the field
     * @param lowerTerm
     *            the lower term
     * @param upperTerm
     *            the upper term
     * @param includesLower
     *            the includes lower
     * @param includesUpper
     *            the includes upper
     */
    public TermRangeQueryImpl(String field, String lowerTerm, String upperTerm, boolean includesLower,
            boolean includesUpper) {

        termRangeQuery = new org.apache.lucene.search.TermRangeQuery(field, lowerTerm, upperTerm, includesLower,
                includesUpper);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQuery#getField()
     */
    @Override
    public String getField() {
        return termRangeQuery.getField();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQuery#getLowerTerm()
     */
    @Override
    public String getLowerTerm() {
        return termRangeQuery.getLowerTerm();
    }

    /**
     * Gets the term range query.
     * 
     * @return the term range query
     */
    public Object getTermRangeQuery() {
        return termRangeQuery;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQuery#getUpperTerm()
     */
    @Override
    public String getUpperTerm() {
        return termRangeQuery.getUpperTerm();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BaseQueryImpl#getWrappedQuery()
     */
    @Override
    public Object getWrappedQuery() {
        return getTermRangeQuery();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQuery#includesLower()
     */
    @Override
    public boolean includesLower() {
        return termRangeQuery.includesLower();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQuery#includesUpper()
     */
    @Override
    public boolean includesUpper() {
        return termRangeQuery.includesUpper();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return termRangeQuery.toString();
    }

    /** The _term range query. */
    private final org.apache.lucene.search.TermRangeQuery termRangeQuery;

}