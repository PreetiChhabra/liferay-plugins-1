package org.rsc.liferay.solr;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.QueryTranslator;
import com.liferay.portal.kernel.util.StringPool;

import java.lang.reflect.Field;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;

/**
 * The Class QueryTranslatorImpl.
 */
public class QueryTranslatorImpl implements QueryTranslator {

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.QueryTranslator#translate(com.liferay.portal.kernel.search.Query)
     */
    @Override
    public Object translate(Query query) throws ParseException {
        if (query instanceof BooleanQueryImpl) {
            return ((BooleanQueryImpl) query).getBooleanQuery();
        } else if (query instanceof TermQueryImpl) {
            return ((TermQueryImpl) query).getTermQuery();
        } else if (query instanceof TermRangeQueryImpl) {
            return ((TermRangeQueryImpl) query).getTermRangeQuery();
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.liferay.portal.kernel.search.QueryTranslator#translateForSolr(com.liferay.portal.kernel.search.Query)
     */
    @Override
    public Object translateForSolr(Query query) {
        Object queryObject = query.getWrappedQuery();

        if (queryObject instanceof org.apache.lucene.search.Query) {
            adjustQuery((org.apache.lucene.search.Query) queryObject);
        }

        return query;
    }

    /**
     * Adjust query.
     * 
     * @param query
     *            the query
     */
    protected void adjustQuery(org.apache.lucene.search.Query query) {
        if (query instanceof BooleanQuery) {
            BooleanQuery booleanQuery = (BooleanQuery) query;

            for (BooleanClause booleanClause : booleanQuery.getClauses()) {
                adjustQuery(booleanClause.getQuery());
            }
        } else if (query instanceof TermQuery) {
            TermQuery termQuery = (TermQuery) query;

            Term term = termQuery.getTerm();

            try {
                String text = term.text();

                if (text.matches("^\\s*[^\"].*\\s+.*[^\"]\\s*$(?m)")) {
                    text = StringPool.QUOTE.concat(text).concat(StringPool.QUOTE);

                    textfield.set(term, text);
                }
            } catch (Exception e) {
                LOGGER.error(e, e);
            }
        } else if (query instanceof WildcardQuery) {
            WildcardQuery wildcardQuery = (WildcardQuery) query;

            Term term = wildcardQuery.getTerm();

            try {
                String text = term.text();

                if (text.matches("^\\s*\\*.*(?m)")) {
                    text = text.replaceFirst("\\*", StringPool.BLANK);

                    textfield.set(term, text);
                }
            } catch (Exception e) {
                LOGGER.error(e, e);
            }
        }
    }

    /** The _log. */
    private static final Log LOGGER = LogFactoryUtil.getLog(QueryTranslatorImpl.class);

    /** The _text field. */
    private static Field textfield = null;

    static {
        try {
            textfield = Term.class.getDeclaredField("text");

            textfield.setAccessible(true);
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }
}
