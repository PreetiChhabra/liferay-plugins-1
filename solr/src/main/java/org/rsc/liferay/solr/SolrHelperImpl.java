package org.rsc.liferay.solr;

import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The Class SolrHelperImpl.
 */
public class SolrHelperImpl implements SolrHelper {

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addExactTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String)
     */
    @Override
    public void addExactTerm(BooleanQuery booleanQuery, String field, String value) {

        addTerm(booleanQuery, field, value, false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addNumericRangeTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void addNumericRangeTerm(BooleanQuery booleanQuery, String field, String startValue, String endValue) {

        NumericRangeQuery<?> numericRangeQuery = NumericRangeQuery.newLongRange(field, GetterUtil.getLong(startValue),
                GetterUtil.getLong(endValue), true, true);

        booleanQuery.add(numericRangeQuery, BooleanClause.Occur.SHOULD);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addRangeTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void addRangeTerm(BooleanQuery booleanQuery, String field, String startValue, String endValue) {

        boolean includesLower = true;

        if ((startValue != null) && startValue.equals(StringPool.STAR)) {
            includesLower = false;
        }

        boolean includesUpper = true;

        if ((endValue != null) && endValue.equals(StringPool.STAR)) {
            includesUpper = false;
        }

        TermRangeQuery termRangeQuery = new TermRangeQuery(field, startValue, endValue, includesLower, includesUpper);

        booleanQuery.add(termRangeQuery, BooleanClause.Occur.SHOULD);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addRequiredTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String, boolean)
     */
    @Override
    public void addRequiredTerm(BooleanQuery booleanQuery, String field, String value, boolean like) {

        addRequiredTerm(booleanQuery, field, new String[] { value }, like);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addRequiredTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String[], boolean)
     */
    @Override
    public void addRequiredTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like) {

        if (values == null) {
            return;
        }

        BooleanQuery query = new BooleanQuery();

        for (String value : values) {
            addTerm(query, field, value, like);
        }

        booleanQuery.add(query, BooleanClause.Occur.MUST);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String, boolean)
     */
    @Override
    public void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like) {

        addTerm(booleanQuery, field, value, like, BooleanClauseOccur.SHOULD);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String, boolean, com.liferay.portal.kernel.search.BooleanClauseOccur)
     */
    @Override
    public void addTerm(BooleanQuery booleanQuery, String field, String value, boolean like,
            BooleanClauseOccur booleanClauseOccur) {

        if (Validator.isNull(value)) {
            return;
        }

        if (like) {
            value = StringUtil.replace(value, StringPool.PERCENT, StringPool.BLANK);
        }

        try {
            Query query = new TermQuery(new Term(field, value));

            BooleanClause.Occur occur = null;

            if (booleanClauseOccur.equals(BooleanClauseOccur.MUST)) {
                occur = BooleanClause.Occur.MUST;
            } else if (booleanClauseOccur.equals(BooleanClauseOccur.MUST_NOT)) {
                occur = BooleanClause.Occur.MUST_NOT;
            } else {
                occur = BooleanClause.Occur.SHOULD;
            }

            includeIfUnique(booleanQuery, query, occur, like);
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#addTerm(org.apache.lucene.search.BooleanQuery, java.lang.String,
     * java.lang.String[], boolean)
     */
    @Override
    public void addTerm(BooleanQuery booleanQuery, String field, String[] values, boolean like) {

        for (String value : values) {
            addTerm(booleanQuery, field, value, like);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#countScoredFieldNames(org.apache.lucene.search.Query, java.lang.String[])
     */
    @Override
    public int countScoredFieldNames(Query query, String[] filedNames) {
        int count = 0;
        // TODO
        return count;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#getAnalyzer()
     */
    @Override
    public Analyzer getAnalyzer() {
        return analyzer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#getQueryTerms(org.apache.lucene.search.Query)
     */
    @Override
    public String[] getQueryTerms(Query query) {
        // TODO
        Set<String> queryTerms = new HashSet<String>();
        return queryTerms.toArray(new String[queryTerms.size()]);
    }

    /**
     * Sets the analyzer.
     * 
     * @param analyzer
     *            the new analyzer
     */
    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the new version
     */
    public void setVersion(Version version) {
        this.version = version;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.idex.connext.solr.SolrHelper#getVersion()
     */
    @Override
    public Version getVersion() {
        return version;
    }

    /** The _log. */
    private static final Log LOGGER = LogFactoryUtil.getLog(SolrHelperImpl.class);

    /** The _analyzer. */
    private Analyzer analyzer;

    /** The _version. */
    private Version version;

    /**
     * _include if unique.
     * 
     * @param booleanQuery
     *            the boolean query
     * @param query
     *            the query
     * @param occur
     *            the occur
     * @param like
     *            the like
     */
    private void includeIfUnique(BooleanQuery booleanQuery, Query query, BooleanClause.Occur occur, boolean like) {

        if (query instanceof TermQuery) {
            Set<Term> terms = new HashSet<Term>();

            query.extractTerms(terms);

            for (Term term : terms) {
                String termValue = term.text();

                if (like) {
                    term = term.createTerm(StringPool.STAR.concat(termValue).concat(StringPool.STAR));

                    query = new WildcardQuery(term);
                } else {
                    query = new TermQuery(term);
                }

                boolean included = false;

                for (BooleanClause booleanClause : booleanQuery.getClauses()) {
                    if (query.equals(booleanClause.getQuery())) {
                        included = true;
                    }
                }

                if (!included) {
                    booleanQuery.add(query, occur);
                }
            }
        } else if (query instanceof BooleanQuery) {
            BooleanQuery curBooleanQuery = (BooleanQuery) query;

            BooleanQuery containerBooleanQuery = new BooleanQuery();

            for (BooleanClause booleanClause : curBooleanQuery.getClauses()) {
                includeIfUnique(containerBooleanQuery, booleanClause.getQuery(), booleanClause.getOccur(), like);
            }

            if (containerBooleanQuery.getClauses().length > 0) {
                booleanQuery.add(containerBooleanQuery, occur);
            }
        } else {
            boolean included = false;

            for (BooleanClause booleanClause : booleanQuery.getClauses()) {
                if (query.equals(booleanClause.getQuery())) {
                    included = true;
                }
            }

            if (!included) {
                booleanQuery.add(query, occur);
            }
        }
    }
}
