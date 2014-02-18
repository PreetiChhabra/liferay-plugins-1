package org.rsc.liferay.solr;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.NGramHolder;
import com.liferay.portal.kernel.search.NGramHolderBuilderUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;

public class NGramQueryBuilderImpl implements NGramQueryBuilder {

	@Override
	public SolrQuery getNGramQuery(String input) throws SearchException {
		SolrQuery solrQuery = new SolrQuery();

		StringBundler sb = new StringBundler(10);

		NGramHolder nGramHolder = NGramHolderBuilderUtil.buildNGramHolder(
			input);

		Map<String, List<String>> nGrams = nGramHolder.getNGrams();

		addNGramsListQuery(sb, nGrams);

		if (!nGrams.isEmpty()) {
			addOrQuerySeparator(sb);
		}

		Map<String, String> nGramEnds = nGramHolder.getNGramEnds();

		addNGramsQuery(sb, nGramEnds);

		if (!nGramEnds.isEmpty()) {
			addOrQuerySeparator(sb);
		}

		Map<String, String> nGramStarts = nGramHolder.getNGramStarts();

		addNGramsQuery(sb, nGramStarts);

		if (!nGramStarts.isEmpty()) {
			addOrQuerySeparator(sb);
		}

		sb.append(Field.SPELL_CHECK_WORD);
		sb.append(StringPool.COLON);
		sb.append(input);

		solrQuery.setQuery(sb.toString());

		return solrQuery;
	}

	protected void addNGramsListQuery(
		StringBundler sb, Map<String, List<String>> nGrams) {

		Set<Map.Entry<String, List<String>>> set = nGrams.entrySet();

		Iterator<Map.Entry<String, List<String>>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();

			String fieldName = entry.getKey();
			List<String> fieldValues = entry.getValue();

			Iterator<String> fieldValuesIterator = fieldValues.iterator();

			while (fieldValuesIterator.hasNext()) {
				addQuery(sb, fieldName, fieldValuesIterator.next());

				if (fieldValuesIterator.hasNext() || iterator.hasNext()) {
					addOrQuerySeparator(sb);
				}
			}
		}
	}

	protected void addNGramsQuery(
		StringBundler sb, Map<String, String> nGrams) {

		Set<Map.Entry<String, String>> set = nGrams.entrySet();

		Iterator<Map.Entry<String, String>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();

			String fieldName = entry.getKey();
			String fieldValue = entry.getValue();

			addQuery(sb, fieldName, fieldValue);

			if (iterator.hasNext()) {
				addOrQuerySeparator(sb);
			}
		}
	}

	protected void addOrQuerySeparator(StringBundler sb) {
		sb.append(_OR_QUERY_SEPARATOR);
	}

	protected void addQuery(
		StringBundler sb, String fieldName, String fieldValue) {

		sb.append(fieldName);
		sb.append(StringPool.COLON);
		sb.append(fieldValue);
	}

	private static final String _OR_QUERY_SEPARATOR = " OR ";

}