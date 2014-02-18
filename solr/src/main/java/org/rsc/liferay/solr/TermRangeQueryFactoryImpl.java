package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactory;

/**
 * The Class TermRangeQueryFactoryImpl.
 */
public class TermRangeQueryFactoryImpl implements TermRangeQueryFactory {

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermRangeQueryFactory#create(java.lang.String, java.lang.String,
     * java.lang.String, boolean, boolean)
     */
    @Override
    public TermRangeQuery create(String field, String lowerTerm, String upperTerm, boolean includesLower,
            boolean includesUpper) {

        return new TermRangeQueryImpl(field, lowerTerm, upperTerm, includesLower, includesUpper);
    }

}