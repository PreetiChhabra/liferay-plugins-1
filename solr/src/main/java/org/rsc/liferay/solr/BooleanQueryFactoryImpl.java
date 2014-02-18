package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactory;

/**
 * The Class BooleanQueryFactoryImpl.
 */
public class BooleanQueryFactoryImpl implements BooleanQueryFactory {

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanQueryFactory#create()
     */
    @Override
    public BooleanQuery create() {
        return new BooleanQueryImpl();
    }

}
