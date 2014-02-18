package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactory;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanClauseOccurImpl;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngine;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.TermQueryFactory;

/**
 * The Class BooleanClauseFactoryImpl.
 */
public class BooleanClauseFactoryImpl implements BooleanClauseFactory {

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanClauseFactory#create(com.liferay.portal.kernel.search.SearchContext,
     * com.liferay.portal.kernel.search.Query, java.lang.String)
     */
    @Override
    public BooleanClause create(SearchContext searchContext, Query query, String occur) {

        BooleanClauseOccur booleanClauseOccur = new BooleanClauseOccurImpl(occur);

        return new BooleanClauseImpl(query, booleanClauseOccur);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.BooleanClauseFactory#create(com.liferay.portal.kernel.search.SearchContext,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public BooleanClause create(SearchContext searchContext, String field, String value, String occur) {

        String searchEngineId = searchContext.getSearchEngineId();

        SearchEngine searchEngine = SearchEngineUtil.getSearchEngine(searchEngineId);

        TermQueryFactory termQueryFactory = searchEngine.getTermQueryFactory();

        Query query = termQueryFactory.create(field, value);

        BooleanClauseOccur booleanClauseOccur = new BooleanClauseOccurImpl(occur);

        return new BooleanClauseImpl(query, booleanClauseOccur);
    }
}