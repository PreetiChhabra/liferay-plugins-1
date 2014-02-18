package org.rsc.liferay.solr;

import org.apache.lucene.index.Term;

import com.liferay.portal.kernel.search.BaseQueryImpl;
import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.TermQuery;

/**
 * The Class TermQueryImpl.
 */
public class TermQueryImpl extends BaseQueryImpl implements TermQuery {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1122348669359847709L;

    /**
     * Instantiates a new term query impl.
     * 
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public TermQueryImpl(String field, long value) {
        this(field, String.valueOf(value));
    }

    /**
     * Instantiates a new term query impl.
     * 
     * @param field
     *            the field
     * @param value
     *            the value
     */
    public TermQueryImpl(String field, String value) {
        termQuery = new org.apache.lucene.search.TermQuery(new Term(field, value));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermQuery#getQueryTerm()
     */
    @Override
    public QueryTerm getQueryTerm() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the term query.
     * 
     * @return the term query
     */
    public org.apache.lucene.search.TermQuery getTermQuery() {
        return termQuery;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BaseQueryImpl#getWrappedQuery()
     */
    @Override
    public Object getWrappedQuery() {
        return getTermQuery();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return termQuery.toString();
    }

    /** The _term query. */
    private final org.apache.lucene.search.TermQuery termQuery;

}
