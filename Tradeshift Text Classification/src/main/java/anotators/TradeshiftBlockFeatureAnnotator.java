package anotators;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import type.TradeshiftBlockFeature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeshiftBlockFeatureAnnotator extends JCasAnnotator_ImplBase {
    private Pattern featurePattern = Pattern.compile("[,\\n]");

    @Override
    public void process(JCas jCas) throws AnalysisEngineProcessException {
        String docText = jCas.getDocumentText();
        Matcher matcher = featurePattern.matcher(docText);
        int start = 0, end;
        while (matcher.find()) {
            end = matcher.end();
            TradeshiftBlockFeature annotation = new TradeshiftBlockFeature(jCas, start, end);
//            String s = docText.substring(start, end - 1);
            annotation.setValue(docText.substring(start, end - 1));
            annotation.addToIndexes();
            start = end;
        }
    }

    public static AnalysisEngineDescription getDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(TradeshiftBlockFeatureAnnotator.class);
    }
}
