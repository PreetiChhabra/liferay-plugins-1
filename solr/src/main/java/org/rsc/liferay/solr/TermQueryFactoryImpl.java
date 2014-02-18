package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactory;

/**
 * The Class TermQueryFactoryImpl.
 */
public class TermQueryFactoryImpl implements TermQueryFactory {

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermQueryFactory#create(java.lang.String, long)
     */
    @Override
    public TermQuery create(String field, long value) {
        return new TermQueryImpl(field, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.TermQueryFactory#create(java.lang.String, java.lang.String)
     */
    @Override
    public TermQuery create(String field, String value) {
        return new TermQueryImpl(field, value);
    }
}