package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Query;

/**
 * The Class BooleanClauseImpl.
 */
public class BooleanClauseImpl implements BooleanClause {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5098219740476974571L;

    /**
     * Instantiates a new boolean clause impl.
     * 
     * @param query
     *            the query
     * @param booleanClauseOccur
     *            the boolean clause occur
     */
    public BooleanClauseImpl(Query query, BooleanClauseOccur booleanClauseOccur) {

        this.query = query;
        this.booleanClauseOccur = booleanClauseOccur;
    }

    /**
     * Instantiates a new boolean clause impl.
     * 
     * @param booleanClause
     *            the boolean clause
     */
    public BooleanClauseImpl(org.apache.lucene.search.BooleanClause booleanClause) {
        this.booleanClause = booleanClause;
    }

    /**
     * Gets the boolean clause.
     * 
     * @return the boolean clause
     */
    public org.apache.lucene.search.BooleanClause getBooleanClause() {
        return booleanClause;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanClause#getBooleanClauseOccur()
     */
    @Override
    public BooleanClauseOccur getBooleanClauseOccur() {
        return booleanClauseOccur;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanClause#getQuery()
     */
    @Override
    public Query getQuery() {
        return query;
    }

    /** The _boolean clause occur. */
    private BooleanClauseOccur booleanClauseOccur;

    /** The _query. */
    private Query query;

    /** The _boolean clause. */
    private org.apache.lucene.search.BooleanClause booleanClause;

}
