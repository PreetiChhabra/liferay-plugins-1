package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.BooleanClauseOccur;

/**
 * The Class BooleanClauseOccurTranslator.
 */
public final class BooleanClauseOccurTranslator {

    /**
     * Private.
     */
    private BooleanClauseOccurTranslator() {
    }

    /**
     * Translate.
     * 
     * @param occur
     *            the occur
     * @return the org.apache.lucene.search. boolean clause. occur
     */
    public static org.apache.lucene.search.BooleanClause.Occur translate(BooleanClauseOccur occur) {

        if (occur.equals(BooleanClauseOccur.MUST)) {
            return org.apache.lucene.search.BooleanClause.Occur.MUST;
        } else if (occur.equals(BooleanClauseOccur.MUST_NOT)) {
            return org.apache.lucene.search.BooleanClause.Occur.MUST_NOT;
        } else if (occur.equals(BooleanClauseOccur.SHOULD)) {
            return org.apache.lucene.search.BooleanClause.Occur.SHOULD;
        } else {
            return null;
        }
    }

}
