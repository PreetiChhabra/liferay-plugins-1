package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.QueryTranslator;
import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

/**
 * The Class QueryTranslatorUtil.
 */
public class QueryTranslatorUtil {

    /**
     * Gets the query translator.
     * 
     * @return the query translator
     */
    public static QueryTranslator getQueryTranslator() {
        PortalRuntimePermission.checkGetBeanProperty(QueryTranslatorUtil.class);

        return queryTranslator;
    }

    /**
     * Translate.
     * 
     * @param query
     *            the query
     * @return the object
     * @throws ParseException
     *             the parse exception
     */
    public static Object translate(Query query) throws ParseException {
        return getQueryTranslator().translate(query);
    }

    /**
     * Translate for solr.
     * 
     * @param query
     *            the query
     * @return the object
     * @throws ParseException
     *             the parse exception
     */
    public static Object translateForSolr(Query query) throws ParseException {
        return getQueryTranslator().translateForSolr(query);
    }

    /**
     * Sets the query translator.
     * 
     * @param queryTranslator
     *            the new query translator
     */
    public void setQueryTranslator(QueryTranslator qTranslator) {
        PortalRuntimePermission.checkSetBeanProperty(getClass());

        queryTranslator = qTranslator;
    }

    /** The _query translator. */
    private static QueryTranslator queryTranslator;

}
